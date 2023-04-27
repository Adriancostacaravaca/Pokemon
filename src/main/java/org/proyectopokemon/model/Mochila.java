package org.proyectopokemon.model;

import java.util.ArrayList;
import java.util.List;

public class Mochila {
    private static List<Objeto> mochila;
    public  Mochila(){
        mochila = new ArrayList<>();
    }
    public List<Objeto> getMochila() {
        return mochila;
    }


    public void añadirAMochila(Objeto objetoComprado){
        mochila.add(objetoComprado);
    }

}
