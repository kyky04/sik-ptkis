package uinbdg.skirpsi.futsal.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
import uinbdg.skirpsi.futsal.Adapter.AdapterTim;
import uinbdg.skirpsi.futsal.Model.DataItem;
import uinbdg.skirpsi.futsal.Model.DataItemTeam;
import uinbdg.skirpsi.futsal.Model.Team;
import uinbdg.skirpsi.futsal.Model.TeamResponse;
import uinbdg.skirpsi.futsal.R;
import uinbdg.skirpsi.futsal.Service.ApiClient;
import uinbdg.skirpsi.futsal.Service.AppConstans;
import uinbdg.skirpsi.futsal.Service.FutsalApi;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class TimByLapangActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.action_search)
    ImageButton actionSearch;
    @BindView(R.id.search_bar)
    CardView searchBar;
    @BindView(R.id.recycler_view_tim)
    RecyclerView recyclerViewPeserta;

    List<DataItemTeam> dataItemTeamList;

    AdapterTim adapterPeserta;

    Retrofit retrofit;
    FutsalApi futsalApi;

    int id_lapang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        id_lapang = getIntent().getIntExtra("id_lapang", 0);
        initView();
        getTim();
    }

    private void initView() {
        retrofit = ApiClient.newInstance();
        futsalApi = retrofit.create(FutsalApi.class);
        dataItemTeamList = new ArrayList<>();

        recyclerViewPeserta.setLayoutManager(new LinearLayoutManager(this));

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
        futsalApi.getTeamByLapang(id_lapang).enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.code() == AppConstans.HTTP_OK) {
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        dataItemTeamList.add(response.body().getData().get(i));
                    }
                    adapterPeserta = new AdapterTim(TimByLapangActivity.this, dataItemTeamList);
                    recyclerViewPeserta.setAdapter(adapterPeserta);
                    recyclerViewPeserta.setHasFixedSize(true);
                    adapterPeserta.setOnItemClickListener(new AdapterTim.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            ajakTanding(dataItemTeamList.get(position));
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {

            }
        });
    }

    void ajakTanding(DataItemTeam team ){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ajak tanding ?");
        String message = team.getNama()+"\n"+team.getLapang().getNama();
        builder.setMessage(message);
        builder.setPositiveButton("YA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setNegativeButton("KEMBALI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
