package uinbdg.SIK.ptkis.Activities;

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
import uinbdg.SIK.ptkis.R;
import uinbdg.SIK.ptkis.Util.CommonUtil;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_univ)
    RelativeLayout btnUniv;
    @BindView(R.id.btn_beasiswa)
    RelativeLayout btnBeasiswa;
    @BindView(R.id.btn_tentang)
    RelativeLayout btnTentang;
    @BindView(R.id.btn_exit)
    RelativeLayout btnExit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

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

                break;
            case R.id.menu_exit:
                CommonUtil.exit(this);
                break;
            case R.id.menu_edit_profil:

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.btn_univ, R.id.btn_beasiswa, R.id.btn_tentang, R.id.btn_exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_univ:
                startActivity(new Intent(this, UniversitasActivity.class));
                break;
            case R.id.btn_beasiswa:
                startActivity(new Intent(this, PendaftarActivity.class));
                break;
            case R.id.btn_tentang:
                break;
            case R.id.btn_exit:
                CommonUtil.exit(this);
                break;
        }
    }
}
