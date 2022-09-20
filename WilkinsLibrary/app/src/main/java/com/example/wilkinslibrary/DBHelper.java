package com.example.wilkinslibrary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "libraryDB";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Books";
    private static final String ISBN_COL = "ISBN";
    private static final String BOOK_NAME_COL = "Book";
    private static final String AUTHOR_NAME_COL = "Author";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //String query = new StringBuilder().append("CREATE TABLE ").append(TABLE_NAME).append(" (").append(ISBN_COL).append(" INTEGER PRIMARY KEY, ").append(BOOK_NAME_COL).append(" TEXT,").append(AUTHOR_NAME_COL).append(" TEXT)").toString();
        String query = "CREATE TABLE " + TABLE_NAME + " ('" + ISBN_COL + "' TEXT PRIMARY KEY , '" + BOOK_NAME_COL + "' TEXT,'" + AUTHOR_NAME_COL + "' TEXT)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME ;
        //sqLiteDatabase.execSQL(new StringBuilder().append("DROP TABLE IF EXISTS ").append(TABLE_NAME).toString());
        onCreate(sqLiteDatabase);
    }

    public void addNewBook(String isbnNumber, String bookName, String authorName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BOOK_NAME_COL, bookName);
        values.put(ISBN_COL,isbnNumber);
        values.put(AUTHOR_NAME_COL, authorName);
        db.insert(TABLE_NAME, null, values);
        db.close();
//        String query = "INSERT INTO " + TABLE_NAME + " (" + ISBN_COL + ", " + BOOK_NAME_COL + ", " + AUTHOR_NAME_COL + ") VALUES ('" + isbnNumber + "', " + bookName + "', " + authorName + "')";
//        db.execSQL(query);
    }

    public ArrayList<BookModel> readBooks() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<BookModel> bookModelArrayList = new ArrayList<>();
        if(cursor.moveToFirst()) {
            do {
                bookModelArrayList.add(new BookModel(cursor.getString(0),
                                            cursor.getString(1),
                                            cursor.getString(2 )));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return bookModelArrayList;
    }

    public void updateBooks(String isbnNumber, String bookName, String authorName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ISBN_COL, isbnNumber);
        values.put(BOOK_NAME_COL, bookName);
        values.put(AUTHOR_NAME_COL, authorName);
        db.update(TABLE_NAME, values, "ISBN = ?", new String[]{isbnNumber});
        db.close();
    }

    public void deleteBook(String isbnNumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "ISBN = ?", new String[] {isbnNumber});
        db.close();
    }
}
