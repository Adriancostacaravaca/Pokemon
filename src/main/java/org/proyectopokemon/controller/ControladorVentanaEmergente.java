package org.proyectopokemon.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.proyectopokemon.model.Entrenador;
import org.proyectopokemon.model.Pokemon;

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

    public void anyadirPokemonNuevoACaja(){
        String nombre = txtFieldNombrePokemon.getText();
        Pokemon p = new Pokemon(nombre, null,null,null);
        Entrenador.miEntrenador.getCaja().add(p);
        Stage stage = (Stage) btnHecho.getScene().getWindow();
        stage.close();
    }
}
