package edu.aku.hassannaqvi.srcDadu052020.ui.sync;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.srcDadu052020.CONSTANTS;
import edu.aku.hassannaqvi.srcDadu052020.R;
import edu.aku.hassannaqvi.srcDadu052020.adapter.SyncListAdapter;
import edu.aku.hassannaqvi.srcDadu052020.adapter.UploadListAdapter;
import edu.aku.hassannaqvi.srcDadu052020.contracts.FormsContract;
import edu.aku.hassannaqvi.srcDadu052020.contracts.ParticipantContract;
import edu.aku.hassannaqvi.srcDadu052020.core.DatabaseHelper;
import edu.aku.hassannaqvi.srcDadu052020.core.MainApp;
import edu.aku.hassannaqvi.srcDadu052020.databinding.ActivitySyncBinding;
import edu.aku.hassannaqvi.srcDadu052020.get.GetAllData;
import edu.aku.hassannaqvi.srcDadu052020.otherClasses.SyncModel;
import edu.aku.hassannaqvi.srcDadu052020.sync.SyncAllData;
import edu.aku.hassannaqvi.srcDadu052020.sync.SyncAllPhotos;
import edu.aku.hassannaqvi.srcDadu052020.sync.SyncDevice;
import edu.aku.hassannaqvi.srcDadu052020.utils.AndroidUtilityKt;
import edu.aku.hassannaqvi.srcDadu052020.utils.UtilKt;

import static edu.aku.hassannaqvi.srcDadu052020.utils.CreateTable.PROJECT_NAME;

public class SyncActivity extends AppCompatActivity implements SyncDevice.SyncDevicInterface {
    SharedPreferences.Editor editor;
    DatabaseHelper db;
    SyncListAdapter syncListAdapter;
    UploadListAdapter uploadListAdapter;
    ActivitySyncBinding bi;
    SyncModel model;
    SyncModel uploadmodel;
    List<SyncModel> list;
    List<SyncModel> uploadlist;
    Boolean listActivityCreated;
    Boolean uploadlistActivityCreated;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    private boolean sync_flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_sync);
        bi.setCallback(this);
        list = new ArrayList<>();
        uploadlist = new ArrayList<>();
        bi.noItem.setVisibility(View.VISIBLE);
        bi.noDataItem.setVisibility(View.VISIBLE);
        listActivityCreated = true;
        uploadlistActivityCreated = true;
        db = MainApp.appInfo.getDbHelper();
        UtilKt.dbBackup(this);

        sync_flag = getIntent().getBooleanExtra(CONSTANTS.SYNC_LOGIN, false);

        bi.btnSync.setOnClickListener(v -> onSyncDataClick());
        bi.btnUpload.setOnClickListener(v -> syncServer());
        setAdapter();
        setUploadAdapter();
    }

    public void onSyncDataClick() {
        if (AndroidUtilityKt.isNetworkConnected(this)) {
            if (sync_flag) new SyncData(SyncActivity.this, MainApp.DIST_ID).execute(true);
            else new SyncDevice(SyncActivity.this, true).execute();
        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }
    }

    void setAdapter() {
        syncListAdapter = new SyncListAdapter(list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        bi.rvSyncList.setLayoutManager(mLayoutManager);
        bi.rvSyncList.setItemAnimator(new DefaultItemAnimator());
        bi.rvSyncList.setAdapter(syncListAdapter);
        syncListAdapter.notifyDataSetChanged();
        if (syncListAdapter.getItemCount() > 0) {
            bi.noItem.setVisibility(View.GONE);
        } else {
            bi.noItem.setVisibility(View.VISIBLE);
        }
    }

    void setUploadAdapter() {
        uploadListAdapter = new UploadListAdapter(uploadlist);
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getApplicationContext());
        bi.rvUploadList.setLayoutManager(mLayoutManager2);
        bi.rvUploadList.setItemAnimator(new DefaultItemAnimator());
        bi.rvUploadList.setAdapter(uploadListAdapter);
        uploadListAdapter.notifyDataSetChanged();
        if (uploadListAdapter.getItemCount() > 0) {
            bi.noDataItem.setVisibility(View.GONE);
        } else {
            bi.noDataItem.setVisibility(View.VISIBLE);
        }
    }

    public void syncServer() {

        if (AndroidUtilityKt.isNetworkConnected(this)) {

            new SyncDevice(this, false).execute();
//  *******************************************************Forms*********************************
            Toast.makeText(getApplicationContext(), "Syncing Forms", Toast.LENGTH_SHORT).show();
            if (uploadlistActivityCreated) {
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "Forms",
                    "updateSyncedForms",
                    FormsContract.class,
                    MainApp._HOST_URL + MainApp._SERVER_URL,
                    FormsContract.FormsTable.TABLE_NAME,
                    db.getUnsyncedForms(), 0, uploadListAdapter, uploadlist
            ).execute();


            Toast.makeText(getApplicationContext(), "Syncing Participansts", Toast.LENGTH_SHORT).show();
            if (uploadlistActivityCreated) {
                uploadmodel = new SyncModel();
                uploadmodel.setstatusID(0);
                uploadlist.add(uploadmodel);
            }
            new SyncAllData(
                    this,
                    "Participant",
                    "updateSyncedParticipantForms",
                    ParticipantContract.class,
                    MainApp._HOST_URL + ParticipantContract.SingleParticipant._URI,
                    ParticipantContract.SingleParticipant.TABLE_NAME,
                    db.getAllParticipants(), 1, uploadListAdapter, uploadlist
            ).execute();

            bi.noDataItem.setVisibility(View.GONE);
            uploadlistActivityCreated = false;
            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = syncPref.edit();
            editor.putString("LastUpSyncServer", dtToday);
            editor.apply();
        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void processFinish(boolean flag) {
        if (flag) {
            MainApp.appInfo.updateTagName(SyncActivity.this);
            new SyncData(SyncActivity.this, MainApp.DIST_ID).execute(sync_flag);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(RESULT_OK);
        finish();
    }

    public void uploadPhotos(View view) {

        File sdDir = Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        Log.d("Files", "Path: " + sdDir);
        File directory = new File(String.valueOf(sdDir), PROJECT_NAME);
        Log.d("Directory", "uploadPhotos: " + directory);
        if (directory.exists()) {
            File[] files = directory.listFiles(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    return (file.getPath().endsWith(".jpg") || file.getPath().endsWith(".jpeg"));
                }
            });


            Log.d("Files", "Count: " + files.length);
            if (files.length > 0) {
                for (File file : files) {
                    Log.d("Files", "FileName:" + file.getName());
                    SyncAllPhotos syncAllPhotos = new SyncAllPhotos(file.getName(), this);
                    syncAllPhotos.execute();

                    try {
                        //3000 ms delay to process upload of next file.
                        Thread.sleep(3000);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else {
                Toast.makeText(this, "No photos to upload.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "No photos were taken", Toast.LENGTH_SHORT).show();
        }

    }

    private class SyncData extends AsyncTask<Boolean, String, String> {

        private Context mContext;
        private String distID;

        private SyncData(Context mContext, String districtId) {
            this.mContext = mContext;
            this.distID = districtId;
        }

        @Override
        protected String doInBackground(Boolean... booleans) {
            runOnUiThread(() -> {

//              Getting Users!!
                if (listActivityCreated) {
                    model = new SyncModel();
                    model.setstatusID(0);
                    list.add(model);
                }
                new GetAllData(mContext, "User", syncListAdapter, list).execute();

//              Getting App Version
                if (listActivityCreated) {
                    model = new SyncModel();
                    model.setstatusID(0);
                    list.add(model);
                }
                new GetAllData(mContext, "VersionApp", syncListAdapter, list).execute();

//              Getting Talukas
                if (listActivityCreated) {
                    model = new SyncModel();
                    model.setstatusID(0);
                    list.add(model);
                }
                new GetAllData(mContext, "Talukas", syncListAdapter, list).execute();
                bi.noItem.setVisibility(View.GONE);

//              Getting UCS
                if (listActivityCreated) {
                    model = new SyncModel();
                    model.setstatusID(0);
                    list.add(model);
                }
                new GetAllData(mContext, "UCS", syncListAdapter, list).execute();
                bi.noItem.setVisibility(View.GONE);

//              Getting Villages
                if (listActivityCreated) {
                    model = new SyncModel();
                    model.setstatusID(0);
                    list.add(model);
                }
                new GetAllData(mContext, "Villages", syncListAdapter, list).execute();
                bi.noItem.setVisibility(View.GONE);

                listActivityCreated = false;
            });

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            new Handler().postDelayed(() -> {
                editor.putBoolean("flag", true);
                editor.commit();
                UtilKt.dbBackup(mContext);

            }, 1200);
        }
    }
}
