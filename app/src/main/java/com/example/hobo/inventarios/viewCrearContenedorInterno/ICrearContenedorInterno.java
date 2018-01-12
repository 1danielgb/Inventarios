package com.example.hobo.inventarios.viewCrearContenedorInterno;

/**
 * Created by Caleb on 1/7/2018.
 */

public interface ICrearContenedorInterno {
    String getNombre();
    String getLargo();
    String getAlto();
    String getAncho();
    String getDesc();
    void saveContenedor();
}
