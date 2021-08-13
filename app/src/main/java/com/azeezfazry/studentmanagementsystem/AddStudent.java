package com.azeezfazry.studentmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
        boolean isInserted = collegeDatabase.insertData(fname.getText().toString(), lname.getText().toString(), usn.getText().toString(), phone.getText().toString(), department.getText().toString());
        if(isInserted) {
            fname.setText("");
            lname.setText("");
            usn.setText("");
            phone.setText("");
            department.setText("");
            Toast.makeText(AddStudent.this, "Data Inserted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(AddStudent.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
        }
    }
}