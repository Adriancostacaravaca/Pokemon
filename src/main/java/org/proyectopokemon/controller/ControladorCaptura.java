package org.proyectopokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.proyectopokemon.model.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Objects;

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

    @FXML
    private ImageView imgPokemonAzar;
    private Pokedex pokedex;
    private Entrenador entrenador = new Entrenador("");
    private Pokemon p;

    public void initialize() throws MalformedURLException {
        pokedex = new Pokedex();
        pokedex.rellenarPokedex();
        actualizarPokeballs();
    }
    @FXML
    public void volverAVentanaPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menuprincipal.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
    public void nuevoPokemonACapturar(){
        p = pokedex.presentarPokemonAzar();
    }

    @FXML
    public void mostrarPokemonACapturar() {
        nuevoPokemonACapturar();
        lblPokemon.setText(p.getNombre());
        imgPokemonAzar.setImage(p.getImage());
    }

    @FXML
    public void capturar() {

        boolean capturaHecha = entrenador.capturar(p);

        if (capturaHecha) {
            System.out.println(entrenador.getCaja().toString());
        }

        actualizarPokeballs();
    }
}




