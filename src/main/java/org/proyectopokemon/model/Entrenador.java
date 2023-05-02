package org.proyectopokemon.model;

import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Entrenador {
    private String nombre;
    private int pokedollar;
    private int pokeballs;
    private static List<Pokemon> equipoPrincipal;
    private static List<Pokemon> caja;
    private List<Objeto> cajaObjetos = new ArrayList<>();

    // CREAMOS ENTRENADOR DEL JUGADOR PRINCIPAL Y DEL RIVAL
    public static Entrenador miEntrenador = new Entrenador("Entrenador Jugador");
    public static Entrenador rivalEntrenador1 = new Entrenador("Entrenador Rival");

    public Entrenador(String nombre) {
        Random rd = new Random();
        this.nombre = nombre;
        this.pokedollar = rd.nextInt(201) + 800;
        this.equipoPrincipal = new ArrayList<>();
        this.caja = new ArrayList<>();
        this.pokeballs = 20;
    }

    public int getPokedollar() {
        return pokedollar;
    }

    public List<Pokemon> getCaja() {
        return caja;
    }

    public List<Objeto> getCajaObjetos() {
        return cajaObjetos;
    }

    public int getPokeballs() {
        return pokeballs;
    }

    public void moverACaja(Pokemon pokemonAMover) {
        comprobarCaja(caja, pokemonAMover);
        caja.add(pokemonAMover);
    }

    public void comprobarCaja(List<Pokemon> lista, Pokemon p) {
        for (int i = 0; i < lista.size() ; i++) {
            if (caja.get(i).getNombre() == p.getNombre()) {
                lista.remove(p);
                System.out.println("Ya existe el Pokemon " +  p.getNombre() + " en tu caja");
            }
        }
    }

    public void mostrarCaja() {
        System.out.println(caja);
    }

    // COMPROBACIÓN DE SI TENEMOS DINERO O NO
    public boolean comprar(Objeto objeto) {
        if (pokedollar >= objeto.getCoste()) {
            pokedollar -= objeto.getCoste();
            getCajaObjetos().add(objeto);
            return true;
        } else {
            return false;
        }
    }

    public boolean capturar(Pokemon pokemon, Label lblComprobacion) {

        Random rd = new Random();
        int numero = 2;
        int numeroAzar = rd.nextInt(2) + 1;
        boolean opcion = true;
        if (pokemon == null) {
            lblComprobacion.setText("No hay ningún pokemon disponible para ser capturado");
        }
        if(pokemon != null) {
            if ((numero == numeroAzar) && this.pokeballs > 0) {
                miEntrenador.caja.add(pokemon);
                pokeballs -= 1;
            }
            else if (this.pokeballs == 0) {
                lblComprobacion.setText("No tienes suficiente Pokéballs para poder capturar un Pokémon");
                opcion = false;
            }
            else {
                lblComprobacion.setText("Has fallado");
                pokeballs -= 1;
                opcion = false;
            }
        }
        return opcion;
    }

}
