package org.proyectopokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.proyectopokemon.model.Entrenador;

import java.io.IOException;
import java.util.Objects;

public class ControladorEquipoPokemon {
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private Label lblTuEquipo;
    @FXML
    private Button btnPokemon1;
    @FXML
    private Button btnPokemon2;
    @FXML
    private Button btnPokemon3;
    @FXML
    private Button btnPokemon4;
    @FXML
    private Button btnPokemon5;
    @FXML
    private Button btnPokemon6;
    @FXML
    private Button btnVolver;

    @FXML
    public void volverAVentanaAnterior(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaMochila.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Centro Pokémon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    // FIXME: SI NO HAY UN EQUIPO DE 6 POKEMON, PETA, PORQUE NO RECONOCE Y ENTONCES NO RELLENA LOS BUTTONS CON UN SETTEXT Y EL NOMBRE
    public void initialize(){
        btnPokemon1.setText(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getNombre());
        //btnPokemon2.setText(Entrenador.miEntrenador.getEquipoPrincipal().get(1).getNombre());
        //btnPokemon3.setText(Entrenador.miEntrenador.getEquipoPrincipal().get(2).getNombre());
        //btnPokemon4.setText(Entrenador.miEntrenador.getEquipoPrincipal().get(3).getNombre());
        //btnPokemon5.setText(Entrenador.miEntrenador.getEquipoPrincipal().get(4).getNombre());
        //btnPokemon6.setText(Entrenador.miEntrenador.getEquipoPrincipal().get(5).getNombre());
    }


}
