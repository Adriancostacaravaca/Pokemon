package org.proyectopokemon.model;

public class Objeto {

    private String nombre;
    private double aumenta;
    private double disminuye;
    private int coste;
    private String descripcion;

    // CREACIÓN DE OBJETO
    public Objeto(String nombre, double aumenta, double disminuye, int coste,String descripcion){
        this.nombre = nombre;
        this.aumenta = aumenta;
        this.disminuye = disminuye;
        this.coste = coste;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public double getAumenta() {
        return aumenta;
    }

    public double getDisminuye() {
        return disminuye;
    }

    public int getCoste() {
        return coste;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
