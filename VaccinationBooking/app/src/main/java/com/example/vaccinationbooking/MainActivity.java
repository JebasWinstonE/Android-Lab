package com.example.vaccinationbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LottieAnimationView registerButton = (LottieAnimationView) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(view -> {
            registerButton.setSpeed(1);
            registerButton.playAnimation();
            delay(1000 );
            Intent nextPageIntent = new Intent(this, TwoActivity.class);
            startActivity(nextPageIntent);
        });
    }

    private void delay(int i) {
        for(int j=0; j<i; j++);
    }
}