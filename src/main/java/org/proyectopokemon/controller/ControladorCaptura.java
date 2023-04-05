package org.proyectopokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.proyectopokemon.model.Pokemon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ControladorCaptura {
    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    private Button btnVolver;
    @FXML
    private Button btnMostrarPokemon;

    protected Pokemon Pokemon;
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
    // CREACIÓN LISTA DE POKEMON A MOSTRAR Y POKEMON CREADOS
    private List<Pokemon> Pokedex = new ArrayList<>();
    Pokemon pokemon1 = new Pokemon("Charizard", "Chari",'H');
    Pokemon pokemon2 = new Pokemon("Mewtwo", "Mew2",'M');
    Pokemon pokemon3 = new Pokemon("Pikachu", "Pika",'H');
    Pokemon pokemon4 = new Pokemon("Treecko", "Treek0",'M');
    @FXML
    public void mostrarPokemonACapturar() {
        Random rd = new Random();
        Pokedex.add(pokemon1);
        Pokedex.add(pokemon2);
        Pokedex.add(pokemon3);
        Pokedex.add(pokemon4);
        for (int i = 0; i < Pokedex.size(); i++) {
            System.out.println(Pokedex.get(i) + " posición: " + i);
        }
    }

}
