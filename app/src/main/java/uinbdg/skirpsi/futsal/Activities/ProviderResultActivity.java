package uinbdg.skirpsi.futsal.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import uinbdg.skirpsi.futsal.Adapter.AdapterVpResultProvider;
import uinbdg.skirpsi.futsal.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ProviderResultActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab_layout_result_provider)
    TabLayout tabLayoutResultProvider;
    @BindView(R.id.view_pager_result_provider)
    ViewPager viewPagerResultProvider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_provider);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initView();
    }

    private void initView() {

        tabLayoutResultProvider.addTab(tabLayoutResultProvider.newTab().setText("RUMAH SAKIT"));
        tabLayoutResultProvider.addTab(tabLayoutResultProvider.newTab().setText("KLINIK"));
        tabLayoutResultProvider.addTab(tabLayoutResultProvider.newTab().setText("DOKTER"));

        viewPagerResultProvider.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutResultProvider));

        viewPagerResultProvider.setAdapter(new AdapterVpResultProvider(getSupportFragmentManager()));
        tabLayoutResultProvider.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerResultProvider.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

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
