package com.jjsoluciones.segundosprint.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by eduardoarias on 7/04/17.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "english.db";
    private static final String TABLE_NAME = "user";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_USERNAME = "user_name";
    private static final String COLUMN_PASSWORD = "password";

    private static final String TABLE_CREATE = "CREATE TABLE user(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL," +
            "user_name TEXT NOT NULL," +
            "password TEXT NOT NULL);";

    private SQLiteDatabase db;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP IF EXISTS" + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }

    public void inserUser(User u) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,u.getUser());
        values.put(COLUMN_USERNAME,u.getNameUser());
        values.put(COLUMN_PASSWORD,u.getPassword());

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public String searchUser(String username) {
        db = this.getReadableDatabase();
        String query = "SELECT user_name, password FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);

        String user;
        String password;
        password = "no encontrado";
        if (cursor.moveToFirst()){
            do {
                user = cursor.getString(0);
                if (user.equals(username)){
                    password = cursor.getString(1);
                    break;
                }
            }while (cursor.moveToNext());
        }
        return password;
    }
}
