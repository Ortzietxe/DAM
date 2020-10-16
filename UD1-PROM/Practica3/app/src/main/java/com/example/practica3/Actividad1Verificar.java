package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Actividad1Verificar extends AppCompatActivity {

    public TextView campoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1_verificar);

        campoUsuario = findViewById(R.id.usuario);

        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        String apellido = extras.getString("apellido");

        String usuario = (nombre + " " + apellido).toUpperCase();

        campoUsuario.setText(usuario);
    }

    public void aceptarCondiciones(View v)
    {
        Intent intent = new Intent(Actividad1Verificar.this, Actividad1.class);
        intent.putExtra("condiciones", "aceptar");
        setResult(RESULT_OK, intent);
        finish();
    }

    public void rechazarCondiciones(View v)
    {
        Intent intent = new Intent(Actividad1Verificar.this, Actividad1.class);
        intent.putExtra("condiciones", "rechazar");
        setResult(RESULT_OK, intent);
        finish();
    }
}