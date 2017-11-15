package com.example.hobo.inventarios.pojo;

/**
 * Created by Caleb on 11/14/2017.
 */

public class Object {
    int containerId;
    String name, properties;

    public Object(String name, String properties) {
        this.name = name;
        this.properties = properties;
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
}
