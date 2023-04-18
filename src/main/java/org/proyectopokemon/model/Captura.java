package org.proyectopokemon.model;

import java.util.Random;

public class Captura {

    Entrenador entrenador = new Entrenador(" ");
    Random rd = new Random();
    public void añadirALista(Pokemon pokemonCapturado){
        entrenador.getCaja().add(pokemonCapturado);

    }
}
