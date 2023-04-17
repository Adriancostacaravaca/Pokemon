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
    private Pokedex pokedex = new Pokedex();

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
    public void subirNivel(ActionEvent event) throws IOException{
        pokedex.pikachu.subirNivel();
        if (pokedex.pikachu.getExperiencia() == 0 && (pokedex.pikachu.getNivel() == 3 || pokedex.pikachu.getNivel() == 6 || pokedex.pikachu.getNivel() == 9 || pokedex.pikachu.getNivel() == 12)) {
            try{
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaElegirMovimientoAprendido.fxml")));
                scene = new Scene(root, 650, 400);
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                stage.setTitle("Combatir Pokemon");
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("Nivel: " + pokedex.pikachu.getNivel());
        System.out.println("Vitalidad: " + pokedex.pikachu.getVitalidad());
        System.out.println("Ataque: " + pokedex.pikachu.getAtaque());
        System.out.println("Experiencia: " + pokedex.pikachu.getExperiencia());
    }
    @FXML
    public void combatir(){
        pokedex.pikachu.atacarAPokemon(pokedex.treecko);

        System.out.println("Vitalidad de: " + pokedex.treecko.getNombre() + ", " + pokedex.treecko.getVitalidad());
        System.out.println("Estamina disponible: " + pokedex.pikachu.getEstamina());
    }
    @FXML
    public void descansar(){
        pokedex.pikachu.descansar();
        if(pokedex.pikachu.getEstamina() < 20){
            System.out.println("Has recuperado 5 de estamina");
        }

    }

    @FXML
    public void aprenderMovimiento(){
        pokedex.pikachu.rellenarListaCuatroAtaques();
        if(pokedex.pikachu.getNivel() == 1){
            System.out.println(pokedex.pikachu.getListaCuatroAtaques().get(0));
        } else if (pokedex.pikachu.getNivel() == 2) {

            for(int i = 0; i < 2;i++){
                System.out.println(pokedex.pikachu.getListaCuatroAtaques().get(i));
            }
        } else if (pokedex.pikachu.getNivel() == 3) {
            for(int i = 0; i < 3;i++){
                System.out.println(pokedex.pikachu.getListaCuatroAtaques().get(i));
            }
        } else if (pokedex.pikachu.getNivel() == 4) {
            for(int i = 0; i < 3;i++){
                System.out.println(pokedex.pikachu.getListaCuatroAtaques().get(i));
            }
        }
    }

    @FXML public void verCajaEntrenador() {
        Entrenador.jugadorEntrenador.moverACaja(pokedex.treecko);
        Entrenador.jugadorEntrenador.mostrarCaja();
    }

}
