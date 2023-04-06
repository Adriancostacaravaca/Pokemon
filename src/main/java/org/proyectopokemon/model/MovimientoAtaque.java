package org.proyectopokemon.model;


public class MovimientoAtaque extends Movimiento{

    private int potencia;

    private Tipo tipo;


    public MovimientoAtaque(String nombre,int turnos, int potencia, Tipo tipo) {
        super(nombre,turnos);
        this.potencia = potencia;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nombre;
    }

    //MovimientoAtaque impactrueno = new MovimientoAtaque("Impactrueno", 20, Tipo.ELECTRICO);

}
