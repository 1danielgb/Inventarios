package com.example.hobo.inventarios.viewCrearContenedorInterno;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hobo.inventarios.R;
import com.example.hobo.inventarios.presenter.CrearContenedorInternoPresenter.CrearContenedorInternoPresenter;
import com.example.hobo.inventarios.presenter.CrearContenedorInternoPresenter.ICrearContenedorInternoPresenter;
import com.example.hobo.inventarios.viewContenedor.Contenedor;
import com.example.hobo.inventarios.viewCrearContenedor.CrearContenedor;
import com.example.hobo.inventarios.viewInventario.Inventario;

public class CrearContenedorInterno extends AppCompatActivity implements ICrearContenedorInterno {

    private Button guardar;
    TextInputEditText etNombre, etLargo, etAlto, etAncho, etDesc;
    ICrearContenedorInternoPresenter conenedorPresenter;
    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_contenedor_interno);

        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Crear Contenedor");

        etNombre = (TextInputEditText) findViewById(R.id.etNombre);
        etLargo = (TextInputEditText) findViewById(R.id.etLargo);
        etAlto = (TextInputEditText) findViewById(R.id.etAlto);
        etAncho = (TextInputEditText) findViewById(R.id.etAncho);
        etDesc = (TextInputEditText) findViewById(R.id.etDescripcion);
        guardar = (Button) findViewById(R.id.btnGuardarContInt);
        getIdContenedor();
        conenedorPresenter = new CrearContenedorInternoPresenter(this, this, id);
        saveContenedor();
    }

    private void getIdContenedor() {
        final Bundle bundle = getIntent().getExtras();

        id = bundle.getInt("id");
    }

    @Override
    public String getNombre() {
        return etNombre.getText().toString();
    }

    @Override
    public String getLargo() {
        return etLargo.getText().toString();
    }

    @Override
    public String getAlto() {
        return etAlto.getText().toString();
    }

    @Override
    public String getAncho() {
        return etAncho.getText().toString();
    }

    @Override
    public String getDesc() {
        return etDesc.getText().toString();
    }

    @Override
    public void saveContenedor() {
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conenedorPresenter.saveContenedor();
                Bundle bundle = getIntent().getExtras();
                Intent intent = new Intent(CrearContenedorInterno.this, Contenedor.class);
                intent.putExtra("id", bundle.getInt("id"));
                intent.putExtra("name", bundle.getString("name"));
                intent.putExtra("length", bundle.getDouble("length"));
                intent.putExtra("height", bundle.getDouble("height"));
                intent.putExtra("width", bundle.getDouble("width"));
                intent.putExtra("desc", bundle.getString("desc"));
                startActivity(intent);
            }
        });
    }
}
