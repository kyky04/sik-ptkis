package uinbdg.skirpsi.futsal.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uinbdg.skirpsi.futsal.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class KlaimActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.lay_riwayat)
    LinearLayout layRiwayat;
    @BindView(R.id.lay_kirim)
    LinearLayout layKirim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klaim);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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


    @OnClick({R.id.lay_riwayat, R.id.lay_kirim})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lay_riwayat:
                startActivity(new Intent(this,KlaimRiwayatActivity.class));
                break;
            case R.id.lay_kirim:
                startActivity(new Intent(this,KlaimKirimActivity.class));
                break;
        }
    }
}
