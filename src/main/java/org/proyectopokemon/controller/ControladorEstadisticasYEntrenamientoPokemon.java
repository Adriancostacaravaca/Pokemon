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
import org.proyectopokemon.model.Entrenador;
import org.proyectopokemon.model.Entrenamiento;

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
    private Entrenamiento entrenamiento = new Entrenamiento();

    public void initialize(){
        actualizarEstadisticas();
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

    public void actualizarEstadisticas(){
        lblNombre.setText("Nombre: " + Entrenador.miEntrenador.getEquipoPrincipal().get(0).getNombre());
        lblVitalidad.setText("Vitalidad: " + Entrenador.miEntrenador.getEquipoPrincipal().get(0).getVitalidad());
        lblAtaque.setText("Ataque: " + Entrenador.miEntrenador.getEquipoPrincipal().get(0).getAtaque());
        lblDefensa.setText("Defensa: " + Entrenador.miEntrenador.getEquipoPrincipal().get(0).getDefensa());
        lblVelocidad.setText("Velocidad: " + Entrenador.miEntrenador.getEquipoPrincipal().get(0).getVelocidad());
        imageViewPokemon.setImage(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getImage());
    }
    @FXML
    public void aplicarEnt1(){
        entrenamiento.aplicarEnt1();
        actualizarEstadisticas();
    }

}
