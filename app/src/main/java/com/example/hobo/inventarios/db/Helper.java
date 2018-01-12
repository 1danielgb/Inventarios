package com.example.hobo.inventarios.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hobo.inventarios.API.HttpPetitions.SetUser;

import java.util.Random;

/**
 * Created by Caleb on 11/7/2017.
 */

public class Helper extends SQLiteOpenHelper {

    private static final int RANDOM_STRING_LENGTH = 10;
    private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    public Helper(Context context) {
        super(context, DataBaseManager.DATA_BASE_NAME, null, DataBaseManager.DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DataBaseManager.CREATE_TABLE_USER);
        sqLiteDatabase.execSQL(DataBaseManager.CREATE_TABLE_INVENTORIES);
        sqLiteDatabase.execSQL(DataBaseManager.CREATE_TABLE_CONTAINERS);
        sqLiteDatabase.execSQL(DataBaseManager.CREATE_TABLE_ICONTAINERS);
        sqLiteDatabase.execSQL(DataBaseManager.CREATE_TABLE_OBJECTS);
        ContentValues contentValues = new ContentValues();
        int numero = (int) (Math.random() * 12) + 1;
        String random = generateRandomString();
        contentValues.put(DataBaseManager.TABLE_USER_ID, numero);
        contentValues.put(DataBaseManager.TABLE_USER_NAME, "Nombre de Usuario");
        contentValues.put(DataBaseManager.TABLE_USER_PASSWORD, random);
        sqLiteDatabase.insert(DataBaseManager.TABLE_NAME_USER, null, contentValues);
        SetUser setUser = new SetUser();
        setUser.postMethod(numero, "NombreUsuario", random);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public String generateRandomString(){

        StringBuffer randStr = new StringBuffer();
        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    private int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }
}
