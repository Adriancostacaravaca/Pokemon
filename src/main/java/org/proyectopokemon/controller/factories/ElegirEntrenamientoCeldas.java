package org.proyectopokemon.controller.factories;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import org.proyectopokemon.model.Entrenamiento;

public class ElegirEntrenamientoCeldas implements Callback<ListView<Entrenamiento>, ListCell<Entrenamiento>> {

    @Override
    public ListCell<Entrenamiento> call(ListView<Entrenamiento> param) {
        return new ListCell<Entrenamiento>() {
            @Override
            protected void updateItem(Entrenamiento entrenamiento, boolean empty) {
                super.updateItem(entrenamiento, empty);
                if (empty || entrenamiento == null) {
                    setText(null);
                } else {
                    setText("Nombre: " + entrenamiento.getNombre() + "\n"
                            + "Descripción: " + entrenamiento.getDescripcion() + "\n");
                }
            }
        };
    }
}
