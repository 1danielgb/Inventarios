package com.example.hobo.inventarios.viewContenedor;

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
import com.example.hobo.inventarios.adapter.ContenedoresInternosAdapter;
import com.example.hobo.inventarios.pojo.IContainer;
import com.example.hobo.inventarios.presenter.ContenedorPresenter.ContenedorPresenter;
import com.example.hobo.inventarios.presenter.ContenedorPresenter.IContenedorPresenter;
import com.example.hobo.inventarios.viewCrearContenedorInterno.CrearContenedorInterno;

import java.util.ArrayList;

public class Contenedor extends AppCompatActivity implements IContenedor {

    private RecyclerView rvContenedores;
    private TextView tvNombre, tvDesc, tvLargo, tvAlto, tvAncho;
    private int id;
    private IContenedorPresenter contenedorPresenter;
    Double alto, largo, ancho;
    String nombre, desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Contenedor");

        tvNombre = (TextView) findViewById(R.id.tvNameContenedor);
        tvAlto = (TextView) findViewById(R.id.tvAlto);
        tvLargo = (TextView) findViewById(R.id.tvLargo);
        tvAncho = (TextView) findViewById(R.id.tvAncho);
        tvDesc = (TextView) findViewById(R.id.tvDescriptionContenedor);
        rvContenedores = (RecyclerView) findViewById(R.id.rvContenedoresInternos);
        setValues();
        contenedorPresenter = new ContenedorPresenter(this, this, id);
    }

    @Override
    public void generateLinerLayout() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvContenedores.setLayoutManager(layoutManager);
    }

    @Override
    public ContenedoresInternosAdapter createAdapter(ArrayList<IContainer> containers) {
        return new ContenedoresInternosAdapter(containers, this);
    }

    @Override
    public void startAdapter(ContenedoresInternosAdapter contenedoresInternosAdapter) {
        rvContenedores.setAdapter(contenedoresInternosAdapter);
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

    public void openCrearIContenedor (View view) {
        Intent intent = new Intent(this, CrearContenedorInterno.class);
        intent.putExtra("id", id);
        intent.putExtra("name", nombre);
        intent.putExtra("length", largo);
        intent.putExtra("height", alto);
        intent.putExtra("width", ancho);
        intent.putExtra("desc", desc);
        startActivity(intent);
    }
}
