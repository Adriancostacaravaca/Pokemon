package org.proyectopokemon.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MovimientosDisponiblesParaPokemon {

    ObservableList<MovimientoAtaque> movimientos = FXCollections.observableArrayList();

    public ObservableList<MovimientoAtaque> getMovimientos() {
        return movimientos;
    }

    public void añadirMovimientos(){
        movimientos.add(new MovimientoAtaque("Impactrueno",1,15, Tipo.ELECTRICO));
        movimientos.add(new MovimientoAtaque("Chispa",1,13,Tipo.ELECTRICO));
        movimientos.add(new MovimientoAtaque("Chispazo",1,20,Tipo.ELECTRICO));
    }


}
