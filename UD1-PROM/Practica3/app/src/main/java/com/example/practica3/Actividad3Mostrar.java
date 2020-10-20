package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Actividad3Mostrar extends AppCompatActivity {
    TextView campoInformacion;
    String nombre, apellido, sexo;
    String strAficiones = "";
    ArrayList<String>aficiones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3_mostrar);

        campoInformacion = findViewById(R.id.informacion);

        aficiones = new ArrayList<String>();

        Bundle extras = getIntent().getExtras();
        nombre = extras.getString("nombre");
        apellido = extras.getString("apellido");
        sexo = extras.getString("sexo");
        aficiones = (ArrayList<String>) extras.getStringArrayList("aficiones");
        for(int x = 0; x < aficiones.size(); x++)
        {
            strAficiones = strAficiones + "," + aficiones.get(x);
        }

        campoInformacion.setText("Tu nombre es:" + nombre + "\nTu apellido es:" + apellido +"\nTu sexo es:" + sexo + "\nY entre tus aficiones estan:" + strAficiones);

    }

}