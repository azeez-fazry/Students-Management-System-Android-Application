package com.azeezfazry.studentmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ViewDetailsActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
    }

    public void buSearchActivity(View view) {
        editText = findViewById(R.id.etUSNSearch);
        String usn = editText.getText().toString();
//      TODO validate the usn
        Intent intent = new Intent(ViewDetailsActivity.this, SearchResultsActivity.class);
        intent.putExtra("usn", usn);
        startActivity(intent);
    }
}