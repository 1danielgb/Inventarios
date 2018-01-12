package com.example.hobo.inventarios.viewAgregarInventario;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hobo.inventarios.API.HttpPetitions.SetInventory;
import com.example.hobo.inventarios.viewInventarios.Inventarios;
import com.example.hobo.inventarios.R;
import com.example.hobo.inventarios.presenter.AgregarInventarioPresenter.AgregarInventarioPresenter;
import com.example.hobo.inventarios.presenter.AgregarInventarioPresenter.IAgregarInventarioPresenter;

public class AgregarInventario extends AppCompatActivity implements IAgregarInventario {

    private TextInputEditText etNombre, etDescripcion;
    private Button btnGuardar;
    private IAgregarInventarioPresenter agregarInventarioPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_inventario);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Crear Inventario");

        etNombre = (TextInputEditText) findViewById(R.id.etNombre);
        etDescripcion = (TextInputEditText) findViewById(R.id.etDescripcion);
        btnGuardar = (Button) findViewById(R.id.btnGuardarInventario);
        agregarInventarioPresenter = new AgregarInventarioPresenter(this, this);
        saveData();
    }

    @Override
    public String getNombre() {
        return etNombre.getText().toString();
    }

    @Override
    public String getDescripcion() {
        return etDescripcion.getText().toString();
    }

    @Override
    public void saveData() {
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarInventarioPresenter.saveInventory();
                /*SetInventory setInventory = new SetInventory();
                setInventory.postMethod();*/
                Intent intent = new Intent(AgregarInventario.this, Inventarios.class);
                startActivity(intent);
            }
        });
    }
}
