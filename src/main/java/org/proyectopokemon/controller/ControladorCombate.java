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
import org.proyectopokemon.pokemon.Pokedex;

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
    private Label lblErrorEquipoVacio;
    private Pokedex pokedex;

    public void initialize() throws IOException {
        Logger.write("Estás en la ventana previa al combate contra un entrenador");
        pokedex = new Pokedex();
        Entrenador.rivalEntrenador1.rellenarEquipoRival();
        // REVISA EL EQUIPO DEL ENTRENADOR Y HABILITA EL BOTON DE COMBATIR SI HAY UN POKEMON COMO MINIMO

        if(Entrenador.miEntrenador.getEquipoPrincipal().size() < 1){
            btnCombatir.setDisable(true);
            lblErrorEquipoVacio.setText("No hay ningún Pokémon en tu equipo");
        }else {
            btnCombatir.setDisable(false);
            lblErrorEquipoVacio.setText(" ");
        }

    }

    @FXML
    public void volverAVentanaPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menuprincipal.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Menú Principal - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void irACombatir(ActionEvent event) throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCombate2.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Combate Pokémon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void subirNivel(ActionEvent event) throws IOException{
    }
    // FIXME: PETA EL HASHMAP POR ALGÚN MOTIVO QUE DESCONOZCO - ADRIAN
    @FXML
    public void comprobarVentaja() {
        System.out.println(Entrenador.miEntrenador.getEquipoPrincipal().get(0).comprobarVentaja(Entrenador.rivalEntrenador1.getEquipoPrincipal().get(0)));
    }

    @FXML
    public void comprobarEquipoRival(ActionEvent event) throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaEquipoPokemonRival.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Equipo rival - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }




}
