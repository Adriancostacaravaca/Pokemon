package org.proyectopokemon.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import org.proyectopokemon.controller.ControladorVentanaEmergente;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * CLASE ENTRENADOR DONDE CREAREMOS CUALQUIER METODO QUE REQUIERA LA INTERVENCION DE ESTA CLASE
 */
public class Entrenador {
    private String nombre;
    private int pokedollar;
    private int pokeballs;

    // CREAMOS EQUIPO Y CAJA DEL ENTRENADOR
    private ObservableList<Pokemon> equipoPrincipal;
    private ObservableList<Pokemon> caja;
    private List<Objeto> cajaObjetos;

    // CREAMOS ENTRENADOR DEL JUGADOR PRINCIPAL Y DEL RIVAL
    public static Entrenador miEntrenador = new Entrenador("Entrenador Jugador");
    public static Entrenador rivalEntrenador1 = new Entrenador("Entrenador Rival");

    public ControladorVentanaEmergente controladorVentanaEmergente = new ControladorVentanaEmergente();

    private Pokemon p1;
    private Pokemon p2;
    private Pokemon nuevoPokemon;

    /**
     * CONSTRUCTOR PARA LA CREACIÓN DE UN NUEVO ENTRENADOR
     * @param nombre NOMBRE DEL ENTRENADOR
     */
    public Entrenador(String nombre) {
        Random rd = new Random();
        this.nombre = nombre;
        this.pokedollar = rd.nextInt(201) + 800;
        this.cajaObjetos = new ArrayList<>();
        this.pokeballs = 20;
        this.equipoPrincipal = FXCollections.observableArrayList();
        this.caja = FXCollections.observableArrayList();
    }

    public Pokemon getNuevoPokemon() {
        return nuevoPokemon;
    }

    public int getPokedollar() {
        return pokedollar;
    }

    public void setPokedollar(int pokedollar) {
        this.pokedollar = pokedollar;
    }

    public ObservableList<Pokemon> getCaja() {
        return caja;
    }

    public ObservableList<Pokemon> getEquipoPrincipal() {
        return equipoPrincipal;
    }

    public List<Objeto> getCajaObjetos() {
        return cajaObjetos;
    }

    public int getPokeballs() {
        return pokeballs;
    }

    /**
     * MÉTODO PARA MOSTRAR LA CAJA DEL ENTRENADOR, CON UN SIZE RECORREMOS EL ARRAY Y SI ESTÁ A 0, MOSTRAMOS UN PRINT
     * DICIENDO QUE ESTÁ VACÍA
     */

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
    public Pokemon criar(Pokemon[] p1){
        if (Entrenador.miEntrenador.getPokedollar() >= 800) {
            System.out.println("Crianza realizada");
            pokedollar -= 800;
            nuevoPokemon = new Pokemon(controladorVentanaEmergente.getNombre(), p1[0].getTipo(),p1[1].getTipo(),p1[1].getImage());
        }
        else if (Entrenador.miEntrenador.getPokedollar() < 800) {
            System.out.println("No tienes suficiente Pokedólares para realizar la crianza");
        }
        return nuevoPokemon;
    }

    /**
     * MÉTODO PARA CAPTURAR POKÉMON EN LA VENTANA DE CAPTURA
     * @param pokemon SELECCIONAMOS EL POKEMON QUE QUEREMOS CAPTURAR
     * @param lblComprobacion LABEL PARA MOSTRAR MENSAJE POR PANTALLA DANDO INFORMACIÓN SOBRE LA CAPTURA
     * @return BOOLEAN QUE NOS DEVUELVE VERDADERO O FALSO, PARA SABER SI HEMOS CAPTURADO O HEMOS FALLADO
     */

    public boolean capturar(Pokemon pokemon, Label lblComprobacion) {
        Random rd = new Random();
        int numero = 2;
        int numeroAzar = rd.nextInt(2) + 1;
        boolean opcion = true;
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

    /**
     * MÉTODO PARA MOVER UN POKEMON DEL EQUIPO DEL ENTRENADOR A LA CAJA DEL ENTRENADOR
     * @param pokemon POKEMON QUE VAMOS A MOVER
     */

    public void moverEquipoACaja(Pokemon pokemon){
        equipoPrincipal.remove(pokemon);
        caja.add(pokemon);
    }

    /**
     * MÉTODO PARA MOVER UN POKEMON DE LA CAJA DEL ENTRENADOR AL EQUIPO DEL ENTRENADOR
     * @param pokemon POKEMON QUE VAMOS A MOVER
     */
    public void moverCajaAEquipo(Pokemon pokemon){
        caja.remove(pokemon);
        equipoPrincipal.add(pokemon);
    }

    /**
     * MÉTODO PARA RELLENAR UN ARRAY QUE SERÁ EL EQUIPO DEL ENTRENADOR RIVAL CON 6 POKEMON
     */
    public void rellenarEquipoRival(){
        for (int i = 0; i < Pokedex.getPokedex().size(); i++) {
            Random rd = new Random();
            int azar = rd.nextInt(Pokedex.getPokedex().size());
            if (rivalEntrenador1.getEquipoPrincipal().size() < 6) {
            rivalEntrenador1.getEquipoPrincipal().add(Pokedex.getPokedex().get(azar));}
        }
    }

}
