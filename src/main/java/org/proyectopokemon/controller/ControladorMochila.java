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
import org.proyectopokemon.model.Entrenador;

import java.io.IOException;
import java.util.Objects;

public class ControladorMochila {
    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    private Button btnVolver;
    @FXML
    private Button btnRevisarEquipoPokemon;
    @FXML
    private Button btnRevisarCajaPokemon;
    @FXML
    private Label lblMochila;

    public void volverAVentanaPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menuprincipal.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Menú Principal - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void IrAVentanaEquipoPokemon(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaEquipoPokemon.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Equipo Pokémon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        verEquipoEntrenador();
    }

    @FXML
    public void verEquipoEntrenador() {
        Entrenador.miEntrenador.mostrarEquipo();
    }
    @FXML
    public void verCajaEntrenador() {
        Entrenador.miEntrenador.mostrarCaja();
    }


}
