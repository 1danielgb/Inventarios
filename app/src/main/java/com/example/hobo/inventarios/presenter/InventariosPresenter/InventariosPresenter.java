package com.example.hobo.inventarios.presenter.InventariosPresenter;

import android.app.Activity;

import com.example.hobo.inventarios.viewInventarios.IInventarios;
import com.example.hobo.inventarios.db.DataBaseConstructor;
import com.example.hobo.inventarios.pojo.Inventory;

import java.util.ArrayList;

/**
 * Created by Caleb on 12/1/2017.
 */

public class InventariosPresenter implements IInventariosPresenter {

    private IInventarios iInventarios;
    private DataBaseConstructor dataBaseConstructor;
    private ArrayList<Inventory> inventories;

    public InventariosPresenter(IInventarios iInventarios, Activity activity) {
        this.iInventarios = iInventarios;
        dataBaseConstructor = new DataBaseConstructor(activity);
        getInventarios();
    }

    @Override
    public void getInventarios() {
        inventories = dataBaseConstructor.getInventories();
        showInventrios();
    }

    @Override
    public void showInventrios() {
        iInventarios.startAdapter(iInventarios.createAdapter(inventories));
        iInventarios.generateLinerLayout();
    }
}
