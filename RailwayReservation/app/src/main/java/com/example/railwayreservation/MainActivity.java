package com.example.railwayreservation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] users = {"jebas@gmail.com", "Jebas Winston", "sample@gmail.com", "Sample"};
        ArrayList <String> userNames = new ArrayList<>(Arrays.asList(users));
        String[] passwords = {"12345", "12345", "98765", "98765"};
        ArrayList <String> passWords = new ArrayList<>(Arrays.asList(passwords));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText userNameET = (EditText) findViewById(R.id.username);
        EditText passwordET = (EditText) findViewById(R.id.password);
        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener( view -> {
            Intent nextPageIntent = new Intent(this, TwoActivity.class);
            String userName = userNameET.getText().toString();
            String passWord = passwordET.getText().toString();
            int userNameIndex = userNames.indexOf(userName);
            if (userNameIndex == -1) {
                AlertDialog.Builder usernameMismatchAlert = new AlertDialog.Builder(this);
                usernameMismatchAlert.setMessage("Oops! User Name is incorrect!");
                usernameMismatchAlert.setCancelable(true);
                usernameMismatchAlert.setPositiveButton("Okay", (dialog, id) -> dialog.cancel());
                usernameMismatchAlert.setNegativeButton("Cancel", (dialog, id) -> dialog.cancel());
                AlertDialog usernameMismatch = usernameMismatchAlert.create();
                usernameMismatch.show();
            } else if (!passwords[userNameIndex].equals(passWord)) {
                AlertDialog.Builder passwordMismatchAlert = new AlertDialog.Builder(this);
                passwordMismatchAlert.setCancelable(true);
                passwordMismatchAlert.setMessage("Oops! Your password isn't correct. Try with another one!");
                passwordMismatchAlert.setPositiveButton("Okay", (dialog,id) -> dialog.cancel());
                passwordMismatchAlert.setNegativeButton("Cancel", (dialog,id) -> dialog.cancel());
                AlertDialog passwordMismatch = passwordMismatchAlert.create();
                passwordMismatch.show();
            } else {
                nextPageIntent.putExtra("UserName", users[userNameIndex+1]);
                startActivity(nextPageIntent);
            }
        });
    }
}