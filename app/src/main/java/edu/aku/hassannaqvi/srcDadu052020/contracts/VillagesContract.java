package edu.aku.hassannaqvi.srcDadu052020.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 10/31/2016.
 */

public class VillagesContract {

    private String talukacode;
    private String uccode;
    private String villagecode;
    private String villagename;


    public VillagesContract() {
    }


    public void setTalukacode(String talukacode) {
        this.talukacode = talukacode;
    }

    public void setUccode(String uccode) {
        this.uccode = uccode;
    }

    public void setVillagecode(String villagecode) {
        this.villagecode = villagecode;
    }

    public void setVillagename(String villagename) {
        this.villagename = villagename;
    }

    public String getUccode() {
        return uccode;
    }

    public String getTalukacode() {
        return talukacode;
    }

    public String getVillagecode() {
        return villagecode;
    }

    public String getVillagename() {
        return villagename;
    }

    public VillagesContract sync(JSONObject jsonObject) throws JSONException {

        this.talukacode = jsonObject.getString(SingleVillage.COLUMN_TALUKA_CODE);
        this.uccode = jsonObject.getString(SingleVillage.COLUMN_UC_CODE);
        this.villagecode = jsonObject.getString(SingleVillage.COLUMN_VILLAGE_CODE);
        this.villagename = jsonObject.getString(SingleVillage.COLUMN_VILLAGE_NAME);

        return this;
    }

    public VillagesContract hydrate(Cursor cursor) {
        this.talukacode = cursor.getString(cursor.getColumnIndex(SingleVillage.COLUMN_TALUKA_CODE));
        this.uccode = cursor.getString(cursor.getColumnIndex(SingleVillage.COLUMN_UC_CODE));
        this.villagecode = cursor.getString(cursor.getColumnIndex(SingleVillage.COLUMN_VILLAGE_CODE));
        this.villagename = cursor.getString(cursor.getColumnIndex(SingleVillage.COLUMN_VILLAGE_NAME));

        return this;
    }


    public static abstract class SingleVillage implements BaseColumns {

        public static final String TABLE_NAME = "villages";
        public static final String _ID = "_id";
        public static final String COLUMN_TALUKA_CODE = "taluka_code";
        public static final String COLUMN_UC_CODE = "uc_code";
        public static final String COLUMN_VILLAGE_CODE = "village_code";
        public static final String COLUMN_VILLAGE_NAME = "village_name";

        public static final String _URI = "villages.php";
    }

}