package com.example.hobo.inventarios.viewInventarios;

import com.example.hobo.inventarios.adapter.InventarioAdapter;
import com.example.hobo.inventarios.pojo.Inventory;

import java.util.ArrayList;

/**
 * Created by Caleb on 12/1/2017.
 */

public interface IInventarios {
    void generateLinerLayout();
    InventarioAdapter createAdapter(ArrayList<Inventory> inventories);
    void startAdapter(InventarioAdapter inventarioAdapter);

}
