package uinbdg.skirpsi.futsal.Activities;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uinbdg.skirpsi.futsal.R;
import uinbdg.skirpsi.futsal.Util.CommonUtil;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class EditProfilActivity extends AppCompatActivity {

    @BindView(R.id.et_alamat)
    EditText etNoPeserta;
    @BindView(R.id.et_manager)
    EditText etDate;
    @BindView(R.id.et_et_email)
    EditText etEtEmail;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.et_konfir_password)
    EditText etKonfirPassword;
    @BindView(R.id.btn_daftar)
    Button btnDaftar;

    DatePickerDialog datePicker;
    @BindView(R.id.btn_back_to_login)
    ImageButton btnBackToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_team);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        etDate.setText(CommonUtil.getCurrentDate("dd/mm/yyyy"));

        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy", Locale.US);
        Calendar newCalendar = Calendar.getInstance();
        datePicker = new DatePickerDialog(EditProfilActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(i, i1, i2);
                etDate.setText(dateFormat.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    @OnClick({R.id.et_alamat, R.id.et_manager, R.id.et_et_email, R.id.et_phone, R.id.et_password, R.id.et_konfir_password, R.id.btn_daftar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_alamat:
                break;
            case R.id.et_manager:
                datePicker.show();
                break;
            case R.id.et_et_email:
                break;
            case R.id.et_phone:
                break;
            case R.id.et_password:
                break;
            case R.id.et_konfir_password:
                break;
            case R.id.btn_daftar:
                dialogKirimKlaim();
                break;
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void dialogKirimKlaim() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profil anda berhasil di perbaharui");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        Dialog dialog = builder.create();
        dialog.show();

    }

    @OnClick(R.id.btn_back_to_login)
    public void onViewClicked() {
        onBackPressed();
    }
}
