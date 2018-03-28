package uinbdg.SIK.ptkis.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import uinbdg.SIK.ptkis.Adapter.AdapterPendaftar;
import uinbdg.SIK.ptkis.Model.Response.DataItemPendaftar;
import uinbdg.SIK.ptkis.Model.Response.PendaftarResponse;
import uinbdg.SIK.ptkis.R;
import uinbdg.SIK.ptkis.Service.ApiClient;
import uinbdg.SIK.ptkis.Service.AppConstans;
import uinbdg.SIK.ptkis.Service.PTKISApi;
import uinbdg.SIK.ptkis.Util.Session;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class RankingPendaftarActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view_tim)
    RecyclerView recyclerViewUniversitas;

    List<DataItemPendaftar> dataItemPendaftarList;

    AdapterPendaftar adapterUniversitas;

    Retrofit retrofit;
    PTKISApi ptkisApi;
    Session session;
    int id_univ;
    String nama_univ;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_add_beasiswa)
    FloatingActionButton btnAddBeasiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftar);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        session = new Session(this);
        initView();

        getPendaftar();
    }

    private void initView() {
        retrofit = ApiClient.newInstance();
        ptkisApi = retrofit.create(PTKISApi.class);
        dataItemPendaftarList = new ArrayList<>();

        id_univ = getIntent().getIntExtra("id_univ", 0);

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

    void getPendaftar() {
        ptkisApi.getPendaftarBeasiswa().enqueue(new Callback<PendaftarResponse>() {
            @Override
            public void onResponse(Call<PendaftarResponse> call, Response<PendaftarResponse> response) {
                if (response.code() == AppConstans.HTTP_OK) {
                    for (int i = 0; i < response.body().getData().size(); i++) {
                        dataItemPendaftarList.add(response.body().getData().get(i));
                    }


                    bobotIpk(dataItemPendaftarList);
                    bobotPrestasi(dataItemPendaftarList);
                    bobotPendapatan(dataItemPendaftarList);
                    bobotTanggungan(dataItemPendaftarList);
                    bobotKendaraan(dataItemPendaftarList);
                    vectorS(dataItemPendaftarList);
                    Collections.sort(dataItemPendaftarList, new Comparator<DataItemPendaftar>() {
                        @Override
                        public int compare(DataItemPendaftar c1, DataItemPendaftar c2) {
                            return Double.compare(c2.getVectorV(), c1.getVectorV());
                        }
                    });
//                    adapterUniversitas.setOnItemClickListener(new AdapterBeritaUniversitas.OnItemClickListener() {
                    adapterUniversitas = new AdapterPendaftar(RankingPendaftarActivity.this, dataItemPendaftarList);
                    recyclerViewUniversitas.setAdapter(adapterUniversitas);
                    recyclerViewUniversitas.setHasFixedSize(true);
//                        @Override
//                        public void onItemClick(int position) {
//                            Intent i = new Intent(BeritaUniversitasActivity.this, FakultasActivity.class);
//                            i.putExtra("id_univ", dataItemPendaftarList.get(position).getId());
//                            i.putExtra("nama_univ", dataItemPendaftarList.get(position).getNama());
//                            startActivity(i);
//                        }
//                    });
                }
            }

            @Override
            public void onFailure(Call<PendaftarResponse> call, Throwable t) {

            }
        });
    }


    @OnClick(R.id.btn_add_beasiswa)
    public void onViewClicked() {
        startActivity(new Intent(this,DaftarActivity.class));
    }


    void bobotIpk(List<DataItemPendaftar> itemPendaftars){
        for (int i = 0; i < itemPendaftars.size(); i++) {
            if(Float.parseFloat(itemPendaftars.get(i).getIpk().replace(",", ".")) > 2.0 && Float.parseFloat(itemPendaftars.get(i).getIpk().replace(",",".")) < 2.5 ){
                itemPendaftars.get(i).setBobotIpk(1);
            }else if(Float.parseFloat(itemPendaftars.get(i).getIpk().replace(",", ".")) > 2.5 && Float.parseFloat(itemPendaftars.get(i).getIpk().replace(",",".")) < 3.0 ){
                itemPendaftars.get(i).setBobotIpk(2);
            }else if(Float.parseFloat(itemPendaftars.get(i).getIpk().replace(",", ".")) > 3.0 && Float.parseFloat(itemPendaftars.get(i).getIpk().replace(",",".")) < 3.5 ){
                itemPendaftars.get(i).setBobotIpk(3);
            }else if(Float.parseFloat(itemPendaftars.get(i).getIpk().replace(",", ".")) > 3.5 && Float.parseFloat(itemPendaftars.get(i).getIpk().replace(",",".")) < 4.0 ){
                itemPendaftars.get(i).setBobotIpk(4);
            }
            Log.d("BOBOTIPK", String.valueOf(itemPendaftars.get(i).getBobotIpk()));
        }
    }


    void bobotPrestasi(List<DataItemPendaftar> itemPendaftars){
        for (int i = 0; i < itemPendaftars.size(); i++) {
            if(itemPendaftars.get(i).getPrestasiAkademik().equals("Universitas")){
                itemPendaftars.get(i).setPrestasiNonAkademis(4);
            }else if(itemPendaftars.get(i).getPrestasiAkademik().equals("Fakultas")){
                itemPendaftars.get(i).setPrestasiNonAkademis(3);
            }else if(itemPendaftars.get(i).getPrestasiAkademik().equals("Jurusan")){
                itemPendaftars.get(i).setPrestasiNonAkademis(2);
            }else if(itemPendaftars.get(i).getPrestasiAkademik().equals("Tidak Punya")){
                itemPendaftars.get(i).setPrestasiNonAkademis(1);
            }
            Log.d("BOBOTPRESTASI", String.valueOf(itemPendaftars.get(i).getPrestasiNonAkademis()));
        }
    }

    void bobotPendapatan(List<DataItemPendaftar> itemPendaftars){
        for (int i = 0; i < itemPendaftars.size(); i++) {
            Log.d("BOBOTPENGHASILAN", String.valueOf(Integer.parseInt(itemPendaftars.get(i).getPendapatanOrangtua().replace(".",""))));
            if(Integer.parseInt(itemPendaftars.get(i).getPendapatanOrangtua().replace(".","")) >= 1000000 && Integer.parseInt(itemPendaftars.get(i).getPendapatanOrangtua().replace(".","")) < 2000000 ){
                itemPendaftars.get(i).setPenghasilan(1);
            }else if(Integer.parseInt(itemPendaftars.get(i).getPendapatanOrangtua().replace(".","")) >= 2000000 && Integer.parseInt(itemPendaftars.get(i).getPendapatanOrangtua().replace(".","")) < 4000000 ){
                itemPendaftars.get(i).setPenghasilan(2);
            }else if(Integer.parseInt(itemPendaftars.get(i).getPendapatanOrangtua().replace(".","")) >= 4000000 && Integer.parseInt(itemPendaftars.get(i).getPendapatanOrangtua().replace(".","")) <= 6000000 ){
                itemPendaftars.get(i).setPenghasilan(3);
            }else if(Integer.parseInt(itemPendaftars.get(i).getPendapatanOrangtua().replace(".","")) >= 6000000 ){
                itemPendaftars.get(i).setPenghasilan(4);
            }
            Log.d("BOBOTPENGHASILAN", String.valueOf(itemPendaftars.get(i).getPenghasilan()));
        }
    }

    void bobotTanggungan(List<DataItemPendaftar> itemPendaftars){
        for (int i = 0; i < itemPendaftars.size(); i++) {
            if(Integer.parseInt(itemPendaftars.get(i).getTanggunganOrangtua()) == 1 ){
                itemPendaftars.get(i).setJumlahTanggungan(1);
            }else if(Integer.parseInt(itemPendaftars.get(i).getTanggunganOrangtua()) == 2 ){
                itemPendaftars.get(i).setJumlahTanggungan(2);
            }else if(Integer.parseInt(itemPendaftars.get(i).getTanggunganOrangtua()) == 3 ){
                itemPendaftars.get(i).setJumlahTanggungan(3);
            }else if(Integer.parseInt(itemPendaftars.get(i).getTanggunganOrangtua()) >= 4 ){
                itemPendaftars.get(i).setJumlahTanggungan(4);
            }
            Log.d("BOBOTTANGGUNGAN", String.valueOf(itemPendaftars.get(i).getTanggunganOrangtua()));
        }
    }

    void bobotKendaraan(List<DataItemPendaftar> itemPendaftars){
        for (int i = 0; i < itemPendaftars.size(); i++) {
            if(itemPendaftars.get(i).getKendaraanPribadi().equals("Tidak Punya")){
                itemPendaftars.get(i).setKendaraan(1);
            }else if(itemPendaftars.get(i).getKendaraanPribadi().equals("sepeda")){
                itemPendaftars.get(i).setKendaraan(2);
            }else if(itemPendaftars.get(i).getKendaraanPribadi().equals("Motor")){
                itemPendaftars.get(i).setKendaraan(3);
            }else if(itemPendaftars.get(i).getKendaraanPribadi().equals("Mobil")){
                itemPendaftars.get(i).setKendaraan(4);
            }
            Log.d("BOBOTKENDARAAN", String.valueOf(itemPendaftars.get(i).getKendaraan()));
        }
    }

    void vectorS(List<DataItemPendaftar> itemPendaftars){
        double pangkatIpk = 0.3;
        double pangkatPrestasi = 0.3;
        double pangkatPendapatan = 0.2;
        double pangkatTanggungan = 0.2;
        double pangkatKendaraan = 0.1;
        for (int i = 0; i < itemPendaftars.size(); i++) {
            double bobotIpk = Math.pow(itemPendaftars.get(i).getBobotIpk(),pangkatIpk);
            double bobotPrestasi = Math.pow(itemPendaftars.get(i).getPrestasiNonAkademis(),pangkatPrestasi);
            double bobotPendapatan = Math.pow(itemPendaftars.get(i).getPenghasilan(),pangkatPendapatan);
            double bobotTanggungan = Math.pow(itemPendaftars.get(i).getJumlahTanggungan(),pangkatTanggungan);
            double bobotKendaraan = Math.pow(itemPendaftars.get(i).getKendaraan(),pangkatKendaraan);

            NumberFormat formatter = new DecimalFormat("#0.000");
            double hasilS1 = bobotIpk*bobotPrestasi*bobotPendapatan*bobotTanggungan*bobotKendaraan;
            itemPendaftars.get(i).setVectorS(hasilS1);
            Log.d("BOBOT  S1", String.valueOf(formatter.format(hasilS1)));
        }
        double sTotal = 0;
        for (int i = 0; i < itemPendaftars.size(); i++) {
            sTotal = sTotal + itemPendaftars.get(i).getVectorS();
        }
        NumberFormat formatter = new DecimalFormat("#0.000");
        Log.d("BOBOT  STOTAL", String.valueOf(formatter.format(sTotal)));
        vectorV(dataItemPendaftarList,sTotal);
    }

    void vectorV(List<DataItemPendaftar> itemPendaftars,double sTotal){
        NumberFormat formatter = new DecimalFormat("#0.000");
        double vectorV;
        for (int i = 0; i < itemPendaftars.size(); i++) {
            vectorV = itemPendaftars.get(i).getVectorS() / sTotal;
            Log.d("BOBOT  STOTAL", String.valueOf(formatter.format(vectorV)));
            itemPendaftars.get(i).setVectorV(vectorV);
        }
    }
}
