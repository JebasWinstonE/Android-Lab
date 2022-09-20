package com.example.wilkinslibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RemoveBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_book);

        Button remove = findViewById(R.id.remove);
        remove.setOnClickListener(view -> {
            DBHelper dbHelper = new DBHelper(this);
            EditText isbnNumberET = findViewById(R.id.isbnNum);
            dbHelper.deleteBook(isbnNumberET.getText().toString());
            Toast.makeText(this, "Book removed successfull!", Toast.LENGTH_LONG).show();
            Intent bookDetailsIntent = new Intent(this, BookDetailsActivity.class);
            startActivity(bookDetailsIntent);
        });
    }
}