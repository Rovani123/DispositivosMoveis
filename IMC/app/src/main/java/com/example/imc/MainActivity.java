package com.example.imc;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button bt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bt = findViewById(R.id.btCalc);
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                float resultado;
                float peso;
                float altura;

                EditText txtpeso ;
                EditText txtaltura;

                txtpeso = findViewById(R.id.txtPeso);
                txtaltura = findViewById(R.id.txtAltura);

                peso = Float.parseFloat(String.valueOf(txtpeso.getText()));
                altura = Float.parseFloat(String.valueOf(txtaltura.getText()));
                resultado = (peso)/(altura*altura);

                Intent i = new Intent(getApplicationContext(),MainActivity2.class);
                i.putExtra("peso",peso);
                i.putExtra("altura",altura);
                i.putExtra("resultado",resultado);
                startActivity(i);

            }
        });
    }
}
