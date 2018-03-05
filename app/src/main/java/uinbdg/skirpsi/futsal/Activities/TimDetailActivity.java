package uinbdg.skirpsi.futsal.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import uinbdg.skirpsi.futsal.Model.DataItemTeam;
import uinbdg.skirpsi.futsal.Model.TeamDetailResponse;
import uinbdg.skirpsi.futsal.R;
import uinbdg.skirpsi.futsal.Service.ApiClient;
import uinbdg.skirpsi.futsal.Service.AppConstans;
import uinbdg.skirpsi.futsal.Service.FutsalApi;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class TimDetailActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    int id_team;

    @BindView(R.id.tv_nama_tim)
    TextView tvNamaTim;
    @BindView(R.id.tv_manager_team)
    TextView tvManagerTeam;
    @BindView(R.id.tv_home_base)
    TextView tvHomeBase;
    @BindView(R.id.lay_lihat_pemain)
    LinearLayout layLihatPemain;
    @BindView(R.id.lay_lihat_jadwal)
    LinearLayout layLihatJadwal;

    Retrofit retrofit;
    FutsalApi futsalApi;
    DataItemTeam team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        initView();
        getTim();
    }

    private void initView() {
        retrofit = ApiClient.newInstance();
        futsalApi = retrofit.create(FutsalApi.class);
        id_team = getIntent().getIntExtra(AppConstans.ID_TEAM, 0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                supportFinishAfterTransition();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    void getTim() {
        futsalApi.getTim(id_team).enqueue(new Callback<TeamDetailResponse>() {
            @Override
            public void onResponse(Call<TeamDetailResponse> call, Response<TeamDetailResponse> response) {
                if (response.code() == AppConstans.HTTP_OK) {
                    team = response.body().getData();
                    tvNamaTim.setText(team.getNama());
                    tvHomeBase.setText(team.getLapang().getNama());
                }
            }

            @Override
            public void onFailure(Call<TeamDetailResponse> call, Throwable t) {

            }
        });
    }

    @OnClick({R.id.lay_lihat_pemain, R.id.lay_lihat_jadwal})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lay_lihat_pemain:
                Intent i = new Intent(TimDetailActivity.this,PemainActivity.class);
                i.putExtra(AppConstans.ID_TEAM,team.getId());
                startActivity(i);
                break;
            case R.id.lay_lihat_jadwal:
                Intent ii = new Intent(TimDetailActivity.this,JadwalActivity.class);
                ii.putExtra(AppConstans.ID_TEAM,team.getId());
                startActivity(ii);
                break;
        }
    }
}
