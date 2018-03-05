package uinbdg.skirpsi.futsal.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import uinbdg.skirpsi.futsal.Adapter.AdapterBukuSaku;
import uinbdg.skirpsi.futsal.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class BukuSakuActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler_view_buku_saku)
    RecyclerView recyclerViewKontak;
    AdapterBukuSaku adapterBukuSaku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku_saku);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initView();
    }

    private void initView() {
        adapterBukuSaku = new AdapterBukuSaku(this);

    recyclerViewKontak.setLayoutManager(new LinearLayoutManager(this));
    recyclerViewKontak.setAdapter(adapterBukuSaku);
    recyclerViewKontak.setHasFixedSize(true);

    adapterBukuSaku.setOnItemClickListener(new AdapterBukuSaku.OnItemClickListener() {
        @Override
        public void onItemClick( int position) {
            startActivity(new Intent(BukuSakuActivity.this,BukuSakuDetailActivity.class));
        }
    });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
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
