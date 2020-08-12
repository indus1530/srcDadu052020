package edu.aku.hassannaqvi.srcDadu052020.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
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
import edu.aku.hassannaqvi.srcDadu052020.ui.other.EndingActivity;

import static edu.aku.hassannaqvi.srcDadu052020.core.MainApp.pc;

public class SectionParticipantsSRC extends AppCompatActivity {

    private static final String TAG = "Part";
    //public static ParticipantContract pc;
    static int counter = 1;
    static int counter_addmore = 1;
    static boolean iscomplete = false;

    ActivitySectionParticipantsSRCBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_participants_s_r_c);
        bi.setCallback(this);

        counter = 1;

        if (MainApp.No_participants == 0) {
            MainApp.No_participants = 1;

            bi.sno.setText("Participants # - " + counter + " of " + MainApp.No_participants);
        } else {
            bi.sno.setText("Participants # - " + counter + " of " + MainApp.No_participants);
        }

        setupListeners();
    }


    private void setupListeners() {

        bi.c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (bi.f1.isChecked() && bi.c2.isChecked()) {

                    Clear.clearAllFields(bi.fldGrpCVg);
                    Clear.clearAllFields(bi.fldGrpCVh);

                    bi.i12.setEnabled(true);
                    bi.f5.setEnabled(true);

                    bi.fldGrpCVg.setVisibility(View.GONE);
                    bi.fldGrpCVh.setVisibility(View.GONE);

                } else if (bi.c1.isChecked()) {
                    bi.fldGrpCVg.setVisibility(View.GONE);
                    bi.fldGrpCVh.setVisibility(View.GONE);

                    Clear.clearAllFields(bi.fldGrpCVg);
                    Clear.clearAllFields(bi.fldGrpCVh);

                    bi.i12.setChecked(false);
                    bi.i12.setEnabled(false);

                    bi.f5.setChecked(false);
                    bi.f5.setEnabled(false);

                } else {
                    bi.fldGrpCVg.setVisibility(View.VISIBLE);
                    bi.fldGrpCVh.setVisibility(View.VISIBLE);

                    //bi.i12.setChecked(true);
                    bi.i12.setEnabled(true);

                    //bi.f5.setChecked(true);
                    bi.f5.setEnabled(true);
                }
            }
        });

        bi.f.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (bi.c1.isChecked()) {
                    Clear.clearAllFields(bi.fldGrpCVg);
                    Clear.clearAllFields(bi.fldGrpCVh);

                    bi.i12.setChecked(false);
                    bi.i12.setEnabled(false);

                    bi.f5.setChecked(false);
                    bi.f5.setEnabled(false);

                    bi.fldGrpCVg.setVisibility(View.GONE);
                    bi.fldGrpCVh.setVisibility(View.GONE);
                } else if (bi.f2.isChecked() && bi.c2.isChecked() ||
                        bi.f3.isChecked() && bi.c2.isChecked() ||
                        bi.f4.isChecked() && bi.c2.isChecked() ||
                        bi.f5.isChecked() && bi.c2.isChecked()) {

                    bi.i12.setEnabled(true);
                    bi.f5.setEnabled(true);

                    bi.fldGrpCVg.setVisibility(View.VISIBLE);
                    bi.fldGrpCVh.setVisibility(View.VISIBLE);

                } else if (bi.f1.isChecked() && bi.c2.isChecked()) {
                    Clear.clearAllFields(bi.fldGrpCVg);
                    Clear.clearAllFields(bi.fldGrpCVh);

                    bi.f5.setEnabled(true);
                    bi.f5.setEnabled(true);

                    bi.fldGrpCVg.setVisibility(View.GONE);
                    bi.fldGrpCVh.setVisibility(View.GONE);
                }
            }
        });

        bi.g.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (!bi.f1.isChecked() && bi.g1.isChecked() && bi.c2.isChecked()) {
                    bi.fldGrpCVh.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpCVh.setVisibility(View.GONE);
                    Clear.clearAllFields(bi.fldGrpCVh);
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
            db.updatesParticipant(ParticipantContract.SingleParticipant.COLUMN_UID, pc.getUID());
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
        pc.setTaluka(MainApp.talukacode);
        pc.setUc(MainApp.uccode);
        pc.setVillage(MainApp.villagecode);
        pc.setUser(MainApp.userName);
        pc.setSno(String.valueOf(counter));
        MainApp.setGPS(this);


        JSONObject json = new JSONObject();

        json.put("sno", counter);
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

        if (!bi.d.getText().toString().equals("")) {
            if (bi.d.getText().toString().length() < 11) {
                Toast.makeText(this, "Contact number must be 11 digits ", Toast.LENGTH_SHORT).show();
                return false;
            }
        }


        /*if (!bi.e.getText().toString().equals("") && !bi.b.getText().toString().equals("")) {
            if (!bi.e.getText().toString().equals("97")) {
                if (Integer.valueOf(bi.e.getText().toString()) >= Integer.valueOf(bi.b.getText().toString())) {
                    Toast.makeText(this, "Education cannot be greater or cannot be equal to age", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
        }*/

        if (!bi.e.getText().toString().equals("")) {
            if (!bi.e.getText().toString().equals("97")) {
                if (Integer.parseInt(bi.e.getText().toString()) < 0 || Integer.parseInt(bi.e.getText().toString()) > 16) {
                    Toast.makeText(this, "Education must be between 0 - 16 or 97", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
        }

        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnContinue() {
        if (formValidation()) {

            if (counter > MainApp.No_participants) {
                bi.btnContinue.setVisibility(View.GONE);
                bi.btnAddMore.setVisibility(View.VISIBLE);
                bi.btnEnd.setVisibility(View.VISIBLE);

                iscomplete = true;

                if (MainApp.No_participants == 0) {
                    bi.sno.setText("Participants # - 1 of " + counter);
                } else {
                    bi.sno.setText("Participants # - " + MainApp.No_participants + " of " + counter);
                }

                //Log.d(TAG, "BtnContinue: Mainapp - " + MainApp.No_participants + " counter - " + counter);

            } else {

                try {
                    SaveDraft();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if (UpdateDB()) {
                    //finish();
                    ///startActivity(new Intent(this, MainActivity.class));
                } else {
                    Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
                }


                if (counter >= MainApp.No_participants) {
                    bi.btnContinue.setVisibility(View.GONE);
                    bi.btnAddMore.setVisibility(View.VISIBLE);
                    bi.btnEnd.setVisibility(View.VISIBLE);

                    iscomplete = true;

                    bi.sno.setText("Participants # - " + MainApp.No_participants + " of " + counter);
                }


                counter++;


                bi.a.setText("");
                bi.b.setText("");
                bi.c.clearCheck();
                bi.d.setText("");
                bi.e.setText("");
                bi.f.clearCheck();
                bi.g.clearCheck();
                bi.h.setText("");
                bi.i.clearCheck();

                bi.a.requestFocus();

                bi.sno.setText("Participants # - " + counter + " of " + MainApp.No_participants);

                //Log.d(TAG, "BtnContinue: Mainapp1 - " + MainApp.No_participants + " counter - " + counter);
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
                //finish();
                //startActivity(new Intent(this, MainActivity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }

            iscomplete = true;

            //counter++;
            counter_addmore++;
            bi.sno.setText("Participants # - " + counter_addmore + " of " + counter + "(" + MainApp.No_participants + ")");

            /*bi.a.setText("");
            bi.b.setText("");
            bi.c.clearCheck();
            bi.d.setText("");
            bi.e.setText("");
            bi.f.clearCheck();
            bi.g.clearCheck();
            bi.h.setText("");
            bi.i.clearCheck();*/
            Clear.clearAllFields(bi.GrpName);
            bi.a.requestFocus();
        }

    }


    public void BtnEnd() {
        //if (!formValidation()) return;
        //contextEndActivity(this);

        Intent intent = new Intent(this, EndingActivity.class);
        intent.putExtra("complete", iscomplete);

        counter = 0;
        counter_addmore = 0;
        iscomplete = false;

        finish();

        startActivity(intent);
    }

}