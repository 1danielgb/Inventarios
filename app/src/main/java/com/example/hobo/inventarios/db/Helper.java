package com.example.hobo.inventarios.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Caleb on 11/7/2017.
 */

public class Helper extends SQLiteOpenHelper {

    public Helper(Context context) {
        super(context, DataBaseManager.DATA_BASE_NAME, null, DataBaseManager.DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DataBaseManager.CREATE_TABLE_INVENTORIES);
        sqLiteDatabase.execSQL(DataBaseManager.CREATE_TABLE_CONTAINERS);
        sqLiteDatabase.execSQL(DataBaseManager.CREATE_TABLE_ICONTAINERS);
        sqLiteDatabase.execSQL(DataBaseManager.CREATE_TABLE_OBJECTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
