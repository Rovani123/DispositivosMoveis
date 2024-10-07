package com.example.listagem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] nomes = new String[] {"Jonas","Antonio","Douglas"};
    ListView jlista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jlista = findViewById(R.id.jlista);
        ArrayAdapter adap = new ArrayAdapter(this, android.R.layout.simple_list_item_1,android.R.id.text1,nomes);
        jlista.setAdapter(adap);
        jlista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String pos = String.valueOf(i);
                Toast.makeText(MainActivity.this, pos+nomes[i], Toast.LENGTH_LONG).show();
            }
        });
    }
}