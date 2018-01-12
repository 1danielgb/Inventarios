package com.example.hobo.inventarios.viewContenedorInterno;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hobo.inventarios.R;
import com.example.hobo.inventarios.adapter.ObjetosAdapter;
import com.example.hobo.inventarios.pojo.Object;
import com.example.hobo.inventarios.presenter.ContenedorInternoPresenter.ContenedorInternoPresenter;
import com.example.hobo.inventarios.presenter.ContenedorInternoPresenter.IContenedorInternoPresenter;
import com.example.hobo.inventarios.viewCrearObjeto.CrearObjeto;

import java.util.ArrayList;

public class ContenedorInterno extends AppCompatActivity implements IContenedorInterno {

    private RecyclerView rvObjetos;
    private TextView tvNombre, tvDesc, tvLargo, tvAlto, tvAncho;
    private int id;
    private IContenedorInternoPresenter contenedorPresenter;
    Double alto, largo, ancho;
    String nombre, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor_interno);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Contenedor");

        tvNombre = (TextView) findViewById(R.id.tvNameContenedorInt);
        tvAlto = (TextView) findViewById(R.id.tvAlto);
        tvLargo = (TextView) findViewById(R.id.tvLargo);
        tvAncho = (TextView) findViewById(R.id.tvAncho);
        tvDesc = (TextView) findViewById(R.id.tvDescriptionContenedor);
        rvObjetos = (RecyclerView) findViewById(R.id.rvObjetos);
        setValues();
        contenedorPresenter = new ContenedorInternoPresenter(this, this, id);
    }

    @SuppressLint("SetTextI18n")
    private void setValues() {
        Bundle bundle = getIntent().getExtras();
        this.id = bundle.getInt("id");
        this.largo = bundle.getDouble("length");
        this.alto = bundle.getDouble("height");
        this.ancho = bundle.getDouble("width");
        this.nombre = bundle.getString("name");
        this.desc = bundle.getString("desc");
        tvNombre.setText(nombre);
        tvAlto.setText(alto.toString() + " alto");
        tvLargo.setText(largo.toString() + " largo");
        tvAncho.setText(ancho.toString() + " ancho");
        tvDesc.setText(desc);
    }

    @Override
    public void generateLinerLayout() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvObjetos.setLayoutManager(layoutManager);
    }

    @Override
    public ObjetosAdapter createAdapter(ArrayList<Object> objects) {
        return new ObjetosAdapter(objects, this);
    }

    @Override
    public void startAdapter(ObjetosAdapter objetosAdapter) {
        rvObjetos.setAdapter(objetosAdapter);
    }

    public void openCrearObjeto (View view) {
        Intent intent = new Intent(this, CrearObjeto.class);
        intent.putExtra("id", id);
        intent.putExtra("name", nombre);
        intent.putExtra("length", largo);
        intent.putExtra("height", alto);
        intent.putExtra("width", ancho);
        intent.putExtra("desc", desc);
        startActivity(intent);
    }
}
