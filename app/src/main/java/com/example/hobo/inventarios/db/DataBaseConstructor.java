package com.example.hobo.inventarios.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.hobo.inventarios.pojo.Container;
import com.example.hobo.inventarios.pojo.IContainer;
import com.example.hobo.inventarios.pojo.Inventory;
import com.example.hobo.inventarios.pojo.Object;

import java.util.ArrayList;

/**
 * Created by Caleb on 11/7/2017.
 */

public class DataBaseConstructor {
    private DataBaseCRUD db;

    public DataBaseConstructor(Context context) {
        db = new DataBaseCRUD(context);
    }

    /* Inventory Methods */
    public void insertInventory(String name, String properties) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseManager.TABLE_INVENTORIES_NAME, name);
        contentValues.put(DataBaseManager.TABLE_INVENTORIES_PROPERTIES, properties);
        db.insertInventory(contentValues);
    }

    public ArrayList<Inventory> getInventories() {
        return db.getInventories();
    }

    /* Container Methods */
    public void insertContainer(int inventoryId, String name, double height, double length, double width, String properties) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseManager.TABLE_CONTAINERS_INVENTORY_ID, inventoryId);
        contentValues.put(DataBaseManager.TABLE_CONTAINERS_NAME, name);
        contentValues.put(DataBaseManager.TABLE_CONTAINERS_HEIGHT, height);
        contentValues.put(DataBaseManager.TABLE_CONTAINERS_LENGTH, length);
        contentValues.put(DataBaseManager.TABLE_CONTAINERS_WIDTH, width);
        contentValues.put(DataBaseManager.TABLE_CONTAINERS_PROPERTIES, properties);
        db.insertContainer(contentValues);
    }

    public ArrayList<Container> getContainers(int inventoryId) {
        return db.getContainers(inventoryId);
    }

    /* IContainer Methods */
    public void insertIContainer(int containerId, String name, double height, double length, double width, String properties) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseManager.TABLE_ICONTAINERS_CONTAINER_ID,  containerId);
        contentValues.put(DataBaseManager.TABLE_ICONTAINERS_NAME, name);
        contentValues.put(DataBaseManager.TABLE_ICONTAINERS_HEIGHT, height);
        contentValues.put(DataBaseManager.TABLE_ICONTAINERS_LENGTH, length);
        contentValues.put(DataBaseManager.TABLE_ICONTAINERS_WIDTH, width);
        contentValues.put(DataBaseManager.TABLE_ICONTAINERS_PROPERTIES, properties);
        db.insertIContainer(contentValues);
    }

    public ArrayList<IContainer> getIContainers(int containerId) {
        return db.getIContainers(containerId);
    }

    /* Object Methods */
    public void insertObject(int icontainerId, String name, String properties) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseManager.TABLE_OBJECTS_ICONTAINER_ID, icontainerId);
        contentValues.put(DataBaseManager.TABLE_OBJECTS_NAME, name);
        contentValues.put(DataBaseManager.TABLE_OBJECTS_PROPERTIES, properties);
        db.insertObject(contentValues);
    }

    public ArrayList<Object> getObjects(int icontinerId) {
        return db.getObjects(icontinerId);
    }

    public int getUserId() { return db.getUserId(); }
}
