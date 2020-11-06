package com.example.practica4;

import android.graphics.drawable.Drawable;

public class InfoWeb {
    private String nombre;
    private String url;
    private int imagen;

    public InfoWeb(String nombre, String url, int imagen)
    {
        this.nombre = nombre;
        this.url = url;
        this.imagen = imagen;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getUrl(){
        return url;
    }

    public int getImagen(){
        return imagen;
    }
}
