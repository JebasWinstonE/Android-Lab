package com.example.wilkinslibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Button okay = findViewById(R.id.okay);
        okay.setOnClickListener(view -> {
            Intent backIntent = new Intent(this, TwoActivity.class);
            startActivity(backIntent);
        });
    }
}