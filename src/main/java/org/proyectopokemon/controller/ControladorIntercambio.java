package org.proyectopokemon.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.proyectopokemon.controller.factories.CajaCeldas;
import org.proyectopokemon.controller.factories.EquipoPrincipalCeldas;
import org.proyectopokemon.model.Entrenador;
import org.proyectopokemon.model.Pokemon;

import java.io.IOException;
import java.util.Objects;

public class ControladorIntercambio {
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private Button btnVolver;
    @FXML
    private Button btnEquipoACaja;
    @FXML
    private Button btnCajaAEquipo;
    @FXML
    private Label lblIntercambio;
    @FXML
    private Label lblMiEquipo;
    @FXML
    private Label lblCaja;
    @FXML
    private ListView<Pokemon> listViewCaja;
    @FXML
    private ListView<Pokemon> listViewEquipo;


    public void volverAVentanaPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCentroPokemon.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Menú Principal - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public void initialize() {
        lblIntercambio.setText("Intercambio");
        lblCaja.setText("Caja");
        lblMiEquipo.setText("Mi equipo principal");
        listViewCaja.setItems(Entrenador.getCaja());
        listViewCaja.setCellFactory(new CajaCeldas());

        listViewEquipo.setItems((ObservableList<Pokemon>) Entrenador.getEquipoPrincipal());
        listViewEquipo.setCellFactory(new EquipoPrincipalCeldas());

        listViewCaja.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                btnEquipoACaja.setDisable(false);

            } else {
                btnEquipoACaja.setDisable(true);
            }
        });
        listViewEquipo.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                btnCajaAEquipo.setDisable(false);
            } else {
                btnCajaAEquipo.setDisable(true);
            }
        });
    }

    @FXML
    public void equipoACaja(){
        Pokemon pokemonSelect = listViewEquipo.getSelectionModel().getSelectedItem();
        Entrenador.miEntrenador.moverEquipoACaja(pokemonSelect);
    }
    @FXML
    public void cajaAEquipo(){
        Pokemon pokemonSelect = listViewCaja.getSelectionModel().getSelectedItem();
        Entrenador.miEntrenador.moverCajaAEquipo(pokemonSelect);
    }
}