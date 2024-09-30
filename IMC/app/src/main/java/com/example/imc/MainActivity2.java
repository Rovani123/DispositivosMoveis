package com.example.imc;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView t1;
        TextView t2;
        TextView resul;

        t1 = findViewById(R.id.lblAltura3);
        t2 =findViewById(R.id.lblPeso3);
        resul = findViewById(R.id.lblIMC3);
        Intent i = getIntent();
        Bundle b =i.getExtras();
        Float peso = b.getFloat("peso");
        Float altura = b.getFloat("altura");
        Float resultado = b.getFloat("resultado");
        t1.setText(String.valueOf(altura));
        t2.setText(String.valueOf(peso));
        resul.setText(String.valueOf(resultado));
    }
}
