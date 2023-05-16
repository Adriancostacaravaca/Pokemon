package org.proyectopokemon.controller.factories;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import org.proyectopokemon.shop.Objeto;

public class MochilaCeldas implements Callback<ListView<Objeto>, ListCell<Objeto>> {

    @Override
    public ListCell<Objeto> call(ListView<Objeto> param) {
        return new ListCell<Objeto>() {
            @Override
            protected void updateItem(Objeto objeto, boolean empty) {
                super.updateItem(objeto, empty);
                if (empty || objeto == null) {
                    setText(null);
                } else {
                    setText("Nombre: " + objeto.getNombre() + "\n"
                            + "Precio: " + objeto.getCoste() + "\n"
                            + "Descripcion: " + objeto.getDescripcion() + "\n");
                }
            }
        };
    }
}
