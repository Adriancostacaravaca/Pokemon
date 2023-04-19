package org.proyectopokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.proyectopokemon.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ControladorCaptura {
    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    private Button btnVolver;
    @FXML
    private Button btnMostrarPokemon;
    @FXML
    private Label lblPokemon;
    @FXML
    private Label lblIntentos;

    private Pokedex pokedex = new Pokedex();
    private Captura captura = new Captura();
    private Entrenador entrenador =new Entrenador("");


    @FXML
    public void volverAVentanaPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menuprincipal.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Pokemon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    // MOSTRAR POKEMON CREADOS
    public void actualizarPokeballs() {
        lblIntentos.setText("Pokeballs disponibles: " + entrenador.getPokeballs());
    }

    @FXML
    public void mostrarPokemonACapturar() {
        pokedex.rellenarPokedex();
        lblPokemon.setText(pokedex.presentarPokemonAzar().getNombre());
    }

    public void initialize(){
        actualizarPokeballs();
    }

    @FXML
    public void capturar() {
        if (pokedex.presentarPokemonAzar() != null) {
            boolean capturaHecha = entrenador.capturar(pokedex.presentarPokemonAzar());
            if (capturaHecha) {
                actualizarPokeballs();
                captura.añadirALista(pokedex.presentarPokemonAzar());
                for (Pokemon i:
                        entrenador.getCaja()) {
                    System.out.println(entrenador.getCaja().toString());
                }
            } else {
                System.out.println(entrenador.getCaja().toString());
                System.out.println("Intentalo de nuevo o compra mas pokeballs");
            }
        }
        actualizarPokeballs();

    }

}
