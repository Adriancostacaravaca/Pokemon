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
import java.util.ArrayList;
import java.util.List;
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

    private List<Button> botones;
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

    // FIXME: SI NO HAY UN EQUIPO DE 6 POKEMON, PETA, PORQUE NO RECONOCE Y ENTONCES NO RELLENA LOS BUTTONS CON UN SETTEXT Y EL NOMBRE ¿TRYCATCH?
    // FIXME: CALCULAR EL SIZE Y HABILITAR BOTONES CONFORME AL TAMAÑO DEL EQUIPO
    public void initialize(){
        botones = new ArrayList<>();
        botones.add(btnPokemon1);
        botones.add(btnPokemon2);
        botones.add(btnPokemon3);
        botones.add(btnPokemon4);
        botones.add(btnPokemon5);
        botones.add(btnPokemon6);

        for(int i = 0; i < Entrenador.miEntrenador.getEquipoPrincipal().size(); i++){
            if(Entrenador.miEntrenador.getEquipoPrincipal().get(i) != null){
                botones.get(i).setText(Entrenador.miEntrenador.getEquipoPrincipal().get(i).getNombre());
            }else{
                System.out.println("error");
            }
        }


    }


}
