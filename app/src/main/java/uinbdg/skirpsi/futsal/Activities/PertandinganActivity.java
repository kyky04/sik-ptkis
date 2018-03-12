package uinbdg.skirpsi.futsal.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import uinbdg.skirpsi.futsal.Adapter.AdapterPertandingan;
import uinbdg.skirpsi.futsal.Adapter.AdapterTim;
import uinbdg.skirpsi.futsal.Model.DataItem;
import uinbdg.skirpsi.futsal.Model.DataItemTeam;
import uinbdg.skirpsi.futsal.Model.PertandinganResponse;
import uinbdg.skirpsi.futsal.Model.TeamResponse;
import uinbdg.skirpsi.futsal.R;
import uinbdg.skirpsi.futsal.Service.ApiClient;
import uinbdg.skirpsi.futsal.Service.AppConstans;
import uinbdg.skirpsi.futsal.Service.FutsalApi;
import uinbdg.skirpsi.futsal.Util.Session;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class PertandinganActivity extends AppCompatActivity {


    List<DataItem> dataItemTeamList;

    AdapterPertandingan adapterPeserta;

    Retrofit retrofit;
    FutsalApi futsalApi;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler_view_tim)
    RecyclerView recyclerViewTim;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertandingan);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        session = new Session(this);
        initView();
        getTim();
    }

    private void initView() {
        retrofit = ApiClient.newInstance();
        futsalApi = retrofit.create(FutsalApi.class);
        dataItemTeamList = new ArrayList<>();


        recyclerViewTim.setLayoutManager(new LinearLayoutManager(this));

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
        futsalApi.getPertandingan(session.getID()).enqueue(new Callback<PertandinganResponse>() {
            @Override
            public void onResponse(Call<PertandinganResponse> call, Response<PertandinganResponse> response) {
                if (response.code() == AppConstans.HTTP_OK) {
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        dataItemTeamList.add(response.body().getData().get(i));
                    }
                    adapterPeserta = new AdapterPertandingan(PertandinganActivity.this, dataItemTeamList);
                    recyclerViewTim.setAdapter(adapterPeserta);
                    recyclerViewTim.setHasFixedSize(true);
                    adapterPeserta.setOnItemClickListener(new AdapterPertandingan.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<PertandinganResponse> call, Throwable t) {

            }
        });
    }
}
