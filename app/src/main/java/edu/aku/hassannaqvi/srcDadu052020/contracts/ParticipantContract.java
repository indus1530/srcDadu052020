package edu.aku.hassannaqvi.srcDadu052020.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class ParticipantContract {

    private static final String TAG = "Participant Contract";

    String id;
    String uid;
    String uuid;
    String projectname;
    String formdate;
    String deviceid;

    String sno;
    String a;
    String b;
    String c;
    String d;

    String e;
    String f;
    String g;
    String h;
    String i;

    public ParticipantContract() {
        // Default Constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getFormdate() {
        return formdate;
    }

    public void setFormdate(String formdate) {
        this.formdate = formdate;
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

        this.deviceid = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_DEVICEID);
        this.uuid = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_UUID);
        this.uid = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_UID);
        this.formdate = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_FORMDATE);
        this.projectname = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_PROJECTNAME);

        this.id = jsonObject.getString(ParticipantContract.singleParticipant.COLUMN_ID);
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

        this.deviceid = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_DEVICEID));
        this.projectname = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_PROJECTNAME));
        this.uuid = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_UUID));
        this.uid = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_UID));
        this.formdate = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_FORMDATE));

        this.id = cursor.getString(cursor.getColumnIndex(ParticipantContract.singleParticipant.COLUMN_ID));
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

        json.put(ParticipantContract.singleParticipant.COLUMN_DEVICEID, this.deviceid == null ? JSONObject.NULL : this.deviceid);
        json.put(ParticipantContract.singleParticipant.COLUMN_UUID, this.uuid == null ? JSONObject.NULL : this.uuid);
        json.put(ParticipantContract.singleParticipant.COLUMN_UID, this.uid == null ? JSONObject.NULL : this.uid);
        json.put(ParticipantContract.singleParticipant.COLUMN_FORMDATE, this.formdate == null ? JSONObject.NULL : this.formdate);
        json.put(ParticipantContract.singleParticipant.COLUMN_PROJECTNAME, this.projectname == null ? JSONObject.NULL : this.projectname);

        json.put(ParticipantContract.singleParticipant.COLUMN_ID, this.id == null ? JSONObject.NULL : this.id);
        json.put(ParticipantContract.singleParticipant.COLUMN_SNO, this.sno == null ? JSONObject.NULL : this.sno);
        json.put(ParticipantContract.singleParticipant.COLUMN_A, this.sno == null ? JSONObject.NULL : this.a);
        json.put(ParticipantContract.singleParticipant.COLUMN_B, this.sno == null ? JSONObject.NULL : this.b);
        json.put(ParticipantContract.singleParticipant.COLUMN_C, this.sno == null ? JSONObject.NULL : this.c);
        json.put(ParticipantContract.singleParticipant.COLUMN_D, this.sno == null ? JSONObject.NULL : this.d);
        json.put(ParticipantContract.singleParticipant.COLUMN_E, this.sno == null ? JSONObject.NULL : this.e);
        json.put(ParticipantContract.singleParticipant.COLUMN_F, this.sno == null ? JSONObject.NULL : this.f);
        json.put(ParticipantContract.singleParticipant.COLUMN_G, this.sno == null ? JSONObject.NULL : this.g);
        json.put(ParticipantContract.singleParticipant.COLUMN_H, this.sno == null ? JSONObject.NULL : this.h);
        json.put(ParticipantContract.singleParticipant.COLUMN_I, this.sno == null ? JSONObject.NULL : this.i);

        return json;
    }


    public static abstract class singleParticipant implements BaseColumns {

        public static final String TABLE_NAME = "participant";

        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_UUID = "uuid";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN_PROJECTNAME = "projectname";
        public static final String COLUMN_FORMDATE = "formdate";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_SNO = "sno";
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