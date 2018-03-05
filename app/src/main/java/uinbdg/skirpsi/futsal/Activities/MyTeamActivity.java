package uinbdg.skirpsi.futsal.Activities;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import uinbdg.skirpsi.futsal.Adapter.AdapterSpinnerString;
import uinbdg.skirpsi.futsal.Model.DataItem;
import uinbdg.skirpsi.futsal.Model.DataItemLapangan;
import uinbdg.skirpsi.futsal.Model.DataItemTeam;
import uinbdg.skirpsi.futsal.Model.LapanganResponse;
import uinbdg.skirpsi.futsal.Model.TeamDetailResponse;
import uinbdg.skirpsi.futsal.R;
import uinbdg.skirpsi.futsal.Service.ApiClient;
import uinbdg.skirpsi.futsal.Service.AppConstans;
import uinbdg.skirpsi.futsal.Service.FutsalApi;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MyTeamActivity extends AppCompatActivity {


    DatePickerDialog datePicker;
    @BindView(R.id.btn_back_to_login)
    ImageButton btnBackToLogin;
    @BindView(R.id.img_logo)
    ImageView imgLogo;
    @BindView(R.id.etTitle)
    TextView etTitle;
    @BindView(R.id.et_nama_tim)
    EditText etNamaTim;
    @BindView(R.id.et_date)
    EditText etDate;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.sp_lapangan)
    Spinner spLapangan;
    @BindView(R.id.btn_daftar)
    Button btnSave;

    Retrofit retrofit;
    FutsalApi futsalApi;
    DataItemTeam team;

    int id_user;
    List<String> dataItemLapangansString;
    List<DataItem> dataItemLapangans;

    DataItemTeam teamPost;
    @BindView(R.id.btn_pemain)
    Button btnPemain;
    @BindView(R.id.btn_jadwal)
    Button btnJadwal;

    boolean timAda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_team);
        ButterKnife.bind(this);
        initView();


        getTim();
        getLapang();
    }

    private void initView() {
        retrofit = ApiClient.newInstance();
        futsalApi = retrofit.create(FutsalApi.class);
        id_user = 1;
        dataItemLapangansString = new ArrayList<>();
        dataItemLapangans = new ArrayList<>();
        team = new DataItemTeam();
        teamPost = new DataItemTeam();
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void dialogCreateTeam() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Anda Yakin Menambahkan Tim ini ?");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                postTim();
            }
        });
        Dialog dialog = builder.create();
        dialog.show();
    }   private void editTeam() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Anda Yakin edit Tim ini ?");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                postTim();
            }
        });
        Dialog dialog = builder.create();
        dialog.show();
    }


    @OnClick({R.id.btn_back_to_login, R.id.btn_daftar,R.id.btn_pemain, R.id.btn_jadwal})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back_to_login:
                supportFinishAfterTransition();
                break;
            case R.id.btn_daftar:
                if(timAda){
                    Log.d("POSITION", "" + dataItemLapangans.get(spLapangan.getSelectedItemPosition()).getId());
                    dialogCreateTeam();
                }else {
                    editTeam();
                }
                break;
            case R.id.btn_pemain:
                Intent i = new Intent(MyTeamActivity.this,PemainActivity.class);
                i.putExtra(AppConstans.ID_TEAM,team.getId());
                i.putExtra("fromMyTeam",true);
                startActivity(i);
                break;
            case R.id.btn_jadwal:
                Intent ii = new Intent(MyTeamActivity.this,JadwalActivity.class);
                ii.putExtra(AppConstans.ID_TEAM,team.getId());
                startActivity(ii);
                break;
        }
    }


    void getTim() {
        futsalApi.getMyTim(id_user).enqueue(new Callback<TeamDetailResponse>() {
            @Override
            public void onResponse(Call<TeamDetailResponse> call, Response<TeamDetailResponse> response) {
                if (response.code() == AppConstans.HTTP_OK) {
                    timAda = true;
                    team = response.body().getData();
                    etNamaTim.setText(team.getNama());
                    etTitle.setVisibility(View.VISIBLE);
                    etTitle.setText("Edit Tim");
                    btnJadwal.setVisibility(View.VISIBLE);
                    btnPemain.setVisibility(View.VISIBLE);
                    btnSave.setText("Edit Tim");
//                    etPhone.setText(team.getNama());
                } else if (response.code() == 404) {
                    timAda = false;
                    etTitle.setVisibility(View.VISIBLE);
                    etTitle.setText("Buat Tim");
                    btnSave.setText("Buat Tim");
                }
            }

            @Override
            public void onFailure(Call<TeamDetailResponse> call, Throwable t) {

            }
        });
    }

    void getLapang() {
        futsalApi.getLapang().enqueue(new Callback<LapanganResponse>() {
            @Override
            public void onResponse(Call<LapanganResponse> call, Response<LapanganResponse> response) {
                if (response.code() == AppConstans.HTTP_OK) {
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        dataItemLapangansString.add(response.body().getData().get(i).getNama());
                        dataItemLapangans.add(response.body().getData().get(i));
                    }
                    AdapterSpinnerString adapter = new AdapterSpinnerString(MyTeamActivity.this, android.R.layout.simple_list_item_1, dataItemLapangansString);
                    spLapangan.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<LapanganResponse> call, Throwable t) {

            }
        });
    }

    void postTim() {
        teamPost.setNama(etNamaTim.getText().toString());
        teamPost.setIdLapang(dataItemLapangans.get(spLapangan.getSelectedItemPosition()).getId());
        teamPost.setIdUser(2);

        futsalApi.postTeam(teamPost).enqueue(new Callback<TeamDetailResponse>() {
            @Override
            public void onResponse(Call<TeamDetailResponse> call, Response<TeamDetailResponse> response) {
                if (response.code() == AppConstans.HTTP_OK) {
                    Toast.makeText(MyTeamActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                } else if (response.code() == 404) {

                }
            }

            @Override
            public void onFailure(Call<TeamDetailResponse> call, Throwable t) {

            }
        });
    }


}
