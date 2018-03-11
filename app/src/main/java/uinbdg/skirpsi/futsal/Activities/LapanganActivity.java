package uinbdg.skirpsi.futsal.Activities;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import uinbdg.skirpsi.futsal.Adapter.AdapterLapangan;
import uinbdg.skirpsi.futsal.Adapter.AdapterTim;
import uinbdg.skirpsi.futsal.Model.DataItem;
import uinbdg.skirpsi.futsal.Model.DataItemLapangan;
import uinbdg.skirpsi.futsal.Model.Lapang;
import uinbdg.skirpsi.futsal.Model.LapanganResponse;
import uinbdg.skirpsi.futsal.R;
import uinbdg.skirpsi.futsal.Service.ApiClient;
import uinbdg.skirpsi.futsal.Service.AppConstans;
import uinbdg.skirpsi.futsal.Service.FutsalApi;
import uinbdg.skirpsi.futsal.Util.GPSTracker;
import uinbdg.skirpsi.futsal.Widget.SpacesItemDecoration;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LapanganActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler_view_lapangan)
    RecyclerView recyclerViewLapangan;

    List<DataItemLapangan> dataItemLapangans;

    AdapterLapangan adapterLapangan;

    Retrofit retrofit;
    FutsalApi futsalApi;

    GPSTracker gpsTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lapangan);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initView();

    }

    private void initView() {
        retrofit = ApiClient.newInstance();
        futsalApi = retrofit.create(FutsalApi.class);
        dataItemLapangans = new ArrayList<>();

        gpsTracker = new GPSTracker(this);
        getLapang();
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

    void getLapang() {
        futsalApi.getLapang().enqueue(new Callback<LapanganResponse>() {
            @Override
            public void onResponse(Call<LapanganResponse> call, Response<LapanganResponse> response) {
//                Log.d(LapanganActivity.class.getSimpleName(), response.body().getMessage());
                if (response.code() == 200) {
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        dataItemLapangans.add(response.body().getData().get(i));
                        dataItemLapangans.get(i).setDistance(getDistance(gpsTracker.getLatitude(),gpsTracker.getLongitude(),response.body().getData().get(i).getLatitude(),response.body().getData().get(i).getLongitude()));

                    }

                    Collections.sort(dataItemLapangans, new Comparator<DataItemLapangan>() {
                        @Override
                        public int compare(DataItemLapangan c1, DataItemLapangan c2) {


                            return Float.compare(c1.getDistance(), c2.getDistance());
                        }
                    });

                    adapterLapangan = new AdapterLapangan(LapanganActivity.this, dataItemLapangans);
                    recyclerViewLapangan.setLayoutManager(new LinearLayoutManager(LapanganActivity.this));
                    recyclerViewLapangan.setAdapter(adapterLapangan);
                    recyclerViewLapangan.setHasFixedSize(true);
                    recyclerViewLapangan.addItemDecoration(new SpacesItemDecoration(2));

                    adapterLapangan.setOnItemClickListener(new AdapterLapangan.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            Intent i = new Intent(LapanganActivity.this, TimByLapangActivity.class);
                            i.putExtra("id_lapang", dataItemLapangans.get(position).getId());
                            startActivity(i);
                        }
                    });

                }
            }

            @Override
            public void onFailure(Call<LapanganResponse> call, Throwable t) {
                Log.d(LapanganActivity.class.getSimpleName(), t.getMessage());
            }
        });
    }

    public static float getDistance(double startLati, double startLongi, double goalLati, double goalLongi) {
        float[] resultArray = new float[99];
        Location.distanceBetween(startLati, startLongi, goalLati, goalLongi, resultArray);
        return resultArray[0];
    }
}
