package com.example.hobo.inventarios.presenter.InventarioPresenter;

import android.app.Activity;

import com.example.hobo.inventarios.viewInventario.IInventario;
import com.example.hobo.inventarios.db.DataBaseConstructor;
import com.example.hobo.inventarios.pojo.Container;

import java.util.ArrayList;

/**
 * Created by Caleb on 12/2/2017.
 */

public class InventarioPresenter implements IInventarioPresenter {
    public IInventario iInventario;
    private DataBaseConstructor dataBaseConstructor;
    private ArrayList<Container> containers;
    private Activity activity;

    public InventarioPresenter(IInventario iInventario, Activity activity, int idInventario) {
        this.iInventario = iInventario;
        this.activity = activity;
        dataBaseConstructor = new DataBaseConstructor(activity);
        getContenedor(idInventario);
    }

    @Override
    public void getContenedor(int idInventario) {
        containers = dataBaseConstructor.getContainers(idInventario);
        showContedeores();
    }

    @Override
    public void showContedeores() {
        iInventario.startAdapter(iInventario.createAdapter(containers));
        iInventario.generateLinerLayout();
    }

}
