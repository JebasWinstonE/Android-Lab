package com.example.cabbooking;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button book = findViewById(R.id.bookcab);
        EditText nameET = findViewById(R.id.name);
        EditText pickupET = findViewById(R.id.pickup);
        EditText reacoutET = findViewById(R.id.reachout);
        EditText mobileET = findViewById(R.id.mobile);
        EditText nopET = findViewById(R.id.persons);
        book.setOnClickListener(view -> {
            String name = nameET.getText().toString();
            String pickup = pickupET.getText().toString();
            String reachout = reacoutET.getText().toString();
            String mobile = mobileET.getText().toString();
            String nop = nopET.getText().toString();
            if(Integer.parseInt(nop) > 4)
            {
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setCancelable(true);
                alert.setMessage("Oops! You can't accomodate more than 4 members in this cab.");
                alert.setNegativeButton("Cancel", ((dialogInterface, i) -> dialogInterface.cancel()));
                alert.setPositiveButton("Okay", ((dialogInterface, i) -> dialogInterface.cancel()));
                alert.show();
            } else {
                StringBuilder message = new StringBuilder();
                message.append("Name: " + name);
                message.append("\nFrom: " + pickup);
                message.append("\nTo: " + reachout);
                message.append("\nMobile Number: " + mobile);
                message.append("\nNumber of Persons: " + nop);
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(mobile, null, String.valueOf(message), null, null);
                Toast.makeText(this,"Message Sent Successfully!", Toast.LENGTH_LONG).show();
            }
        });
    }
}