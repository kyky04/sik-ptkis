package uinbdg.skirpsi.futsal.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import uinbdg.skirpsi.futsal.Adapter.AdapterJadwal;
import uinbdg.skirpsi.futsal.Model.DataItemJadwal;
import uinbdg.skirpsi.futsal.Model.JadwalResponse;
import uinbdg.skirpsi.futsal.R;
import uinbdg.skirpsi.futsal.Service.ApiClient;
import uinbdg.skirpsi.futsal.Service.AppConstans;
import uinbdg.skirpsi.futsal.Service.FutsalApi;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class JadwalActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.action_search)
    ImageButton actionSearch;
    @BindView(R.id.search_bar)
    CardView searchBar;
    @BindView(R.id.recycler_view_tim)
    RecyclerView recyclerViewPemain;

    List<DataItemJadwal> dataItemJadwals;

    AdapterJadwal adapterPemain;

    Retrofit retrofit;
    FutsalApi futsalApi;

    int id_team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        id_team = getIntent().getIntExtra(AppConstans.ID_TEAM,0);
        initView();

        if(id_team != 0){
            getJadwalByTeam();
        }else {
            getAllJadwal();
        }

    }

    private void initView() {
        retrofit = ApiClient.newInstance();
        futsalApi = retrofit.create(FutsalApi.class);
        dataItemJadwals = new ArrayList<>();
        recyclerViewPemain.setLayoutManager(new LinearLayoutManager(this));

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

    void getJadwalByTeam(){
        futsalApi.getJadwalByTeam(id_team).enqueue(new Callback<JadwalResponse>() {
            @Override
            public void onResponse(Call<JadwalResponse> call, Response<JadwalResponse> response) {
                if(response.code() == AppConstans.HTTP_OK){
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        dataItemJadwals.add(response.body().getData().get(i));
                    }
                    adapterPemain = new AdapterJadwal(JadwalActivity.this, dataItemJadwals);
                    recyclerViewPemain.setAdapter(adapterPemain);
                    recyclerViewPemain.setHasFixedSize(true);
//                    adapterPemain.setOnItemClickListener(new AdapterPemain.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(int position) {
//                            Intent i = new Intent(PemainActivity.this,PemainActivity.class);
//                            i.putExtra(AppConstans.ID_PEMAIN, dataItemPemainList.get(position).getId());
//                            startActivity(i);
//                        }
//                    });
                }
            }

            @Override
            public void onFailure(Call<JadwalResponse> call, Throwable t) {

            }
        });
    }

    void getAllJadwal(){
        futsalApi.getJadwal().enqueue(new Callback<JadwalResponse>() {
            @Override
            public void onResponse(Call<JadwalResponse> call, Response<JadwalResponse> response) {
                if(response.code() == AppConstans.HTTP_OK){
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        dataItemJadwals.add(response.body().getData().get(i));
                    }
                    adapterPemain = new AdapterJadwal(JadwalActivity.this, dataItemJadwals);
                    recyclerViewPemain.setAdapter(adapterPemain);
                    recyclerViewPemain.setHasFixedSize(true);
//                    adapterPemain.setOnItemClickListener(new AdapterPemain.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(int position) {
//                            Intent i = new Intent(PemainActivity.this,PemainActivity.class);
//                            i.putExtra(AppConstans.ID_PEMAIN, dataItemPemainList.get(position).getId());
//                            startActivity(i);
//                        }
//                    });
                }
            }

            @Override
            public void onFailure(Call<JadwalResponse> call, Throwable t) {

            }
        });
    }
}
