package com.example.hobo.inventarios.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Caleb on 11/7/2017.
 */

public class DataBaseCRUD {
    private Helper helper;
    private SQLiteDatabase sqLiteDatabase;

    public DataBaseCRUD(Context context) {
        this.helper = new Helper(context);
        this.sqLiteDatabase = helper.getWritableDatabase();
    }


}
