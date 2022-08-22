package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button gallery = (Button) findViewById(R.id.gallery);
        Button camera = (Button) findViewById(R.id.camera);
        Button browser = (Button) findViewById(R.id.browser);
        Button dialler = (Button) findViewById(R.id.dialler);
        gallery.setOnClickListener( view -> {
            Intent galleryIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
            startActivity(galleryIntent);
        });
        camera.setOnClickListener( view -> {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, 0);
        });
        browser.setOnClickListener( view -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
            startActivity(browserIntent);
        });

        // Dialler 
        dialler.setOnClickListener( view -> {
            EditText dialET = (EditText) findViewById(R.id.phoneNumber);
            Intent calculatorIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + dialET.getText().toString()));
            startActivity(calculatorIntent);
        });

    }
}