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
import javafx.stage.Stage;
import org.proyectopokemon.movements.Movimiento;
import org.proyectopokemon.movements.MovimientosDisponiblesParaPokemon;
import org.proyectopokemon.pokemon.Pokedex;

import java.io.IOException;
import java.util.Objects;

public class ControladorElegirMovimiento {
    Parent root;
    Scene scene;
    Stage stage;
    @FXML
    private Label lblMovimientoNuevo;
    @FXML
    private Button btnAprender;
    @FXML
    private ListView<Movimiento> opcionesMovimientos;
    private Pokedex pokedex;
    private MovimientosDisponiblesParaPokemon movimientosDisponiblesParaPokemon = new MovimientosDisponiblesParaPokemon();
    public void initialize() {
        pokedex = new Pokedex();
        //movimientosDisponiblesParaPokemon.anyadirMovimientos();
       // opcionesMovimientos.setItems(movimientosDisponiblesParaPokemon.getMovimientos());
        //opcionesMovimientos.setCellFactory(new ElegirMovimientoCeldas());
        opcionesMovimientos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                btnAprender.setDisable(false);
            } else {
                btnAprender.setDisable(true);
            }
        });
    }

    // FIXME: NO FUNCIONA
    @FXML
    public void aprender(ActionEvent event) throws IOException{
        Movimiento movimientoSelected = opcionesMovimientos.getSelectionModel().getSelectedItem();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCombate.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Elegir nueva habilidad - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
