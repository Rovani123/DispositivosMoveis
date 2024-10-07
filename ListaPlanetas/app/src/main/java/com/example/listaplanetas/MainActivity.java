package com.example.listaplanetas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listaview;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaview = findViewById(R.id.listview);
        PlanetaDAO pdao = new PlanetaDAO();
        PlanetaAdapter padap = new PlanetaAdapter(this,R.layout.itemplaneta,pdao.getPlanetas());

        listaview.setAdapter(padap);

        //listaview.setOnItemClickListener();
    }
}