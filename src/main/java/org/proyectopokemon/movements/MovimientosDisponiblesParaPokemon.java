package org.proyectopokemon.movements;

import org.proyectopokemon.enums.Estado;
import org.proyectopokemon.enums.Tipo;

import java.util.ArrayList;
import java.util.List;
/**
 * CLASE MOVIMIENTO DONDE RECOGEREMOS TODOS LOS MOVIMIENTOS DE LOS POKEMON
 */
public class MovimientosDisponiblesParaPokemon {

    private  static List<Movimiento> movimientos = new ArrayList<>();

    public static List<Movimiento> getMovimientos() {
        return movimientos;
    }

    /**
     * METODO PARA AÑADIR LOS MOVIMIENTOS A UNA LISTA GENERAL DE MOVIMIENTOS
     */
    public void anyadirMovimientos(){
        movimientos.add(new MovimientoAtaque("Impactrueno",1,15, Tipo.ELECTRICO));
        movimientos.add(new MovimientoAtaque("Chispa",1,13,Tipo.ELECTRICO));
        movimientos.add(new MovimientoAtaque("Chispazo",1,20,Tipo.ELECTRICO));
        movimientos.add(new MovimientoAtaque("Placaje",1,20,Tipo.ELECTRICO));
        movimientos.add(new MovimientoAtaque("Placaje",1,20, Tipo.ELECTRICO));

        movimientos.add(new MovimientoEstado("Congelar",1, Estado.CONGELADO));
        movimientos.add(new MovimientoEstado("Maldecir",1,Estado.MALDITO));
        movimientos.add(new MovimientoEstado("Enamorar",1,Estado.ENAMORADO));
        movimientos.add(new MovimientoEstado("Dormir",1, Estado.DORMIDO));
        movimientos.add(new MovimientoEstado("Atrapado",1,Estado.ATRAPADO));

        movimientos.add(new MovimientoMejora("Mejora1",1));
        movimientos.add(new MovimientoMejora("Mejora2",1));
        movimientos.add(new MovimientoMejora("Mejora3",1));
        movimientos.add(new MovimientoMejora("Mejora4",1));
        movimientos.add(new MovimientoMejora("Mejora5",1));

    }





}
