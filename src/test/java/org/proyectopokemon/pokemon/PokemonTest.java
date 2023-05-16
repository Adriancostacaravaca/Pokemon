package org.proyectopokemon.pokemon;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

 // TODOS LOS ATRIBUTOS HAN DE SER STATIC

class PokemonTest {

    static Pokemon p1;
    static Pokemon p2;

    // SIMILAR A INITIALIZE
    @BeforeAll
    static void crearPokemon(){
        p1 = new Pokemon();
        p2 = new Pokemon();
    }



    @Test
    void subirNivel() {
        p2.setNivel(3);
        p2.setExperiencia(30);
        int nivel = p2.getNivel();
        p2.subirNivel();
        Assert.assertTrue(nivel < p2.getVitalidad());
    }

    @Test
    void atacarAPokemon() {
        int vidaInicial = 50;
        p1.atacarAPokemon(p2);
        Assert.assertTrue(p2.getVitalidad() < vidaInicial);
    }

    @Test
    void descansar() {
    }

}