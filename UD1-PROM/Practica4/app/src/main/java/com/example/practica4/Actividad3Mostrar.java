package com.example.practica4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Actividad3Mostrar extends AppCompatActivity {
    TextView campoNombre;
    String nombre;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3_mostrar);

        campoNombre = findViewById(R.id.nomEquipo);
        imagen = findViewById(R.id.imagenEquipo);

        Bundle extras = getIntent().getExtras();
        nombre = extras.getString("equipo");

        switch (nombre){
            case "alaves":
                campoNombre.setText("Alaves");
                imagen.setImageResource(R.drawable.alaves);
                break;

            case "athletic":
                campoNombre.setText("Athletic");
                imagen.setImageResource(R.drawable.athletic);
                break;

            case "osasuna":
                campoNombre.setText("Osasuna");
                imagen.setImageResource(R.drawable.osasuna);
                break;

            case "real-sociedad":
                campoNombre.setText("Real-Sociedad");
                imagen.setImageResource(R.drawable.real);
                break;

            case "eibar":
                campoNombre.setText("Eibar");
                imagen.setImageResource(R.drawable.eibar);
                break;
        }
    }
}