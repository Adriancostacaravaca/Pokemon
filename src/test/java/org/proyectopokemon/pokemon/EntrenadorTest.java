package org.proyectopokemon.pokemon;

import javafx.scene.control.Label;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.proyectopokemon.enums.Tipo;
import org.proyectopokemon.shop.Objeto;

import java.awt.*;

// TODOS LOS ATRIBUTOS HAN DE SER STATIC

class EntrenadorTest {

    static Entrenador p1;
    static Objeto objeto1;

    static Pokemon prueba1;
    static Pokemon prueba2;
    static Pokemon prueba[];
    static Label labelPrueba;

    // SIMILAR A INITIALIZE
    @BeforeAll
    static void crearPokemon(){
        prueba1 = new Pokemon("Juan", Tipo.PLANTA,Tipo.PLANTA,null);
        prueba2 = new Pokemon("Juan1", Tipo.PLANTA,Tipo.PLANTA,null);
        p1 = new Entrenador("juan");
        objeto1 = new Objeto("pala",5,2,200,"mata");
        prueba = new Pokemon[2];
        prueba[0] = prueba1;
        prueba[1] = prueba2;
    }



    @Test
    void comprar() {
        int dineroInicial = p1.getPokedollar();
        p1.comprar(objeto1);
        Assert.assertTrue(dineroInicial > p1.getPokedollar());
    }

    @Test
    void criar(){
        int dineroInicial = p1.getPokedollar();
        p1.criar(prueba);
        Assert.assertTrue(dineroInicial > p1.getPokedollar());

    }

    @Test
    void capturar(){
        Assert.assertTrue(p1.capturar(prueba1,labelPrueba));
    }


}