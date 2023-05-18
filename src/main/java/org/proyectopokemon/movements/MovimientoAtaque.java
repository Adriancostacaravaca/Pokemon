package org.proyectopokemon.movements;


import org.proyectopokemon.enums.Tipo;

/**
 * CLASE PARA ESTABLECER LOS ATRIBUTOS DE UN MOVIMIENTO ATAQUE
 */
public class MovimientoAtaque extends Movimiento{

    private int potencia;
    private Tipo tipo;

    public MovimientoAtaque(String nombre, int potencia) {
        this.nombre = nombre;
        this.turnos = turnos;
        this.potencia = potencia;
        this.tipo = tipo;
    }

    public int getPotencia() {
        return potencia;
    }

    public Tipo getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return nombre;
    }


}
