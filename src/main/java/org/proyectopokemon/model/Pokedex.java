package org.proyectopokemon.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import org.proyectopokemon.enums.Tipo;

import java.io.File;
import java.util.Random;
/**
 * CLASE POKEDEX DONDE CREAREMOS CUALQUIER METODO QUE REQUIERA LA INTERVENCION DE ESTA CLASE
 */
public class Pokedex {

    private static ObservableList<Pokemon> pokedex = FXCollections.observableArrayList();

    public static ObservableList<Pokemon> getPokedex() {
        return pokedex;
    }

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

   public Pokemon pikachu = new Pokemon("Pikachu",Tipo.ELECTRICO, Tipo.ELECTRICO, pikachuImg);
    public Pokemon treecko = new Pokemon("Treecko", Tipo.PLANTA, Tipo.PLANTA, treeckoImg);
    public Pokemon bulbasaur = new Pokemon("Bulbasaur",Tipo.PLANTA, Tipo.PLANTA, bulbasaurImg);
    public Pokemon charmander = new Pokemon("Charmander", Tipo.FUEGO, Tipo.FUEGO, charmanderImg);
    public Pokemon caterpie = new Pokemon("Caterpie", Tipo.BICHO, Tipo.BICHO, caterpieImg);
    public Pokemon squirtle = new Pokemon("Squirtle", Tipo.AGUA, Tipo.AGUA, squirtleImg);
    public Pokemon rattata = new Pokemon("Rattata", Tipo.NORMAL, Tipo.NORMAL, rattataImg);

    /**
     * CONSTRUCTOR VACÍO DE POKÉDEX
     */
    public Pokedex(){
    }

    /**
     * MÉTODO PARA AÑADIR TODOS LOS POKEMON QUE TENEMOS CREADOS EN NUESTRA LISTA DE POKÉDEX
     */
    public void rellenarPokedex() {
        pokedex.add(pikachu);
        pokedex.add(treecko);
        pokedex.add(bulbasaur);
        pokedex.add(charmander);
        pokedex.add(caterpie);
        pokedex.add(squirtle);
        pokedex.add(rattata);
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
