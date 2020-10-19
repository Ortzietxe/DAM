package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Actividad2 extends AppCompatActivity {

    TextView campoCorrectas;
    TextView campoIncorrectas;
    TextView campoNum1;
    TextView campoNum2;
    EditText campoResultado;
    int randNum1, randNum2;
    int correctas = 0;
    int incorrectas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        campoCorrectas = findViewById(R.id.correctas);
        campoCorrectas.setText("" + correctas);

        campoIncorrectas = findViewById(R.id.incorrectas);
        campoIncorrectas.setText("" + incorrectas);

        campoNum1 = findViewById(R.id.num1);
        campoNum2 = findViewById(R.id.num2);

        randNum1 = new Random().nextInt(99);
        campoNum1.setText("" + randNum1);

        randNum2 = new Random().nextInt(99);
        campoNum2.setText("" + randNum2);

        campoResultado = findViewById(R.id.resultado);
    }


    public void comprobar(View v)
    {

        int num1 = Integer.parseInt(campoNum1.getText().toString());

        int num2 = Integer.parseInt(campoNum2.getText().toString());

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
            if(res.equals("correcta"))
            {
                correctas++;
                campoCorrectas.setText("" + correctas);
            }
            else
            {
                incorrectas++;
                campoIncorrectas.setText("" + incorrectas);
            }

            randNum1 = new Random().nextInt(99);
            campoNum1.setText("" + randNum1);

            randNum2 = new Random().nextInt(99);
            campoNum2.setText("" + randNum2);

            campoResultado.setText("");
        }
    }
}