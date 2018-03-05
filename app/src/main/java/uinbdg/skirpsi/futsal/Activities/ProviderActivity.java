package uinbdg.skirpsi.futsal.Activities;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uinbdg.skirpsi.futsal.R;
import uinbdg.skirpsi.futsal.Util.DummyData;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ProviderActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_detail_provinsi)
    TextView tvDetailProvinsi;
    @BindView(R.id.lay_provider_)
    LinearLayout layProvider;
    @BindView(R.id.tv_detail_kota)
    TextView tvDetailKota;
    @BindView(R.id.lay_provider_kota)
    LinearLayout layProviderKota;
    @BindView(R.id.btn_proses)
    Button btnProses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_provider);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initView();
    }

    private void initView() {

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

    private void dialogList(String title, final String[] listItem, final TextView textView) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_list);
        dialog.setTitle(title);

        ListView listView = (ListView) dialog.findViewById(R.id.list);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItem);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                dialog.dismiss();
                textView.setText(listItem[i]);
            }
        });
        dialog.show();
    }

    @OnClick({R.id.lay_provider_, R.id.lay_provider_kota})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lay_provider_:
                dialogList("Pilih Provinsi", DummyData.listProvinsi(), tvDetailProvinsi);
                break;
            case R.id.lay_provider_kota:
                dialogList("Pilih Kota", DummyData.listKOTA(), tvDetailKota);
                break;
        }
    }

    @OnClick(R.id.btn_proses)
    public void onViewClicked() {
        startActivity(new Intent(this,ProviderResultActivity.class));
    }
}
