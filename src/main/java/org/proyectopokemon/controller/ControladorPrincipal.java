package org.proyectopokemon.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ControladorPrincipal {

    @FXML
    private Button btnCombate;
    @FXML
    private Button btnTienda;
    @FXML
    private Button btnCaptura;
    @FXML
    private Button btnCriarPokemon;
    @FXML
    private Button btnMochila;
    @FXML
    private Button btnPokedex;
    @FXML
    private Button btnSalir;

    @FXML
    public void irAVentanaCombate(){
        System.out.println("Ir a Combate");
    }
    @FXML
    public void irAVentanaTienda(){
        System.out.println("Ir a Tienda");
    }
    @FXML
    public void irAVentanaCaptura(){
        System.out.println("Ir a Captura");
    }
    @FXML
    public void IrAVentanaCrianza(){
        System.out.println("Ir a Crianza");
    }
    @FXML
    public void irAVentanaMochila(){
        System.out.println("Ir a Mochila");
    }
    @FXML
    public void irAVentanaPokedex(){
        System.out.println("Ir a Pokédex");
    }
    @FXML
    public void cerrarPokemon(){
        System.out.println("Salir");
    }

}
