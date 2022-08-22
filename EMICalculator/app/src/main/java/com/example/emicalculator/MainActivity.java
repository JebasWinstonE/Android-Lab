package com.example.emicalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // View Instances
        EditText pricipleET = (EditText) findViewById(R.id.principle);
        Spinner loanSP = (Spinner) findViewById(R.id.loanType);
        SeekBar yearsSB = (SeekBar) findViewById(R.id.years);
        EditText rateET = (EditText) findViewById(R.id.rateOfInterest);
        Button submitBT = findViewById(R.id.calculate);

        // Assign values to spinner
        ArrayList <String> loanTypes = new ArrayList<>();
        loanTypes.add("Home Loan");
        loanTypes.add("Car Loan");
        loanTypes.add("Personal Loan");
        ArrayAdapter <String> incomeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, loanTypes);
        incomeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        loanSP.setAdapter(incomeAdapter);

        // Setting Listener
        submitBT.setOnClickListener(view -> {
            int principle = Integer.parseInt(pricipleET.getText().toString());
            int years = (yearsSB.getProgress() + 1) * 12;
            int rate = Integer.parseInt(rateET.getText().toString());
            double emi = (principle*rate*Math.pow((1+rate), years)) / (Math.pow((1+rate), years-1));
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            StringBuilder message = new StringBuilder();
            message.append("Principle: " + principle + "\nNo. of Months: " + years + "\nRate of Interest: " + rate + "\nEMI: " + Float.parseFloat(String.valueOf(emi)));
            alert.setMessage(message);
            alert.setCancelable(true);
            alert.setPositiveButton("Okay", (dialog, id) -> dialog.cancel());
            alert.setNegativeButton("Cancel", (dialog, id) -> dialog.cancel());
            AlertDialog alertMessage = alert.create();
            alertMessage.show();
        });
    }
}