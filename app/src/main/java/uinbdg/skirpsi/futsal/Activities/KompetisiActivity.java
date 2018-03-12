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
import uinbdg.skirpsi.futsal.Adapter.AdapterKompetisi;
import uinbdg.skirpsi.futsal.Adapter.AdapterLapangan;
import uinbdg.skirpsi.futsal.Adapter.AdapterTim;
import uinbdg.skirpsi.futsal.Model.DataItemKompetisi;
import uinbdg.skirpsi.futsal.Model.KompetisiResponse;
import uinbdg.skirpsi.futsal.Model.TeamResponse;
import uinbdg.skirpsi.futsal.R;
import uinbdg.skirpsi.futsal.Service.ApiClient;
import uinbdg.skirpsi.futsal.Service.AppConstans;
import uinbdg.skirpsi.futsal.Service.FutsalApi;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class KompetisiActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler_view_kompetisi)
    RecyclerView recyclerViewKompetisi;

    Retrofit retrofit;
    FutsalApi futsalApi;

    List<DataItemKompetisi> itemKompetisis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kompetisi);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        retrofit = ApiClient.newInstance();
        futsalApi = retrofit.create(FutsalApi.class);

        getKompetisi();
        initView();
    }

    private void initView() {
        itemKompetisis = new ArrayList<>();
        recyclerViewKompetisi.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewKompetisi.setHasFixedSize(true);
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

    void getKompetisi() {
        futsalApi.getKompetisi().enqueue(new Callback<KompetisiResponse>() {
            @Override
            public void onResponse(Call<KompetisiResponse> call, Response<KompetisiResponse> response) {
                if (response.code() == AppConstans.HTTP_OK) {
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        itemKompetisis.add(response.body().getData().get(i));
                    }
                    AdapterKompetisi adapter = new AdapterKompetisi(KompetisiActivity.this, itemKompetisis);
                    recyclerViewKompetisi.setAdapter(adapter);

                    recyclerViewKompetisi.setHasFixedSize(true);
                }
            }

            @Override
            public void onFailure(Call<KompetisiResponse> call, Throwable t) {

            }
        });
    }
}
