package com.azeezfazry.studentmanagementsystem;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.Short2;

import androidx.annotation.Nullable;

/**
 * Created by Azeez Fazry on 2021-07-21 10:02 PM
 *
 * git: azeez-fazry
 */
public class CollegeDatabase extends SQLiteOpenHelper {

//    For student table
    public static final String DATABASE_NAME = "college.db";
    public static final String STUDENT_TABLE = "student_table";
    public static final String TABLE_COL_1 = "id";
    public static final String TABLE_COL_2 = "first_name";
    public static final String TABLE_COL_3 = "last_name";
    public static final String TABLE_COL_4 = "usn";
    public static final String TABLE_COL_5 = "phone";
    public static final String TABLE_COL_6 = "department";

//    For marks table
    public static final String MARKS_TABLE = "marks_table";
    public static final String USN = "usn";
    public static final String SGPA_1 = "sgpa_1";
    public static final String SGPA_2 = "sgpa_2";
    public static final String SGPA_3 = "sgpa_3";
    public static final String SGPA_4 = "sgpa_4";
    public static final String SGPA_5 = "sgpa_5";
    public static final String SGPA_6 = "sgpa_6";
    public static final String SGPA_7 = "sgpa_7";
    public static final String SGPA_8 = "sgpa_8";


    public CollegeDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE " + STUDENT_TABLE);
        db.execSQL("DROP TABLE " + MARKS_TABLE);
        db.execSQL("CREATE TABLE " + STUDENT_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, FIRST_NAME TEXT, LAST_NAME TEXT, USN TEXT, PHONE TEXT, DEPARTMENT TEXT)");
        db.execSQL("CREATE " + MARKS_TABLE + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, USN TEXT, SGPA_1 TEXT, SGPA_2 TEXT, SGPA_3 TEXT, SGPA_4 TEXT, SGPA_5 TEXT, SGPA_6 TEXT, SGPA_7 TEXT, SGPA_8 TEXT, FOREIGN KEY (USN) REFERENCES " + STUDENT_TABLE +"(USN))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + STUDENT_TABLE);
        db.execSQL("DROP TABLE " + MARKS_TABLE);
        onCreate(db);
    }

    public boolean insertData(String fname, String lname, String usn, String phone, String department){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(TABLE_COL_2, fname);
        contentValues.put(TABLE_COL_3, lname);
        contentValues.put(TABLE_COL_4, usn);
        contentValues.put(TABLE_COL_5, phone);
        contentValues.put(TABLE_COL_6, department);

        // Insert contents into database
        long success = db.insert(STUDENT_TABLE, null, contentValues);

        if(success == -1){
            // when query not inserted into database
            return false;
        } else {
            return true;
        }
    }

    public boolean insertMarks(String usn, String sgpa1, String sgpa2, String sgpa3, String sgpa4, String sgpa5, String sgpa6, String sgpa7, String sgpa8){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(USN, usn);
        contentValues.put(SGPA_1, sgpa1);
        contentValues.put(SGPA_2, sgpa2);
        contentValues.put(SGPA_3, sgpa3);
        contentValues.put(SGPA_4, sgpa4);
        contentValues.put(SGPA_5, sgpa5);
        contentValues.put(SGPA_6, sgpa6);
        contentValues.put(SGPA_7, sgpa7);
        contentValues.put(SGPA_8, sgpa8);

        // Insert contents into database
        long success = db.insert(MARKS_TABLE, null, contentValues);

        if(success == -1){
            // when query not inserted into database
            return false;
        } else {
            return true;
        }
    }

    public Cursor retrieveData(String usn) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT "+TABLE_COL_2+" ,"+TABLE_COL_3+" ,"+TABLE_COL_4+" FROM " + STUDENT_TABLE + " WHERE usn = '"+ usn +"'", null);
        return cursor;
    }

    public Cursor retrieveResults(String usn) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + MARKS_TABLE + " WHERE USN = '" + usn + "'",null);
        return cursor;
    }
}
