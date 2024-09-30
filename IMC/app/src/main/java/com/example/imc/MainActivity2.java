package com.example.imc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.DrawableRes;
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
        TextView lblaltura;
        TextView lblpeso;
        TextView resul;
        TextView lblmensagem;
        ImageView img;
        Button bt;

        bt = findViewById(R.id.btVoltar);
        lblaltura = findViewById(R.id.lblAlturaResul);
        lblpeso = findViewById(R.id.lblPesoResul);
        resul = findViewById(R.id.lblIMC3);
        lblmensagem = findViewById(R.id.lblMensagem);
        img = findViewById(R.id.imgIMC);

        Intent i = getIntent();
        Bundle b =i.getExtras();

        Float peso = b.getFloat("peso");
        Float altura = b.getFloat("altura");
        Float resultado = b.getFloat("resultado");

        lblaltura.setText(String.valueOf(altura));
        lblpeso.setText(String.valueOf(peso));
        resul.setText(String.valueOf(resultado));

        if(resultado < 18.5)
        {
            lblmensagem.setText("Abaixo do peso");
            img.setImageResource(R.drawable.abaixopeso);

        }
        if(resultado >= 18.5 && resultado < 25)
        {
            lblmensagem.setText("Peso normal");
            img.setImageResource(R.drawable.normal);
        }
        if(resultado >=25 && resultado < 30)
        {
            lblmensagem.setText("Sobrepeso");
            img.setImageResource(R.drawable.sobrepeso);
        }
        if(resultado >= 30 && resultado <35)
        {
            lblmensagem.setText("Obesidade grau 1");
            img.setImageResource(R.drawable.obesidade1);
        }
        if(resultado >= 35 && resultado < 40)
        {
            lblmensagem.setText("Obesidade grau 2");
            img.setImageResource(R.drawable.obesidade2);
        }
        if(resultado >= 40)
        {
            lblmensagem.setText("Obesidade grau 3");
            img.setImageResource(R.drawable.obesidade3);
        }
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(),MainActivity.class);

                startActivity(in);
            }
        });
    }
}
