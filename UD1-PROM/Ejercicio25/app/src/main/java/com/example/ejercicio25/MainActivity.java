package com.example.ejercicio25;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public ImageView imagen;
   //public Button botonYahoo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Google(View v)
    {
        imagen = findViewById(R.id.imagen);
        imagen.setImageResource(R.drawable.google);
    }
}