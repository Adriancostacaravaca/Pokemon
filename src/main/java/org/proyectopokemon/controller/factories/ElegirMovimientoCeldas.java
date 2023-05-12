package org.proyectopokemon.controller.factories;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import org.proyectopokemon.model.Movimiento;

public class ElegirMovimientoCeldas implements Callback<ListView<Movimiento>, ListCell<Movimiento>> {

    public ListCell<Movimiento> call(ListView<Movimiento> param) {
        return new ListCell<Movimiento>() {
            @Override
            protected void updateItem(Movimiento movimiento, boolean empty) {
                super.updateItem(movimiento, empty);
                if (empty || movimiento == null) {
                    setText(null);
                } else {
                    setText("Nombre: " + movimiento.getNombre() + "\n");
                }
            }
        };
    }
}
