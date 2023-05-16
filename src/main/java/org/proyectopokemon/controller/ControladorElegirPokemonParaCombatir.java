package org.proyectopokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.proyectopokemon.logger.Logger;
import org.proyectopokemon.pokemon.Entrenador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControladorElegirPokemonParaCombatir {
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private Label lblTuEquipo;
    @FXML
    private Button btnPokemon1;
    @FXML
    private Button btnPokemon2;
    @FXML
    private Button btnPokemon3;
    @FXML
    private Button btnPokemon4;
    @FXML
    private Button btnPokemon5;
    @FXML
    private Button btnPokemon6;

    private List<Button> botones;

    public void initialize(){
        botones = new ArrayList<>();
        botones.add(this.btnPokemon1);
        botones.add(this.btnPokemon2);
        botones.add(this.btnPokemon3);
        botones.add(this.btnPokemon4);
        botones.add(this.btnPokemon5);
        botones.add(this.btnPokemon6);

        // RECORRE EL EQUIPO DEL ENTRENADOR Y VA HABILITANDO BOTONES CONFORME ENCUENTRA LOS POKEMON
        for (int i = 0; i < botones.size(); i++) {
            botones.get(i).setDisable(true);
        }
        for(int i = 0; i < Entrenador.miEntrenador.getEquipoPrincipal().size(); i++){
            if(Entrenador.miEntrenador.getEquipoPrincipal().get(i) != null){
                botones.get(i).setDisable(false);
                botones.get(i).setText(Entrenador.miEntrenador.getEquipoPrincipal().get(i).getNombre());
            }
        }
    }
    @FXML
    public void elegirPokemon1(ActionEvent event) throws IOException {
        ControladorCombate2.setPokemonElegido(Entrenador.miEntrenador.getEquipoPrincipal().get(0));
        Logger.write("Haz Elegido " + Entrenador.miEntrenador.getEquipoPrincipal().get(0).getNombre() + " para combatir");
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCombate2.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Centro Pokémon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void elegirPokemon2(ActionEvent event) throws IOException {
        ControladorCombate2.setPokemonElegido(Entrenador.miEntrenador.getEquipoPrincipal().get(1));
        Logger.write("Haz Elegido " + Entrenador.miEntrenador.getEquipoPrincipal().get(1).getNombre() + " para combatir");
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCombate2.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Centro Pokémon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void elegirPokemon3(ActionEvent event) throws IOException {
        ControladorCombate2.setPokemonElegido(Entrenador.miEntrenador.getEquipoPrincipal().get(2));
        Logger.write("Haz Elegido " + Entrenador.miEntrenador.getEquipoPrincipal().get(2).getNombre() + " para combatir");
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCombate2.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Centro Pokémon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void elegirPokemon4(ActionEvent event) throws IOException {
        ControladorCombate2.setPokemonElegido(Entrenador.miEntrenador.getEquipoPrincipal().get(3));
        Logger.write("Haz Elegido " + Entrenador.miEntrenador.getEquipoPrincipal().get(3).getNombre() + " para combatir");
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCombate2.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Centro Pokémon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void elegirPokemon5(ActionEvent event) throws IOException {
        ControladorCombate2.setPokemonElegido(Entrenador.miEntrenador.getEquipoPrincipal().get(4));
        Logger.write("Haz Elegido " + Entrenador.miEntrenador.getEquipoPrincipal().get(4).getNombre() + " para combatir");
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCombate2.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Centro Pokémon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void elegirPokemon6(ActionEvent event) throws IOException {
        ControladorCombate2.setPokemonElegido(Entrenador.miEntrenador.getEquipoPrincipal().get(5));
        Logger.write("Haz Elegido " + Entrenador.miEntrenador.getEquipoPrincipal().get(5).getNombre() + " para combatir");
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCombate2.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Centro Pokémon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
