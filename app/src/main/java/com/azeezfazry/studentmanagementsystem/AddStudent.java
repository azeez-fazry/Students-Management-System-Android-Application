package com.azeezfazry.studentmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddStudent extends AppCompatActivity {
    EditText fname, lname, usn, phone, department;
    CollegeDatabase collegeDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        collegeDatabase = new CollegeDatabase(this);

        fname = findViewById(R.id.etFirstName);
        lname = findViewById(R.id.etLastName);
        usn = findViewById(R.id.etUSN);
        phone = findViewById(R.id.etPhone);
        department = findViewById(R.id.etDepartment);
    }

    public void buSubmitAction(View view) {
        // Insert data into database
        boolean isInserted = collegeDatabase.insertData(fname.getText().toString(), lname.getText().toString(), usn.getText().toString(), phone.getText().toString(), department.getText().toString());

        // Show toast when data inserted successfully
        if(isInserted) {
            Toast.makeText(AddStudent.this, "Data Inserted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(AddStudent.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
        }
    }
}