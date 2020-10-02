package com.example.ejercicio22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int num1, num2, id, resultado;
    public EditText txtNum1, txtNum2;
    public TextView lblresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void operar(View v){
        lblresultado = findViewById(R.id.textView3);
        lblresultado.setText("Resultado: ");

        txtNum1 = findViewById(R.id.editTextNumber);
        num1 = Integer.parseInt(txtNum1.getText().toString());

        txtNum2 = findViewById(R.id.editTextNumber2);
        num2 = Integer.parseInt(txtNum2.getText().toString());

        id = v.getId();

        switch(id)
        {
            case R.id.sumar:
                resultado = num1 + num2;

                lblresultado.setText(lblresultado.getText().toString() + " " + resultado);
                break;

            case R.id.restar:
                resultado = num1 - num2;

                lblresultado.setText(lblresultado.getText().toString() + " " + resultado);
                break;

            case R.id.multiplicar:
                resultado = num1 * num2;

                lblresultado.setText(lblresultado.getText().toString() + " " + resultado);
                break;

            case R.id.dividir:
                resultado = num1 / num2;

                lblresultado.setText(lblresultado.getText().toString() + " " + resultado);
                break;
        }

    }
}