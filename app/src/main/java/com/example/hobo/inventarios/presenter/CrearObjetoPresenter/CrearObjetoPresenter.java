package com.example.hobo.inventarios.presenter.CrearObjetoPresenter;

import android.app.Activity;

import com.example.hobo.inventarios.API.HttpPetitions.SetObject;
import com.example.hobo.inventarios.db.DataBaseConstructor;
import com.example.hobo.inventarios.viewCrearObjeto.ICrearObjeto;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Caleb on 1/10/2018.
 */

public class CrearObjetoPresenter implements ICrearObjetoPresenter {

    ICrearObjeto iCrearObjeto;
    DataBaseConstructor dataBaseConstructor;
    int idContenedorInterno;

    public CrearObjetoPresenter(ICrearObjeto iCrearObjeto, Activity activity, int idContenedorInterno) {
        this.iCrearObjeto = iCrearObjeto;
        this.dataBaseConstructor = new DataBaseConstructor(activity);
        this.idContenedorInterno = idContenedorInterno;
    }

    @Override
    public void saveObjeto() {
        dataBaseConstructor.insertObject(idContenedorInterno, iCrearObjeto.getNombre(), iCrearObjeto.getDesc());
        SetObject setObject = new SetObject();

        setObject.postMethod(iCrearObjeto.getIdContenedor(), iCrearObjeto.getNombre(), iCrearObjeto.getDesc());
    }
}
