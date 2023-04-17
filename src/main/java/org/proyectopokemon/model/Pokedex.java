package org.proyectopokemon.model;

import java.util.ArrayList;
import java.util.List;

public class Pokedex {

    public List<Pokemon> Pokedex = new ArrayList<>();
    public Pokemon pikachu = new Pokemon("Pikachu","pika",'H');
    public Pokemon treecko = new Pokemon("Treecko", "treek0", 'M');

    public List<Pokemon> getPokedex() {
        return Pokedex;
    }
}
