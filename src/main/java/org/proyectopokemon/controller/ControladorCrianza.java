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
import org.proyectopokemon.model.Entrenador;

import java.io.IOException;
import java.util.Objects;

public class ControladorCrianza {

    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private Button btnVolver;
    @FXML
    private Button btnPokemon1;
    @FXML
    private Button btnPokemon2;
    @FXML
    private Button btnPokemon3;
    @FXML
    private Button btnPokemon4;
    @FXML
    private Button btnPokemon5;
    @FXML
    private Button btnPokemon6;
    @FXML
    private Button btnCriar;
    @FXML
    private ImageView imageViewPokemon1;
    @FXML
    private ImageView imageViewPokemon2;
    @FXML
    private Label lblCoste;
    @FXML
    private Label lblPokedolares;

    public void initialize() {
        btnPokemon1.setText(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getNombre());
        btnPokemon2.setText(Entrenador.miEntrenador.getEquipoPrincipal().get(1).getNombre());
        btnPokemon3.setText(Entrenador.miEntrenador.getEquipoPrincipal().get(2).getNombre());
        btnPokemon4.setText(Entrenador.miEntrenador.getEquipoPrincipal().get(3).getNombre());
        btnPokemon5.setText(Entrenador.miEntrenador.getEquipoPrincipal().get(4).getNombre());
        btnPokemon6.setText(Entrenador.miEntrenador.getEquipoPrincipal().get(5).getNombre());
        actualizarDinero();
    }
    @FXML
    public void volverAVentanaAnterior(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCentroPokemon.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Pokemon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        actualizarDinero();
    }

    // ACTUALIZAMOS NUESTRO DINERO
    public void actualizarDinero() {
        lblCoste.setText("Coste: 800");
        lblPokedolares.setText("Pokedólares: " + Entrenador.miEntrenador.getPokedollar());
    }

    // MÉTODO PARA REALIZAR LA CRIANZA ENTRE DOS POKÉMON
    public void criar(){
        Entrenador.miEntrenador.criar();
        actualizarDinero();
    }

}
