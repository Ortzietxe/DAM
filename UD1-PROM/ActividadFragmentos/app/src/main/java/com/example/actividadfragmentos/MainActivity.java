package com.example.actividadfragmentos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CancionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentListado fragmentListado = (FragmentListado) getSupportFragmentManager().findFragmentById(R.id.FragmentListado);
        fragmentListado.setCancionListener(this);
    }

    @Override
    public void onCancionSeleccionado(Cancion c) {
        boolean hayDescripcion = (getSupportFragmentManager().findFragmentById(R.id.FragmentDescripcion) != null);
        if (hayDescripcion) {
            ((FragmentDescripcion) getSupportFragmentManager().findFragmentById(R.id.FragmentDescripcion)).mostrarDescripcion(c.getDescripcion());
        } else {
            Intent i = new Intent(this, DescripcionActivity.class);
            i.putExtra(DescripcionActivity.EXTRA_TEXTO, c.getDescripcion());
            startActivity(i);
        }
    }
}