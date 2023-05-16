package org.proyectopokemon.pokemon;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.proyectopokemon.shop.Objeto;

// TODOS LOS ATRIBUTOS HAN DE SER STATIC

class EntrenadorTest {

    static Entrenador p1;
    static Objeto objeto1;

    // SIMILAR A INITIALIZE
    @BeforeAll
    static void crearPokemon(){
        p1 = new Entrenador("juan");
        objeto1 = new Objeto("pala",5,2,200,"mata");
    }



    @Test
    void comprar() {
        int dineroInicial = p1.getPokedollar();
        p1.comprar(objeto1);
        Assert.assertTrue(dineroInicial > p1.getPokedollar());
    }


}