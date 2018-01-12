package com.example.hobo.inventarios.presenter.AgregarInventarioPresenter;

import android.app.Activity;

import com.example.hobo.inventarios.API.HttpPetitions.SetInventory;
import com.example.hobo.inventarios.db.DataBaseManager;
import com.example.hobo.inventarios.viewAgregarInventario.IAgregarInventario;
import com.example.hobo.inventarios.db.DataBaseConstructor;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Caleb on 12/27/2017.
 */

public class AgregarInventarioPresenter implements IAgregarInventarioPresenter {
    private IAgregarInventario iAgregarInventario;
    private DataBaseConstructor dataBaseConstructor;

    public AgregarInventarioPresenter(IAgregarInventario iAgregarInventario, Activity activity) {
        this.iAgregarInventario = iAgregarInventario;
        dataBaseConstructor = new DataBaseConstructor(activity);
    }

    @Override
    public void saveInventory() {
        dataBaseConstructor.insertInventory(iAgregarInventario.getNombre(), iAgregarInventario.getDescripcion());
        SetInventory setInventory = new SetInventory();

        setInventory.postMethod(dataBaseConstructor.getUserId(), iAgregarInventario.getNombre(),iAgregarInventario.getDescripcion() );
    }
}
