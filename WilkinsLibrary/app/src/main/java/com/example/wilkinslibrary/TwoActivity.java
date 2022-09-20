package com.example.wilkinslibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        TextView profileTxt = findViewById(R.id.profileTxt);
        TextView booksTxt = findViewById(R.id.bookstxt);
        ImageView profileImg = findViewById(R.id.profileImg);
        ImageView booksImg = findViewById(R.id.booksImg);
        Intent profileIntent = new Intent(this, ProfileActivity.class);
        Intent booksIntent = new Intent(this,  BooksActivity.class);
        profileTxt.setOnClickListener(view -> startActivity(profileIntent));
        profileImg.setOnClickListener(view -> startActivity(profileIntent));
        booksTxt.setOnClickListener(view -> startActivity(booksIntent));
        booksImg.setOnClickListener(view -> startActivity(booksIntent));
    }
}