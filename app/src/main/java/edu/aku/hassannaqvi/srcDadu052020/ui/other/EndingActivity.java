package edu.aku.hassannaqvi.srcDadu052020.ui.other;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.srcDadu052020.R;
import edu.aku.hassannaqvi.srcDadu052020.core.DatabaseHelper;
import edu.aku.hassannaqvi.srcDadu052020.core.MainApp;
import edu.aku.hassannaqvi.srcDadu052020.databinding.ActivityEndingBinding;
import edu.aku.hassannaqvi.srcDadu052020.validator.validator.ValidatorClass;

import static edu.aku.hassannaqvi.srcDadu052020.CONSTANTS.SUB_INFO_END_FLAG;

public class EndingActivity extends AppCompatActivity {

    ActivityEndingBinding bi;
    private boolean subInfoEndActivityFlag = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_ending);
        bi.setCallback(this);

        setupSkips();

        boolean check = getIntent().getBooleanExtra("complete", false);
        subInfoEndActivityFlag = getIntent().getBooleanExtra(SUB_INFO_END_FLAG, false);

        if (check) {
            bi.istatusa.setEnabled(true);
            bi.istatusb.setEnabled(false);
            bi.istatusc.setEnabled(false);
            bi.istatus96.setEnabled(false);
            bi.istatus96x.setEnabled(false);
        } else {
            bi.istatusa.setEnabled(false);
            bi.istatusb.setEnabled(true);
            bi.istatusc.setEnabled(true);
            bi.istatus96.setEnabled(true);
        }
    }

    private void setupSkips() {
        bi.istatus96.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (bi.istatus96.isChecked()) {
                    bi.istatus96x.setVisibility(View.VISIBLE);
                } else {
                    Clear.clearAllFields(bi.istatus96x);
                    bi.istatus96x.setVisibility(View.GONE);
                }
            }
        });
    }

    public void BtnEnd() {
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                finish();
                if (subInfoEndActivityFlag) startActivity(new Intent(this, MainActivity.class));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void SaveDraft() {

        String statusValue = bi.istatusa.isChecked() ? "1"
                : bi.istatusb.isChecked() ? "2"
                : bi.istatusc.isChecked() ? "3"
                : bi.istatus96.isChecked() ? "96"
                : "0";

        MainApp.fc.setEndingdatetime(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        MainApp.fc.setfStatus(statusValue);
        MainApp.fc.setFstatus88x(bi.istatus96x.getText().toString());
    }

    public boolean UpdateDB() {

        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updateEnding();
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpEnd);
        //return Validator.emptyCheckingContainer(this, bi.fldGrpEnd);
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

}