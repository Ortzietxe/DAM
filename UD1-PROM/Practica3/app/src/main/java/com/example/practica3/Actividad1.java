package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Actividad1 extends AppCompatActivity {

    TextView estadoCondiciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);
    }

    public void volver(View v)
    {
        Intent intent = new Intent(Actividad1.this, MainActivity.class);
        startActivity(intent);
    }

    public void verificar(View v)
    {
        EditText campoNombre = findViewById(R.id.nombre);
        String nombre = campoNombre.getText().toString();

        EditText campoApellido = findViewById(R.id.apellido);
        String apellido = campoApellido.getText().toString();

        Intent intent = new Intent(Actividad1.this, Actividad1Verificar.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("apellido", apellido);
        startActivityForResult(intent,1234);
    }

    protected void onActivityResult (int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        estadoCondiciones = findViewById(R.id.estadoCondiciones);

        if (requestCode == 1234 && resultCode == RESULT_OK) {
            String res = data.getExtras().getString("condiciones");
            estadoCondiciones.setText(res);
        }
    }
}