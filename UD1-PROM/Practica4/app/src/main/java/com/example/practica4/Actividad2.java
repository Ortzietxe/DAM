package com.example.practica4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class Actividad2 extends AppCompatActivity {
    InfoWeb [] datosWebs = new InfoWeb[]
            {
                    new InfoWeb("YOUTUBE", "Red social para compartir y ver diversos videos", R.drawable.youtube),
                    new InfoWeb("TWITCH", "Red social para el streaming o videos en direcot", R.drawable.twitch),
                    new InfoWeb("TWITTER", "Red social para criticar y comentar imagenes o discusiones", R.drawable.twitter),
                    new InfoWeb("REDDIT", "Red social para compartir informacion y dicutir acerca de juegos o cualquier tema en general", R.drawable.reddit)
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        ListView lvLista = findViewById(R.id.lvLista);

        /*final String[] datos = new String[] {"YOUTUBE","TWITCH","TWITTER","REDDIT", "INSTAGRAM"};
        ArrayAdapter<String> adaptadorListView = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datos);
        lvLista.setAdapter(adaptadorListView);*/

        AdaptadorWebs Adaptador = new AdaptadorWebs(this, datosWebs);
        lvLista = (ListView) findViewById(R.id.lvLista);
        lvLista.setAdapter(Adaptador);
    }

    class AdaptadorWebs extends ArrayAdapter<InfoWeb>
    {
        public AdaptadorWebs(@NonNull Context context, InfoWeb[] datos)
        {
            super(context, R.layout.listitemwebs, datos);
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitemwebs, null);
            TextView tvNombre = (TextView)item.findViewById(R.id.tvNombre);
            tvNombre.setText(datosWebs[position].getNombre());
            TextView tvUrl = (TextView)item.findViewById(R.id.tvUrl);
            tvUrl.setText(datosWebs[position].getUrl());
            ImageView tvImage = (ImageView)item.findViewById(R.id.tvImage);
            tvImage.setImageResource(datosWebs[position].getImagen());
            return (item);


        }
    }
}