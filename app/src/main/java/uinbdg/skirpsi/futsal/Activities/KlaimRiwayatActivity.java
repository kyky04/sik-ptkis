package uinbdg.skirpsi.futsal.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import uinbdg.skirpsi.futsal.Adapter.AdapterRiwayatKlaim;
import uinbdg.skirpsi.futsal.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class KlaimRiwayatActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler_view_riwayat_klaim)
    RecyclerView recyclerViewRiwayat;

    AdapterRiwayatKlaim adapterRiwayatKlaim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klaim_riwayat);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initView();
    }

    private void initView() {
        adapterRiwayatKlaim = new AdapterRiwayatKlaim(this);
        recyclerViewRiwayat.setLayoutManager(new GridLayoutManager(this,2));
        recyclerViewRiwayat.setAdapter(adapterRiwayatKlaim);
        recyclerViewRiwayat.setHasFixedSize(true);

        adapterRiwayatKlaim.setOnItemClickListener(new AdapterRiwayatKlaim.OnItemClickListener() {
            @Override
            public void onItemClick( int position) {
                startActivity(new Intent(KlaimRiwayatActivity.this,KlaimDetailActivity.class));
            }
        });
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
}
