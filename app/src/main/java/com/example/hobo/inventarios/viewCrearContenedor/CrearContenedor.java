package com.example.hobo.inventarios.viewCrearContenedor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hobo.inventarios.R;
import com.example.hobo.inventarios.presenter.CrearContenedorPresenter.CrearContenedorPresenter;
import com.example.hobo.inventarios.presenter.CrearContenedorPresenter.ICrearConenedorPresenter;
import com.example.hobo.inventarios.viewInventario.Inventario;

public class CrearContenedor extends AppCompatActivity implements ICrearContenedor {
    private Button guardar;
    TextInputEditText etNombre, etLargo, etAlto, etAncho, etDesc;
    ICrearConenedorPresenter conenedorPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_contenedor);

        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Crear Contenedor");

        etNombre = (TextInputEditText) findViewById(R.id.etNombre);
        etLargo = (TextInputEditText) findViewById(R.id.etLargo);
        etAlto = (TextInputEditText) findViewById(R.id.etAlto);
        etAncho = (TextInputEditText) findViewById(R.id.etAncho);
        etDesc = (TextInputEditText) findViewById(R.id.etDescripcion);
        guardar = (Button) findViewById(R.id.btnGuardarInventario);
        conenedorPresenter = new CrearContenedorPresenter(this, this, getIdInventory());
        saveContenedor();
    }

    private int getIdInventory() {
        final Bundle bundle = getIntent().getExtras();

        return bundle.getInt("idInventario");
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
                Intent intent = new Intent(CrearContenedor.this, Inventario.class);
                intent.putExtra("id", bundle.getInt("idInventario"));
                intent.putExtra("name", bundle.getString("name"));
                intent.putExtra("desc", bundle.getString("desc"));
                startActivity(intent);
            }
        });
    }
}