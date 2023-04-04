package org.proyectopokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.proyectopokemon.model.Entrenador;
import org.proyectopokemon.model.Pokemon;

import java.io.IOException;
import java.util.Objects;

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
    private Pokemon pokemon = new Pokemon("Pikachu","pika",'H');
    @FXML
    public void irAVentanaCombate(){
        pokemon.subirNivel();
        if (pokemon.getExperiencia() == 0 && pokemon.getNivel() == 3 || pokemon.getNivel() == 6 || pokemon.getNivel() == 9 || pokemon.getNivel() == 12) {
            pokemon.añadirAtaque();
        }
        System.out.println("Nivel: " + pokemon.getNivel());
        System.out.println("Vitalidad: " + pokemon.getVitalidad());
        System.out.println("Ataque: " + pokemon.getAtaque());
        System.out.println("Experiencia: " + pokemon.getExperiencia());
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

    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    public void irAVentanaCaptura(ActionEvent event) throws IOException {
          root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCaptura.fxml")));
          scene = new Scene(root, 600, 400);
          stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          stage.setTitle("Capturar Pokemon");
          stage.setScene(scene);
          stage.show();
    }
    @FXML
    public void cerrarPokemon(){
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
    }

}
