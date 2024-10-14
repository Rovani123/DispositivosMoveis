package com.example.listaplanetas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PlanetaAdapter extends ArrayAdapter<Planeta> {

    Context mContexto;
    Integer mRes;
    List<Planeta> mListaPlaneta;

    public PlanetaAdapter(@NonNull Context context, int resource, @NonNull List<Planeta> objects) {
        super(context, resource, objects);
        mContexto=context;
        mRes=resource;
        mListaPlaneta=objects;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContexto);
        View v = layoutInflater.inflate(mRes,parent,false);

        TextView tvnomeplaneta = v.findViewById(R.id.lblnome);
        ImageView imageview = v.findViewById(R.id.imageview);

        Planeta planeta = mListaPlaneta.get(position);
        tvnomeplaneta.setText(planeta.nome);
        imageview.setImageResource(planeta.foto);

        return v;
    }
}
