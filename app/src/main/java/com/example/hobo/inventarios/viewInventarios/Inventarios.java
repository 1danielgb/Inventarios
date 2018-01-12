package com.example.hobo.inventarios.viewInventarios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.hobo.inventarios.R;
import com.example.hobo.inventarios.adapter.InventarioAdapter;
import com.example.hobo.inventarios.pojo.Inventory;
import com.example.hobo.inventarios.presenter.InventariosPresenter.IInventariosPresenter;
import com.example.hobo.inventarios.presenter.InventariosPresenter.InventariosPresenter;
import com.example.hobo.inventarios.viewAgregarInventario.AgregarInventario;

import java.util.ArrayList;

public class Inventarios extends AppCompatActivity implements IInventarios {

    private RecyclerView rvInventarios;
    private IInventariosPresenter inventariosPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventarios);

        rvInventarios = (RecyclerView) findViewById(R.id.rvInventarios);
        inventariosPresenter = new InventariosPresenter(this, this);
    }

    @Override
    public void generateLinerLayout() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvInventarios.setLayoutManager(manager);
    }

    @Override
    public InventarioAdapter createAdapter(ArrayList<Inventory> inventories) {
        return new InventarioAdapter(inventories, this);
    }

    @Override
    public void startAdapter(InventarioAdapter inventarioAdapter) {
        rvInventarios.setAdapter(inventarioAdapter);
    }

    public void agregarInventario(View view) {
        Intent agregarInventario = new Intent(this, AgregarInventario.class);
        startActivity(agregarInventario);
    }
}
