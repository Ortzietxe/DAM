package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int num1, num2, suma;
    public EditText txtNum1, txtNum2;
    public TextView lblsuma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void sumar(View v){
        lblsuma = findViewById(R.id.textView3);
        lblsuma.setText("La suma es: ");

        txtNum1 = findViewById(R.id.editTextNumber);
        num1 = Integer.parseInt(txtNum1.getText().toString());

        txtNum2 = findViewById(R.id.editTextNumber2);
        num2 = Integer.parseInt(txtNum2.getText().toString());

        suma = num1 + num2;

        lblsuma.setText(lblsuma.getText().toString() + " " + suma);

    }
}