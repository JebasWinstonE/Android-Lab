package com.example.wilkinslibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.widget.Button;

public class BooksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        Button viewBooks = findViewById(R.id.viewBooks);
        Button updateBooks = findViewById(R.id.updateBooks);
        Button removeBooks = findViewById(R.id.removeBooks);
        viewBooks.setOnClickListener(view -> {
            Intent bookDetailsIntent = new Intent(this, BookDetailsActivity.class);
            startActivity(bookDetailsIntent);
        });
        updateBooks.setOnClickListener(view -> {
            Intent updateDetailsIntent = new Intent(this, UpdateDetailsActivity.class);
            updateDetailsIntent.putExtra("Usage Type", "Update Book");
            startActivity(updateDetailsIntent);
        });
        removeBooks.setOnClickListener(view -> {
            Intent removeBooksIntent = new Intent(this, RemoveBookActivity.class);
            startActivity(removeBooksIntent);
        });
    }
}