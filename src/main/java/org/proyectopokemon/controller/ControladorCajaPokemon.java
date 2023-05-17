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
import org.proyectopokemon.logger.Logger;
import org.proyectopokemon.pokemon.Entrenador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControladorCajaPokemon {
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private Label lblTuCaja;
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
    private Button btnPokemon7;
    @FXML
    private Button btnPokemon8;
    @FXML
    private Button btnPokemon9;
    @FXML
    private Button btnPokemon10;
    @FXML
    private Button btnPokemon11;
    @FXML
    private Button btnPokemon12;
    @FXML
    private Button btnPokemon13;
    @FXML
    private Button btnPokemon14;
    @FXML
    private Button btnPokemon15;
    @FXML
    private Button btnPokemon16;
    @FXML
    private Button btnVolver;
    private List<Button> botones;
    @FXML
    public void volverAVentanaAnterior(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaMochila.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Mochila - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() throws IOException {
        Logger.write("Estás revisando los Pokémon que se encuentran en tu caja");
        botones = new ArrayList<>();
        botones.add(this.btnPokemon1);
        botones.add(this.btnPokemon2);
        botones.add(this.btnPokemon3);
        botones.add(this.btnPokemon4);
        botones.add(this.btnPokemon5);
        botones.add(this.btnPokemon6);
        botones.add(this.btnPokemon7);
        botones.add(this.btnPokemon8);
        botones.add(this.btnPokemon9);
        botones.add(this.btnPokemon10);
        botones.add(this.btnPokemon11);
        botones.add(this.btnPokemon12);
        botones.add(this.btnPokemon13);
        botones.add(this.btnPokemon14);
        botones.add(this.btnPokemon15);
        botones.add(this.btnPokemon16);

        // RECORRE LA CAJA DEL ENTRENADOR Y VA HABILITANDO BOTONES CONFORME ENCUENTRA LOS POKEMON
        for (int i = 0; i < botones.size(); i++) {
            botones.get(i).setDisable(true);
        }
        for(int i = 0; i < Entrenador.miEntrenador.getCaja().size(); i++){
            if(Entrenador.miEntrenador.getCaja().get(i) != null){
                botones.get(i).setDisable(false);
                botones.get(i).setText(Entrenador.miEntrenador.getCaja().get(i).getNombre());
            }
        }
    }


}
