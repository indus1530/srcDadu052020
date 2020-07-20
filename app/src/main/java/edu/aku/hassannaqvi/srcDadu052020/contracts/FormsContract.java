package edu.aku.hassannaqvi.srcDadu052020.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import androidx.lifecycle.LiveData;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FormsContract extends LiveData<FormsContract> {

    public static final String CONTENT_AUTHORITY = "edu.aku.hassannaqvi.srcDadu052020";
    public static final String PATH_FORMS = "forms";
    private final String projectName = "SRCDADU052020";
    private String _ID = "";
    private String _UID = "";
    private String formType = "";
    private String sysdate = ""; // Date
    private String taluka = ""; // Date
    private String uc = ""; // Date
    private String village = ""; // Date
    private String user = ""; // Interviewer
    private String istatus = ""; // Interview Status
    private String istatus88x = ""; // Interview Status
    private String luid = "";
    private String endingdatetime = "";
    private String gpsLat = "";
    private String gpsLng = "";
    private String gpsDT = "";
    private String gpsAcc = "";
    private String deviceID = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";
    private String appversion = "";
    private String clusterCode = "";
    private String hhno = "";
    private String fStatus = "";
    private String fstatus88x = ""; // Interview Status

    private String sA = "";
    private String sE = "";
    private String sM = "";
    private String sN = "";
    private String sO = "";

    public FormsContract() {
    }


    public String getTaluka() {
        return taluka;
    }

    public void setTaluka(String taluka) {
        this.taluka = taluka;
    }


    public String getfStatus() {
        return fStatus;
    }

    public void setfStatus(String fStatus) {
        this.fStatus = fStatus;
    }


    public String getsA() {
        return sA;
    }

    public void setsA(String sA) {
        this.sA = sA;
    }


    public String getUc() {
        return uc;
    }

    public void setUc(String uc) {
        this.uc = uc;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getsE() {
        return sE;
    }

    public void setsE(String sE) {
        this.sE = sE;
    }

    public String getsM() {
        return sM;
    }

    public void setsM(String sM) {
        this.sM = sM;
    }

    public String getsN() {
        return sN;
    }

    public void setsN(String sN) {
        this.sN = sN;
    }

    public String getsO() {
        return sO;
    }

    public void setsO(String sO) {
        this.sO = sO;
    }

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }

    public String getFstatus88x() {
        return fstatus88x;
    }

    public void setFstatus88x(String fstatus88x) {
        this.fstatus88x = fstatus88x;
    }

    public FormsContract Sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getString(FormsTable.COLUMN_ID);
        this._UID = jsonObject.getString(FormsTable.COLUMN_UID);
        this.sysdate = jsonObject.getString(FormsTable.COLUMN_FORMDATE);
        this.taluka = jsonObject.getString(FormsTable.COLUMN_TALUKA);
        this.uc = jsonObject.getString(FormsTable.COLUMN_UC);
        this.village = jsonObject.getString(FormsTable.COLUMN_VILLAGE);
        this.user = jsonObject.getString(FormsTable.COLUMN_USER);
        this.istatus = jsonObject.getString(FormsTable.COLUMN_ISTATUS);
        this.istatus88x = jsonObject.getString(FormsTable.COLUMN_ISTATUS88x);
        this.fstatus88x = jsonObject.getString(FormsTable.COLUMN_FSTATUS88x);
        this.luid = jsonObject.getString(FormsTable.COLUMN_LUID);
        this.endingdatetime = jsonObject.getString(FormsTable.COLUMN_ENDINGDATETIME);
        this.gpsLat = jsonObject.getString(FormsTable.COLUMN_GPSLAT);
        this.gpsLng = jsonObject.getString(FormsTable.COLUMN_GPSLNG);
        this.gpsDT = jsonObject.getString(FormsTable.COLUMN_GPSDATE);
        this.gpsAcc = jsonObject.getString(FormsTable.COLUMN_GPSACC);
        this.deviceID = jsonObject.getString(FormsTable.COLUMN_DEVICEID);
        this.devicetagID = jsonObject.getString(FormsTable.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(FormsTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(FormsTable.COLUMN_SYNCED_DATE);
        this.appversion = jsonObject.getString(FormsTable.COLUMN_SYNCED_DATE);
        this.hhno = jsonObject.getString(FormsTable.COLUMN_HHNO);
        this.fStatus = jsonObject.getString(FormsTable.COLUMN_FSTATUS);
        this.sA = jsonObject.getString(FormsTable.COLUMN_SA);

        this.sE = jsonObject.getString(FormsTable.COLUMN_SE);
        this.sM = jsonObject.getString(FormsTable.COLUMN_SM);
        this.sN = jsonObject.getString(FormsTable.COLUMN_SN);
        this.sO = jsonObject.getString(FormsTable.COLUMN_SO);

        return this;

    }

    public FormsContract Hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ID));
        this._UID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_UID));
        this.sysdate = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_FORMDATE));
        this.taluka = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_TALUKA));
        this.uc = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_UC));
        this.village = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_VILLAGE));
        this.user = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_USER));
        this.istatus = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS));
        this.istatus88x = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS88x));
        this.fstatus88x = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_FSTATUS88x));
        this.luid = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_LUID));
        this.endingdatetime = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ENDINGDATETIME));
        this.gpsLat = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLNG));
        this.gpsDT = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSDATE));
        this.gpsAcc = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSACC));
        this.deviceID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICEID));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICETAGID));
        this.appversion = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_APPVERSION));

        this.hhno = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_HHNO));
        this.fStatus = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_FSTATUS));
        this.sA = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SA));

        this.sE = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SE));
        this.sM = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SM));
        this.sN = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SN));
        this.sO = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SO));

        return this;
    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(FormsTable.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(FormsTable.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(FormsTable.COLUMN_FORMDATE, this.sysdate == null ? JSONObject.NULL : this.sysdate);
        json.put(FormsTable.COLUMN_TALUKA, this.taluka == null ? JSONObject.NULL : this.taluka);
        json.put(FormsTable.COLUMN_UC, this.uc == null ? JSONObject.NULL : this.uc);
        json.put(FormsTable.COLUMN_VILLAGE, this.village == null ? JSONObject.NULL : this.village);
        json.put(FormsTable.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);
        json.put(FormsTable.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
        json.put(FormsTable.COLUMN_FSTATUS, this.fStatus == null ? JSONObject.NULL : this.fStatus);
        json.put(FormsTable.COLUMN_ISTATUS88x, this.istatus88x == null ? JSONObject.NULL : this.istatus88x);
        json.put(FormsTable.COLUMN_FSTATUS88x, this.fstatus88x == null ? JSONObject.NULL : this.fstatus88x);
        json.put(FormsTable.COLUMN_LUID, this.luid == null ? JSONObject.NULL : this.luid);
        json.put(FormsTable.COLUMN_ENDINGDATETIME, this.endingdatetime == null ? JSONObject.NULL : this.endingdatetime);


        if (!this.sA.equals("")) {
            json.put(FormsTable.COLUMN_SA, new JSONObject(this.sA));
        }


        if (!this.sE.equals("")) {
            json.put(FormsTable.COLUMN_SE, new JSONObject(this.sE));
        }

        if (!this.sM.equals("")) {
            json.put(FormsTable.COLUMN_SM, new JSONObject(this.sM));
        }

        if (!this.sN.equals("")) {
            json.put(FormsTable.COLUMN_SN, new JSONObject(this.sN));
        }

        if (!this.sO.equals("")) {
            json.put(FormsTable.COLUMN_SO, new JSONObject(this.sO));
        }

        json.put(FormsTable.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
        json.put(FormsTable.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
        json.put(FormsTable.COLUMN_GPSDATE, this.gpsDT == null ? JSONObject.NULL : this.gpsDT);
        json.put(FormsTable.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
        json.put(FormsTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(FormsTable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        json.put(FormsTable.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);
        json.put(FormsTable.COLUMN_HHNO, this.hhno == null ? JSONObject.NULL : this.hhno);

        return json;
    }

    public String getProjectName() {
        return projectName;
    }

    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public String get_UID() {
        return _UID;
    }

    public void set_UID(String _UID) {
        this._UID = _UID;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getFormDate() {
        return sysdate;
    }

    public void setFormDate(String formDate) {
        this.sysdate = formDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }

    public String getIstatus88x() {
        return istatus88x;
    }

    public void setIstatus88x(String istatus88x) {
        this.istatus88x = istatus88x;
    }

    public String getLuid() {
        return luid;
    }

    public void setLuid(String Study_Id) {
        this.luid = Study_Id;
    }


    public String getEndingdatetime() {
        return endingdatetime;
    }

    public void setEndingdatetime(String endingdatetime) {
        this.endingdatetime = endingdatetime;
    }

    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    public String getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
    }

    public String getGpsDT() {
        return gpsDT;
    }

    public void setGpsDT(String gpsDT) {
        this.gpsDT = gpsDT;
    }

    public String getGpsAcc() {
        return gpsAcc;
    }

    public void setGpsAcc(String gpsAcc) {
        this.gpsAcc = gpsAcc;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDevicetagID() {
        return devicetagID;
    }

    public void setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;

    }

    public String getClusterCode() {
        return clusterCode;
    }

    public void setClusterCode(String clusterCode) {
        this.clusterCode = clusterCode;
    }

    public String getHhno() {
        return hhno;
    }

    public void setHhno(String hhno) {
        this.hhno = hhno;
    }

    public static abstract class FormsTable implements BaseColumns {

        public static final String TABLE_NAME = "forms";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "projectName";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_FORMDATE = "sysdate";
        public static final String COLUMN_TALUKA = "taluka";
        public static final String COLUMN_UC = "uc";
        public static final String COLUMN_VILLAGE = "village";
        public static final String COLUMN_USER = "username";
        public static final String COLUMN_ISTATUS = "istatus";
        public static final String COLUMN_ISTATUS88x = "istatus88x";
        public static final String COLUMN_FSTATUS = "fStatus";
        public static final String COLUMN_FSTATUS88x = "fstatus88x";
        public static final String COLUMN_LUID = "_luid";
        public static final String COLUMN_ENDINGDATETIME = "endingdatetime";
        public static final String COLUMN_GPSLAT = "gpslat";
        public static final String COLUMN_GPSLNG = "gpslng";
        public static final String COLUMN_GPSDATE = "gpsdate";
        public static final String COLUMN_GPSACC = "gpsacc";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "tagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APPVERSION = "appversion";
        public static final String COLUMN_HHNO = "hhno";
        public static final String COLUMN_SA = "sA";
        public static final String COLUMN_SE = "sE";
        public static final String COLUMN_SM = "sM";
        public static final String COLUMN_SN = "sN";
        public static final String COLUMN_SO = "sO";

        public static String _URL = "sync.php";
    }
}