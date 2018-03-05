package uinbdg.skirpsi.futsal.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uinbdg.skirpsi.futsal.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class BenefitActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.lay_type_manfaat)
    LinearLayout layTypeManfaat;
    @BindView(R.id.btn_proses)
    Button btnProses;
    @BindView(R.id.tv_detail_type_manfaat)
    TextView tvDetailTypeManfaat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benefit);
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

    @OnClick({R.id.lay_type_manfaat, R.id.btn_proses})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lay_type_manfaat:
                PopupMenu popupMenu = new PopupMenu(this, layTypeManfaat);
                popupMenu.inflate(R.menu.menu_type_manfaat);
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        tvDetailTypeManfaat.setText(menuItem.getTitle());
                        return false;
                    }
                });

                break;
            case R.id.btn_proses:
                startActivity(new Intent(this,BenefitManfaatActivity.class));
                break;
        }
    }
}
