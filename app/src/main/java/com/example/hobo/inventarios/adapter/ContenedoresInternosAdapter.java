package com.example.hobo.inventarios.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hobo.inventarios.R;
import com.example.hobo.inventarios.pojo.IContainer;
import com.example.hobo.inventarios.viewContenedorInterno.ContenedorInterno;

import java.util.ArrayList;

/**
 * Created by Caleb on 1/8/2018.
 */

public class ContenedoresInternosAdapter extends RecyclerView.Adapter<ContenedoresInternosAdapter.ContenedorInternoViewHolder> {

    ArrayList<IContainer> containers;
    private Activity activity;

    public ContenedoresInternosAdapter(ArrayList<IContainer> containers, Activity activity) {
        this.containers = containers;
        this.activity = activity;
    }

    @Override
    public ContenedorInternoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contenedor_card_view, null);
        return new ContenedoresInternosAdapter.ContenedorInternoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContenedorInternoViewHolder holder, int position) {
        final IContainer container = containers.get(position);
        System.out.println(position + container.getName());
        holder.tvNameContenedor.setText(container.getName());
        holder.tvNameContenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ContenedorInterno.class);
                intent.putExtra("id", container.getId());
                intent.putExtra("name", container.getName());
                intent.putExtra("length", container.getLength());
                intent.putExtra("height", container.getHeight());
                intent.putExtra("width", container.getWidth());
                intent.putExtra("desc", container.getProperties());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return containers.size();
    }

    public static class ContenedorInternoViewHolder extends RecyclerView.ViewHolder {

        TextView tvNameContenedor;
        public ContenedorInternoViewHolder(View itemView) {
            super(itemView);
            tvNameContenedor = (TextView) itemView.findViewById(R.id.tvNameContenedor);
        }
    }
}
