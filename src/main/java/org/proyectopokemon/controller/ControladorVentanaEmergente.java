package org.proyectopokemon.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControladorVentanaEmergente {

    @FXML
    private Button btnHecho;
    @FXML
    private TextField txtFieldNombrePokemon;
    @FXML
    private Label lblAsignarNombre;

    public void initialize(){
        lblAsignarNombre.setText("¡Asignale un nombre a tu pokemon!");
    }

    public void añadirPokemonNuevoACaja(){

    }
}
