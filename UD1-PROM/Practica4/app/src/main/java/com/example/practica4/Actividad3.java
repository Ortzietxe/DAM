package com.example.practica4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Actividad3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    public Spinner spOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3);

        spOpciones = (Spinner) findViewById(R.id.spEquipos);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.equipos, android.R.layout.simple_spinner_item);
        spOpciones.setAdapter(adapter);
        spOpciones.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        TextView tvMensaje=(TextView) view;

        String equipo = tvMensaje.getText().toString();

        switch (equipo)
        {
            case "":
                break;
            case "Alaves":
                Intent intent1 = new Intent(Actividad3.this, Actividad3Mostrar.class);
                intent1.putExtra("equipo", "alaves");
                startActivity(intent1);
                break;

            case "Athletic":
                Intent intent2 = new Intent(Actividad3.this, Actividad3Mostrar.class);
                intent2.putExtra("equipo", "athletic");
                startActivity(intent2);
                break;

            case "Osasuna":
                Intent intent3 = new Intent(Actividad3.this, Actividad3Mostrar.class);
                intent3.putExtra("equipo", "osasuna");
                startActivity(intent3);
                break;

            case "Real-Sociedad":
                Intent intent4 = new Intent(Actividad3.this, Actividad3Mostrar.class);
                intent4.putExtra("equipo", "real-sociedad");
                startActivity(intent4);
                break;

            case "Eibar":
                Intent intent5= new Intent(Actividad3.this, Actividad3Mostrar.class);
                intent5.putExtra("equipo", "eibar");
                startActivity(intent5);
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
        Toast.makeText(this, "No se ha seleccionado ninguna opción" , Toast.LENGTH_SHORT).show();
    }
}