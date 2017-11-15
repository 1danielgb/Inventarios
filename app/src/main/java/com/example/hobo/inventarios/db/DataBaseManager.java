package com.example.hobo.inventarios.db;

/**
 * Created by Caleb on 11/7/2017.
 */

public class DataBaseManager {
    public static final String DATA_BASE_NAME = "inventories";
    public static final int DATA_BASE_VERSION = 1;

    public static final String TABLE_NAME_USERS     = "users";
    public static final String TABLE_USERS_ID       = "id_user";
    public static final String TABLE_USERS_NAME     = "user_name";
    public static final String TABLE_USERS_PASSWORD = "password";
    public static final String CREATE_TABLE_USERS   = "CREATE TABLE " + TABLE_NAME_USERS + " (" +
            TABLE_USERS_ID          + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TABLE_USERS_NAME        + " TEXT NOT NULL, " +
            TABLE_USERS_PASSWORD    + " TEXT NOT NULL);";

    public static final String TABLE_NAME_INVENTORIES       = "inventories";
    public static final String TABLE_INVENTORIES_ID         = "id_inventory";
    public static final String TABLE_INVENTORIES_USER_ID    = "user_id";
    public static final String TABLE_INVENTORIES_PROPERTIES = "properties_inventory";
    public static final String CREATE_TABLE_INVENTORIES     = "CREATE TABLE " + TABLE_NAME_INVENTORIES + " (" +
            TABLE_INVENTORIES_ID            + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TABLE_INVENTORIES_USER_ID       + " INTEGER NOT NULL, " +
            TABLE_INVENTORIES_PROPERTIES    + " TEXT, " +
            "FOREIGN KEY(" + TABLE_INVENTORIES_USER_ID + ") REFERENCES " + TABLE_NAME_USERS + "(" + TABLE_USERS_ID + "));";

    public static final String TABLE_NAME_CONTAINERS            = "containers";
    public static final String TABLE_CONTAINERS_ID              = "id_container";
    public static final String TABLE_CONTAINERS_INVENTORY_ID    = "inventory_id";
    public static final String TABLE_CONTAINERS_NAME            = "container_name";
    public static final String TABLE_CONTAINERS_HEIGHT          = "height";
    public static final String TABLE_CONTAINERS_LENGTH          = "length";
    public static final String TABLE_CONTAINERS_WIDTH           = "width";
    public static final String TABLE_CONTAINERS_PROPERTIES      = "properties_container";
    public static final String CREATE_TABLE_CONTAINERS           = "CREATE TABLE " + TABLE_NAME_CONTAINERS + " (" +
            TABLE_CONTAINERS_ID             + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TABLE_CONTAINERS_INVENTORY_ID   + " INTEGER NOT NULL, " +
            TABLE_CONTAINERS_NAME           + " TEXT NOT NULL, " +
            TABLE_CONTAINERS_HEIGHT         + " REAL NOT NULL, " +
            TABLE_CONTAINERS_LENGTH         + " REAL NOT NULL, " +
            TABLE_CONTAINERS_WIDTH          + " REAL NOT NULL, " +
            TABLE_CONTAINERS_PROPERTIES     + " TEXT, " +
            "FOREIGN KEY(" + TABLE_CONTAINERS_INVENTORY_ID + ") REFERENCES " + TABLE_NAME_INVENTORIES + "(" + TABLE_INVENTORIES_ID + "));";

    public static final String TABLE_NAME_ICONTAINERS            = "icontainers";
    public static final String TABLE_ICONTAINERS_ID              = "id_icontainer";
    public static final String TABLE_ICONTAINERS_CONTAINER_ID    = "container_id";
    public static final String TABLE_ICONTAINERS_NAME            = "icontainer_name";
    public static final String TABLE_ICONTAINERS_HEIGHT          = "height";
    public static final String TABLE_ICONTAINERS_LENGTH          = "length";
    public static final String TABLE_ICONTAINERS_WIDTH           = "width";
    public static final String TABLE_ICONTAINERS_PROPERTIES      = "properties_icontainer";
    public static final String CREATE_TABLE_ICONTAINERS           = "CREATE TABLE " + TABLE_NAME_ICONTAINERS + " (" +
            TABLE_ICONTAINERS_ID             + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TABLE_ICONTAINERS_CONTAINER_ID   + " INTEGER, " +
            TABLE_ICONTAINERS_NAME           + " TEXT NOT NULL, " +
            TABLE_ICONTAINERS_HEIGHT         + " REAL NOT NULL, " +
            TABLE_ICONTAINERS_LENGTH         + " REAL NOT NULL, " +
            TABLE_ICONTAINERS_WIDTH          + " REAL NOT NULL, " +
            TABLE_ICONTAINERS_PROPERTIES     + " TEXT, " +
            "FOREIGN KEY(" + TABLE_ICONTAINERS_CONTAINER_ID + ") REFERENCES " + TABLE_NAME_CONTAINERS + "(" + TABLE_CONTAINERS_ID + "));";

    public static final String TABLE_NAME_OBJECT            = "object";
    public static final String TABLE_OBJECT_ID              = "id_object";
    public static final String TABLE_OBJECT_ICONTAINER_ID   = "container_id";
    public static final String TABLE_OBJECT_NAME            = "object_name";
    public static final String TABLE_OBJECT_PROPERTIES      = "properties_object";
    public static final String CREATE_TABLE_OBJECT          = "CREATE TABLE " + TABLE_NAME_OBJECT + " (" +
            TABLE_OBJECT_ID             + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TABLE_OBJECT_ICONTAINER_ID  + " TEXT NOT NULL, " +
            TABLE_OBJECT_NAME           + " TEXT NOT NULL, " +
            TABLE_OBJECT_PROPERTIES     + " TEXT, " +
            "FOREIGN KEY(" + TABLE_OBJECT_ICONTAINER_ID + ") REFERENCES " + TABLE_NAME_ICONTAINERS + "(" + TABLE_ICONTAINERS_ID + "));";
}
