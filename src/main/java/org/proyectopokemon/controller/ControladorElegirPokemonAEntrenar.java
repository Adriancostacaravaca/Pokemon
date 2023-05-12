package org.proyectopokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.proyectopokemon.model.Entrenador;
import org.proyectopokemon.model.Pokemon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControladorElegirPokemonAEntrenar {

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
    @FXML
    private Button btnVolver;
    @FXML
    private Button btnEntrenar;
    private List<Button> botones;
    private static String nombre;
    private static int ataque;
    private static int vitalidad;
    private static int defensa;
    private static int velocidad;
    private static Image image;
    @FXML
    public void volverAVentanaAnterior(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaMochila.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Centro Pokémon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(){
        botones = new ArrayList<>();
        botones.add(this.btnPokemon1);
        botones.add(this.btnPokemon2);
        botones.add(this.btnPokemon3);
        botones.add(this.btnPokemon4);
        botones.add(this.btnPokemon5);
        botones.add(this.btnPokemon6);
        for (int i = 0; i < botones.size(); i++) {
            this.botones.get(i).setDisable(true);
        }

        // RECORRE EL EQUIPO DEL ENTRENADOR Y VA HABILITANDO BOTONES CONFORME ENCUENTRA LOS POKEMON

        for(int i = 0; i < Entrenador.miEntrenador.getEquipoPrincipal().size(); i++){
            if(Entrenador.miEntrenador.getEquipoPrincipal().get(i) != null){
                botones.get(i).setText(Entrenador.miEntrenador.getEquipoPrincipal().get(i).getNombre());
                botones.get(i).setDisable(false);
            }
        }
        recogerEstadisticas();
    }

    @FXML
    public void irAVentanaElegirPokemonAEntrenar(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaEstadisticasYEntrenamientoPokemon.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Entrenamiento Pokémon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void recogerEstadisticas(){
        for (int i = 0; i < Entrenador.miEntrenador.getEquipoPrincipal().size(); i++) {
            if (this.btnPokemon1.getText() == Entrenador.miEntrenador.getEquipoPrincipal().get(0).getNombre()){
                this.nombre = Entrenador.miEntrenador.getEquipoPrincipal().get(i).getNombre();
                this.ataque = Entrenador.miEntrenador.getEquipoPrincipal().get(i).getAtaque();
                this.vitalidad = Entrenador.miEntrenador.getEquipoPrincipal().get(i).getVitalidad();
                this.defensa = Entrenador.miEntrenador.getEquipoPrincipal().get(i).getDefensa();
                this.velocidad = Entrenador.miEntrenador.getEquipoPrincipal().get(i).getVelocidad();
                this.image = Entrenador.miEntrenador.getEquipoPrincipal().get(i).getImage();
            }
        }
    }

    public static String getNombre() {
        return nombre;
    }

    public static int getVelocidad() {
        return velocidad;
    }

    public static int getDefensa() {
        return defensa;
    }

    public static int getVitalidad() {
        return vitalidad;
    }

    public static int getAtaque() {
        return ataque;
    }

    public static Image getImage() {
        return image;
    }
}
