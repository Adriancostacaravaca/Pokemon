package org.proyectopokemon.model;

import java.util.ArrayList;
import java.util.List;

/**
 * CLASE MOCHILA DONDE CREAREMOS CUALQUIER METODO QUE REQUIERA LA INTERVENCION DE ESTA CLASE
 */
public class Mochila {
    private static List<Objeto> mochila;
    public  Mochila(){
        mochila = new ArrayList<>();
    }

    /**
     * MÉTODO PARA AÑADIR UN OBJETO A LA MOCHILA DE NUESTRO ENTRENADOR
     * @param objetoComprado EL OBJETO QUE HEMOS COMPRADO EN LA TIENDA
     */
    public void anyadirAMochila(Objeto objetoComprado){
        mochila.add(objetoComprado);
    }
    public List<Objeto> getMochila() {
        return mochila;
    }




}
