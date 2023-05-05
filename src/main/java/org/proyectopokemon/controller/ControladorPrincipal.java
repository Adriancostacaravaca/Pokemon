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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

public class ControladorPrincipal {

    @FXML
    private Button btnCombate;
    @FXML
    private Button btnCaptura;
    @FXML
    private Button btnMochila;
    @FXML
    private Button btnPokedex;
    @FXML
    private Button btnSalir;
    @FXML
    private ImageView imagenPokemon;
    @FXML
    private ImageView imageViewFondo;
    private Media musicaMenuPrincipal = new Media(Paths.get("src/main/resources/musica/musicaMenuPrincipal.mp3").toUri().toString());
    private MediaPlayer mediaPlayer = new MediaPlayer(musicaMenuPrincipal);

    private Parent root;
    private Scene scene;
    private Stage stage;

    public void initialize() {
        File f = new File("src/main/resources/imagenes/Logo.png");
        File x = new File("src/main/resources/imagenes/FondoPrincipal.jpg");
        Image image = new Image(f.toURI().toString());
        Image imagePrincipal = new Image(x.toURI().toString());
        imagenPokemon.setImage(image);
        imageViewFondo.setImage(imagePrincipal);
        musicaMenuPrincipal();
    }

    @FXML
    private void musicaMenuPrincipal() {
        mediaPlayer.play();
    }

    @FXML
    public void irAVentanaCombate(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCombate.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Combate Pokemon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        mediaPlayer.stop();
    }

    @FXML
    public void irAVentanaCaptura(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCaptura.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Capturar Pokémon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        mediaPlayer.stop();
    }

    @FXML
    public void irAVentanaCentroPokemon(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCentroPokemon.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Centro Pokémon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        mediaPlayer.stop();
    }

    @FXML
    public void irAVentanaMochila (ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaMochila.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Mochila - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        mediaPlayer.stop();
    }

    @FXML
    public void irAVentanaPokedex(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaPokedex.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Pokédex - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        mediaPlayer.stop();
    }

    @FXML
    public void cerrarPokemon() {
        Stage stage = (Stage) btnSalir.getScene().getWindow();
        stage.close();
        System.out.println("Pokémon cerrado. ¡Esperamos que vuelvas pronto a Pokémon The Crüe!.");
    }

}
