package org.proyectopokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ControladorCaptura {
    @FXML
    private Button btnCriar;
    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    public void criarPokemon(){
        System.out.println("Capturar Pokemon");
    }

    public void volverAVentanaPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menuprincipal.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Capturar Pokemon");
        stage.setScene(scene);
        stage.show();
    }


}
