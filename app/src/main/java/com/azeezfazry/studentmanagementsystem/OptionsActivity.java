package com.azeezfazry.studentmanagementsystem;

/**
 * Created by Azeez Fazry on 2021-07-21 10:02 PM
 *
 * git: azeez-fazry
 */
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
}