package com.azeezfazry.studentmanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * Created by Azeez Fazry on 2021-07-21 10:02 PM
 *
 * git: azeez-fazry
 */
public class CollegeDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "college.db";
    public static final String TABLE_NAME = "student_table";
    public static final String TABLE_COL_1 = "id";
    public static final String TABLE_COL_2 = "first_name";
    public static final String TABLE_COL_3 = "last_name";
    public static final String TABLE_COL_4 = "usn";
    public static final String TABLE_COL_5 = "phone";
    public static final String TABLE_COL_6 = "department";

    public CollegeDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, FIRST_NAME TEXT, LAST_NAME TEXT, USN TEXT, PHONE TEXT, DEPARTMENT TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String fname, String lname, String usn, String phone, String department){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(TABLE_COL_2, fname);
        contentValues.put(TABLE_COL_3, lname);
        contentValues.put(TABLE_COL_4, usn);
        contentValues.put(TABLE_COL_5, phone);
        contentValues.put(TABLE_COL_5, department);

        // Insert contents into database
        long success = db.insert(TABLE_NAME, null, contentValues);

        if(success == -1){
            // when query not inserted into database
            return false;
        } else {
            return true;
        }
    }
}
