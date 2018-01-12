package com.example.hobo.inventarios.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hobo.inventarios.R;
import com.example.hobo.inventarios.pojo.Object;
import com.example.hobo.inventarios.viewObjeto.Objeto;

import java.util.ArrayList;

/**
 * Created by Caleb on 1/10/2018.
 */

public class ObjetosAdapter extends RecyclerView.Adapter<ObjetosAdapter.ObjetoViewHolder> {

    ArrayList<Object> objects;
    Activity activity;

    public ObjetosAdapter(ArrayList<Object> objects, Activity activity) {
        this.objects = objects;
        this.activity = activity;
    }

    @Override
    public ObjetoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contenedor_card_view, null);
        return new ObjetoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ObjetoViewHolder holder, int position) {
        final Object object = objects.get(position);
        holder.tvName.setText(object.getName());
        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, Objeto.class);
                intent.putExtra("name", object.getName());
                intent.putExtra("desc", object.getProperties());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public static class ObjetoViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        public ObjetoViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tvNameContenedor);
        }
    }
}
