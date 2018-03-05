package uinbdg.skirpsi.futsal.Activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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

public class KlaimKirimActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.lay_type_klaim)
    LinearLayout layTypeKlaim;
    @BindView(R.id.btn_proses)
    Button btnProses;
    @BindView(R.id.tv_detail_tv_klaim)
    TextView tvDetailTvKlaim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klaim_kirim);
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

    private void dialogKirimKlaim() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Klaim Berhasil Dikirim");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        Dialog dialog = builder.create();
        dialog.show();

    }


    @OnClick({R.id.lay_type_klaim, R.id.btn_proses})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lay_type_klaim:
                PopupMenu popupMenu = new PopupMenu(this, layTypeKlaim);
                popupMenu.inflate(R.menu.menu_klaim);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        tvDetailTvKlaim.setText(menuItem.getTitle());
                        return false;
                    }
                });
                popupMenu.show();
                break;
            case R.id.btn_proses:
                dialogKirimKlaim();
                break;
        }
    }
}
