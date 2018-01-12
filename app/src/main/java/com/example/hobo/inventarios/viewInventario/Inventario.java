package com.example.hobo.inventarios.viewInventario;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hobo.inventarios.viewCrearContenedor.CrearContenedor;
import com.example.hobo.inventarios.R;
import com.example.hobo.inventarios.adapter.ContenedoresAdapter;
import com.example.hobo.inventarios.pojo.Container;
import com.example.hobo.inventarios.presenter.InventarioPresenter.IInventarioPresenter;
import com.example.hobo.inventarios.presenter.InventarioPresenter.InventarioPresenter;

import java.util.ArrayList;

public class Inventario extends AppCompatActivity implements IInventario{

    private RecyclerView rvContenedores;
    private TextView tvNombre, tvDesc;
    private int id;
    private String nombre, desc;
    private IInventarioPresenter iInventarioPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Inventario");

        tvNombre = (TextView) findViewById(R.id.tvNameInventario);
        tvDesc   = (TextView) findViewById(R.id.tvDescriptionInventario);
        setValues();
        rvContenedores = (RecyclerView) findViewById(R.id.rvContenedores);
        iInventarioPresenter = new InventarioPresenter(this, this, id);
    }

    @Override
    public void generateLinerLayout() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvContenedores.setLayoutManager(layoutManager);
    }

    @Override
    public ContenedoresAdapter createAdapter(ArrayList<Container> containers) {
        return new ContenedoresAdapter(containers, this);
    }

    @Override
    public void startAdapter(ContenedoresAdapter contenedoresAdapter) {
        rvContenedores.setAdapter(contenedoresAdapter);
    }

    private void setValues() {
        final Bundle extras = getIntent().getExtras();

        id     = extras.getInt("id");
        nombre = extras.getString("name");
        desc   = extras.getString("desc");

        tvNombre.setText(nombre);
        tvDesc.setText(desc);
    }

    public void openCrearContenedor(View view) {
        Intent intent = new Intent(this, CrearContenedor.class);
        intent.putExtra("idInventario", this.id);
        intent.putExtra("name", this.nombre);
        intent.putExtra("desc", desc);
        startActivity(intent);
    }
}
