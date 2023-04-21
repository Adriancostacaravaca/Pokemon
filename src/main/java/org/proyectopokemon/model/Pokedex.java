package org.proyectopokemon.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pokedex {

    public List<Pokemon> pokedexx = new ArrayList<>();
    private Image pikachuImg = new Image("C:\\Users\\FranciscoEstradaCuen\\Desktop\\Pokemon\\imagenes\\pikachu1.png");
    private Image treeckoImg = new Image("C:\\Users\\FranciscoEstradaCuen\\Desktop\\Pokemon\\imagenes\\treecko.png");
    private Image bulbasurImg = new Image("C:\\Users\\FranciscoEstradaCuen\\Desktop\\Pokemon\\imagenes\\bulbasur.png");
    private Image charmanderImg = new Image("C:\\Users\\FranciscoEstradaCuen\\Desktop\\Pokemon\\imagenes\\charmander.png");
    private Image caterpieImg = new Image("C:\\Users\\FranciscoEstradaCuen\\Desktop\\Pokemon\\imagenes\\caterpie.png");
    private Image squirtleImg = new Image("C:\\Users\\FranciscoEstradaCuen\\Desktop\\Pokemon\\imagenes\\squirtle.png");
    private Image rattataImg = new Image("C:\\Users\\FranciscoEstradaCuen\\Desktop\\Pokemon\\imagenes\\rattata.png");

    public Pokemon pikachu = new Pokemon("Pikachu","pika",'H', Tipo.ELECTRICO, pikachuImg );
    public Pokemon treecko = new Pokemon("Treecko", "treek0", 'M', Tipo.PLANTA, treeckoImg);
    public Pokemon bulbasaur = new Pokemon("Bulbasaur", "Bulbasaur", 'M', Tipo.PLANTA, bulbasurImg);
    public Pokemon charmander = new Pokemon("Charmander", "Charmander", 'M', Tipo.FUEGO, charmanderImg);
    public Pokemon caterpie = new Pokemon("Caterpie", "Caterpie", 'M', Tipo.BICHO, caterpieImg);
    public Pokemon squirtle = new Pokemon("Squirtle", "Squirtle", 'M', Tipo.AGUA, squirtleImg);
    public Pokemon rattata = new Pokemon("Rattata", "Rattata", 'M', Tipo.NORMAL, rattataImg);

    public ObservableList<Pokemon> pokedex = FXCollections.observableArrayList();
    public void rellenarPokedex() {
        pokedex.add(pikachu);
        pokedex.add(treecko);
        pokedex.add(bulbasaur);
        pokedex.add(charmander);
        pokedex.add(caterpie);
        pokedex.add(squirtle);
        pokedex.add(rattata);
    }

   public Pokemon presentarPokemonAzar(){
        Random rd = new Random();
        int numAzar = rd.nextInt(pokedex.size());
        return pokedex.get(numAzar);
    }

    public ObservableList<Pokemon> getPokedex() {
        return pokedex;
    }
}
