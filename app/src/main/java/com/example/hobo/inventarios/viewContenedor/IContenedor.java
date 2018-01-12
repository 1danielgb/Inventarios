package com.example.hobo.inventarios.viewContenedor;

import com.example.hobo.inventarios.adapter.ContenedoresInternosAdapter;
import com.example.hobo.inventarios.pojo.IContainer;

import java.util.ArrayList;

/**
 * Created by Caleb on 1/7/2018.
 */

public interface IContenedor {
    void generateLinerLayout();
    ContenedoresInternosAdapter createAdapter(ArrayList<IContainer> containers);
    void startAdapter(ContenedoresInternosAdapter contenedoresInternosAdapter);
}
