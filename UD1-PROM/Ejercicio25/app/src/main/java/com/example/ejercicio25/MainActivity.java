package com.example.ejercicio25;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public ImageView imagen;
   public Button botonYahoo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen = findViewById(R.id.imagen);
        botonYahoo = findViewById(R.id.button);
        botonYahoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imagen.setImageResource(R.drawable.yahoo);
            }
        });
    }

  /*  public void mostrarYahoo(View v)
    {
        ImageView imagen = findViewById(R.id.imagen);
        imagen.setImageResource(R.drawable.yahoo);
    }
*/
    public void mostrarBing(View v)
    {
        //ImageView imagen = findViewById(R.id.imagen);
        Toast.makeText(this, "aaaa", Toast.LENGTH_LONG).show();
        imagen.setImageResource(R.drawable.bing);
    }

    public void mostrarGoogle(View v)
    {
        ImageView imagen = findViewById(R.id.imagen);
        imagen.setImageResource(R.drawable.google);
    }
}