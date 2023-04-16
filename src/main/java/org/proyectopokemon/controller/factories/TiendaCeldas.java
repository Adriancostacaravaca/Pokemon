package org.proyectopokemon.controller.factories;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import org.proyectopokemon.model.Objeto;

import javafx.util.Callback;
//Se utiliza un callBack que sirve para darle forma a la presentacion de datoss de un objeto en celdas
//Ademas se crea una carpeta factories para que se distinga del resto
public class TiendaCeldas implements Callback<ListView<Objeto>, ListCell<Objeto>> {

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