package org.proyectopokemon.controller.factories;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import org.proyectopokemon.pokemon.Pokemon;

public class ElegirPokemonCeldas implements Callback<ListView<Pokemon>, ListCell<Pokemon>> {
    private final ImageView imageView = new ImageView();

    private final HBox hbox = new HBox(imageView);


    @Override
    public ListCell<Pokemon> call(ListView<Pokemon> param) {
        return new ListCell<Pokemon>() {
            @Override
            protected void updateItem(Pokemon pokemon, boolean empty) {
                super.updateItem(pokemon, empty);
                if (empty || pokemon == null) {
                    setText(null);
                } else {
                    imageView.setFitHeight(100);
                    imageView.setFitWidth(100);
                    imageView.setImage(pokemon.getImage());
                    setGraphic(hbox);
                }
            }
        };
    }
}