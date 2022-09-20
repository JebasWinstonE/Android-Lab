package com.example.wilkinslibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_details);
        DBHelper dbHelper = new DBHelper(this);
        Button submit = findViewById(R.id.button);
        submit.setOnClickListener(view -> {
            EditText isbnNumberET = findViewById(R.id.isbnNumber);
            EditText bookNumberET = findViewById(R.id.bookName);
            EditText authorNameET = findViewById(R.id.authorName);
            if(getIntent().getStringExtra("Usage Type").equals("Add Book")) {
                dbHelper.addNewBook(isbnNumberET.getText().toString(), bookNumberET.getText().toString(), authorNameET.getText().toString());
                Toast.makeText(this, "Book Added Successfully!", Toast.LENGTH_LONG).show();
            } else {
                dbHelper.updateBooks(isbnNumberET.getText().toString(), bookNumberET.getText().toString(), authorNameET.getText().toString());
                Toast.makeText(this, "Book Updated Successfully!", Toast.LENGTH_LONG).show();
            }
            Intent bookDetailsIntent = new Intent(this, BookDetailsActivity.class);
            startActivity(bookDetailsIntent);
        });
    }
}