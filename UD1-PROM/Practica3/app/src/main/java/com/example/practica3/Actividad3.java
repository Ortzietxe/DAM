package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Actividad3 extends AppCompatActivity {
    EditText campoNombre, campoApellido;
    RadioGroup grupoSexo;
    CheckBox aficionMusica, aficionLectura, aficionDeportes, aficionViajar;
    String nombre, apellido, sexo;
    ArrayList<String> aficiones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad3);

        campoNombre = findViewById(R.id.nomPersona);
        campoApellido = findViewById(R.id.apePersona);

        grupoSexo = findViewById(R.id.sexo);

        aficionMusica = findViewById(R.id.aficionMusica);
        aficionLectura = findViewById(R.id.aficionLectura);
        aficionDeportes = findViewById(R.id.aficionDeporte);
        aficionViajar = findViewById(R.id.aficionViajar);

        aficiones = new ArrayList<String>();
    }

    public void enviar(View v)
    {
        nombre = campoNombre.getText().toString();
        apellido = campoApellido.getText().toString();

        int radioButtonID = grupoSexo.getCheckedRadioButtonId();
        View radioButton = grupoSexo.findViewById(radioButtonID);
        int idRb = grupoSexo.indexOfChild(radioButton);
        RadioButton rb = (RadioButton) grupoSexo.getChildAt(idRb);
        sexo = rb.getText().toString();

        if(aficionMusica.isChecked())
        {
            aficiones.add(aficionMusica.getText().toString());
        }

        if(aficionLectura.isChecked())
        {
            aficiones.add(aficionLectura.getText().toString());
        }

        if(aficionDeportes.isChecked())
        {
            aficiones.add(aficionDeportes.getText().toString());
        }

        if(aficionViajar.isChecked())
        {
            aficiones.add(aficionViajar.getText().toString());
        }

        Intent intent = new Intent(Actividad3.this, Actividad3Mostrar.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("apellido", apellido);
        intent.putExtra("sexo", sexo);
        intent.putStringArrayListExtra("aficiones", aficiones);
        startActivity(intent);
    }
}