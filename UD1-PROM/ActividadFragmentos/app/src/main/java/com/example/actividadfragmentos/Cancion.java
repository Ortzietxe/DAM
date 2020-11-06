package com.example.actividadfragmentos;

public class Cancion {
    private String nombre;
    private String grupo;
    private String descripcion;

    public Cancion(String nombre, String grupo, String descripcion) {
        this.nombre = nombre;
        this.grupo = grupo;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}