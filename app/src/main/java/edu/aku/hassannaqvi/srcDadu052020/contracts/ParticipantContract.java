package edu.aku.hassannaqvi.srcDadu052020.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class ParticipantContract {

    private static final String TAG = "Participant Contract";

    private String _ID = "";
    private String UID = "";
    private String _UUID = "";
    private String deviceId = "";
    private String sysdate = ""; // Date
    private String taluka = ""; // Date
    private String uc = ""; // Date
    private String village = ""; // Date
    private String user = ""; // Interviewer
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";
    private String cstatus;
    private String cstatus88x;

    private String sA = "";
    private String sno;

    public ParticipantContract() {
        // Default Constructor
    }


    public String getsA() {
        return sA;
    }

    public void setsA(String sA) {
        this.sA = sA;
    }

    public String getTaluka() {
        return taluka;
    }

    public void setTaluka(String taluka) {
        this.taluka = taluka;
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


    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String get_UUID() {
        return _UUID;
    }

    public void set_UUID(String _UUID) {
        this._UUID = _UUID;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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

    public String getCstatus() {
        return cstatus;
    }

    public void setCstatus(String cstatus) {
        this.cstatus = cstatus;
    }

    public String getCstatus88x() {
        return cstatus88x;
    }

    public void setCstatus88x(String cstatus88x) {
        this.cstatus88x = cstatus88x;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }


    public ParticipantContract Sync(JSONObject jsonObject) throws JSONException {

        this._ID = jsonObject.getString(SingleParticipant.COLUMN_ID);
        this.deviceId = jsonObject.getString(SingleParticipant.COLUMN_DEVICEID);
        this._UUID = jsonObject.getString(SingleParticipant.COLUMN_UUID);
        this.UID = jsonObject.getString(SingleParticipant.COLUMN_UID);
        this.sysdate = jsonObject.getString(SingleParticipant.COLUMN_FORMDATE);
        this.taluka = jsonObject.getString(SingleParticipant.COLUMN_TALUKA);
        this.uc = jsonObject.getString(SingleParticipant.COLUMN_UC);
        this.village = jsonObject.getString(SingleParticipant.COLUMN_VILLAGE);
        this.sno = jsonObject.getString(SingleParticipant.COLUMN_SNO);
        this.user = jsonObject.getString(SingleParticipant.COLUMN_USER);
        this.devicetagID = jsonObject.getString(SingleParticipant.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(SingleParticipant.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(SingleParticipant.COLUMN_SYNCED_DATE);
        this.cstatus = jsonObject.getString(SingleParticipant.COLUMN_CSTATUS);
        this.cstatus88x = jsonObject.getString(SingleParticipant.COLUMN_CSTATUS88x);

        this.sA = jsonObject.getString(SingleParticipant.COLUMN_SA);

        return this;
    }

    public ParticipantContract HydrateParticipant(Cursor cursor) {

        this._ID = cursor.getString(cursor.getColumnIndex(SingleParticipant.COLUMN_ID));
        this._UUID = cursor.getString(cursor.getColumnIndex(SingleParticipant.COLUMN_UUID));
        this.UID = cursor.getString(cursor.getColumnIndex(SingleParticipant.COLUMN_UID));
        this.deviceId = cursor.getString(cursor.getColumnIndex(SingleParticipant.COLUMN_DEVICEID));
        this.sysdate = cursor.getString(cursor.getColumnIndex(SingleParticipant.COLUMN_FORMDATE));
        this.taluka = cursor.getString(cursor.getColumnIndex(SingleParticipant.COLUMN_TALUKA));
        this.uc = cursor.getString(cursor.getColumnIndex(SingleParticipant.COLUMN_UC));
        this.village = cursor.getString(cursor.getColumnIndex(SingleParticipant.COLUMN_VILLAGE));
        this.sno = cursor.getString(cursor.getColumnIndex(SingleParticipant.COLUMN_SNO));
        this.user = cursor.getString(cursor.getColumnIndex(SingleParticipant.COLUMN_USER));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(SingleParticipant.COLUMN_DEVICETAGID));
        this.synced = cursor.getString(cursor.getColumnIndex(SingleParticipant.COLUMN_SYNCED));
        this.synced_date = cursor.getString(cursor.getColumnIndex(SingleParticipant.COLUMN_SYNCED_DATE));
        this.cstatus = cursor.getString(cursor.getColumnIndex(SingleParticipant.COLUMN_CSTATUS));
        this.cstatus88x = cursor.getString(cursor.getColumnIndex(SingleParticipant.COLUMN_CSTATUS88x));

        this.sA = cursor.getString(cursor.getColumnIndex(SingleParticipant.COLUMN_SA));

        return this;
    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(SingleParticipant.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(SingleParticipant.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
        json.put(SingleParticipant.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        json.put(SingleParticipant.COLUMN_UUID, this._UUID == null ? JSONObject.NULL : this._UUID);
        json.put(SingleParticipant.COLUMN_UID, this.UID == null ? JSONObject.NULL : this.UID);
        json.put(SingleParticipant.COLUMN_FORMDATE, this.sysdate == null ? JSONObject.NULL : this.sysdate);
        json.put(SingleParticipant.COLUMN_TALUKA, this.taluka == null ? JSONObject.NULL : this.taluka);
        json.put(SingleParticipant.COLUMN_UC, this.uc == null ? JSONObject.NULL : this.uc);
        json.put(SingleParticipant.COLUMN_VILLAGE, this.village == null ? JSONObject.NULL : this.village);
        json.put(SingleParticipant.COLUMN_SNO, this.sno == null ? JSONObject.NULL : this.sno);
        json.put(SingleParticipant.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);
        json.put(SingleParticipant.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
        json.put(SingleParticipant.COLUMN_SYNCED_DATE, this.synced_date == null ? JSONObject.NULL : this.synced_date);
        json.put(SingleParticipant.COLUMN_CSTATUS, this.cstatus == null ? JSONObject.NULL : this.cstatus);
        json.put(SingleParticipant.COLUMN_CSTATUS88x, this.cstatus88x == null ? JSONObject.NULL : this.cstatus88x);


        if (!this.sA.equals("")) {
            json.put(SingleParticipant.COLUMN_SA, new JSONObject(this.sA));
        }

        return json;
    }


    public static abstract class SingleParticipant implements BaseColumns {

        public static final String TABLE_NAME = "participant";

        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_UUID = "_uuid";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_FORMDATE = "sysdate";
        public static final String COLUMN_TALUKA = "taluka";
        public static final String COLUMN_UC = "uc";
        public static final String COLUMN_VILLAGE = "village";
        public static final String COLUMN_SNO = "sno";
        public static final String COLUMN_USER = "username";
        public static final String COLUMN_DEVICETAGID = "tagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_CSTATUS = "cstatus";
        public static final String COLUMN_CSTATUS88x = "cstatus88x";

        public static final String COLUMN_SA = "sa";

        public static final String _URI = "participant.php";
    }

}