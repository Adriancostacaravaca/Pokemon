package org.proyectopokemon.model;


public class MovimientoAtaque extends Movimiento{

    private int potencia;

    private Tipo tipo;

    public MovimientoAtaque() {

    }

    public MovimientoAtaque(String nombre, int potencia, Tipo tipo) {
        this.nombre = nombre;
        this.potencia = potencia;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nombre;
    }

    //MovimientoAtaque impactrueno = new MovimientoAtaque("Impactrueno", 20, Tipo.ELECTRICO);

}
