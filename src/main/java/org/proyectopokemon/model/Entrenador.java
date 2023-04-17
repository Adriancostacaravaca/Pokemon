package org.proyectopokemon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Entrenador {
    private String nombre;
    private int pokedollar;

    private List<Pokemon> equipoPrincipal;
    Random rd = new Random();
    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.pokedollar = rd.nextInt(201)+800;
        this.equipoPrincipal = new ArrayList<>();
    }

    // CREAMOS ENTRENADOR DEL JUGADOR PRINCIPAL
    public static Entrenador jugadorEntrenador = new Entrenador("Entrenador Pokemon");
    private List<Pokemon> caja = new ArrayList<>();
    private List<Objeto> cajaObjetos = new ArrayList<>();

    public void moverACaja(Pokemon pokemonAMover) {
        caja.add(pokemonAMover);
    }
    public void mostrarCaja(){
        System.out.println(caja);
    }

    // COMPROBACIÓN DE SI TENEMOS DINERO O NO
    public boolean comprar(Objeto objeto){
        if(pokedollar >= objeto.getCoste()){
            pokedollar -= objeto.getCoste();
            return true;
        }else {
            return false;
        }
    }

    public int getPokedollar() {
        return pokedollar;
    }

    public void setPokedollar(int pokedollar) {
        this.pokedollar = pokedollar;
    }

    public List<Pokemon> getCaja() {
        return caja;
    }

    public void setCaja(List<Pokemon> caja) {
        this.caja = caja;
    }

    public List<Objeto> getCajaObjetos() {
        return cajaObjetos;
    }

    public void setCajaObjetos(List<Objeto> cajaObjetos) {
        this.cajaObjetos = cajaObjetos;
    }
}
