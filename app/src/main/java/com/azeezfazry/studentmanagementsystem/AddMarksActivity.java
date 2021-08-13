package com.azeezfazry.studentmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddMarksActivity extends AppCompatActivity {
    EditText usnET, sgpa1ET, sgpa2ET, sgpa3ET, sgpa4ET, sgpa5ET, sgpa6ET, sgpa7ET, sgpa8ET;
    CollegeDatabase collegeDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_marks);

        collegeDatabase = new CollegeDatabase(this);

        usnET = findViewById(R.id.etUsn);
        sgpa1ET = findViewById(R.id.etSgpa1);
        sgpa2ET = findViewById(R.id.etSgpa2);
        sgpa3ET = findViewById(R.id.etSgpa3);
        sgpa4ET = findViewById(R.id.etSgpa4);
        sgpa5ET = findViewById(R.id.etSgpa5);
        sgpa6ET = findViewById(R.id.etSgpa6);
        sgpa7ET = findViewById(R.id.etSgpa7);
        sgpa8ET = findViewById(R.id.etSgpa8);
    }

    public void buSubmitAction(View view) {
        boolean isInserted = collegeDatabase.insertMarks(usnET.getText().toString(), sgpa1ET.getText().toString(), sgpa2ET.getText().toString(), sgpa3ET.getText().toString(), sgpa4ET.getText().toString(), sgpa5ET.getText().toString(), sgpa6ET.getText().toString(), sgpa7ET.getText().toString(), sgpa8ET.getText().toString());
        if(isInserted) {
            usnET.setText("");
            sgpa1ET.setText("");
            sgpa2ET.setText("");
            sgpa3ET.setText("");
            sgpa4ET.setText("");
            sgpa5ET.setText("");
            sgpa6ET.setText("");
            sgpa7ET.setText("");
            sgpa8ET.setText("");
            Toast.makeText(AddMarksActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(AddMarksActivity.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
        }
    }
}