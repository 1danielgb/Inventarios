package com.example.hobo.inventarios.presenter.CrearContenedorPresenter;

import android.app.Activity;

import com.example.hobo.inventarios.API.HttpPetitions.SetContainer;
import com.example.hobo.inventarios.db.DataBaseConstructor;
import com.example.hobo.inventarios.viewCrearContenedor.ICrearContenedor;

/**
 * Created by Caleb on 1/8/2018.
 */

public class CrearContenedorPresenter implements ICrearConenedorPresenter {
    ICrearContenedor iCrearContenedor;
    DataBaseConstructor dataBaseConstructor;
    int idInventario;

    public CrearContenedorPresenter(ICrearContenedor iCrearContenedor, Activity activity, int id) {
        this.iCrearContenedor = iCrearContenedor;
        dataBaseConstructor = new DataBaseConstructor(activity);
        this.idInventario = id;
    }


    @Override
    public void saveContenedor() {
        dataBaseConstructor.insertContainer(
                idInventario,
                iCrearContenedor.getNombre(),
                Double.parseDouble(iCrearContenedor.getAlto()),
                Double.parseDouble(iCrearContenedor.getLargo()),
                Double.parseDouble(iCrearContenedor.getAncho()),
                iCrearContenedor.getDesc());

        SetContainer setContainer = new SetContainer();
        int[] array = new int[3];
        array[0] = Integer.parseInt(iCrearContenedor.getAlto());
        array[1] = Integer.parseInt(iCrearContenedor.getAncho());
        array[2] = Integer.parseInt(iCrearContenedor.getLargo());
        setContainer.postMethod(idInventario, iCrearContenedor.getNombre(), array, iCrearContenedor.getDesc());
    }
}
