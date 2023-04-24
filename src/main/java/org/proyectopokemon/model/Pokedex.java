package org.proyectopokemon.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.util.Random;

public class Pokedex {

    private Image pikachuImg = new Image("C:\\Users\\AdriánCostaCaravaca\\Desktop\\Pokémon\\Pokemon\\imagenes\\bulbasur.png");
    private Image treeckoImg = new Image("C:\\Users\\AdriánCostaCaravaca\\Desktop\\Pokémon\\Pokemon\\imagenes\\bulbasur.png");
    private Image bulbasurImg = new Image("C:\\Users\\AdriánCostaCaravaca\\Desktop\\Pokémon\\Pokemon\\imagenes\\bulbasur.png");
    private Image charmanderImg = new Image("C:\\Users\\AdriánCostaCaravaca\\Desktop\\Pokémon\\Pokemon\\imagenes\\bulbasur.png");
    private Image caterpieImg = new Image("C:\\Users\\AdriánCostaCaravaca\\Desktop\\Pokémon\\Pokemon\\imagenes\\bulbasur.png");
    private Image squirtleImg = new Image("C:\\Users\\AdriánCostaCaravaca\\Desktop\\Pokémon\\Pokemon\\imagenes\\bulbasur.png");
    private Image rattataImg = new Image("C:\\Users\\AdriánCostaCaravaca\\Desktop\\Pokémon\\Pokemon\\imagenes\\bulbasur.png");

    public Pokemon pikachu = new Pokemon("Pikachu","pika",'H', Tipo.ELECTRICO, pikachuImg);
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
