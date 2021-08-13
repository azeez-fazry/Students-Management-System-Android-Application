package com.azeezfazry.studentmanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * Created by Azeez Fazry on 2021-07-16 02:39 AM
 *
 * git: github.com/azeez-fazry/Students-Management-System-Android-Application
 */
public class CollegeDatabase extends SQLiteOpenHelper {

    Cursor cursor;
    //    For student table
    public static final String DATABASE_NAME = "college.db";
    public static final String STUDENT_TABLE = "student_table";
    public static final String TABLE_COL_2 = "first_name";
    public static final String TABLE_COL_3 = "last_name";
    public static final String TABLE_COL_4 = "usn";
    public static final String TABLE_COL_5 = "phone";
    public static final String TABLE_COL_6 = "department";

    //    For marks table
    public static final String MARKS_TABLE = "marks_table";
    public static final String MARKS_TABLE_COL_2 = "usn";
    public static final String MARKS_TABLE_COL_3 = "sgpa_1";
    public static final String MARKS_TABLE_COL_4 = "sgpa_2";
    public static final String MARKS_TABLE_COL_5 = "sgpa_3";
    public static final String MARKS_TABLE_COL_6 = "sgpa_4";
    public static final String MARKS_TABLE_COL_7 = "sgpa_5";
    public static final String MARKS_TABLE_COL_8 = "sgpa_6";
    public static final String MARKS_TABLE_COL_9 = "sgpa_7";
    public static final String MARKS_TABLE_COL_10 = "sgpa_8";

    public CollegeDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + MARKS_TABLE);
        db.execSQL("CREATE TABLE " + STUDENT_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, FIRST_NAME TEXT NOT NULL, LAST_NAME TEXT NOT NULL, USN TEXT NOT NULL UNIQUE, PHONE TEXT, DEPARTMENT TEXT NOT NULL)");
        db.execSQL("CREATE TABLE " + MARKS_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, USN TEXT NOT NULL UNIQUE, SGPA_1 TEXT, SGPA_2 TEXT, SGPA_3 TEXT, SGPA_4 TEXT, SGPA_5 TEXT, SGPA_6 TEXT, SGPA_7 TEXT, SGPA_8 TEXT, FOREIGN KEY (" + MARKS_TABLE_COL_2 + ") REFERENCES " + STUDENT_TABLE + " (" + TABLE_COL_4+ "))");
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

//        onCreate(db);
        contentValues.put(TABLE_COL_2, fname);
        contentValues.put(TABLE_COL_3, lname);
        contentValues.put(TABLE_COL_4, usn);
        contentValues.put(TABLE_COL_5, phone);
        contentValues.put(TABLE_COL_6, department);

        long success = db.insert(STUDENT_TABLE, null, contentValues);

        if(success == -1) return false;
        else return true;
    }

    public boolean insertMarks(String usn, String sgpa1, String sgpa2, String sgpa3, String sgpa4, String sgpa5, String sgpa6, String sgpa7, String sgpa8) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(MARKS_TABLE_COL_2, usn);
        contentValues.put(MARKS_TABLE_COL_3, sgpa1);
        contentValues.put(MARKS_TABLE_COL_4, sgpa2);
        contentValues.put(MARKS_TABLE_COL_5, sgpa3);
        contentValues.put(MARKS_TABLE_COL_6, sgpa4);
        contentValues.put(MARKS_TABLE_COL_7, sgpa5);
        contentValues.put(MARKS_TABLE_COL_8, sgpa6);
        contentValues.put(MARKS_TABLE_COL_9, sgpa7);
        contentValues.put(MARKS_TABLE_COL_10, sgpa8);

        long success = db.insert(MARKS_TABLE, null, contentValues);

        if (success == -1) return false;
        else return true;
    }

    public Cursor retrieveData(String usn) {
        SQLiteDatabase db = this.getReadableDatabase();
        cursor = db.rawQuery("SELECT "+TABLE_COL_2+" ,"+TABLE_COL_3+" ,"+TABLE_COL_4 +" ," +TABLE_COL_5+ " FROM " + STUDENT_TABLE + " WHERE usn = '"+ usn +"'", null);
        return cursor;
    }

    public Cursor retrieveResults(String usn) {
        SQLiteDatabase db = this.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM " + MARKS_TABLE + " WHERE usn = '" + usn + "'",null);
        return cursor;
    }

}