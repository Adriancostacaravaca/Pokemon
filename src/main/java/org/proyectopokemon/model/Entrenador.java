package org.proyectopokemon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Entrenador {
    private String nombre;
    private int pokedollar;

    Pokemon pokemon;

    public Entrenador(String nombre) {
        this.nombre = nombre;

    }

    private List<Pokemon> equipoPrincipal = new ArrayList<>();
    private List<Pokemon> caja = new ArrayList<>();

    public void moverACaja(Pokemon pokemonAMover) {
        caja.add(pokemonAMover);
    }
    public void mostrarCaja(){
        System.out.println(caja);
    }
}
