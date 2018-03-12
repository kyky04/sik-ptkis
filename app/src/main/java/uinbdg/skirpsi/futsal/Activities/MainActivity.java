package uinbdg.skirpsi.futsal.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


import uinbdg.skirpsi.futsal.Util.CommonUtil;
import uinbdg.skirpsi.futsal.R;
import uinbdg.skirpsi.futsal.Util.Session;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_tim)
    RelativeLayout btnPeserta;
    @BindView(R.id.btn_jadwal)
    RelativeLayout btnBenefit;
    @BindView(R.id.btn_lapangan)
    RelativeLayout btnProvider;

    @BindView(R.id.btn_myteam)
    RelativeLayout btnKlaim;

    @BindView(R.id.btn_kompetisi)
    RelativeLayout btnBukuSaku;
    @BindView(R.id.btn_tentang)
    RelativeLayout btnKontakKami;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        session = new Session(this);
    }

    @OnClick({R.id.btn_tim, R.id.btn_jadwal, R.id.btn_lapangan, R.id.btn_myteam, R.id.btn_kompetisi, R.id.btn_tentang})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_tim:
                startActivity(new Intent(this, TimActivity.class));
                break;
            case R.id.btn_jadwal:
                startActivity(new Intent(this, JadwalActivity.class));
                break;
            case R.id.btn_lapangan:
                startActivity(new Intent(this, LapanganActivity.class));
                break;
            case R.id.btn_myteam:
                startActivity(new Intent(this, MyTeamActivity.class));
                break;

            case R.id.btn_kompetisi:
                startActivity(new Intent(this, KompetisiActivity.class));
                break;
            case R.id.btn_tentang:
                startActivity(new Intent(this, PertandinganActivity.class));
                break;

        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onBackPressed() {
        CommonUtil.exit(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_logout:
                session.logoutUser();
                break;
            case R.id.menu_exit:
                CommonUtil.exit(this);
                break;
            case R.id.menu_edit_profil:
                startActivity(new Intent(this, EditProfilActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
