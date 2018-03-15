package uinbdg.SIK.ptkis.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import uinbdg.SIK.ptkis.R;
import uinbdg.SIK.ptkis.Util.Session;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.img_logo)
    ImageView imgLogo;
    @BindView(R.id.tv_akun)
    TextView tvAkun;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.tv_reset_pass)
    TextView tvResetPass;

    ProgressDialog progressDialog;

    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        session = new Session(this);

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

//    @OnClick({R.id.img_logo, R.id.btn_login, R.id.tv_akun, R.id.tv_register, R.id.tv_reset_pass})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.img_logo:
//                break;
//            case R.id.btn_login:
//               getAccessToken();
//                break;
//            case R.id.tv_akun:
//                break;
//            case R.id.tv_register:
//                startActivity(new Intent(this, DaftarActivity.class));
//                break;
//            case R.id.tv_reset_pass:
//                startActivity(new Intent(this, ResetPasswordActivity.class));
//                break;
//        }
//    }
//
//    public void getAccessToken() {
//        openDialog();
////        CommonUtil.showProgress(LoginActivity.this, "Authenticating . . .");
//        AccessTokenRequest accessTokenRequest = new AccessTokenRequest();
//        accessTokenRequest.setClient_id(OauthClient.CLIENT_ID);
//        accessTokenRequest.setClient_secret(OauthClient.CLIENT_SECRET);
//        accessTokenRequest.setGrant_type(OauthClient.GRANT_TYPE);
//        accessTokenRequest.setUsername(etUsername.getText().toString());
//        accessTokenRequest.setPassword(etPassword.getText().toString());
//        accessTokenRequest.setScope("*");
//
//        Retrofit retrofit = ApiClient.newInstance();
//        PTKISApi service = retrofit.create(PTKISApi.class);
//
//
//        service.getAccessToken(accessTokenRequest).enqueue(new Callback<AccessTokenResponse>() {
//            @Override
//            public void onResponse(Call<AccessTokenResponse> call, Response<AccessTokenResponse> response) {
//                closeDialog();
//                if (response.code() == 200) {
//                    session.setKeyApiKey(response.body().getAccess_token());
//                    getUser();
//                } else {
//                    Toast.makeText(LoginActivity.this, "Email atau Password tidak sesuai", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<AccessTokenResponse> call, Throwable t) {
//                closeDialog();
//                Toast.makeText(getApplicationContext(), "Gagal menyambungkan", Toast.LENGTH_LONG).show();
//
//            }
//
//        });
//    }
//
//    public void getUser() {
//        openDialog();
//        Retrofit retrofit = ApiClient.newInstance();
//        final PTKISApi service = retrofit.create(PTKISApi.class);
//        service.getUser("Bearer " + session.getAccessToken()).enqueue(new Callback<UserResponse>() {
//            @Override
//            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
//                Log.d("RESPONSE", String.valueOf(response.code()));
//                closeDialog();
//
//                if (response.code() == 200) {
//                    session.createLoginSession(response.body().getName(),response.body().getEmail(),response.body().getId());
//                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
//                    // Closing all the Activities
//                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//                    // Add new Flag to start new Aktifitas
//                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//                    // Staring Login Aktifitas
//                    startActivity(i);
//                } else {
////                    CommonUtil.showSnackMessage(container, "Terjadi kesalahan ketika login", Snackbar.LENGTH_LONG);
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<UserResponse> call, Throwable t) {
//                closeDialog();
//                Log.d("ResponseCode", String.valueOf(t.getMessage()));
//                Toast.makeText(getApplicationContext(), "Error Connection", Toast.LENGTH_LONG).show();
//            }
//        });
//    }
//
//    private void openDialog() {
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setIndeterminate(true);
//        progressDialog.setMessage("Menyambungkan . . .");
//        progressDialog.show();
//    }
//
//    private void closeDialog() {
//        progressDialog.dismiss();
//    }
}
