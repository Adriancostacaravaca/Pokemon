package org.proyectopokemon.pokemon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Random;
/**
 * CLASE POKEDEX DONDE CREAREMOS CUALQUIER METODO QUE REQUIERA LA INTERVENCION DE ESTA CLASE
 */
public class Pokedex {

    private static ObservableList<Pokemon> pokedex = FXCollections.observableArrayList();

    public static ObservableList<Pokemon> getPokedex() {
        return pokedex;
    }


    /**
     * CONSTRUCTOR VACÍO DE POKÉDEX
     */
    public Pokedex(){
    }

    /**
     * MÉTODO PARA ESCOGER UN POKEMON ALEATORIO DE LA LISTA POKÉDEX
     * @return NOS DEVUELVE EL POKÉMON ALEATORIO
     */

   public Pokemon presentarPokemonAzar(){
        Random rd = new Random();
        int numAzar = rd.nextInt(pokedex.size());
        return pokedex.get(numAzar);
    }


}
