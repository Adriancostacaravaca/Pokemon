package org.proyectopokemon.model;

import javafx.scene.image.Image;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pokedex {

    //public ObservableList<Pokemon> pokedex = FXCollections.observableArrayList();

    private List<Pokemon> pokedex = new ArrayList<>();

    File fBulbasur = new File("src/main/resources/imagenes/Bulbasaur.png");
    Image bulbasaurImg = new Image(fBulbasur.toURI().toString());
    File fCaterpie = new File("src/main/resources/imagenes/Caterpie.png");
    Image caterpieImg = new Image(fCaterpie.toURI().toString());
    File fCharmander = new File("src/main/resources/imagenes/Charmander.png");
    Image charmanderImg = new Image(fCharmander.toURI().toString());
    File fPikachu = new File("src/main/resources/imagenes/Pikachu.png");
    Image pikachuImg = new Image(fPikachu.toURI().toString());
    File fRattata = new File("src/main/resources/imagenes/Rattata.png");
    Image rattataImg = new Image(fRattata.toURI().toString());
    File fSquirtle = new File("src/main/resources/imagenes/Squirtle.png");
    Image squirtleImg = new Image(fSquirtle.toURI().toString());
    File fTreecko = new File("src/main/resources/imagenes/Treecko.png");
    Image treeckoImg = new Image(fTreecko.toURI().toString());

    public Pokemon pikachu = new Pokemon("Pikachu","pika",'H', Tipo.ELECTRICO, pikachuImg);
    public Pokemon treecko = new Pokemon("Treecko", "treek0", 'M', Tipo.PLANTA, treeckoImg);
    public Pokemon bulbasaur = new Pokemon("Bulbasaur", "Bulbasaur", 'M', Tipo.PLANTA, bulbasaurImg);
    public Pokemon charmander = new Pokemon("Charmander", "Charmander", 'M', Tipo.FUEGO, charmanderImg);
    public Pokemon caterpie = new Pokemon("Caterpie", "Caterpie", 'M', Tipo.BICHO, caterpieImg);
    public Pokemon squirtle = new Pokemon("Squirtle", "Squirtle", 'M', Tipo.AGUA, squirtleImg);
    public Pokemon rattata = new Pokemon("Rattata", "Rattata", 'M', Tipo.NORMAL, rattataImg);


    public Pokedex(){
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


}
