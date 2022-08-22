package com.example.ipclasses;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class IPv4Validator {

    private static final String IPV4_PATTERN =
            "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$";

    private static final Pattern pattern = Pattern.compile(IPV4_PATTERN);

    public static boolean isValid(final String ip) {
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }

}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText ipET = (EditText) findViewById(R.id.ipaddress);
        Button findBT = (Button) findViewById(R.id.find);
        findBT.setOnClickListener(view -> {
           if(!IPv4Validator.isValid(ipET.getText().toString()))
           {
               AlertDialog.Builder alert = new AlertDialog.Builder(this);
               alert.setMessage("Oops! Your IP Address isn't valid.");
               alert.setCancelable(true);
               alert.setPositiveButton("Okay", (dialog,id) -> dialog.cancel());
               alert.setNegativeButton("Cancel", (dialog,id) -> dialog.cancel());
               AlertDialog alertDialog = alert.create();
               alertDialog.show();
           } else {
               int octect = Integer.parseInt(ipET.getText().toString().substring(0,3));
               String ipClass = "";
               if(octect>=0 && octect<=127)
               {
                   ipClass = "Class A";
               } else if (octect>=128 && octect<=191)
               {
                   ipClass = "Class B";
               } else if (octect>=192 && octect<=223)
               {
                   ipClass = "Class C";
               } else if (octect>=224 && octect<=239)
               {
                   ipClass = "Class D";
               } else if (octect>=240 && octect<=255)
               {
                   ipClass = "Class E";
               }
               AlertDialog.Builder alert = new AlertDialog.Builder(this);
               StringBuilder message = new StringBuilder();
               message.append("IP Address: " + ipET.getText().toString() + "\nValid: Yes\nClass: " + ipClass);
               alert.setMessage(message);
               alert.setCancelable(true);
               alert.setPositiveButton("Okay", (dialog, id) -> dialog.cancel());
               alert.setNegativeButton("Cancel", (dialog, id) -> dialog.cancel());
               AlertDialog alertDialog = alert.create();
               alertDialog.show();
           }
        });
    }
}