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
import javafx.stage.Stage;
import org.proyectopokemon.logger.Logger;
import org.proyectopokemon.pokemon.Entrenador;

import java.io.File;
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
    private Label lblErrorEquipoVacio;
    @FXML
    private ImageView imageViewFondo;

    public void initialize() throws IOException {
        Logger.write("Estás en la ventana Mochila");
        File y = new File("src/main/resources/imagenes/CajaFondo.png");
        Image imagePrincipal = new Image(y.toURI().toString());
        imageViewFondo.setImage(imagePrincipal);
        if (Entrenador.miEntrenador.getEquipoPrincipal().size() < 1) {
            btnRevisarEquipoPokemon.setDisable(true);
            lblErrorEquipoVacio.setText("No hay ningún Pokémon en tu equipo");
        }
        if (Entrenador.miEntrenador.getCaja().size() < 1) {
            btnRevisarCajaPokemon.setDisable(true);
        }
    }

    public void volverAVentanaPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menuprincipal.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Menú Principal - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void IrAVentanaEquipoPokemon(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaEquipoPokemon.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Equipo Pokémon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void irACajaEntrenador(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCajaPokemon.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Caja Pokémon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }


}
