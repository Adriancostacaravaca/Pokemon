package org.proyectopokemon.model;

public abstract class Movimiento {

    protected String nombre;

    protected int turnos;


     public Movimiento(String nombre,int turnos) {
         this.nombre = nombre;
         this.turnos = turnos;

     }
 }
