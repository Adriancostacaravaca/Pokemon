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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.proyectopokemon.controller.factories.ElegirMovimientoCeldas;
import org.proyectopokemon.controller.factories.ElegirPokemonCeldas;
import org.proyectopokemon.model.Pokedex;
import org.proyectopokemon.model.Pokemon;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Objects;

public class ControladorCombate2 {

    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private Button btnVolver;
    @FXML
    private Label lblMiEntrenador;
    @FXML
    private Label lblEntranadorRival;
    @FXML
    private ImageView imagenP1;
    @FXML
    private ImageView imagenP2;
    @FXML
    private Button btnPelear;
    @FXML
    private Button btnAtaque1;
    @FXML
    private Button btnAtaque2;
    @FXML
    private Button btnAtaque3;
    @FXML
    private Button btnAtaque4;
    private Pokedex pokedex;


    public void initialize() throws MalformedURLException {
        pokedex = new Pokedex();
        pokedex.rellenarPokedex();
        }

    public void volverAVentanaPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menuprincipal.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Pokemon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void combatir() {
        pokedex.pikachu.atacarAPokemon(pokedex.treecko);

        System.out.println("Vitalidad de: " + pokedex.treecko.getNombre() + ", " + pokedex.treecko.getVitalidad());
        System.out.println("Estamina disponible: " + pokedex.pikachu.getEstamina()); // FIXME: REVISAR

    }

    @FXML
    public void descansar(){
        pokedex.pikachu.descansar();
        if(pokedex.pikachu.getEstamina() < 20){
            System.out.println("Has recuperado 5 de estamina");
        }
    }
}
