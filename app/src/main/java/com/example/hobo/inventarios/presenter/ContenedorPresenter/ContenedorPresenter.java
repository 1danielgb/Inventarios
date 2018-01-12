package com.example.hobo.inventarios.presenter.ContenedorPresenter;

import android.app.Activity;

import com.example.hobo.inventarios.db.DataBaseConstructor;
import com.example.hobo.inventarios.pojo.IContainer;
import com.example.hobo.inventarios.viewContenedor.IContenedor;

import java.util.ArrayList;

/**
 * Created by Caleb on 1/8/2018.
 */

public class ContenedorPresenter implements IContenedorPresenter {
    public IContenedor iContenedor;
    private DataBaseConstructor dataBaseConstructor;
    private ArrayList<IContainer> containers;
    private Activity activity;

    public ContenedorPresenter(IContenedor iContenedor, Activity activity, int idInventario) {
        this.iContenedor = iContenedor;
        this.activity = activity;
        dataBaseConstructor = new DataBaseConstructor(activity);
        getContenedor(idInventario);
    }

    @Override
    public void getContenedor(int idContenedor) {
        containers = dataBaseConstructor.getIContainers(idContenedor);
        showContedeores();
    }

    @Override
    public void showContedeores() {
        iContenedor.startAdapter(iContenedor.createAdapter(containers));
        iContenedor.generateLinerLayout();
    }
}
