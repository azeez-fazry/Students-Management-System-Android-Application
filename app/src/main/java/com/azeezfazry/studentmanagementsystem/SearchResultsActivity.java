package com.azeezfazry.studentmanagementsystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SearchResultsActivity extends AppCompatActivity {
    String usn;
    CollegeDatabase collegeDatabase;
    TextView textViewFullName;
    TextView textViewEmail;
    TextView phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        onCreate();
    }

    private void onCreate(){
        textViewFullName = findViewById(R.id.tvFullName);
        textViewEmail = findViewById(R.id.tvEmail);
        usn = getIntent().getStringExtra("usn");
        phoneNo = findViewById(R.id.etPhone);
        databaseAccess();
    }

    private void databaseAccess() {
        collegeDatabase = new CollegeDatabase(this);
        Cursor cursor = collegeDatabase.retrieveData(usn);

        if(cursor.getCount() == 0){
            Toast.makeText(SearchResultsActivity.this, "No Data Found!", Toast.LENGTH_SHORT).show();
            return;
        }

        while (cursor.moveToNext()){
            try {
                textViewFullName.setText(cursor.getString(0).toUpperCase() + " " + cursor.getString(1).toUpperCase());
                textViewEmail.setText(cursor.getString(2).toUpperCase());
                phoneNo.setText("+91" + cursor.getString(3));
            } catch (Exception ex) {
                Toast.makeText(SearchResultsActivity.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void buViewResultsActivity(View view) {
        collegeDatabase = new CollegeDatabase(this);
        Cursor cursor = collegeDatabase.retrieveResults(usn);

        if(cursor.getCount() == 0){
            Toast.makeText(SearchResultsActivity.this, "No Data Found!", Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();

        while (cursor.moveToNext()){
            try {
                stringBuffer.append("2nd Sem:   " + cursor.getString(2) + "\n");
                stringBuffer.append("3rd Sem:   " + cursor.getString(3) + "\n");
                stringBuffer.append("4th Sem:   " + cursor.getString(4) + "\n");
                stringBuffer.append("5th Sem:   " + cursor.getString(5) + "\n");
                stringBuffer.append("6th Sem:   " + cursor.getString(6) + "\n");
                stringBuffer.append("7th Sem:   " + cursor.getString(7) + "\n");
                stringBuffer.append("7th Sem:   " + cursor.getString(8) + "\n");
                stringBuffer.append("8th Sem:   " + cursor.getString(9) + "\n\n\n");
            } catch (Exception ex) {
                Toast.makeText(SearchResultsActivity.this, "Error!", Toast.LENGTH_SHORT).show();
            }
            showMessage("Results",stringBuffer.toString());
        }
    }

    private void showMessage(String title, String stringBuffer) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title + " of " + usn.toUpperCase());
        builder.setMessage(stringBuffer);
        builder.show();
    }
}