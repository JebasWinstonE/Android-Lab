package com.example.railwayreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ThreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        Bundle extras = getIntent().getExtras();
        TextView message = (TextView) findViewById(R.id.message);
        String username = extras.getString("username");
        String from = extras.getString("from");
        String to = extras.getString("to");
        String date = extras.getString("date");
        String noOfTickets = extras.getString("noOfTickets");

        message.setText("User Name: " + username +
                        "\nFrom: " + from +
                        "\nTo: " + to +
                        "\nDate: " + date +
                        "\nNumber of Tickets: " + noOfTickets);

        Button done = (Button) findViewById(R.id.done);
        done.setOnClickListener(view -> {
            Intent backToHomeIntent = new Intent(this, MainActivity.class);
            startActivity(backToHomeIntent);
        });
    }
}