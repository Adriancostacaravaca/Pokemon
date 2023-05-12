package org.proyectopokemon.model;


import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Entrenamiento {

    private String nombreEntrenamiento;
    private String descripcion;
    private List<Entrenamiento> entrenamientos = new ArrayList<>();

    public Entrenamiento(String nombreEntrenamiento) {
        this.nombreEntrenamiento = nombreEntrenamiento;
    }
    public Entrenamiento() {

    }


    public void aplicarEnt1(){
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).setVitalidad(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getVitalidad() + 5);
    }

}
