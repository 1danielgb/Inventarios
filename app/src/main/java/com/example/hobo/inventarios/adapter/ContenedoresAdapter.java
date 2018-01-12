package com.example.hobo.inventarios.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hobo.inventarios.R;
import com.example.hobo.inventarios.pojo.Container;
import com.example.hobo.inventarios.viewContenedor.Contenedor;

import java.util.ArrayList;

/**
 * Created by Caleb on 12/2/2017.
 */

public class ContenedoresAdapter extends RecyclerView.Adapter<ContenedoresAdapter.ContenedorViewHolder> {

    ArrayList<Container> containers;
    private Activity activity;

    public ContenedoresAdapter(ArrayList<Container> containers, Activity activity) {
        this.containers = containers;
        this.activity = activity;
    }

    @Override
    public ContenedorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contenedor_card_view, null);
        return new ContenedorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContenedorViewHolder holder, int position) {
        final Container container = containers.get(position);
        holder.tvNameContenedor.setText(container.getName());
        holder.tvNameContenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, Contenedor.class);
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

    public static class ContenedorViewHolder extends RecyclerView.ViewHolder {
        TextView tvNameContenedor;

        public ContenedorViewHolder(View itemView) {
            super(itemView);

            tvNameContenedor = (TextView) itemView.findViewById(R.id.tvNameContenedor);
        }
    }

}
