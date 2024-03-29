package org.proyectopokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.proyectopokemon.logger.Logger;
import org.proyectopokemon.pokemon.Entrenador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

public class ControladorCentroPokemon {
    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    private Button btnVolver;
    @FXML
    private Button btnCriarPokemon;
    @FXML
    private Button btnTienda;
    @FXML
    private Button btnEntrenarPokemon;
    @FXML
    private Button btnMoverAEquipo;
    @FXML
    private Button btnMoverACaja;
    private Media musicaCentroPokemon = new Media(Paths.get("src/main/resources/musica/musicaMenuPrincipal.mp3").toUri().toString());
    private MediaPlayer mediaPlayer = new MediaPlayer(musicaCentroPokemon);
    @FXML
    private Label lblErrorEquipoVacio;
    @FXML
    private ImageView imageViewFondo;
    public void initialize() throws IOException {
        Logger.write("Has entrado al Centro Pokémon");
        File x = new File("src/main/resources/imagenes/CentroPokemon.jpeg");
        Image imagePrincipal = new Image(x.toURI().toString());
        imageViewFondo.setImage(imagePrincipal);

        btnCriarPokemon.setDisable(false);
        btnEntrenarPokemon.setDisable(false);
        if (Entrenador.miEntrenador.getEquipoPrincipal().size() < 1) {
            btnEntrenarPokemon.setDisable(true);
            btnCriarPokemon.setDisable(true);
            lblErrorEquipoVacio.setText("No hay ningún Pokémon en tu equipo");}
        else if(Entrenador.miEntrenador.getEquipoPrincipal().size() < 2){
            btnCriarPokemon.setDisable(true);
            lblErrorEquipoVacio.setText("Necesitas dos Pokémon en tu equipo para poder criar");
        }
    }
    @FXML
    public void irAVentanaTienda(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaTienda.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Tienda Pokémon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void IrAVentanaCrianza(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCrianza.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Crianza Pokémon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        mediaPlayer.stop();
    }
    @FXML
    public void volverAVentanaPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menuprincipal.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Menú Principal - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        mediaPlayer.stop();
    }
    @FXML
    public void IrAVentanaEntrenamiento(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaEstadisticasYEntrenamientoPokemon.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Entrenamiento Pokémon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        mediaPlayer.stop();
    }
    @FXML
    public void IrAVentanaIntercambio(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaIntercambioEntreCajaYEquipo.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Intercambio Pokémon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        mediaPlayer.stop();
    }
}
