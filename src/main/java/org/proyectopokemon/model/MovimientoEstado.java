package org.proyectopokemon.model;

public class MovimientoEstado extends Movimiento{
    Estado estado;
    public MovimientoEstado(String nombre, int turnos, Estado estado){
        super(nombre,turnos);

    }

}
