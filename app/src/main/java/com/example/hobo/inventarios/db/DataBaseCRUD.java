package com.example.hobo.inventarios.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hobo.inventarios.pojo.Container;
import com.example.hobo.inventarios.pojo.IContainer;
import com.example.hobo.inventarios.pojo.Inventory;
import com.example.hobo.inventarios.pojo.Object;

import java.util.ArrayList;

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

    /* inventories table methods */
    public void insertInventory(ContentValues contentValues) {
        sqLiteDatabase.insert(DataBaseManager.TABLE_NAME_INVENTORIES, null, contentValues);
//        sqLiteDatabase.close();
    }

    public ArrayList<Inventory> getInventories() {
        ArrayList<Inventory> inventories = new ArrayList<>();
        String query = "SELECT * FROM  " + DataBaseManager.TABLE_NAME_INVENTORIES;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseManager.TABLE_INVENTORIES_ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseManager.TABLE_INVENTORIES_NAME));
            String properties = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseManager.TABLE_INVENTORIES_PROPERTIES));
            inventories.add(new Inventory(id, name, properties));
        }
        cursor.close();
        return inventories;
    }

    /* containers table methods */
    public void insertContainer(ContentValues contentValues) {
        sqLiteDatabase.insert(DataBaseManager.TABLE_NAME_CONTAINERS, null, contentValues);
//        sqLiteDatabase.close();
    }

    public ArrayList<Container> getContainers(int inventoryId) {
        ArrayList<Container> containers = new ArrayList<>();
        String query = "SELECT *" +
                " FROM "  + DataBaseManager.TABLE_NAME_CONTAINERS +
                " WHERE " + DataBaseManager.TABLE_CONTAINERS_INVENTORY_ID + " = " + inventoryId + ";";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseManager.TABLE_CONTAINERS_ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseManager.TABLE_CONTAINERS_NAME));
            double height = cursor.getDouble(cursor.getColumnIndexOrThrow(DataBaseManager.TABLE_CONTAINERS_HEIGHT));
            double length = cursor.getDouble(cursor.getColumnIndexOrThrow(DataBaseManager.TABLE_CONTAINERS_LENGTH));
            double width = cursor.getDouble(cursor.getColumnIndexOrThrow(DataBaseManager.TABLE_CONTAINERS_WIDTH));
            String properties = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseManager.TABLE_CONTAINERS_PROPERTIES));
            containers.add(new Container(id, name, height, length, width, properties));
        }
        cursor.close();
        return containers;
    }

    /* icontainers table methods */
    public void insertIContainer(ContentValues contentValues) {
        sqLiteDatabase.insert(DataBaseManager.TABLE_NAME_ICONTAINERS, null, contentValues);
//        sqLiteDatabase.close();
    }

    public ArrayList<IContainer> getIContainers(int containerId) {
        ArrayList<IContainer> containers = new ArrayList<>();
        String query = "SELECT *" +
                " FROM "  + DataBaseManager.TABLE_NAME_ICONTAINERS +
                " WHERE " + DataBaseManager.TABLE_ICONTAINERS_CONTAINER_ID + " = " + containerId + ";";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseManager.TABLE_ICONTAINERS_ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseManager.TABLE_ICONTAINERS_NAME));
            double height = cursor.getDouble(cursor.getColumnIndexOrThrow(DataBaseManager.TABLE_ICONTAINERS_HEIGHT));
            double length = cursor.getDouble(cursor.getColumnIndexOrThrow(DataBaseManager.TABLE_ICONTAINERS_LENGTH));
            double width = cursor.getDouble(cursor.getColumnIndexOrThrow(DataBaseManager.TABLE_ICONTAINERS_WIDTH));
            String properties = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseManager.TABLE_ICONTAINERS_PROPERTIES));
            containers.add(new IContainer(id, name, height, length, width, properties));
        }
        cursor.close();
        return containers;
    }

    /* objects table methods */
    public void insertObject(ContentValues contentValues) {
        sqLiteDatabase.insert(DataBaseManager.TABLE_NAME_OBJECTS, null, contentValues);
//        sqLiteDatabase.close();
    }

    public ArrayList<Object> getObjects(int icontainerId) {
        ArrayList<Object> objectArrayList = new ArrayList<>();
        String query = "SELECT *" +
                " FROM " + DataBaseManager.TABLE_NAME_OBJECTS +
                " WHERE " + DataBaseManager.TABLE_OBJECTS_ICONTAINER_ID + " = " + icontainerId + ";";
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseManager.TABLE_OBJECTS_NAME));
            String properties = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseManager.TABLE_OBJECTS_PROPERTIES));
            objectArrayList.add(new Object(name, properties));
        }
        cursor.close();
        return objectArrayList;
    }

    public int getUserId() {
        int userId;
        String query = "SELECT " + DataBaseManager.TABLE_USER_ID +
                " FROM " + DataBaseManager.TABLE_NAME_USER;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        cursor.moveToNext();
        userId = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseManager.TABLE_USER_ID));
        cursor.close();
        return userId;
    }
}
