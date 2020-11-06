package com.example.actividadfragmentos;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentListado extends Fragment {
    private Cancion[] datos = new Cancion[]{
            new Cancion("Cemetery Gates", "Pantera", "Cancion clasica del famoso grupo pantera con un solazo de Dimebag Darrell"),
            new Cancion("Mr.Crowley", "Ozzy Osbourne", "Cancion clasica del primer disco del ex cantante de black sabbath ozzy con su nuevo grupo y con uno de los mejores solos de la epoca a manos de Randy Rhoads"),
            new Cancion("Cult of personality", "Living Colours", "Cancion clasica del grupo Living Colours que no fueron reconocidos como como grupo clasico hasta hace poco"),
            new Cancion("War pigs", "Black Sabbath", "Cancion clasica del famosisimo grupo Black Sabbath"),
    };
    private ListView lstListado;
    private CancionListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lstListado = (ListView) getView().findViewById(R.id.lstListado);
        lstListado.setAdapter(new AdaptadorCanciones(this));
        lstListado.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,View view, int position, long id) {
                if (listener != null)listener.onCancionSeleccionado((Cancion)lstListado.getAdapter().getItem(position));
            }
        });
    }
    class AdaptadorCanciones extends ArrayAdapter<Cancion>{
        Activity context;

        AdaptadorCanciones(Fragment context) {
            super(context.getActivity(), R.layout.listitem_cancion, datos);
            this.context = context.getActivity();
        }
        @NonNull
        @Override
        public View getView(int position,
                            @Nullable View convertView,
                            @NonNull ViewGroup parent)
        {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_cancion, null);
            TextView lblDe = (TextView) item.findViewById(R.id.desc);
            lblDe.setText(datos[position].getDescripcion());
            TextView lblNombre = (TextView)item.findViewById(R.id.nombre);
            lblNombre.setText(datos[position].getNombre());
            return (item);
        }
    }

    public void setCancionListener (CancionListener listener)
    {
        this.listener = listener;
    }
}

