package com.example.wilkinslibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class BookDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        FloatingActionButton addBooks = findViewById(R.id.addBooks);
        addBooks.setOnClickListener(view -> {
            Intent addBooksIntent = new Intent(this, UpdateDetailsActivity.class);
            addBooksIntent.putExtra("Usage Type", "Add Book");
            startActivity(addBooksIntent);
        });
        ScrollView scrollView = findViewById(R.id.scrollView);
        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        DBHelper dbHelper = new DBHelper(this);
        ArrayList<BookModel> books = dbHelper.readBooks();
        for(BookModel i : books) {
            TextView textView = new TextView(this);
            textView.setText(i.getIsbnNumber() + " - " + i.getBookName() + " - " + i.getAuthorName());
            textView.setTextSize(30);
            textView.setTextColor(Color.rgb(19,20,23));
            linearLayout.addView(textView);
        }
    }
}