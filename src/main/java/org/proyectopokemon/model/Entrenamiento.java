package org.proyectopokemon.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Entrenamiento {

    private String nombre;
    private int nivel;
    private String descripcion;
    private Pokedex pokedex = new Pokedex();
    ObservableList<Entrenamiento> entrenamientos = FXCollections.observableArrayList();

    public Entrenamiento(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public Entrenamiento(){

    }

    public void añadirEntrenamientos(){
        entrenamientos.add(new Entrenamiento("Entrenamiento Pesado",
                "Se aumentan las estadísticas de defensa, defensa especial y vitalidad de tu Pokemon en 5 puntos"));
        entrenamientos.add(new Entrenamiento("Entrenamiento Furioso",
                "Se aumentan las estadísticas de ataque, ataque especial y velocidad de tu Pokemon en 5 puntos"));
        entrenamientos.add(new Entrenamiento("Entrenamiento Funcional",
                "Se aumentan las estadísticas de velocidad, ataque, defensa y vitalidad de tu Pokemon en 5 puntos"));
        entrenamientos.add(new Entrenamiento("Entrenamiento Onírico",
                "Se aumentan las estadísticas de velocidad, ataque especial, defensa especial de tu Pokemon en 5 puntos"));
    }

    public ObservableList<Entrenamiento> getEntrenamientos() {
        return entrenamientos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
