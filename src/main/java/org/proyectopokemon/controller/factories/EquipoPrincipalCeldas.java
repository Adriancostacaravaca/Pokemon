package org.proyectopokemon.controller.factories;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import org.proyectopokemon.model.Pokemon;

public class EquipoPrincipalCeldas implements Callback<ListView<Pokemon>, ListCell<Pokemon>> {
    @Override
    public ListCell<Pokemon> call(ListView<Pokemon> param) {
        return new ListCell<Pokemon>() {
            @Override
            protected void updateItem(Pokemon pokemon, boolean empty) {
                super.updateItem(pokemon, empty);
                if (empty || pokemon == null) {
                    setText(null);
                } else {
                    setText(pokemon.getNombre() + "\n");
                }
            }
        };
    }
}
