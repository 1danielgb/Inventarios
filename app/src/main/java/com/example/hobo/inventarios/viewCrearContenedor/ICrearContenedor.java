package com.example.hobo.inventarios.viewCrearContenedor;

/**
 * Created by Caleb on 1/7/2018.
 */

public interface ICrearContenedor {
    String getNombre();
    String getLargo();
    String getAlto();
    String getAncho();
    String getDesc();
    void saveContenedor();
}
