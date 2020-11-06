package com.example.actividadfragmentos;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class DescripcionActivity extends AppCompatActivity {
    public static final String EXTRA_TEXTO = "com.example.actividadfragmentos.EXTRA_TEXTO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);
        FragmentDescripcion descripcion = (FragmentDescripcion) getSupportFragmentManager().findFragmentById(R.id.FragmentDescripcion);
        Log.i("valor EXTRA_TEXTO: ",EXTRA_TEXTO);
        Log.i("paso: ",getIntent().getStringExtra(EXTRA_TEXTO));
        Log.i("AAA: ",getIntent().getClass().toString());
        descripcion.mostrarDescripcion(getIntent().getStringExtra(EXTRA_TEXTO));
    }
}
