package uinbdg.skirpsi.futsal.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
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
import uinbdg.skirpsi.futsal.Adapter.AdapterPemain;
import uinbdg.skirpsi.futsal.Model.DataItemPemain;
import uinbdg.skirpsi.futsal.Model.PemainDetailResponse;
import uinbdg.skirpsi.futsal.Model.PemainResponse;
import uinbdg.skirpsi.futsal.R;
import uinbdg.skirpsi.futsal.Service.ApiClient;
import uinbdg.skirpsi.futsal.Service.AppConstans;
import uinbdg.skirpsi.futsal.Service.FutsalApi;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class PemainActivity extends AppCompatActivity implements AdapterPemain.OnItemClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.action_search)
    ImageButton actionSearch;
    @BindView(R.id.search_bar)
    CardView searchBar;
    @BindView(R.id.recycler_view_tim)
    RecyclerView recyclerViewPemain;

    List<DataItemPemain> dataItemPemainList;

    AdapterPemain adapterPemain;

    Retrofit retrofit;
    FutsalApi futsalApi;

    int id_team;

    boolean fromMyTeam;
    @BindView(R.id.btn_add)
    FloatingActionButton btnAdd;

    DataItemPemain pemain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemain);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        id_team = getIntent().getIntExtra(AppConstans.ID_TEAM, 0);
        fromMyTeam = getIntent().getBooleanExtra("fromMyTeam", false);
        initView();
        getTim();

        if (fromMyTeam) {
            btnAdd.setVisibility(View.VISIBLE);
        } else {
            btnAdd.setVisibility(View.GONE);
        }

    }

    private void initView() {
        retrofit = ApiClient.newInstance();
        futsalApi = retrofit.create(FutsalApi.class);
        dataItemPemainList = new ArrayList<>();
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

    void getTim() {
        futsalApi.getPemainByTeam(id_team).enqueue(new Callback<PemainResponse>() {
            @Override
            public void onResponse(Call<PemainResponse> call, Response<PemainResponse> response) {
                if (response.code() == AppConstans.HTTP_OK) {
                    dataItemPemainList.clear();
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        dataItemPemainList.add(response.body().getData().get(i));
                    }
                    adapterPemain = new AdapterPemain(PemainActivity.this, dataItemPemainList);
                    adapterPemain.notifyDataSetChanged();
                    adapterPemain.setOnItemClickListener(PemainActivity.this);
                    recyclerViewPemain.setAdapter(adapterPemain);
                    recyclerViewPemain.setHasFixedSize(true);

                }
            }

            @Override
            public void onFailure(Call<PemainResponse> call, Throwable t) {

            }
        });
    }

    @OnClick(R.id.btn_add)
    public void onViewClicked() {
        final EditText namaPemain = new EditText(this);
        namaPemain.setHint("Nama Pemain");
//        editText.setHint("Posisi");
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setView(namaPemain)
                .setTitle("Tambah Pemain")
                .setPositiveButton("Tambahkan", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        postPemain(namaPemain.getText().toString(),1);


                    }
                }).setNegativeButton("Kembali", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    void postPemain(String nama_pemain, int id_team) {
        pemain = new DataItemPemain();
        pemain.setNama(nama_pemain);
        pemain.setIdTeam(id_team);

        futsalApi.postPemain(pemain).enqueue(new Callback<PemainDetailResponse>() {
            @Override
            public void onResponse(Call<PemainDetailResponse> call, Response<PemainDetailResponse> response) {
                if (response.code() == AppConstans.HTTP_OK) {
                    Toast.makeText(PemainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                    getTim();
                } else if (response.code() == 404) {

                }
            }

            @Override
            public void onFailure(Call<PemainDetailResponse> call, Throwable t) {

            }
        });
    } void putPemain(int id_pemain,String nama_pemain, int id_team) {
        pemain = new DataItemPemain();
        pemain.setNama(nama_pemain);
        pemain.setIdTeam(id_team);

        futsalApi.putPemain(id_pemain,pemain).enqueue(new Callback<PemainDetailResponse>() {
            @Override
            public void onResponse(Call<PemainDetailResponse> call, Response<PemainDetailResponse> response) {
                if (response.code() == AppConstans.HTTP_OK) {
                    Toast.makeText(PemainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                    getTim();
                } else if (response.code() == 404) {

                }
            }

            @Override
            public void onFailure(Call<PemainDetailResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void onItemClick(final int position) {
        final EditText namaPemain = new EditText(this);
        namaPemain.setHint(dataItemPemainList.get(position).getNama());
//        editText.setHint("Posisi");
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setView(namaPemain)
                .setTitle("Tambah Pemain")
                .setPositiveButton("Tambahkan", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        putPemain(dataItemPemainList.get(position).getId(),namaPemain.getText().toString(),1);
                        adapterPemain.notifyDataSetChanged();
                    }
                }).setNegativeButton("Kembali", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
