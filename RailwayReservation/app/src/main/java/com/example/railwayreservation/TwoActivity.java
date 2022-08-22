package com.example.railwayreservation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class TwoActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    private int count = 0;
    Button dateButton;
    String from = "";
    String to = "";
    String date = "";
    String username = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Bundle extras =  getIntent().getExtras();

        // Getting information from the previous screen
        TextView usernameTV = (TextView) findViewById(R.id.username);
        username = extras.getString("UserName");
        usernameTV.setText(username);

        // Setting values for From and To Spinners
        ArrayList <String> fromLocations = new ArrayList<>();
        fromLocations.add("Chennai");
        fromLocations.add("Maduari");
        fromLocations.add("Tirunelveli");
        fromLocations.add("Tuticorin");
        fromLocations.add("Virudhunagar");
        ArrayList <String> toLocations = new ArrayList<>();
        toLocations.addAll(fromLocations);
        Spinner fromSP = (Spinner) findViewById(R.id.from);
        Spinner toSP = (Spinner) findViewById(R.id.to);
        fromSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                from = fromLocations.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        toSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                to = toLocations.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter <String> fromAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, fromLocations);
        ArrayAdapter <String> toAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, toLocations);
        fromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSP.setAdapter(fromAdapter);
        toSP.setAdapter(toAdapter);

        // Pop-Up date picker using Button
        dateButton = (Button) findViewById(R.id.datePicker);
        dateButton.setOnClickListener(view -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    this,
                    this,
                    Calendar.getInstance().get(Calendar.YEAR),
                    Calendar.getInstance().get(Calendar.MONTH),
                    Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
            );
            datePickerDialog.show();
        });

        // Increment and Decrement using Image Listeners
        ImageView increase = (ImageView) findViewById(R.id.increase);
        ImageView decrease = (ImageView) findViewById(R.id.decrease);
        EditText numberOfTicketsET = (EditText) findViewById(R.id.noOfTickets);
        increase.setOnClickListener(view -> {
            if(numberOfTicketsET.getText().toString().equals("")) {
                count = 0;
            }
            numberOfTicketsET.setText(String.valueOf(++count));
        });
        decrease.setOnClickListener(view -> {
            if(numberOfTicketsET.getText().toString().equals("")) {
                count = 1;
            }
            if(count != 0) {
                numberOfTicketsET.setText(String.valueOf(--count));
            } else if (count == 0) {
                numberOfTicketsET.setText(String.valueOf(count));
            }
        });

        // Button Click Listener
        Button bookTicket = (Button) findViewById(R.id.bookTicket);
        bookTicket.setOnClickListener(view -> {
//            AlertDialog.Builder alert = new AlertDialog.Builder(this);
//            alert.setCancelable(true);
//            alert.setMessage("You've Successfully booked the ticket!\n" +
//                             "                      Ticket Details\n" +
//                             "   From: " + from +
//                             "\n   To: " + to +
//                             "\n   Number of Tickets: " + count +
//                             "\n   Date: " + date);
//            alert.setPositiveButton("Okay", (dialog, id) -> dialog.cancel());
//            alert.setNegativeButton("Cancel", (dialog, id) -> dialog.cancel());
//            alert.show();

            Intent paymentCompletePageIntent = new Intent(this, ThreeActivity.class);
            paymentCompletePageIntent.putExtra("username", username);
            paymentCompletePageIntent.putExtra("from", from);
            paymentCompletePageIntent.putExtra("to", to);
            paymentCompletePageIntent.putExtra("date", date);
            paymentCompletePageIntent.putExtra("noOfTickets", String.valueOf(count));
            startActivity(paymentCompletePageIntent);
        });
    }

    private String dateToString(int day, int month, int year) {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month) {
        if(month == 1) {
            return "JAN";
        } else if (month == 2) {
            return "FEB";
        } else if (month == 3) {
            return "MAR";
        } else if (month == 4) {
            return "APR";
        } else if (month == 5) {
            return "MAY";
        } else if (month == 6) {
            return "JUN";
        } else if (month == 7) {
            return "JUL";
        } else if (month == 8) {
            return "AUG";
        } else if (month == 9) {
            return "SEP";
        } else if (month == 10) {
            return "OCT";
        } else if (month == 11) {
            return "NOV";
        } else if (month == 12) {
            return "DEC";
        }
        return "JAN";
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        date = dateToString(day, month+1, year);
        dateButton.setText(date);
    }
}