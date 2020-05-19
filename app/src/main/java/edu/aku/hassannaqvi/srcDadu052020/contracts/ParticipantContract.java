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
    private String formDate = ""; // Date
    private String user = ""; // Interviewer
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";
    private String cstatus;
    private String cstatus88x;

    private String sA = "";
    private String sno;
    private String a;
    private String b;
    private String c;
    private String d;

    private String e;
    private String f;
    private String g;
    private String h;
    private String i;

    public ParticipantContract() {
        // Default Constructor
    }


    public String getsA() {
        return sA;
    }

    public void setsA(String sA) {
        this.sA = sA;
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
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
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

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }


    public ParticipantContract Sync(JSONObject jsonObject) throws JSONException {

        this._ID = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_ID);
        this.deviceId = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_DEVICEID);
        this._UUID = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_UUID);
        this.UID = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_UID);
        this.formDate = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_FORMDATE);
        this.user = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_USER);
        this.devicetagID = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_SYNCED_DATE);
        this.cstatus = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_CSTATUS);
        this.cstatus88x = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_CSTATUS88x);


        this.sA = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_SA);


        this.sno = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_SNO);
        this.a = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_A);
        this.b = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_B);
        this.c = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_C);
        this.d = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_D);
        this.e = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_E);
        this.f = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_F);
        this.g = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_G);
        this.h = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_H);
        this.i = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_I);

        return this;
    }

    public ParticipantContract HydrateParticipant(Cursor cursor) {

        this._ID = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_ID));
        this._UUID = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_UUID));
        this.UID = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_UID));
        this.deviceId = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_DEVICEID));
        this.formDate = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_FORMDATE));
        this.user = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_USER));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_DEVICETAGID));
        this.synced = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_SYNCED));
        this.synced_date = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_SYNCED_DATE));
        this.cstatus = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_CSTATUS));
        this.cstatus88x = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_CSTATUS88x));

        this.sA = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_SA));


        this.sno = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_SNO));
        this.a = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_A));
        this.b = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_B));
        this.c = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_C));
        this.d = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_D));
        this.e = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_E));
        this.f = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_F));
        this.g = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_G));
        this.h = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_H));
        this.i = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_I));

        return this;
    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(ParticipantContract.singleParticipant.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(ParticipantContract.singleParticipant.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
        json.put(ParticipantContract.singleParticipant.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        json.put(ParticipantContract.singleParticipant.COLUMN_UUID, this._UUID == null ? JSONObject.NULL : this._UUID);
        json.put(ParticipantContract.singleParticipant.COLUMN_UID, this.UID == null ? JSONObject.NULL : this.UID);
        json.put(ParticipantContract.singleParticipant.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(ParticipantContract.singleParticipant.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);
        json.put(ParticipantContract.singleParticipant.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
        json.put(ParticipantContract.singleParticipant.COLUMN_SYNCED_DATE, this.synced_date == null ? JSONObject.NULL : this.synced_date);
        json.put(ParticipantContract.singleParticipant.COLUMN_CSTATUS, this.cstatus == null ? JSONObject.NULL : this.cstatus);
        json.put(ParticipantContract.singleParticipant.COLUMN_CSTATUS88x, this.cstatus88x == null ? JSONObject.NULL : this.cstatus88x);

        json.put(ParticipantContract.singleParticipant.COLUMN_SA, this.sA == null ? JSONObject.NULL : this.sA);
        json.put(ParticipantContract.singleParticipant.COLUMN_SNO, this.sno == null ? JSONObject.NULL : this.sno);
        json.put(ParticipantContract.singleParticipant.COLUMN_A, this.a == null ? JSONObject.NULL : this.a);
        json.put(ParticipantContract.singleParticipant.COLUMN_B, this.b == null ? JSONObject.NULL : this.b);
        json.put(ParticipantContract.singleParticipant.COLUMN_C, this.c == null ? JSONObject.NULL : this.c);
        json.put(ParticipantContract.singleParticipant.COLUMN_D, this.d == null ? JSONObject.NULL : this.d);
        json.put(ParticipantContract.singleParticipant.COLUMN_E, this.e == null ? JSONObject.NULL : this.e);
        json.put(ParticipantContract.singleParticipant.COLUMN_F, this.f == null ? JSONObject.NULL : this.f);
        json.put(ParticipantContract.singleParticipant.COLUMN_G, this.g == null ? JSONObject.NULL : this.g);
        json.put(ParticipantContract.singleParticipant.COLUMN_H, this.h == null ? JSONObject.NULL : this.h);
        json.put(ParticipantContract.singleParticipant.COLUMN_I, this.i == null ? JSONObject.NULL : this.i);

        return json;
    }


    public static abstract class singleParticipant implements BaseColumns {

        public static final String TABLE_NAME = "participant";

        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_UUID = "_uuid";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_USER = "username";
        public static final String COLUMN_DEVICETAGID = "tagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_CSTATUS = "cstatus";
        public static final String COLUMN_CSTATUS88x = "cstatus88x";

        public static final String COLUMN_SNO = "sno";
        public static final String COLUMN_SA = "sa";
        public static final String COLUMN_A = "a";
        public static final String COLUMN_B = "b";
        public static final String COLUMN_C = "c";
        public static final String COLUMN_D = "d";
        public static final String COLUMN_E = "e";
        public static final String COLUMN_F = "f";
        public static final String COLUMN_G = "g";
        public static final String COLUMN_H = "h";
        public static final String COLUMN_I = "i";

        public static final String _URI = "participant.php";
    }

}