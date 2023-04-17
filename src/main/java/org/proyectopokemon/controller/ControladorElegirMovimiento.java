package org.proyectopokemon.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.proyectopokemon.controller.factories.ElegirMovimientoCeldas;
import org.proyectopokemon.controller.factories.TiendaCeldas;
import org.proyectopokemon.model.*;

import java.io.IOException;
import java.util.Objects;

public class ControladorElegirMovimiento {
    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    private Button btnVolver;

    @FXML
    private Button btnAprender;
    @FXML
    private ListView<MovimientoAtaque> opcionesMovimientos;

    Pokedex pokedex = new Pokedex();
    MovimientosDisponiblesParaPokemon movimientosDisponiblesParaPokemon = new MovimientosDisponiblesParaPokemon();

    @FXML
    public void volverAVentanaPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menuprincipal.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Pokemon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() {
        movimientosDisponiblesParaPokemon.añadirMovimientos();
        opcionesMovimientos.setItems(movimientosDisponiblesParaPokemon.getMovimientos());
        opcionesMovimientos.setCellFactory(new ElegirMovimientoCeldas());

        opcionesMovimientos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                btnAprender.setDisable(false);
            } else {
                btnAprender.setDisable(true);
            }
        });
    }

    @FXML
    public void aprender(ActionEvent event) throws IOException{
        MovimientoAtaque movimientoSelected = opcionesMovimientos.getSelectionModel().getSelectedItem();
        pokedex.pikachu.getListaCuatroAtaques().add(movimientoSelected);
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCombate.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Pokemon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();


    }

}
