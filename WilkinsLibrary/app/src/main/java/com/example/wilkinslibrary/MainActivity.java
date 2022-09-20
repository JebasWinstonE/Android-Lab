package com.example.wilkinslibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login = findViewById(R.id.login);
        login.setOnClickListener(view -> {
            EditText userNameET = findViewById(R.id.username);
            EditText passwordET = findViewById(R.id.password);
            if(userNameET.getText().toString().equals("JebasWinston") && passwordET.getText().toString().equals("12345")) {
                Intent nextPageIntent = new Intent(this, TwoActivity.class);
                startActivity(nextPageIntent);
            } else {
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setCancelable(true);
                alert.setMessage("Oops! Your Username and Password mismatches. Check your credentials.");
                alert.setPositiveButton("Okay", ((dialogInterface, i) -> dialogInterface.cancel()));
                alert.setNegativeButton("Cancel", ((dialogInterface, i) -> dialogInterface.cancel()));
                alert.show();
            }
        });
    }
}