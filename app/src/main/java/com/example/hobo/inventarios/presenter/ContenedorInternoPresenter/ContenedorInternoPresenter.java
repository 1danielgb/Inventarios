package com.example.hobo.inventarios.presenter.ContenedorInternoPresenter;

import android.app.Activity;

import com.example.hobo.inventarios.db.DataBaseConstructor;
import com.example.hobo.inventarios.pojo.Object;
import com.example.hobo.inventarios.viewContenedorInterno.IContenedorInterno;

import java.util.ArrayList;

/**
 * Created by Caleb on 1/10/2018.
 */

public class ContenedorInternoPresenter implements IContenedorInternoPresenter {

    public IContenedorInterno iContenedor;
    private DataBaseConstructor dataBaseConstructor;
    private ArrayList<Object> objects;
    private Activity activity;

    public ContenedorInternoPresenter(IContenedorInterno iContenedor, Activity activity, int idContenedor) {
        this.iContenedor = iContenedor;
        this.activity = activity;
        dataBaseConstructor = new DataBaseConstructor(activity);
        getObjetos(idContenedor);
    }

    @Override
    public void getObjetos(int idContenedorInterno) {
        objects = dataBaseConstructor.getObjects(idContenedorInterno);
        showObjetos();
    }

    @Override
    public void showObjetos() {
        iContenedor.startAdapter(iContenedor.createAdapter(objects));
        iContenedor.generateLinerLayout();
    }
}
