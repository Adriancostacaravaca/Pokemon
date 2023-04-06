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
import org.proyectopokemon.model.Pokemon;

import java.io.IOException;
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

    Entrenador entrenador = new Entrenador("Entrenador Pokemon");
    private Pokemon pikachu = new Pokemon("Pikachu","pika",'H');
    private Pokemon treecko = new Pokemon("Treecko", "treek0", 'M');

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
    public void irAVentanaElegirMovimiento(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaElegirMovimientoAprendido.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Combatir Pokemon");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void subirNivel(){
        pikachu.subirNivel();
        if (pikachu.getExperiencia() == 0 && pikachu.getNivel() == 3 || pikachu.getNivel() == 6 || pikachu.getNivel() == 9 || pikachu.getNivel() == 12) {
            pikachu.añadirAtaque();
        }
        System.out.println("Nivel: " + pikachu.getNivel());
        System.out.println("Vitalidad: " + pikachu.getVitalidad());
        System.out.println("Ataque: " + pikachu.getAtaque());
        System.out.println("Experiencia: " + pikachu.getExperiencia());
    }
    @FXML
    public void combatir(){
        pikachu.atacarAPokemon(treecko);

        System.out.println("Vitalidad de: " + treecko.getNombre() + ", " + treecko.getVitalidad());
        System.out.println("Estamina disponible: " + pikachu.getEstamina());
    }
    @FXML
    public void descansar(){
        pikachu.descansar();
        if(pikachu.getEstamina() < 20){
            System.out.println("Has recuperado 5 de estamina");
        }

    }

    @FXML
    public void aprenderMovimiento(){
        pikachu.rellenarListaCuatroAtaques();
        if(pikachu.getNivel() == 1){
            System.out.println(pikachu.getListaCuatroAtaques().get(0));
        } else if (pikachu.getNivel() == 2) {
            for(int i = 0; i < 2;i++){
                System.out.println(pikachu.getListaCuatroAtaques().get(i));
            }
        } else if (pikachu.getNivel() == 3) {
            for(int i = 0; i < 3;i++){
                System.out.println(pikachu.getListaCuatroAtaques().get(i));
            }
        } else if (pikachu.getNivel() == 4) {
            for(int i = 0; i < 3;i++){
                System.out.println(pikachu.getListaCuatroAtaques().get(i));
            }
        }
    }

    @FXML public void getCaja() {
        entrenador.getCaja();
    }

}
