package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Actividad2Comprobar extends AppCompatActivity {

    TextView campoComprobacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2_comprobar);

        campoComprobacion = findViewById(R.id.usuario);

        Bundle extras = getIntent().getExtras();
        int num1 = extras.getInt("num1");
        int num2 = extras.getInt("num2");
        int resultado = extras.getInt("resultado");

        int suma = num1 + num2;

        if(resultado == suma)
        {
            campoComprobacion.setText("CORRECTA");
        }
        else
        {
            campoComprobacion.setText("INCORRECTA");
        }
    }

    public void volver(View v)
    {
        campoComprobacion = findViewById(R.id.comprobado);
        String comprobacion = campoComprobacion.getText().toString();
        Intent intent = new Intent(Actividad2Comprobar.this, Actividad2.class);
        if(comprobacion == "CORRECTA")
        {
            intent.putExtra("comprobacion", "correcta");
        }
        else
        {
            intent.putExtra("comprobacion", "incorrecta");
        }

        setResult(RESULT_OK, intent);
        finish();
    }
}