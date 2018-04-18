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
import uinbdg.SIK.ptkis.Adapter.AdapterBeasiswa;
import uinbdg.SIK.ptkis.Adapter.AdapterPendaftar;
import uinbdg.SIK.ptkis.Model.Response.DataItemBeasiswa;
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

    List<DataItemBeasiswa> dataItemPendaftarList;

    AdapterBeasiswa adapterUniversitas;

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


                    bobotNilai(dataItemPendaftarList);
                    bobotPrestasi(dataItemPendaftarList);
                    bobotPendapatan(dataItemPendaftarList);
                    bobotTanggungan(dataItemPendaftarList);
                    bobotKriteriaRumah(dataItemPendaftarList);
                    bobotIsiRumah(dataItemPendaftarList);
                    bobotPemilikRumah(dataItemPendaftarList);
                    bobotSumberAir(dataItemPendaftarList);
                    bobotMandiCuciKakus(dataItemPendaftarList);
                    bobotLuasTanah(dataItemPendaftarList);
                    bobotJarakPusat(dataItemPendaftarList);

                    vectorS(dataItemPendaftarList);
                    Collections.sort(dataItemPendaftarList, new Comparator<DataItemBeasiswa>() {
                        @Override
                        public int compare(DataItemBeasiswa c1, DataItemBeasiswa c2) {
                            return Double.compare(c2.getVectorV(), c1.getVectorV());
                        }
                    });
//                    adapterUniversitas.setOnItemClickListener(new AdapterBeritaUniversitas.OnItemClickListener() {
                    adapterUniversitas = new AdapterBeasiswa(RankingPendaftarActivity.this, dataItemPendaftarList);
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
        startActivity(new Intent(this, DaftarActivity.class));
    }


    void bobotNilai(List<DataItemBeasiswa> itemPendaftars) {
        for (int i = 0; i < itemPendaftars.size(); i++) {
            if (Float.parseFloat(itemPendaftars.get(i).getNilaiUn().replace(",", ".")) >= 5.0 && Float.parseFloat(itemPendaftars.get(i).getNilaiUn().replace(",", ".")) <= 6.0) {
                itemPendaftars.get(i).setBobotNilaiUn(1);
            } else if (Float.parseFloat(itemPendaftars.get(i).getNilaiUn().replace(",", ".")) >= 6.0 && Float.parseFloat(itemPendaftars.get(i).getNilaiUn().replace(",", ".")) <= 7.0) {
                itemPendaftars.get(i).setBobotNilaiUn(2);
            } else if (Float.parseFloat(itemPendaftars.get(i).getNilaiUn().replace(",", ".")) >= 7.0 && Float.parseFloat(itemPendaftars.get(i).getNilaiUn().replace(",", ".")) <= 8.0) {
                itemPendaftars.get(i).setBobotNilaiUn(3);
            } else if (Float.parseFloat(itemPendaftars.get(i).getNilaiUn().replace(",", ".")) >= 8.0 && Float.parseFloat(itemPendaftars.get(i).getNilaiUn().replace(",", ".")) <= 10.0) {
                itemPendaftars.get(i).setBobotNilaiUn(4);
            }
            Log.d("BOBOT NILAI UN", String.valueOf(itemPendaftars.get(i).getBobotNilaiUn()));
        }
    }


    void bobotPrestasi(List<DataItemBeasiswa> itemPendaftars) {
        for (int i = 0; i < itemPendaftars.size(); i++) {
            if (itemPendaftars.get(i).getPrestasi().equals("Ada")) {
                itemPendaftars.get(i).setBobotPrestasi(1);
            } else if (itemPendaftars.get(i).getPrestasi().equals("Tidak Ada")) {
                itemPendaftars.get(i).setBobotPrestasi(1);
            }
            Log.d("BOBOT PRESTASI", String.valueOf(itemPendaftars.get(i).getBobotPrestasi()));
        }
    }

    void bobotPendapatan(List<DataItemBeasiswa> itemPendaftars) {
        for (int i = 0; i < itemPendaftars.size(); i++) {
            Log.d("BOBOTPENGHASILAN", String.valueOf(itemPendaftars.get(i).getPenghasilan()));
            if (itemPendaftars.get(i).getPenghasilan() <= 1000000) {
                itemPendaftars.get(i).setBobotPenghasilan(4);
            } else if (itemPendaftars.get(i).getPenghasilan() >= 1000000 && itemPendaftars.get(i).getPenghasilan() < 1500000) {
                itemPendaftars.get(i).setBobotPenghasilan(3);
            } else if (itemPendaftars.get(i).getPenghasilan() >= 1500000 && itemPendaftars.get(i).getPenghasilan() <= 2000000) {
                itemPendaftars.get(i).setBobotPenghasilan(2);
            } else if (itemPendaftars.get(i).getPenghasilan() >= 2000000) {
                itemPendaftars.get(i).setBobotPenghasilan(1);
            }
            Log.d("BOBOT PENGHASILAN", String.valueOf(itemPendaftars.get(i).getBobotPenghasilan()));
        }
    }

    void bobotTanggungan(List<DataItemBeasiswa> itemPendaftars) {
        for (int i = 0; i < itemPendaftars.size(); i++) {
            if (itemPendaftars.get(i).getTanggungan() == 1) {
                itemPendaftars.get(i).setJumlahTanggungan(1);
            } else if (itemPendaftars.get(i).getTanggungan() == 2) {
                itemPendaftars.get(i).setJumlahTanggungan(2);
            } else if (itemPendaftars.get(i).getTanggungan() == 3) {
                itemPendaftars.get(i).setJumlahTanggungan(3);
            } else if (itemPendaftars.get(i).getTanggungan() >= 4) {
                itemPendaftars.get(i).setJumlahTanggungan(4);
            }
            Log.d("BOBOT TANGGUNGAN", String.valueOf(itemPendaftars.get(i).getTanggungan()));
        }
    }

    void bobotKriteriaRumah(List<DataItemBeasiswa> itemPendaftars) {
        for (int i = 0; i < itemPendaftars.size(); i++) {
            if (itemPendaftars.get(i).getKriteriaRumah().equalsIgnoreCase(("Rumah Permanen"))) {
                itemPendaftars.get(i).setBobotKriteriaRumah(1);
            } else if (itemPendaftars.get(i).getKriteriaRumah().equalsIgnoreCase(("Rumah Kayu alas semen"))) {
                itemPendaftars.get(i).setBobotKriteriaRumah(2);
            } else if (itemPendaftars.get(i).getKriteriaRumah().equalsIgnoreCase(("Rumah Kayu Panggung"))) {
                itemPendaftars.get(i).setBobotKriteriaRumah(3);
            } else if (itemPendaftars.get(i).getKriteriaRumah().equalsIgnoreCase(("Rumah Kayu ALas tanah"))) {
                itemPendaftars.get(i).setBobotKriteriaRumah(4);
            }
            Log.d("BOBOT KRITERIA RUMAH", String.valueOf(itemPendaftars.get(i).getBobotKriteriaRumah()));
        }
    }

    void bobotPemilikRumah(List<DataItemBeasiswa> itemPendaftars) {
        for (int i = 0; i < itemPendaftars.size(); i++) {
            if (itemPendaftars.get(i).getKepimilikanRumah().equalsIgnoreCase(("Pribadi"))) {
                itemPendaftars.get(i).setBobotKepemilikanRumah(1);
            } else if (itemPendaftars.get(i).getKepimilikanRumah().equalsIgnoreCase(("Sewa Tahunan"))) {
                itemPendaftars.get(i).setBobotKepemilikanRumah(2);
            } else if (itemPendaftars.get(i).getKepimilikanRumah().equalsIgnoreCase(("Sewa Bulanan"))) {
                itemPendaftars.get(i).setBobotKepemilikanRumah(3);
            } else if (itemPendaftars.get(i).getKepimilikanRumah().equalsIgnoreCase(("Numpang"))) {
                itemPendaftars.get(i).setBobotKepemilikanRumah(4);
            }
            Log.d("BOBOT PEMILIK RUMAH", String.valueOf(itemPendaftars.get(i).getBobotKepemilikanRumah()));
        }
    }

    void bobotIsiRumah(List<DataItemBeasiswa> itemPendaftars) {
        for (int i = 0; i < itemPendaftars.size(); i++) {
            if (itemPendaftars.get(i).getIsiRumah().equals(("4"))) {
                itemPendaftars.get(i).setBobotIsiRumah(1);
            } else if (itemPendaftars.get(i).getIsiRumah().equals(("3"))) {
                itemPendaftars.get(i).setBobotIsiRumah(2);
            } else if (itemPendaftars.get(i).getIsiRumah().equals(("2"))) {
                itemPendaftars.get(i).setBobotIsiRumah(3);
            } else if (itemPendaftars.get(i).getIsiRumah().equals(("1"))) {
                itemPendaftars.get(i).setBobotIsiRumah(4);
            } else {
                itemPendaftars.get(i).setBobotIsiRumah(1);
            }
            Log.d("BOBOT ISI RUMAH", String.valueOf(itemPendaftars.get(i).getBobotIsiRumah()));
        }
    }

    void bobotMandiCuciKakus(List<DataItemBeasiswa> itemPendaftars) {
        for (int i = 0; i < itemPendaftars.size(); i++) {
            if (itemPendaftars.get(i).getMandiCuciKakus().equalsIgnoreCase(("Ada dalam rumah"))) {
                itemPendaftars.get(i).setBobotMandiCuciKakus(1);
            } else if (itemPendaftars.get(i).getMandiCuciKakus().equalsIgnoreCase(("Ada luar rumah"))) {
                itemPendaftars.get(i).setBobotMandiCuciKakus(2);
            } else if (itemPendaftars.get(i).getMandiCuciKakus().equalsIgnoreCase(("Ada tidak layak"))) {
                itemPendaftars.get(i).setBobotMandiCuciKakus(3);
            } else if (itemPendaftars.get(i).getMandiCuciKakus().equalsIgnoreCase(("umum"))) {
                itemPendaftars.get(i).setBobotMandiCuciKakus(4);
            }
            Log.d("BOBOT MANDI CUCI KAKUS", String.valueOf(itemPendaftars.get(i).getBobotMandiCuciKakus()));
        }
    }

    void bobotLuasTanah(List<DataItemBeasiswa> itemPendaftars) {
        for (int i = 0; i < itemPendaftars.size(); i++) {
            if (itemPendaftars.get(i).getLuasTanah() >= 200) {
                itemPendaftars.get(i).setBobotLuasTanah(1);
            } else if (itemPendaftars.get(i).getLuasTanah() >= 100 && itemPendaftars.get(i).getLuasTanah() <= 200) {
                itemPendaftars.get(i).setBobotLuasTanah(2);
            } else if (itemPendaftars.get(i).getLuasTanah() >= 50 && itemPendaftars.get(i).getLuasTanah() <= 100) {
                itemPendaftars.get(i).setBobotLuasTanah(3);
            } else if (itemPendaftars.get(i).getLuasTanah() <= 50) {
                itemPendaftars.get(i).setBobotLuasTanah(4);
            }
            Log.d("BOBOT LUAS TANAH", String.valueOf(itemPendaftars.get(i).getBobotLuasTanah()));
        }
    }void bobotJarakPusat(List<DataItemBeasiswa> itemPendaftars) {
        for (int i = 0; i < itemPendaftars.size(); i++) {
            if (itemPendaftars.get(i).getJarakPusatKota() <= 5) {
                itemPendaftars.get(i).setBobotJarakPusatKota(1);
            }else if (itemPendaftars.get(i).getJarakPusatKota() >= 5 && itemPendaftars.get(i).getJarakPusatKota() <= 10) {
                itemPendaftars.get(i).setBobotJarakPusatKota(2);
            }else if (itemPendaftars.get(i).getJarakPusatKota() >=10 && itemPendaftars.get(i).getJarakPusatKota() <= 15) {
                itemPendaftars.get(i).setBobotJarakPusatKota(3);
            }else if (itemPendaftars.get(i).getJarakPusatKota() >= 15) {
                itemPendaftars.get(i).setBobotJarakPusatKota(4);
            }
            Log.d("BOBOT JARAK PUSAT KOTA", String.valueOf(itemPendaftars.get(i).getJarakPusatKota()));
        }
    }void bobotSumberAir(List<DataItemBeasiswa> itemPendaftars) {
        for (int i = 0; i < itemPendaftars.size(); i++) {
            if (itemPendaftars.get(i).getSumberAir().equalsIgnoreCase("Kemasan")) {
                itemPendaftars.get(i).setBobotSumberAir(1);
            }else if (itemPendaftars.get(i).getSumberAir().equalsIgnoreCase("PDAM")) {
                itemPendaftars.get(i).setBobotSumberAir(2);
            }else if (itemPendaftars.get(i).getSumberAir().equalsIgnoreCase("SUMUR")) {
                itemPendaftars.get(i).setBobotSumberAir(3);
            }else if (itemPendaftars.get(i).getSumberAir().equalsIgnoreCase("SUNGAI")) {
                itemPendaftars.get(i).setBobotSumberAir(4);
            }
            Log.d("BOBOT SUMBER AIR", String.valueOf(itemPendaftars.get(i).getSumberAir()));
        }
    }

    void vectorS(List<DataItemBeasiswa> itemPendaftars) {
        double pangkatNilaiUn = 0.15;
        double pangkatPrestasi = 0.10;
        double pangkatPendapatan = 0.12;
        double pangkatTanggungan = 0.12;
        double pangkatKriteriaRumah = 0.10;
        double pangkatPemilikRumah = 0.09;
        double pangkatIsiRumah = 0.08;
        double pangkatMandiCuci = 0.08;
        double pangkatLuasTanah = 0.06;
        double pangkatJarakPusatKota = 0.05;
        double pangkatSumberAir = 0.05;

        for (int i = 0; i < itemPendaftars.size(); i++) {
            double bobotIpk = Math.pow(itemPendaftars.get(i).getBobotNilaiUn(), pangkatNilaiUn);
            double bobotPrestasi = Math.pow(itemPendaftars.get(i).getBobotPrestasi(), pangkatPrestasi);
            double bobotPendapatan = Math.pow(itemPendaftars.get(i).getBobotPenghasilan(), pangkatPendapatan);
            double bobotTanggungan = Math.pow(itemPendaftars.get(i).getJumlahTanggungan(), pangkatTanggungan);

            double bobotKriteriaRumah = Math.pow(itemPendaftars.get(i).getBobotKriteriaRumah(), pangkatKriteriaRumah);
            double bobotPemilik = Math.pow(itemPendaftars.get(i).getBobotKepemilikanRumah(), pangkatPemilikRumah);
            double bobotIsi = Math.pow(itemPendaftars.get(i).getBobotIsiRumah(), pangkatIsiRumah);
            double bobotMandi = Math.pow(itemPendaftars.get(i).getBobotMandiCuciKakus(), pangkatMandiCuci);
            double bobotLuas = Math.pow(itemPendaftars.get(i).getBobotLuasTanah(), pangkatLuasTanah);
            double bobotJakPus = Math.pow(itemPendaftars.get(i).getBobotJarakPusatKota(), pangkatJarakPusatKota);
            double bobotSumberAir = Math.pow(itemPendaftars.get(i).getBobotSumberAir(), pangkatSumberAir);

            NumberFormat formatter = new DecimalFormat("#0.000");
            double hasilS1 = bobotIpk * bobotPrestasi * bobotPendapatan * bobotTanggungan * bobotKriteriaRumah
                           * bobotPemilik * bobotIsi * bobotMandi * bobotLuas * bobotJakPus* bobotSumberAir;
            itemPendaftars.get(i).setVectorS(hasilS1);
            Log.d("BOBOT  S1", String.valueOf(formatter.format(hasilS1)));
        }
        double sTotal = 0;
        for (int i = 0; i < itemPendaftars.size(); i++) {
            sTotal = sTotal + itemPendaftars.get(i).getVectorS();
        }
        NumberFormat formatter = new DecimalFormat("#0.000");
        Log.d("BOBOT  STOTAL", String.valueOf(formatter.format(sTotal)));
        vectorV(dataItemPendaftarList, sTotal);
    }

    void vectorV(List<DataItemBeasiswa> itemPendaftars, double sTotal) {
        NumberFormat formatter = new DecimalFormat("#0.000");
        double vectorV;
        for (int i = 0; i < itemPendaftars.size(); i++) {
            vectorV = itemPendaftars.get(i).getVectorS() / sTotal;
            Log.d("BOBOT  STOTAL", String.valueOf(vectorV));
            itemPendaftars.get(i).setVectorV(vectorV);
        }
    }
}
