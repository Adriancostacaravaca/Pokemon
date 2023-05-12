package org.proyectopokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.proyectopokemon.controller.factories.ElegirEntrenamientoCeldas;
import org.proyectopokemon.model.Entrenamiento;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

public class ControladorEntrenamiento {

    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    private Button btnVolver;

    @FXML
    private Button btnSeleccionar;
    private Entrenamiento entrenamiento = new Entrenamiento();
    @FXML
    private ListView<Entrenamiento> listaEntrenamiento;
    private Media musicaEntrenamiento = new Media(Paths.get("src/main/resources/musica/tienda.mp3").toUri().toString());
    private MediaPlayer mediaPlayer = new MediaPlayer(musicaEntrenamiento);

    public void initialize() {
        entrenamiento.anyadirEntrenamientos();
        listaEntrenamiento.setItems(entrenamiento.getEntrenamientos());
        listaEntrenamiento.setCellFactory(new ElegirEntrenamientoCeldas());

        listaEntrenamiento.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                btnSeleccionar.setDisable(false);
            } else {
                btnSeleccionar.setDisable(true);
            }
        });
    }
    @FXML
    public void volverAVentanaAnterior(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCentroPokemon.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Centro Pokémon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        mediaPlayer.stop();
    }

    public void entrenar() {

    }

}
