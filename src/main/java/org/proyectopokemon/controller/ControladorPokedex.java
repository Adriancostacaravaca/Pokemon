package org.proyectopokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.proyectopokemon.controller.factories.EquipoPrincipalCeldas;
import org.proyectopokemon.model.Pokedex;
import org.proyectopokemon.model.Pokemon;

import java.io.IOException;
import java.util.Objects;

public class ControladorPokedex {
    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    private Button btnVolver;
    @FXML
    private Button btnRevisar;
    @FXML
    private Label lblPokedex;
    @FXML
    private ListView<Pokemon> listViewPokemon;
    @FXML
    private ImageView imageViewPokemon;

    @FXML
    public void volverAVentanaPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menuprincipal.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Menú Principal - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(){
        listViewPokemon.setItems(Pokedex.getPokedex());
        listViewPokemon.setCellFactory(new EquipoPrincipalCeldas());
    }
}
