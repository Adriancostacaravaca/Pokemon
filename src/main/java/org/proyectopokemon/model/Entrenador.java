package org.proyectopokemon.model;

import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Entrenador {
    private String nombre;
    private int pokedollar;
    private int pokeballs;

    // CREAMOS EQUIPO Y CAJA DEL ENTRENADOR
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

    public static List<Pokemon> getCaja() {
        return caja;
    }

    public static List<Pokemon> getEquipoPrincipal() {
        return equipoPrincipal;
    }

    public List<Objeto> getCajaObjetos() {
        return cajaObjetos;
    }

    public int getPokeballs() {
        return pokeballs;
    }

    public void mostrarEquipo() {
        System.out.println("EQUIPO DEL ENTRENADOR:");
        if (miEntrenador.getEquipoPrincipal().size() == 0) {
            System.out.println("El equipo del entrenador está vacío");
        }
        for (int i = 0; i < miEntrenador.getEquipoPrincipal().size(); i++) {
            System.out.println(miEntrenador.getEquipoPrincipal().get(i));
        }
    }

    public void mostrarCaja() {
        System.out.println("CAJA DEL ENTRENADOR:");
        if (miEntrenador.getCaja().size() == 0) {
            System.out.println("La caja del entrenador está vacía");
        }
        for (int i = 0; i < miEntrenador.getCaja().size(); i++) {
            System.out.println(miEntrenador.getCaja().get(i));
        }
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
    // FIXME: AÑADIR DOS POKEMON A LA CRIANZA
    public void criar(){
        if (Entrenador.miEntrenador.getPokedollar() >= 800) {
            System.out.println("Crianza realizada");
            pokedollar -= 800;
        }
        else if (Entrenador.miEntrenador.getPokedollar() < 800) {
            System.out.println("No tienes suficiente Pokedólares para realizar la crianza");
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
                moverAEquipo(pokemon);
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

    public void moverAEquipo(Pokemon pokemon){
        equipoPrincipal.add(pokemon);
    }

}
