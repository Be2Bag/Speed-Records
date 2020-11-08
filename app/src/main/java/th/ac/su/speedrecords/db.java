package th.ac.su.speedrecords;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class db extends SQLiteOpenHelper {

    public static final String DB_name = "speeds.db";
    public static final String table_name = "speeds_table";
    public static final String col_1 = "id";
    public static final String col_2 = "t";
    public static final String col_3 = "s";


    public db(@Nullable Context context) {
        super(context, DB_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE speeds_table (id INTEGER PRIMARY KEY AUTOINCREMENT, t REAL,s REAL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS"+ table_name);
        onCreate(sqLiteDatabase);
    }

    public boolean addAllData(float t, float s){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2,t);
        contentValues.put(col_3,s);
        long result = sqLiteDatabase.insert(table_name,null,contentValues);
        if(result == 1){
            return false;
        }else{
            return true;
        }
    }



}
