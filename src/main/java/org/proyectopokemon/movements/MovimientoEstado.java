package org.proyectopokemon.movements;

import org.proyectopokemon.enums.Estado;

public class MovimientoEstado extends Movimiento{
    private Estado estado;
    public MovimientoEstado(String nombre,Estado estado){
        this.nombre = nombre;
        this.turnos = turnos;
        this.estado = estado;

    }

}
