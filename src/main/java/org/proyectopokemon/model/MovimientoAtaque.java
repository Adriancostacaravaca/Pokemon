package org.proyectopokemon.model;


public class MovimientoAtaque extends Movimiento{

    private int potencia;
    private Tipo tipo;

    public MovimientoAtaque(String nombre,int turnos, int potencia, Tipo tipo) {
        this.nombre = nombre;
        this.turnos = turnos;
        this.potencia = potencia;
        this.tipo = tipo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nombre;
    }


}
