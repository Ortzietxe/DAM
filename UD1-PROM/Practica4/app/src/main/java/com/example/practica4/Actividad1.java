package com.example.practica4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.time.temporal.Temporal;

public class Actividad1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    public Spinner spOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);

        spOpciones = (Spinner) findViewById(R.id.spPaises);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.valores_array, android.R.layout.simple_spinner_item);
        spOpciones.setAdapter(adapter);
        spOpciones.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        TextView tvMensaje=(TextView) view;

        String pais = tvMensaje.getText().toString();

        switch (pais)
        {
            case "España":
                Toast.makeText(this, pais + " tiene 46,94 millones de habitantes ", Toast.LENGTH_SHORT).show();
                break;

            case "Francia":
                Toast.makeText(this, pais + " tiene 66,99 millones de habitantes ", Toast.LENGTH_SHORT).show();
                break;

            case "Alemania":
                Toast.makeText(this, pais + " tiene 83,02 millones de habitantes ", Toast.LENGTH_SHORT).show();
                break;

            case "Italia":
                Toast.makeText(this, pais + " tiene 60,36 millones de habitantes ", Toast.LENGTH_SHORT).show();
                break;

            case "Reino Unido":
                Toast.makeText(this, pais + " tiene 66,65 millones de habitantes ", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
        Toast.makeText(this, "No se ha seleccionado ninguna opción" , Toast.LENGTH_SHORT).show();
    }
}