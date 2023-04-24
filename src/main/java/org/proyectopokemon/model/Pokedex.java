package org.proyectopokemon.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Random;

public class Pokedex {

    public ObservableList<Pokemon> pokedex = FXCollections.observableArrayList();

    File fBulbasur = new File("src/main/resources/imagenes/bulbasur.png");
    Image bulbasurImg = new Image(fBulbasur.toURI().toURL().toString());
    File fCaterpie = new File("src/main/resources/imagenes/caterpie.png");
    Image caterpieImg = new Image(fCaterpie.toURI().toURL().toString());
    File fCharmander = new File("src/main/resources/imagenes/charmander.png");
    Image charmanderImg = new Image(fCharmander.toURI().toURL().toString());
    File fPikachu = new File("src/main/resources/imagenes/pikachu.png");
    Image pikachuImg = new Image(fPikachu.toURI().toURL().toString());
    File fRattata = new File("src/main/resources/imagenes/rattata.png");
    Image rattataImg = new Image(fRattata.toURI().toURL().toString());
    File fSquirtle = new File("src/main/resources/imagenes/squirtle.png");
    Image squirtleImg = new Image(fSquirtle.toURI().toURL().toString());
    File fTreecko = new File("src/main/resources/imagenes/treecko.png");
    Image treeckoImg = new Image(fTreecko.toURI().toURL().toString());

    public Pokemon pikachu = new Pokemon("Pikachu","pika",'H', Tipo.ELECTRICO, pikachuImg);
    public Pokemon treecko = new Pokemon("Treecko", "treek0", 'M', Tipo.PLANTA, treeckoImg);
    public Pokemon bulbasaur = new Pokemon("Bulbasaur", "Bulbasaur", 'M', Tipo.PLANTA, bulbasurImg);
    public Pokemon charmander = new Pokemon("Charmander", "Charmander", 'M', Tipo.FUEGO, charmanderImg);
    public Pokemon caterpie = new Pokemon("Caterpie", "Caterpie", 'M', Tipo.BICHO, caterpieImg);
    public Pokemon squirtle = new Pokemon("Squirtle", "Squirtle", 'M', Tipo.AGUA, squirtleImg);
    public Pokemon rattata = new Pokemon("Rattata", "Rattata", 'M', Tipo.NORMAL, rattataImg);


    public Pokedex() throws MalformedURLException {
    }

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
