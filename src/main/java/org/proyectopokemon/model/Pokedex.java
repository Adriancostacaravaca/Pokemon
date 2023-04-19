package org.proyectopokemon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pokedex {

    public List<Pokemon> pokedex = new ArrayList<>();
    public Pokemon pikachu = new Pokemon("Pikachu","pika",'H');
    public Pokemon treecko = new Pokemon("Treecko", "treek0", 'M');
    public Pokemon bulbasaur = new Pokemon("Bulbasaur", "Bulbasaur", 'M');
    public Pokemon charmander = new Pokemon("Charmander", "Charmander", 'M');
    public Pokemon caterpie = new Pokemon("Caterpie", "Caterpie", 'M');
    public Pokemon squirtle = new Pokemon("Squirtle", "Squirtle", 'M');
    public Pokemon rattata = new Pokemon("Rattata", "Rattata", 'M');

    public void rellenarPokedex() {
        pokedex.add(pikachu);
        pokedex.add(treecko);
        pokedex.add(bulbasaur);
        pokedex.add(charmander);
        pokedex.add(caterpie);
        pokedex.add(squirtle);
        pokedex.add(rattata);
    }
    public List<Pokemon> getPokedex() {
        return pokedex;
    }

    public Pokemon presentarPokemonAzar(){
        Random rd = new Random();
        int numAzar = rd.nextInt(pokedex.size());
        return pokedex.get(numAzar);
    }
}
