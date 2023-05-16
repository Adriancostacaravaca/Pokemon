package org.proyectopokemon.movements;

import org.proyectopokemon.enums.Estado;

public class MovimientoEstado extends Movimiento{
    Estado estado;
    public MovimientoEstado(String nombre, int turnos, Estado estado){
        this.nombre = nombre;
        this.turnos = turnos;
        this.estado = estado;

    }

}
