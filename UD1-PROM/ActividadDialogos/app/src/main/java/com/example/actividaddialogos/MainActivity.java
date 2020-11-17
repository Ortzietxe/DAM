package com.example.actividaddialogos;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements Login.OnDialogoConfirmacionListener{
    static String nombre, password;
    public Login login;
    public Spinner spOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();

        login = new Login();
        login.show(fm, "login");

        spOpciones = (Spinner) findViewById(R.id.spElementos);
        final String[] datos = new String [] {"Menu 1","Menu 2","Menu 3","Menu 4", "Menu 5","Menu 6"} ;
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, datos);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spOpciones.setAdapter(adaptador);
    }
    public boolean comprobar()
    {
        nombre = login.getCampoNombre().getText().toString();
        password = login.getCampoPassword().getText().toString();
        if(nombre.equals("usuario1") && password.equals("123456")){
            Toast.makeText(getApplicationContext(),"Bienvenido de vuelta " + nombre ,Toast.LENGTH_SHORT).show();
            return true;
        }
        else
        {
            Toast.makeText(getApplicationContext(),"El usuario no es correcto",Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    public void onPossitiveButtonClick() {
        comprobar();
    }

    public void salir(View v)
    {
        System.exit(0);
    }
}
