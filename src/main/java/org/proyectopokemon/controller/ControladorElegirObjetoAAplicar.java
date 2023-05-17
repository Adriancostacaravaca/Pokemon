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

public class ControladorElegirObjetoAAplicar {
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private Label lblTuEquipo;
    @FXML
    private Button btnObjeto1;
    @FXML
    private Button btnObjeto2;
    @FXML
    private Button btnObjeto3;
    @FXML
    private Button btnObjeto4;
    @FXML
    private Button btnObjeto5;
    @FXML
    private Button btnObjeto6;
    @FXML
    private Button btnVolver;
    private List<Button> botones;
    @FXML
    public void volverAVentanaAnterior(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaEstadisticasYEntrenamientoPokemon.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Entrenamiento Pokémon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() throws IOException {
        Logger.write("Estás revisando los objetos que puedes aplicar a tu Pokémon");
        botones = new ArrayList<>();
        botones.add(this.btnObjeto1);
        botones.add(this.btnObjeto2);
        botones.add(this.btnObjeto3);
        botones.add(this.btnObjeto4);
        botones.add(this.btnObjeto5);
        botones.add(this.btnObjeto6);

        // RECORRE EL EQUIPO DEL ENTRENADOR Y VA HABILITANDO BOTONES CONFORME ENCUENTRA LOS POKEMON
        for (int i = 0; i < botones.size(); i++) {
            botones.get(i).setDisable(true);
        }
        for(int i = 0; i < Entrenador.miEntrenador.getCajaObjetos().size(); i++){
            if(Entrenador.miEntrenador.getCajaObjetos().get(i) != null){
                botones.get(i).setText(Entrenador.miEntrenador.getCajaObjetos().get(i).getNombre());
                botones.get(i).setDisable(false);
            }
        }
    }


}
