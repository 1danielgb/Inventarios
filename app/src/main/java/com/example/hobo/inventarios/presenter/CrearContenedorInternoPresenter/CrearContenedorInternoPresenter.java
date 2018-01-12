package com.example.hobo.inventarios.presenter.CrearContenedorInternoPresenter;

import android.app.Activity;

import com.example.hobo.inventarios.API.HttpPetitions.SetContainer;
import com.example.hobo.inventarios.API.HttpPetitions.SetIContainer;
import com.example.hobo.inventarios.db.DataBaseConstructor;
import com.example.hobo.inventarios.viewCrearContenedorInterno.ICrearContenedorInterno;

/**
 * Created by Caleb on 1/9/2018.
 */

public class CrearContenedorInternoPresenter implements ICrearContenedorInternoPresenter {
    ICrearContenedorInterno iCrearContenedor;
    DataBaseConstructor dataBaseConstructor;
    int idContenedor;

    public CrearContenedorInternoPresenter(ICrearContenedorInterno iCrearContenedor, Activity activity, int id) {
        this.iCrearContenedor = iCrearContenedor;
        dataBaseConstructor = new DataBaseConstructor(activity);
        this.idContenedor = id;
    }


    @Override
    public void saveContenedor() {
        dataBaseConstructor.insertIContainer(
                idContenedor,
                iCrearContenedor.getNombre(),
                Double.parseDouble(iCrearContenedor.getAlto()),
                Double.parseDouble(iCrearContenedor.getLargo()),
                Double.parseDouble(iCrearContenedor.getAncho()),
                iCrearContenedor.getDesc());
        SetIContainer setIContainer = new SetIContainer();
        int[] array = new int[3];
        array[0] = Integer.parseInt(iCrearContenedor.getAlto());
        array[1] = Integer.parseInt(iCrearContenedor.getAncho());
        array[2] = Integer.parseInt(iCrearContenedor.getLargo());
        setIContainer.postMethod(idContenedor, iCrearContenedor.getNombre(), array, iCrearContenedor.getDesc());
    }
}
