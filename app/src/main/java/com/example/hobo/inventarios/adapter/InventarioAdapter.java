package com.example.hobo.inventarios.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hobo.inventarios.viewInventario.Inventario;
import com.example.hobo.inventarios.R;
import com.example.hobo.inventarios.pojo.Inventory;

import java.util.ArrayList;

/**
 * Created by Caleb on 12/1/2017.
 */

public class InventarioAdapter extends RecyclerView.Adapter<InventarioAdapter.InventarioViewHolder> {

    ArrayList<Inventory> inventarios;
    Activity activity;

    public InventarioAdapter(ArrayList<Inventory> inventarios, Activity activity) {
        this.inventarios = inventarios;
        this.activity = activity;
    }

    @Override
    public InventarioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_inventario_card_view, parent, false);
        return new InventarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InventarioAdapter.InventarioViewHolder holder, int position) {
        final Inventory inventory = inventarios.get(position);
        holder.tvNameInventario.setText(inventory.getName());
        holder.tvNameInventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, Inventario.class);
                intent.putExtra("id", inventory.getId());
                intent.putExtra("name", inventory.getName());
                intent.putExtra("desc", inventory.getProperties());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return inventarios.size();
    }

    public static class InventarioViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNameInventario;

        public InventarioViewHolder(View itemView) {
            super(itemView);
            tvNameInventario = (TextView) itemView.findViewById(R.id.tvNameInventario);
        }
    }
}
