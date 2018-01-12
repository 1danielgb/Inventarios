package com.example.hobo.inventarios.viewContenedorInterno;

import com.example.hobo.inventarios.adapter.ObjetosAdapter;
import com.example.hobo.inventarios.pojo.Object;

import java.util.ArrayList;

/**
 * Created by Caleb on 1/7/2018.
 */

public interface IContenedorInterno {
    void generateLinerLayout();
    ObjetosAdapter createAdapter(ArrayList<Object> objects);
    void startAdapter(ObjetosAdapter objetosAdapter);
}
