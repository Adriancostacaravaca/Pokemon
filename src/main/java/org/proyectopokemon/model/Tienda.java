package org.proyectopokemon.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import org.proyectopokemon.controller.factories.TiendaCeldas;

public class Tienda {
    ObservableList<Objeto> objetosTienda = FXCollections.observableArrayList();
    public ObservableList<Objeto> getObjetosTienda() {
        return objetosTienda;
    }

    public void añadirObjetosATienda(){
        objetosTienda.add(new Objeto("Pesa",0.2,0.2,250, "Aumenta el ataque y la defensa un 20%, pero disminuye la velocidad un 20%"));
        objetosTienda.add(new Objeto("Pluma",0.3,0.2,250, "Aumenta la velocidad un 30%, pero disminuye la defensa y la defensa\n" +
                "especial un 20%"));
        objetosTienda.add(new Objeto("Chaleco",0.2,0.15,250,"Aumenta la defensa y la defensa especial un 20%, pero disminuye la\n" +
                "velocidad y el ataque un 15%"));
        objetosTienda.add(new Objeto("Baston",0.2,0.15,350,"Aumenta la estamina un 20%, pero disminuye un 15% la velocidad"));
        objetosTienda.add(new Objeto("Pilas",0.5,0.3,300,"Aumenta la recuperación de estamina en un 50%, pero disminuye la defensa\n" +
                "especial un 30%"));
        objetosTienda.add(new Objeto("Pokeball",0,0,50,"Sirve para capturar pokemons"));
    }
}
