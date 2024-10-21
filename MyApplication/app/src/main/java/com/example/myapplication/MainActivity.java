package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase banco;
    EditText editNome, editDataNsc, editEmail;
    Button bt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome = findViewById(R.id.txtnome);
        editEmail= findViewById(R.id.txtemail);
        editDataNsc = findViewById(R.id.txtdata);
        bt=findViewById(R.id.button);

        banco = openOrCreateDatabase("banco",MODE_PRIVATE, null);
        banco.execSQL("CREATE TABLE if not exists pessoas (id  INTEGER PRIMARY KEY autoincrement,nome varchar, email varchar, dtnsc date)");

        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            String nome = editNome.getText().toString();
            String email = editEmail.getText().toString();
            String data = editDataNsc.getText().toString();

            ContentValues cv = new ContentValues();
            cv.put("nome",nome);
            cv.put("email",email);

            long status =banco.insert("pessoas",null,cv);

            if(status>0){
                Toast.makeText(MainActivity.this, "Deu boa", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(MainActivity.this, "Garr", Toast.LENGTH_SHORT).show();
            }

            }
        });
    }
}