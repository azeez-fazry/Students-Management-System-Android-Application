package com.azeezfazry.studentmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buLoginAction(View view) {
        EditText editTextUsername = findViewById(R.id.etUsername);
        EditText editTextPassword = findViewById(R.id.etPassword);
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();
        if (isValidLogin(username, password)) {
            Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
            startActivity(intent);
        }

    }

    /**
     * Function to validate the user
     * @param username
     * @param password
     * @return
     */
    private boolean isValidLogin(String username, String password) {
        if("admin".equals(username) && "admin@123".equals(password)) {
                return true;
        }
        Toast.makeText(this, "Incorrect Username or Password", Toast.LENGTH_SHORT).show();
        return false;
    }
}