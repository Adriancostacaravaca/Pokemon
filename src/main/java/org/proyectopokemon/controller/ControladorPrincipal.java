package org.proyectopokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.File;
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
    @FXML
    private ImageView imagenPokemon;

    private Parent root;
    private Scene scene;
    private Stage stage;

    public void initialize() {
        File f = new File("src/main/resources/imagenes/Pokemon.png");
        Image image = new Image(f.toURI().toString());
        imagenPokemon.setImage(image);
    }

    @FXML
    public void irAVentanaCombate(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCombate.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Combatir Pokemon");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void irAVentanaTienda(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaTienda.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Combatir Pokemon");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    public void irAVentanaCaptura(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCaptura.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Capturar Pokemon");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void IrAVentanaCrianza() {
        System.out.println("Ir a Crianza");
    }

    @FXML
    public void irAVentanaMochila (ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaMochila.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Combatir Pokemon");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void irAVentanaPokedex(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaPokedex.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Capturar Pokemon");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void IrAVentanaEntrenamiento(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaEntrenamiento.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Entrenar Pokemon");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void cerrarPokemon() {
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
        System.out.println("Pokémon cerrado. ¡Esperamos que vuelvas pronto!.");
    }

}
