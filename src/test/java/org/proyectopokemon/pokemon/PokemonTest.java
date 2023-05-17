package org.proyectopokemon.pokemon;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.proyectopokemon.enums.Tipo;

// TODOS LOS ATRIBUTOS HAN DE SER STATIC

class PokemonTest {

    static Pokemon p1;
    static Pokemon p2;

    // SIMILAR A INITIALIZE
    @BeforeAll
    static void crearPokemon(){
        p1 = new Pokemon("juan1", Tipo.PLANTA,Tipo.PLANTA,null);
        p2 = new Pokemon("juan2", Tipo.PLANTA,Tipo.PLANTA,null);
    }
    @Test
    void subirNivel() {
        p2.setNivel(2);
        p2.setExperiencia(20);
        int nivelAnterios = p2.getNivel();
        p2.subirNivel();
        int nivelAhora = p2.getNivel();
        Assert.assertEquals(3,  nivelAhora);
    }

    @Test
    void atacarAPokemon() {
        int vidaInicial = 50;
        p1.atacarAPokemon(p2);
        Assert.assertTrue(p2.getVitalidad() < vidaInicial);
    }

    @Test
    void descansar() {
        p2.setEstamina(3);
        p2.descansar();
        Assert.assertEquals(20,p2.getEstamina());
    }

}