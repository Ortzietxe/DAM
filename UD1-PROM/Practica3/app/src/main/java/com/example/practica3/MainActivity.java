package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mostrarActividad1(View v)
    {
        Intent intent = new Intent(MainActivity.this, Actividad1.class);
        startActivity(intent);
    }

    public void mostrarActividad2(View v)
    {
        Intent intent = new Intent(MainActivity.this, Actividad2.class);
        startActivity(intent);
    }

    public void mostrarActividad3(View v)
    {

    }

    public void mostrarActividad4(View v)
    {

    }

    public void salir(View v)
    {
        System.exit(0);
    }
}