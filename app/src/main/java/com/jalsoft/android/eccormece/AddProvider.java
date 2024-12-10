package com.jalsoft.android.eccormece;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import java.sql.SQLException;
import java.util.HashMap;

import android.content.Context;
import android.content.UriMatcher;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class AddProvider extends ContentProvider {
    static final String PROVIDER_NAME = "com.jalsoft.android.jalikoa.shop";
    static final String URL = "content://" + PROVIDER_NAME + "/students";
    static final Uri CONTENT_URI = Uri.parse(URL);
    static final String _ID = "_id";
    static final String NAME = "name";
    static final String SKU = "sku";
    static final String QUANTITY = "quantity";
    static final String EXPIRY = "expiring";
    static final String PRICE = "price";
    static final String DESCRIPTION = "description";
    private static HashMap<String, String> PRODUCTS_PROJECTION_MAP;
    static final int shopS = 1;
    static final int shop_ID = 2;

    static final UriMatcher uriMatcher;
    static{
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "shops", shopS);
        uriMatcher.addURI(PROVIDER_NAME, "shops/#", shop_ID);
    }
    private SQLiteDatabase db;
    static final String DATABASE_NAME = "shop";
    static final String PRODUCTS_TABLE_NAME = "products";
    static final int DATABASE_VERSION = 1;
    static final String CREATE_DB_TABLE =
            " CREATE TABLE " + PRODUCTS_TABLE_NAME +
                    " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " name TEXT NOT NULL, " +
                    " sku VARCHAR NOT NULL ,"+
                    " quantity VARCHAR NOT NULL,"+
                    " expiry VARCHAR NOT NULL,"+
                    " price DECIMAL(10,2) NOT NULL,"+
                    " description TEXT NOT NULL,"+
                    " added_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP);";
    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL(CREATE_DB_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + PRODUCTS_TABLE_NAME);
            onCreate(db);
        }
    }
    @Override
    public boolean onCreate() {
        Context context = getContext();
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        /*
         * Create a write able database which will trigger its
         * creation if it doesn't already exist.
         **/
        db = dbHelper.getWritableDatabase();
        return (db == null)? false:true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        /**
         * Add a new student record
         */
        long rowID = db.insert( PRODUCTS_TABLE_NAME, "", values);
        /**
         * If record is added successfully
         */
        if (rowID > 0)
        {
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, rowID);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }
        try {
            throw new SQLException("Failed to add a record into " + uri);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
