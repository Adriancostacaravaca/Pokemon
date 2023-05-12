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

import java.io.IOException;
import java.util.Objects;

public class ControladorEstadisticasYEntrenamientoPokemon {

    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private Label lblNombre;
    @FXML
    private Label lblVitalidad;
    @FXML
    private Label lblAtaque;
    @FXML
    private Label lblDefensa;
    @FXML
    private Label lblVelocidad;
    @FXML
    private ImageView imageViewPokemon;
    @FXML
    private Button btnVolver;
    @FXML
    private Button btnEnt1;
    @FXML
    private Button btnEnt2;
    @FXML
    private Button btnEnt3;
    @FXML
    private Button btnEnt4;


    public void initialize(){
      lblNombre.setText("Nombre: " + ControladorElegirPokemonAEntrenar.getNombre());
      lblVitalidad.setText("Vitalidad: " + ControladorElegirPokemonAEntrenar.getVitalidad());
      lblAtaque.setText("Ataque: " + ControladorElegirPokemonAEntrenar.getAtaque());
      lblDefensa.setText("Defensa: " + ControladorElegirPokemonAEntrenar.getDefensa());
      lblVelocidad.setText("Velocidad: " + ControladorElegirPokemonAEntrenar.getVelocidad());
      imageViewPokemon.setImage(ControladorElegirPokemonAEntrenar.getImage());
    }

    @FXML
    public void volverAVentanaAnterior(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaElegirPokemonAEntrenar.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Pokemon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

}
