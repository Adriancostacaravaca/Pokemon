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


}
