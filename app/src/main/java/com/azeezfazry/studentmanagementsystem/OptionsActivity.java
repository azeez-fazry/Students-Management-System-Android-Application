package com.azeezfazry.studentmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }

    public void buAddStudebtActivity(View view) {
        Intent intent = new Intent(OptionsActivity.this, AddStudent.class);
        startActivity(intent);
    }

    public void buViewDetailsActivity(View view) {
        Intent intent = new Intent(OptionsActivity.this, ViewDetailsActivity.class);
        startActivity(intent);
    }

    public void buAddMarksActivity(View view) {
        Intent intent = new Intent(OptionsActivity.this, AddMarksActivity.class);
        startActivity(intent);
    }
}