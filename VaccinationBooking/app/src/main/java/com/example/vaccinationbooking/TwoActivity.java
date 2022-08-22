package com.example.vaccinationbooking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        EditText nameET = findViewById(R.id.name);
        EditText mobileNumberET = findViewById(R.id.mobileNumber);
        EditText placeET = findViewById(R.id.place);
        LottieAnimationView submit = findViewById(R.id.submit);

        submit.setOnClickListener(view -> {
            if(ContextCompat.checkSelfPermission(TwoActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                Intent homePageIntent = new Intent(this, MainActivity.class);
                submit.playAnimation();
                submit.setSpeed(1);
                String name = nameET.getText().toString();
                String mobileNumber = mobileNumberET.getText().toString();
                String place = placeET.getText().toString();
                if (!name.equals("") && !mobileNumber.equals("") && !place.equals("")) {
                    SmsManager smsManager = SmsManager.getDefault();
                    StringBuilder message = new StringBuilder();
                    message.append("Your slot for the vaccination was successfully booked!\n");
                    message.append("Name: " + name);
                    message.append("\nMobile Number: " + mobileNumber);
                    message.append(("\nPlace: " + place));
                    smsManager.sendTextMessage(mobileNumber,null, String.valueOf(message),null,null);
                    Toast.makeText(this, "Message sent successfully!", Toast.LENGTH_LONG).show();
                    startActivity(homePageIntent);
                } else {
                    Toast.makeText(this, "All the fields are mandatory to fill!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}