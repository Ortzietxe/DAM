package com.example.actividaddialogos;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements Login.OnDialogoConfirmacionListener{
    static String nombre, password;
    public Login login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();

        login = new Login();
        login.show(fm, "login");


    }
    public boolean comprobar()
    {
        nombre = login.getCampoNombre().getText().toString();
        password = login.getCampoPassword().getText().toString();
        if(!nombre.equals("") && !password.equals("")){
            Toast.makeText(getApplicationContext(),"Bienvenido de vuelta " + nombre ,Toast.LENGTH_SHORT).show();
            return true;
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Necesitas escribir el nombre y la contraseña",Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    public void onPossitiveButtonClick() {
        comprobar();
    }
}
