package uinbdg.SIK.ptkis.Activities;

import android.content.Context;
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
import uinbdg.SIK.ptkis.Adapter.AdapterBeritaFakultas;
import uinbdg.SIK.ptkis.Model.Response.BeritaFakultasResponse;
import uinbdg.SIK.ptkis.Model.Response.DataItemBeritaFakultas;
import uinbdg.SIK.ptkis.R;
import uinbdg.SIK.ptkis.Service.ApiClient;
import uinbdg.SIK.ptkis.Service.AppConstans;
import uinbdg.SIK.ptkis.Service.PTKISApi;
import uinbdg.SIK.ptkis.Util.Session;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class BeritaFakultasActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view_tim)
    RecyclerView recyclerViewUniversitas;

    List<DataItemBeritaFakultas> dataItemUniversitas;

    AdapterBeritaFakultas adapterUniversitas;

    Retrofit retrofit;
    PTKISApi ptkisApi;
    Session session;
    int id_univ,id_fak;
    String nama_univ;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universitas);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        session = new Session(this);
        initView();

        getUniv();
    }

    private void initView() {
        retrofit = ApiClient.newInstance();
        ptkisApi = retrofit.create(PTKISApi.class);
        dataItemUniversitas = new ArrayList<>();

        id_univ = getIntent().getIntExtra("id_univ",0);
        id_univ = getIntent().getIntExtra("id_fak",0);

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

    void getUniv() {
        DataItemBeritaFakultas beritaFakultas = new DataItemBeritaFakultas();
        beritaFakultas.setIdFak(id_fak);
        beritaFakultas.setIdUniv(id_univ);
        ptkisApi.getBeritaFakultas(beritaFakultas).enqueue(new Callback<BeritaFakultasResponse>() {
            @Override
            public void onResponse(Call<BeritaFakultasResponse> call, Response<BeritaFakultasResponse> response) {
                if (response.code() == AppConstans.HTTP_OK) {
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        dataItemUniversitas.add(response.body().getData().get(i));
                    }
                    adapterUniversitas = new AdapterBeritaFakultas(BeritaFakultasActivity.this, dataItemUniversitas);
                    recyclerViewUniversitas.setAdapter(adapterUniversitas);
                    recyclerViewUniversitas.setHasFixedSize(true);
//                    adapterUniversitas.setOnItemClickListener(new AdapterBeritaUniversitas.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(int position) {
//                            Intent i = new Intent(BeritaUniversitasActivity.this, FakultasActivity.class);
//                            i.putExtra("id_univ", dataItemUniversitas.get(position).getId());
//                            i.putExtra("nama_univ", dataItemUniversitas.get(position).getNama());
//                            startActivity(i);
//                        }
//                    });
                }
            }

            @Override
            public void onFailure(Call<BeritaFakultasResponse> call, Throwable t) {

            }
        });
    }


}
