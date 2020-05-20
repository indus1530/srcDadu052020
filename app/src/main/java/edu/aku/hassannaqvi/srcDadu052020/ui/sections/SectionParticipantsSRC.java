package edu.aku.hassannaqvi.srcDadu052020.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.srcDadu052020.R;
import edu.aku.hassannaqvi.srcDadu052020.contracts.ParticipantContract;
import edu.aku.hassannaqvi.srcDadu052020.core.DatabaseHelper;
import edu.aku.hassannaqvi.srcDadu052020.core.MainApp;
import edu.aku.hassannaqvi.srcDadu052020.databinding.ActivitySectionParticipantsSRCBinding;
import edu.aku.hassannaqvi.srcDadu052020.ui.other.MainActivity;

import static edu.aku.hassannaqvi.srcDadu052020.utils.UtilKt.contextEndActivity;

public class SectionParticipantsSRC extends AppCompatActivity {

    public static ParticipantContract pc;
    public static int counter = 1;
    public static int counter_addmore = 1;

    ActivitySectionParticipantsSRCBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_participants_s_r_c);
        bi.setCallback(this);

        if (MainApp.No_participants == 0) {
            MainApp.No_participants = 1;
            bi.sno.setText("Participants # - " + MainApp.No_participants);
        } else {
            bi.sno.setText("Participants # - " + MainApp.No_participants);
        }

        setupListeners();
    }


    private void setupListeners() {
        bi.g1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (bi.g1.isChecked() == true) {
                    bi.fldGrpCVh.setVisibility(View.VISIBLE);
                    Clear.clearAllFields(bi.fldGrpCVh, true);
                } else {
                    bi.fldGrpCVh.setVisibility(View.GONE);
                    Clear.clearAllFields(bi.fldGrpCVh, false);
                }
            }
        });
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long updcount = db.addParticipant(pc);
        pc.set_ID(String.valueOf(updcount));

        if (updcount > 0) {
            pc.setUID(MainApp.deviceId + pc.get_ID());
            db.updatesParticipant(ParticipantContract.singleParticipant.COLUMN_UID, pc.getUID());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        pc = new ParticipantContract();
        pc.set_UUID(MainApp.fc.get_UID());
        pc.setDeviceId(MainApp.appInfo.getDeviceID());
        pc.setDevicetagID(MainApp.appInfo.getTagName());
        pc.setFormDate(MainApp.fc.getFormDate());
        pc.setUser(MainApp.userName);
        pc.setSno(String.valueOf(counter));
        MainApp.setGPS(this);


        JSONObject json = new JSONObject();

        json.put("a", bi.a.getText().toString());

        json.put("b", bi.b.getText().toString());

        json.put("c", bi.c1.isChecked() ? "1"
                : bi.c2.isChecked() ? "2"
                : "-1");

        json.put("d", bi.d.getText().toString());

        json.put("e", bi.e.getText().toString());

        json.put("f", bi.f1.isChecked() ? "1"
                : bi.f2.isChecked() ? "2"
                : bi.f3.isChecked() ? "3"
                : bi.f4.isChecked() ? "4"
                : bi.f5.isChecked() ? "5"
                : "-1");

        json.put("g", bi.g1.isChecked() ? "1"
                : bi.g2.isChecked() ? "2"
                : "-1");

        json.put("h", bi.h.getText().toString());

        json.put("i", bi.i1.isChecked() ? "1"
                : bi.i2.isChecked() ? "2"
                : bi.i3.isChecked() ? "3"
                : bi.i4.isChecked() ? "4"
                : bi.i5.isChecked() ? "5"
                : bi.i6.isChecked() ? "6"
                : bi.i7.isChecked() ? "7"
                : bi.i8.isChecked() ? "8"
                : bi.i9.isChecked() ? "9"
                : bi.i10.isChecked() ? "10"
                : bi.i11.isChecked() ? "11"
                : bi.i12.isChecked() ? "12"
                : bi.i13.isChecked() ? "13"
                : bi.i14.isChecked() ? "14"
                : bi.i96.isChecked() ? "96"
                : "-1");

        json.put("i96x", bi.i96x.getText().toString());

        pc.setsA(String.valueOf(json));
    }

    private boolean formValidation() {

        if (Integer.valueOf(bi.e.getText().toString()) >= Integer.valueOf(bi.b.getText().toString())) {
            Toast.makeText(this, "Education cannot be greater or cannot be equal to age", Toast.LENGTH_SHORT).show();
            return false;
        }

        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnContinue() {
        if (formValidation()) {

            if (counter < MainApp.No_participants) {

                try {
                    SaveDraft();
                } catch (JSONException e) {

                    e.printStackTrace();
                }
                if (UpdateDB()) {
                    finish();
                    startActivity(new Intent(this, MainActivity.class));
                } else {
                    Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
                }

                counter++;
            } else {
                bi.btnContinue.setVisibility(View.GONE);
                bi.btnAddMore.setVisibility(View.VISIBLE);
            }

        }

    }

    public void BtnAddMore() {
        if (formValidation()) {

            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, MainActivity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }

            counter++;
            bi.sno.setText("Participants # - " + counter++ + "(" + counter_addmore++ + ")");
        }

    }


    public void BtnEnd() {
        if (!formValidation()) return;
        contextEndActivity(this);
    }

}