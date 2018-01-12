package com.example.hobo.inventarios.viewInventario;

import com.example.hobo.inventarios.adapter.ContenedoresAdapter;
import com.example.hobo.inventarios.pojo.Container;

import java.util.ArrayList;

/**
 * Created by Caleb on 12/2/2017.
 */

public interface IInventario {
    void generateLinerLayout();
    ContenedoresAdapter createAdapter(ArrayList<Container> containers);
    void startAdapter(ContenedoresAdapter contenedoresAdapter);
}
