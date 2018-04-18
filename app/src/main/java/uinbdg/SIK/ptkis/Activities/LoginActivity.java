package uinbdg.SIK.ptkis.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import uinbdg.SIK.ptkis.Model.Response.LoginResponse;
import uinbdg.SIK.ptkis.R;
import uinbdg.SIK.ptkis.Service.ApiClient;
import uinbdg.SIK.ptkis.Service.PTKISApi;
import uinbdg.SIK.ptkis.Util.Session;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class LoginActivity extends AppCompatActivity {
    ProgressDialog progressDialog;

    Session session;
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        session = new Session(this);


    }

    private void login() {
        if (etUsername.getText().toString().equals("kemahasiswaan") && etPassword.getText().toString().equals("admin123")) {
            session.setFullName("kemahasiswaan");
            session.setIsLogin(true);
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Aktifitas
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Aktifitas
            startActivity(i);
        } else if (etUsername.getText().toString().equals("siswa") && etPassword.getText().toString().equals("siswa123")) {
            session.setFullName("siswa");
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Username atau password anda tidak sesuai", Toast.LENGTH_SHORT).show();
        }

    }

    void loginn() {
        openDialog();
        Retrofit retrofit = ApiClient.newInstance();
        PTKISApi service = retrofit.create(PTKISApi.class);
        service.login(etUsername.getText().toString(), etPassword.getText().toString()).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.code() == 200) {
                    try {
                        session.setFullName(response.body().getData().getNama());
                        session.setIsLogin(true);
                        Toast.makeText(LoginActivity.this, response.body().getStatus(), Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(LoginActivity.this, MainActivity.class);
                        // Closing all the Activities
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        // Add new Flag to start new Aktifitas
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                        // Staring Login Aktifitas
                        startActivity(i);

                    }catch (NullPointerException e){
                        e.printStackTrace();
                        closeDialog();
                        Toast.makeText(LoginActivity.this, response.body().getStatus(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, response.body().getStatus(), Toast.LENGTH_SHORT).show();
                    closeDialog();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                closeDialog();
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    private void openDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Menyambungkan . . .");
        progressDialog.show();
    }

    private void closeDialog() {
        progressDialog.dismiss();
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        login();
    }
}
