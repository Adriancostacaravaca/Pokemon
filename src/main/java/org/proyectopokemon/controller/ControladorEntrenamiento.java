package org.proyectopokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.proyectopokemon.controller.factories.ElegirEntrenamientoCeldas;
import org.proyectopokemon.model.Entrenamiento;

import java.io.IOException;
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

    public void initialize() {
        entrenamiento.añadirEntrenamientos();
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
    public void volverAVentanaPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menuprincipal.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Pokemon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void entrenar() {

    }

}
