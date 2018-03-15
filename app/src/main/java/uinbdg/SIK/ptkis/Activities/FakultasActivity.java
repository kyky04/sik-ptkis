package uinbdg.SIK.ptkis.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import uinbdg.SIK.ptkis.Adapter.AdapterFakultas;
import uinbdg.SIK.ptkis.Model.Response.DataItemFakultas;
import uinbdg.SIK.ptkis.Model.Response.FakultasResponse;
import uinbdg.SIK.ptkis.R;
import uinbdg.SIK.ptkis.Service.ApiClient;
import uinbdg.SIK.ptkis.Service.AppConstans;
import uinbdg.SIK.ptkis.Service.PTKISApi;
import uinbdg.SIK.ptkis.Util.Session;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FakultasActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler_view_tim)
    RecyclerView recyclerViewUniversitas;

    List<DataItemFakultas> dataFakultas;

    AdapterFakultas adapterFakultas;

    Retrofit retrofit;
    PTKISApi ptkisApi;
    Session session;

    int id_univ;
    String nama_univ;

    @BindView(R.id.tv_nama_univ)
    TextView tvNamaUniv;
    @BindView(R.id.btn_berita)
    Button btnBerita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fakultas);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        session = new Session(this);
        initView();

        getFakultas();
    }

    private void initView() {
        id_univ = getIntent().getIntExtra("id_univ", 0);
        nama_univ = getIntent().getStringExtra("nama_univ");

        tvNamaUniv.setText(nama_univ);
        retrofit = ApiClient.newInstance();
        ptkisApi = retrofit.create(PTKISApi.class);
        dataFakultas = new ArrayList<>();


        recyclerViewUniversitas.setLayoutManager(new LinearLayoutManager(this));

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

    void getFakultas() {
        DataItemFakultas itemFakultas = new DataItemFakultas();
        itemFakultas.setIdUniv(id_univ);
        ptkisApi.getFakultas(itemFakultas).enqueue(new Callback<FakultasResponse>() {
            @Override
            public void onResponse(Call<FakultasResponse> call, Response<FakultasResponse> response) {
                if (response.code() == AppConstans.HTTP_OK) {
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        dataFakultas.add(response.body().getData().get(i));
                    }
                    adapterFakultas = new AdapterFakultas(FakultasActivity.this, dataFakultas);
                    recyclerViewUniversitas.setAdapter(adapterFakultas);
                    recyclerViewUniversitas.setHasFixedSize(true);
                    adapterFakultas.setOnItemClickListener(new AdapterFakultas.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            Intent i = new Intent(FakultasActivity.this, JurusanActivity.class);
                            i.putExtra("id_fak", dataFakultas.get(position).getId());
                            i.putExtra("id_univ", dataFakultas.get(position).getIdUniv());
                            i.putExtra("nama_fak", dataFakultas.get(position).getNama());
                            i.putExtra("nama_univ", nama_univ);
                            startActivity(i);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<FakultasResponse> call, Throwable t) {

            }
        });
    }


    @OnClick(R.id.btn_berita)
    public void onViewClicked() {
        Intent i = new Intent(FakultasActivity.this, BeritaUniversitasActivity.class);
        i.putExtra("id_univ", id_univ);
        i.putExtra("nama_univ", nama_univ);
        startActivity(i);
    }
}
