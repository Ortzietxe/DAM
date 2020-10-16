package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Actividad2 extends AppCompatActivity {

    EditText campoCorrectas;
    EditText campoIncorrectas;
    int correctas = 0;
    int incorrectas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        campoCorrectas = findViewById(R.id.num1);
        campoIncorrectas = findViewById(R.id.num1);
    }


    public void comprobar(View v)
    {
        EditText campoNum1 = findViewById(R.id.num1);
        int num1 = Integer.parseInt(campoNum1.getText().toString());

        EditText campoNum2 = findViewById(R.id.num2);
        int num2 = Integer.parseInt(campoNum2.getText().toString());

        EditText campoResultado = findViewById(R.id.resultado);
        int resultado = Integer.parseInt(campoResultado.getText().toString());

        Intent intent = new Intent(Actividad2.this, Actividad2Comprobar.class);
        intent.putExtra("num1", num1);
        intent.putExtra("num2", num2);
        intent.putExtra("resultado", resultado);
        startActivityForResult(intent,1234);
    }

    protected void onActivityResult (int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1234 && resultCode == RESULT_OK) {
            String res = data.getExtras().getString("comprobacion");
            if(res == "correcta")
            {
                correctas++;
            }
            else
            {
                incorrectas++;
            }
        }
    }
}