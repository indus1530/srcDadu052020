package edu.aku.hassannaqvi.srcDadu052020.ui.sections;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.srcDadu052020.R;
import edu.aku.hassannaqvi.srcDadu052020.contracts.FormsContract;
import edu.aku.hassannaqvi.srcDadu052020.contracts.TalukasContract;
import edu.aku.hassannaqvi.srcDadu052020.contracts.UCsContract;
import edu.aku.hassannaqvi.srcDadu052020.contracts.UsersContract;
import edu.aku.hassannaqvi.srcDadu052020.contracts.VillagesContract;
import edu.aku.hassannaqvi.srcDadu052020.core.DatabaseHelper;
import edu.aku.hassannaqvi.srcDadu052020.core.MainApp;
import edu.aku.hassannaqvi.srcDadu052020.databinding.ActivitySectionABinding;
import edu.aku.hassannaqvi.srcDadu052020.validator.validator.ValidatorClass;


public class SectionAActivity extends AppCompatActivity {

    private static final String TAG = "";
    public static FormsContract fc;
    ActivitySectionABinding bi;
    private DatabaseHelper db;

    String timeStart = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTimeInMillis());

    public List<String> talukaName, ucName, villageName, usersName, teamLeadName;
    public List<String> talukaCode, ucCode, villageCode, usersCode, teamLeadCode;


    String dateToday = new SimpleDateFormat("dd/MM/yyyy").format(new Date().getTime());
    String date7Months = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTimeInMillis() - ((MainApp.MILLISECONDS_IN_7MONTHS) + MainApp.MILLISECONDS_IN_DAY));
    String timeEnd = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTimeInMillis());
    private String mLanguageCode = "sd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a);
        bi.setCallback(this);
        db = MainApp.appInfo.getDbHelper();
        setupListeners();

        bi.a5.setMinDate(date7Months);
        bi.a5.setMaxDate(dateToday);
        bi.a5.setDate(Calendar.getInstance());

        populateSpinner(this);
    }


    public void populateSpinner_javed(final Context context) {
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


        // Spinner Drop down elements
        usersName = new ArrayList<>();
        usersCode = new ArrayList<>();

        usersName.add("....");
        usersCode.add("....");

        Collection<UsersContract> dc_users = db.getUsers();
        Log.d(TAG, "onCreate: " + dc_users.size());
        for (UsersContract d : dc_users) {
            usersName.add(d.getUserName());
            usersCode.add(String.valueOf(d.getUserID()));
        }

        // Creating adapter for spinner
        ArrayAdapter<String> userAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, usersName);

        // Drop down layout style - list view with radio button
        userAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // attaching data adapter to spinner
        bi.a6.setAdapter(userAdapter);


        // Creating adapter for spinner
        ArrayAdapter<String> userTeamLead = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, usersName);

        // Drop down layout style - list view with radio button
        userTeamLead.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // attaching data adapter to spinner
        bi.a7.setAdapter(userTeamLead);

    }


    public void populateSpinner(final Context context) {
        // Spinner Drop down elements
        talukaName = new ArrayList<>();
        talukaCode = new ArrayList<>();


        talukaName.add("....");
        talukaCode.add("....");

        talukaName.add(1, "Johi");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, talukaName);

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

                ucName.add(1, "Johi Town UC-1");
                ucName.add(2, "Johi Town UC-2");

                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, ucName);

                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                bi.a2.setAdapter(dataAdapter);
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

                villageName.add(1, "Ward No.01");
                villageName.add(2, "Ward No.02");
                villageName.add(3, "Ward No.03");
                villageName.add(4, "Ward No.04");


                ArrayAdapter<String> psuAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, villageName);

                psuAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                bi.a3.setAdapter(psuAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        // Spinner Drop down elements
        usersName = new ArrayList<>();
        usersCode = new ArrayList<>();

        usersName.add("....");
        usersCode.add("....");


        usersName.add(1, "admin1");


        // Creating adapter for spinner
        ArrayAdapter<String> userAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, usersName);

        // Drop down layout style - list view with radio button
        userAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // attaching data adapter to spinner
        bi.a6.setAdapter(userAdapter);


        // Creating adapter for spinner
        ArrayAdapter<String> userTeamLead = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, usersName);

        // Drop down layout style - list view with radio button
        userTeamLead.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // attaching data adapter to spinner
        bi.a7.setAdapter(userTeamLead);

    }


    private void setupListeners() {

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

//        json.put("a1", talukaCode.get(bi.a1.getSelectedItemPosition()));
//        json.put("a2", ucCode.get(bi.a2.getSelectedItemPosition()));
//        json.put("a3", villageCode.get(bi.a3.getSelectedItemPosition()));


        json.put("a1", bi.a1.getSelectedItem());
        json.put("a2", bi.a2.getSelectedItemPosition());
        json.put("a3", bi.a3.getSelectedItemPosition());


        json.put("a4", bi.a4.getText().toString());

        json.put("a5", bi.a5.getText().toString());
        json.put("a51", bi.a51.getText().toString());
        json.put("a52", bi.a52.getText().toString());

//        json.put("a6", usersCode.get(bi.a6.getSelectedItemPosition()));
//        json.put("a7", usersCode.get(bi.a7.getSelectedItemPosition()));


        json.put("a6", bi.a6.getSelectedItemPosition());
        json.put("a7", bi.a7.getSelectedItemPosition());


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

        if (!bi.a8.getText().toString().isEmpty() && !bi.a9.getText().toString().isEmpty()) {

            if (Integer.valueOf(bi.a8.getText().toString()) != (Integer.valueOf(bi.a9.getText().toString()) + Integer.valueOf(bi.a10.getText().toString()))) {
                Toast.makeText(this, "Total no of participants cannot be greater than sum of no of married and non married participants ", Toast.LENGTH_SHORT).show();
                return false;
            }
        }


        if (bi.a9.getText().toString().equals("0") && bi.a10.getText().toString().equals("0")) {
            Toast.makeText(this, "No of married participants and unmarried partcipants both cannot be zero", Toast.LENGTH_SHORT).show();
            return false;
        }


        /*if (Integer.valueOf(bi.a51.getText().toString()) > Integer.valueOf(bi.a52.getText().toString())) {
            Toast.makeText(this, "Session starting time cannot be greater than session end time", Toast.LENGTH_SHORT).show();
            return false;
        }*/

        return ValidatorClass.EmptyCheckingContainer(this, bi.GrpName);
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