package edu.aku.hassannaqvi.srcDadu052020.ui.sections;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.aku.hassannaqvi.srcDadu052020.R;
import edu.aku.hassannaqvi.srcDadu052020.contracts.FormsContract;
import edu.aku.hassannaqvi.srcDadu052020.contracts.TalukasContract;
import edu.aku.hassannaqvi.srcDadu052020.contracts.UCsContract;
import edu.aku.hassannaqvi.srcDadu052020.contracts.VillagesContract;
import edu.aku.hassannaqvi.srcDadu052020.core.DatabaseHelper;
import edu.aku.hassannaqvi.srcDadu052020.core.MainApp;
import edu.aku.hassannaqvi.srcDadu052020.databinding.ActivitySectionABinding;


public class SectionAActivity extends AppCompatActivity {

    private static final String TAG = "";
    public static FormsContract fc;
    ArrayAdapter<String> a1Adapter;
    ActivitySectionABinding bi;
    private DatabaseHelper db;

    public List<String> talukaName, ucName, villageName;
    public List<String> talukaCode, ucCode, villageCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a);
        bi.setCallback(this);
        db = MainApp.appInfo.getDbHelper();
        //setupListeners();

        populateSpinner(this);
    }


    public void populateSpinner(final Context context) {
        // Spinner Drop down elements
        talukaName = new ArrayList<>();
        talukaCode = new ArrayList<>();

        talukaName.add("....");
        talukaCode.add("....");

        Collection<TalukasContract> dc = db.getTalukas();
        Log.d(TAG, "onCreate: " + dc.size());
        for (TalukasContract d : dc) {
            talukaName.add(d.getTaluka());
            talukaCode.add(d.getTalukacode());
        }

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, talukaName);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // attaching data adapter to spinner
        bi.a1.setAdapter(dataAdapter);


        bi.a1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //MainApp.talukaCode = talukaCode.get(position);

                ucCode = new ArrayList<>();
                ucName = new ArrayList<>();


                ucCode.add("....");
                ucName.add("....");

                Collection<UCsContract> pc = db.getUCs(talukaCode.get(position));
                for (UCsContract p : pc) {
                    ucCode.add(p.getUccode());
                    ucName.add(p.getUcs());
                }
                ArrayAdapter<String> psuAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, ucName);

                psuAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                bi.a2.setAdapter(psuAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        bi.a2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //MainApp.talukaCode = talukaCode.get(position);

                villageCode = new ArrayList<>();
                villageName = new ArrayList<>();


                villageCode.add("....");
                villageName.add("....");

                Collection<VillagesContract> pc = db.getVillage(ucCode.get(position));
                for (VillagesContract p : pc) {
                    villageCode.add(p.getVillagecode());
                    villageName.add(p.getVillagename());
                }
                ArrayAdapter<String> psuAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, villageName);

                psuAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                bi.a3.setAdapter(psuAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    private void setupListeners() {

        String[] users = {"Select Taluka", "Johi"};

        Spinner spin = bi.a1;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, users);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);


        String[] ucs = {"Select UC", "Johi Town UC-1", "Johi Town UC-2", "Kamal Khan", "Peer Mashaikh", "Johi"};

        Spinner spin_uc = bi.a2;
        ArrayAdapter<String> adapter_uc = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ucs);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_uc.setAdapter(adapter_uc);


        String[] village = {"Select Village", "Johi|Johi Town UC-1|Ward No.01", "Johi|Johi Town UC-1|Ward No.03", "Johi|Johi Town UC-1|Ward No.04", "Johi|Johi Town UC-1|Ward No.05", "Johi|Johi Town UC-1|Ward No.06", "Johi|Johi Town UC-1|Ward No.07", "Johi|Johi Town UC-1|Ward No.08", "Johi|Kamal Khan|Aadho Rodenani", "Johi|Kamal Khan|Abdul Aziz Solangi", "Johi|Kamal Khan|Abdul Rehman Jamali"};

        Spinner spin_village = bi.a3;
        ArrayAdapter<String> adapter_village = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, village);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_village.setAdapter(adapter_village);


        /*a1Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SplashscreenActivity.provinces);
        a1.setAdapter(a1Adapter);
        a1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) return;
                List<String> districts = new ArrayList<>(Collections.singletonList("...."));
                for (Map.Entry<String, Pair<String, EnumBlockContract>> entry : SplashscreenActivity.districtsMap.entrySet()) {
                    if (entry.getValue().getFirst().equals(a1.getSelectedItem().toString()))
                        districts.add(entry.getKey());
                }
                a2.setAdapter(new ArrayAdapter<>(SectionAActivity.this, android.R.layout.simple_list_item_1
                        , districts));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/


        bi.a1102.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (bi.a1102.isChecked() == true) {
                    bi.fldGrpCVa12.setVisibility(View.VISIBLE);
                    Clear.clearAllFields(bi.fldGrpCVa12, true);
                } else {
                    bi.fldGrpCVa12.setVisibility(View.GONE);
                    Clear.clearAllFields(bi.fldGrpCVa12, false);
                }
            }
        });
    }


    private boolean UpdateDB() {
        long updcount = db.addForm(MainApp.fc);
        MainApp.fc.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            MainApp.fc.set_UID(MainApp.fc.getDeviceID() + MainApp.fc.get_ID());
            db.updatesFormColumn(FormsContract.FormsTable.COLUMN_UID, MainApp.fc.get_UID());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {
        //if (MainApp.fc != null) return;
        MainApp.fc = new FormsContract();
        MainApp.fc.set_UID(MainApp.fc.get_UID());
        MainApp.fc.setDeviceID(MainApp.appInfo.getDeviceID());
        MainApp.fc.setDevicetagID(MainApp.appInfo.getTagName());
        MainApp.fc.setFormDate(MainApp.fc.getFormDate());
        MainApp.fc.setUser(MainApp.userName);
        MainApp.setGPS(this);

        JSONObject json = new JSONObject();

        json.put("a1", bi.a1.getSelectedItem().toString());

        json.put("a2", bi.a2.getSelectedItem().toString());

        json.put("a3", bi.a3.getSelectedItem().toString());

        json.put("a4", bi.a4.getText().toString());

        json.put("a5", bi.a5.getText().toString());

        json.put("a6", bi.a6.getText().toString());

        json.put("a7", bi.a7.getText().toString());

        json.put("a8", bi.a8.getText().toString());

        MainApp.No_participants = Integer.valueOf(bi.a8.getText().toString());

        json.put("a9", bi.a9.getText().toString());

        json.put("a10", bi.a10.getText().toString());

        json.put("a1101", bi.a1101.isChecked() ? "1" : "-1");

        json.put("a1102", bi.a1102.isChecked() ? "2" : "-1");

        json.put("a1103", bi.a1103.isChecked() ? "3" : "-1");

        json.put("a1104", bi.a1104.isChecked() ? "4" : "-1");

        json.put("a1201", bi.a1201.isChecked() ? "1" : "-1");

        json.put("a1202", bi.a1202.isChecked() ? "2" : "-1");

        json.put("a1203", bi.a1203.isChecked() ? "3" : "-1");

        json.put("a1204", bi.a1204.isChecked() ? "4" : "-1");

        json.put("a1205", bi.a1205.isChecked() ? "5" : "-1");

        json.put("a1206", bi.a1206.isChecked() ? "6" : "-1");

        json.put("a1207", bi.a1207.isChecked() ? "7" : "-1");

        json.put("a1208", bi.a1208.isChecked() ? "8" : "-1");

        json.put("a1209", bi.a1209.isChecked() ? "9" : "-1");

        json.put("a1210", bi.a1210.isChecked() ? "10" : "-1");

        json.put("a1211", bi.a1211.isChecked() ? "11" : "-1");

        json.put("a1212", bi.a1212.isChecked() ? "12" : "-1");

        json.put("a1213", bi.a1213.isChecked() ? "13" : "-1");

        MainApp.fc.setsA(String.valueOf(json));
    }

    private boolean formValidation() {

        if (bi.a8.getText().toString() != null && bi.a9.getText().toString() != null) {

            if (Integer.valueOf(bi.a8.getText().toString()) != (Integer.valueOf(bi.a9.getText().toString()) + Integer.valueOf(bi.a10.getText().toString()))) {
                Toast.makeText(this, "Total no of participants cannot be greater than sum of no of married and non married participants ", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

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
                startActivity(new Intent(this, SectionParticipantsSRC.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}