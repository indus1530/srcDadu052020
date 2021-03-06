package edu.aku.hassannaqvi.srcDadu052020.utils;

import edu.aku.hassannaqvi.srcDadu052020.contracts.BLRandomContract.SingleRandomHH;
import edu.aku.hassannaqvi.srcDadu052020.contracts.FormsContract;
import edu.aku.hassannaqvi.srcDadu052020.contracts.ParticipantContract;
import edu.aku.hassannaqvi.srcDadu052020.contracts.TalukasContract;
import edu.aku.hassannaqvi.srcDadu052020.contracts.UCsContract;
import edu.aku.hassannaqvi.srcDadu052020.contracts.UsersContract;
import edu.aku.hassannaqvi.srcDadu052020.contracts.VersionAppContract;
import edu.aku.hassannaqvi.srcDadu052020.contracts.VillagesContract;

public final class CreateTable {

    public static final String DATABASE_NAME = "srcDadu052020.db";
    public static final String DB_NAME = "srcDadu052020_copy.db";
    public static final String PROJECT_NAME = "srcDadu052020";
    public static final int DATABASE_VERSION = 1;

    public static final String SQL_CREATE_FORMS = "CREATE TABLE "
            + FormsContract.FormsTable.TABLE_NAME + "("
            + FormsContract.FormsTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FormsContract.FormsTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_DEVICEID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_DEVICETAGID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_USER + " TEXT,"
            + FormsContract.FormsTable.COLUMN_UID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_LUID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSLAT + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSLNG + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSDATE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSACC + " TEXT,"
            + FormsContract.FormsTable.COLUMN_FORMDATE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_APPVERSION + " TEXT,"
            + FormsContract.FormsTable.COLUMN_CLUSTERCODE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_HHNO + " TEXT,"
            + FormsContract.FormsTable.COLUMN_FORMTYPE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SINFO + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SA + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SM + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SN + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SO + " TEXT,"
            + FormsContract.FormsTable.COLUMN_FSTATUS + " TEXT,"
            + FormsContract.FormsTable.COLUMN_FSTATUS88x + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ENDINGDATETIME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ISTATUS + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ISTATUS88x + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYNCED + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYNCED_DATE + " TEXT"
            + " );";


    public static final String SQL_CREATE_PARTICIPANT_TABLE = "CREATE TABLE " + ParticipantContract.singleParticipant.TABLE_NAME + "("
            + ParticipantContract.singleParticipant._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ParticipantContract.singleParticipant.COLUMN_DEVICEID + " TEXT,"
            + ParticipantContract.singleParticipant.COLUMN_DEVICETAGID + " TEXT,"
            + ParticipantContract.singleParticipant.COLUMN_USER + " TEXT,"
            + ParticipantContract.singleParticipant.COLUMN_UID + " TEXT,"
            + ParticipantContract.singleParticipant.COLUMN_UUID + " TEXT,"
            + ParticipantContract.singleParticipant.COLUMN_FORMDATE + " TEXT,"
            + ParticipantContract.singleParticipant.COLUMN_SA + " TEXT,"
            + ParticipantContract.singleParticipant.COLUMN_SYNCED + " TEXT,"
            + ParticipantContract.singleParticipant.COLUMN_SYNCED_DATE + " TEXT,"

            + ParticipantContract.singleParticipant.COLUMN_A + " TEXT,"
            + ParticipantContract.singleParticipant.COLUMN_B + " TEXT,"
            + ParticipantContract.singleParticipant.COLUMN_C + " TEXT,"
            + ParticipantContract.singleParticipant.COLUMN_D + " TEXT,"
            + ParticipantContract.singleParticipant.COLUMN_E + " TEXT,"
            + ParticipantContract.singleParticipant.COLUMN_F + " TEXT,"
            + ParticipantContract.singleParticipant.COLUMN_G + " TEXT,"
            + ParticipantContract.singleParticipant.COLUMN_H + " TEXT,"
            + ParticipantContract.singleParticipant.COLUMN_I + " TEXT,"
            + ParticipantContract.singleParticipant.COLUMN_CSTATUS + " TEXT,"
            + ParticipantContract.singleParticipant.COLUMN_CSTATUS88x + " TEXT );";


    public static final String SQL_CREATE_USERS = "CREATE TABLE " + UsersContract.singleUser.TABLE_NAME + "("
            + UsersContract.singleUser._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsersContract.singleUser.ROW_USERNAME + " TEXT,"
            + UsersContract.singleUser.ROW_PASSWORD + " TEXT"
            + " );";


    public static final String SQL_CREATE_TALUKA = "CREATE TABLE " + TalukasContract.singleTalukas.TABLE_NAME + "("
            + TalukasContract.singleTalukas._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + TalukasContract.singleTalukas.COLUMN_TALUKA_CODE + " INTEGER,"
            + TalukasContract.singleTalukas.COLUMN_TALUKA + " TEXT"
            + " );";


    public static final String SQL_CREATE_UCS = "CREATE TABLE " + UCsContract.singleUCs.TABLE_NAME + "("
            + UCsContract.singleUCs._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UCsContract.singleUCs.COLUMN_UCCODE + " INTEGER,"
            + UCsContract.singleUCs.COLUMN_UCS + " TEXT,"
            + UCsContract.singleUCs.COLUMN_TALUKA_CODE + " TEXT"
            + " );";


    public static final String SQL_CREATE_VILLAGE = "CREATE TABLE " + VillagesContract.SingleVillage.TABLE_NAME + "("
            + VillagesContract.SingleVillage._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + VillagesContract.SingleVillage.COLUMN_TALUKA_CODE + " TEXT,"
            + VillagesContract.SingleVillage.COLUMN_UC_CODE + " TEXT,"
            + VillagesContract.SingleVillage.COLUMN_VILLAGE_CODE + " TEXT,"
            + VillagesContract.SingleVillage.COLUMN_VILLAGE_NAME + " TEXT"
            + " );";


    public static final String SQL_CREATE_VERSIONAPP = "CREATE TABLE " + VersionAppContract.VersionAppTable.TABLE_NAME + " (" +
            VersionAppContract.VersionAppTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            VersionAppContract.VersionAppTable.COLUMN_VERSION_CODE + " TEXT, " +
            VersionAppContract.VersionAppTable.COLUMN_VERSION_NAME + " TEXT, " +
            VersionAppContract.VersionAppTable.COLUMN_PATH_NAME + " TEXT " +
            ");";

    public static final String SQL_CREATE_BL_RANDOM = "CREATE TABLE " + SingleRandomHH.TABLE_NAME + "("
            + SingleRandomHH.COLUMN_ID + " TEXT,"
            + SingleRandomHH.COLUMN_P_CODE + " TEXT,"
            + SingleRandomHH.COLUMN_EB_CODE + " TEXT,"
            + SingleRandomHH.COLUMN_LUID + " TEXT,"
            + SingleRandomHH.COLUMN_HH + " TEXT,"
            + SingleRandomHH.COLUMN_STRUCTURE_NO + " TEXT,"
            + SingleRandomHH.COLUMN_FAMILY_EXT_CODE + " TEXT,"
            + SingleRandomHH.COLUMN_HH_HEAD + " TEXT,"
            + SingleRandomHH.COLUMN_CONTACT + " TEXT,"
            + SingleRandomHH.COLUMN_HH_SELECTED_STRUCT + " TEXT,"
            + SingleRandomHH.COLUMN_RANDOMDT + " TEXT,"
            + SingleRandomHH.COLUMN_SNO_HH + " TEXT );";

}
