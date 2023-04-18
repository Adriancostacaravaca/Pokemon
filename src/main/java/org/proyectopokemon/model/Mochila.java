package org.proyectopokemon.model;

import java.util.ArrayList;
import java.util.List;

public class Mochila {

    private List<Objeto> mochila;

    public Mochila(){
        mochila = new ArrayList<>();
    }

    public List<Objeto> getMochila() {
        return mochila;
    }

    public void setMochila(List<Objeto> mochila) {
        this.mochila = mochila;
    }
    public void añadirAMochila(Objeto objetoComprado){
        mochila.add(objetoComprado);
    }

}
