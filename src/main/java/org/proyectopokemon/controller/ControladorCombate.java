package org.proyectopokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.proyectopokemon.model.Entrenador;
import org.proyectopokemon.model.Pokedex;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Objects;

public class ControladorCombate {
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private Button btnVolver;
    @FXML
    private Button btnSubirNivel;
    @FXML
    private Button btnCombatir;
    @FXML
    private Button btnDescansar;
    @FXML
    private Button btnAprenderMovimiento;
    private Pokedex pokedex;

    public void initialize() throws MalformedURLException {
        pokedex = new Pokedex();
    }

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
    @FXML
    public void irACombatir(ActionEvent event) throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCombate2.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Combatir Pokemon2");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void subirNivel(ActionEvent event) throws IOException{
        pokedex.pikachu.subirNivel();
        if (pokedex.pikachu.getExperiencia() == 0 && (pokedex.pikachu.getNivel() == 3 || pokedex.pikachu.getNivel() == 6 || pokedex.pikachu.getNivel() == 9 || pokedex.pikachu.getNivel() == 12)) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaElegirMovimientoAprendido.fxml")));
            scene = new Scene(root, 650, 400);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("Combatir Pokemon");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }
        System.out.println("Nivel: " + pokedex.pikachu.getNivel());
        System.out.println("Vitalidad: " + pokedex.pikachu.getVitalidad());
        System.out.println("Ataque: " + pokedex.pikachu.getAtaque());
        System.out.println("Experiencia: " + pokedex.pikachu.getExperiencia());
    }

    @FXML
    public void verCajaEntrenador() {
        Entrenador.jugadorEntrenador.mostrarCaja();
    }

    @FXML
    public void comprobarVentaja() {
        System.out.println(pokedex.pikachu.comprobarVentaja(pokedex.bulbasaur));
    }

}
