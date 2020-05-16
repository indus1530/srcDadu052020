package edu.aku.hassannaqvi.srcDadu052020.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.srcDadu052020.R;
import edu.aku.hassannaqvi.srcDadu052020.contracts.ChildContract;
import edu.aku.hassannaqvi.srcDadu052020.core.DatabaseHelper;
import edu.aku.hassannaqvi.srcDadu052020.core.MainApp;
import edu.aku.hassannaqvi.srcDadu052020.databinding.ActivitySectionABinding;

import static edu.aku.hassannaqvi.srcDadu052020.core.MainApp.child;
import static edu.aku.hassannaqvi.srcDadu052020.utils.UtilKt.contextEndActivity;

public class SectionAActivity extends AppCompatActivity {

    ActivitySectionABinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a);
        bi.setCallback(this);
        setupListeners();
    }


    private void setupListeners() {

        /*bi.ec19.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.ec19a.getId()) {
                Clear.clearAllFields(bi.fldGrpCVec21, false);
            } else {
                Clear.clearAllFields(bi.fldGrpCVec21, true);
            }
        }));

        bi.ec13.setText(String.valueOf(getIntent().getIntExtra(CHILD_SERIAL, 0)));*/
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long updcount = db.addChild(child);
        child.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            child.setUID(MainApp.deviceId + child.get_ID());
            db.updatesChildColumn(ChildContract.SingleChild.COLUMN_UID, child.getUID());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        JSONObject sA = new JSONObject();

        sA.put("a1", bi.a1.getText().toString());

        sA.put("a2", bi.a2.getText().toString());

        sA.put("a3", bi.a3.getText().toString());

        sA.put("a4", bi.a4.getText().toString());

        sA.put("a5", bi.a5.getText().toString());

        sA.put("a6", bi.a6.getText().toString());

        sA.put("a7", bi.a7.getText().toString());

        sA.put("a8", bi.a8.getText().toString());

        sA.put("a9", bi.a9.getText().toString());

        sA.put("a10", bi.a10.getText().toString());

        sA.put("a1101", bi.a1101.isChecked() ? "1" : "-1");

        sA.put("a1102", bi.a1102.isChecked() ? "2" : "-1");

        sA.put("a1103", bi.a1103.isChecked() ? "3" : "-1");

        sA.put("a1104", bi.a1104.isChecked() ? "4" : "-1");

        sA.put("a1201", bi.a1201.isChecked() ? "1" : "-1");

        sA.put("a1202", bi.a1202.isChecked() ? "2" : "-1");

        sA.put("a1203", bi.a1203.isChecked() ? "3" : "-1");

        sA.put("a1204", bi.a1204.isChecked() ? "4" : "-1");

        sA.put("a1205", bi.a1205.isChecked() ? "5" : "-1");

        sA.put("a1206", bi.a1206.isChecked() ? "6" : "-1");

        sA.put("a1207", bi.a1207.isChecked() ? "7" : "-1");

        sA.put("a1208", bi.a1208.isChecked() ? "8" : "-1");

        sA.put("a1209", bi.a1209.isChecked() ? "9" : "-1");

        sA.put("a1210", bi.a1210.isChecked() ? "10" : "-1");

        sA.put("a1211", bi.a1211.isChecked() ? "11" : "-1");

        sA.put("a1212", bi.a1212.isChecked() ? "12" : "-1");

        sA.put("a1213", bi.a1213.isChecked() ? "13" : "-1");

        child.setsCA(String.valueOf(sA));
    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnContinue() {

        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, SectionCHBActivity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void BtnEnd() {
        if (!formValidation()) return;
        contextEndActivity(this);
    }

}