package com.example.hobo.inventarios.pojo;

/**
 * Created by Caleb on 11/14/2017.
 */

public class Container {
    int inventoryId;
    String name, properties;
    double height, length, width;

    public Container(int inventoryId, String name, double height, double length, double width, String properties) {
        this.inventoryId = inventoryId;
        this.name = name;
        this.height = height;
        this.length = length;
        this.width = width;
        this.properties = properties;
    }

    public Container(String name, double height, double length, double width, String properties) {
        this.name = name;
        this.height = height;
        this.length = length;
        this.width = width;
        this.properties = properties;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
