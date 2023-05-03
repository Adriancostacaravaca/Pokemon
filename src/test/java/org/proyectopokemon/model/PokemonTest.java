package org.proyectopokemon.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

 // TODOS LOS ATRIBUTOS HAN DE SER STATIC

class PokemonTest {

    static Pokemon p;

    // SIMILAR A INITIALIZE
    @BeforeAll
    static void crearPokemon(){
        p = new Pokemon();
    }



    @Test
    void subirNivel() {
    }

    @Test
    void atacarAPokemon() {
    }

    @Test
    void descansar() {
    }

}