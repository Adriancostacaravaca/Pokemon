package org.proyectopokemon.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public  class ControladorVentanaEmergente {

    @FXML
    private Button btnHecho;
    @FXML
    private TextField txtFieldNombrePokemon;
    @FXML
    private Label lblAsignarNombre;

    private static String nombre;

    public static String getNombre() {
        return nombre;
    }

    public void initialize(){
        lblAsignarNombre.setText("¡Asignale un nombre a tu pokemon!"
        );

    }

    public void nombrarPokemon(){
        nombre = txtFieldNombrePokemon.getText();
        Stage stage = (Stage) btnHecho.getScene().getWindow();
        stage.close();
    }

}
