package com.example.hobo.inventarios.viewCrearObjeto;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hobo.inventarios.R;
import com.example.hobo.inventarios.presenter.CrearObjetoPresenter.CrearObjetoPresenter;
import com.example.hobo.inventarios.presenter.CrearObjetoPresenter.ICrearObjetoPresenter;
import com.example.hobo.inventarios.viewContenedorInterno.ContenedorInterno;

public class CrearObjeto extends AppCompatActivity implements ICrearObjeto {

    private Button guardar;
    TextInputEditText etNombre, etDesc;
    ICrearObjetoPresenter crearObjetoPresenter;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_objeto);

        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Crear Objeto");

        etNombre = (TextInputEditText) findViewById(R.id.etNombre);
        etDesc = (TextInputEditText) findViewById(R.id.etDescripcion);
        guardar = (Button) findViewById(R.id.btnGuardarObjeto);
        getIdContenedor();
        crearObjetoPresenter = new CrearObjetoPresenter(this, this, getIdContenedor());
        saveContenedor();
    }

    @Override
    public int getIdContenedor() {
        Bundle bundle = getIntent().getExtras();

        return  bundle.getInt("id");
    }

    @Override
    public String getNombre() {
        return etNombre.getText().toString();
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
                crearObjetoPresenter.saveObjeto();
                Bundle bundle = getIntent().getExtras();
                Intent intent = new Intent(CrearObjeto.this, ContenedorInterno.class);
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
