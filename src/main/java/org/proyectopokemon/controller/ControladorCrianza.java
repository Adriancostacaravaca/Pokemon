package org.proyectopokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.proyectopokemon.model.Entrenador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControladorCrianza {

    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private Button btnVolver;
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
    private Button btnCriar;
    @FXML
    private ImageView imageViewPokemon1;
    @FXML
    private ImageView imageViewPokemon2;
    @FXML
    private Label lblCoste;
    @FXML
    private Label lblPokedolares;
    private List<Button> botones;

    public void initialize() {
        botones = new ArrayList<>();
        botones.add(this.btnPokemon1);
        botones.add(this.btnPokemon2);
        botones.add(this.btnPokemon3);
        botones.add(this.btnPokemon4);
        botones.add(this.btnPokemon5);
        botones.add(this.btnPokemon6);

        for (int i = 0; i < Entrenador.miEntrenador.getEquipoPrincipal().size(); i++) {
            if (Entrenador.miEntrenador.getEquipoPrincipal().get(i) != null) {
                botones.get(i).setText(Entrenador.miEntrenador.getEquipoPrincipal().get(i).getNombre());
            } else {
                System.out.println("error");
            }
        }
    }

    @FXML
    public void volverAVentanaAnterior(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCentroPokemon.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Pokemon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        actualizarDinero();
    }

    // ACTUALIZAMOS NUESTRO DINERO
    public void actualizarDinero() {
        lblCoste.setText("Coste: 800");
        lblPokedolares.setText("Pokedólares: " + Entrenador.miEntrenador.getPokedollar());
    }

    // MÉTODO PARA REALIZAR LA CRIANZA ENTRE DOS POKÉMON
    public void criar() {
        Entrenador.miEntrenador.criar();
        actualizarDinero();
    }

    public void motrarImg1() {
        if (Entrenador.miEntrenador.getEquipoPrincipal().size() < 1) {
            System.out.println("No hay ningun pokemon aqui");
        }else if (botones.get(0).getText() == Entrenador.miEntrenador.getEquipoPrincipal().get(0).getNombre()){
            imageViewPokemon1.setImage(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getImage());
        }
    }

    public void motrarImg2() {
        if (Entrenador.miEntrenador.getEquipoPrincipal().size() < 2) {
            System.out.println("No hay ningun pokemon aqui");
        }else if (botones.get(1).getText() == Entrenador.miEntrenador.getEquipoPrincipal().get(1).getNombre()){
            imageViewPokemon1.setImage(Entrenador.miEntrenador.getEquipoPrincipal().get(1).getImage());
        }
    }

    public void motrarImg3() {
        if (Entrenador.miEntrenador.getEquipoPrincipal().size() < 3) {
            System.out.println("No hay ningun pokemon aqui");
        }else if (botones.get(2).getText() == Entrenador.miEntrenador.getEquipoPrincipal().get(2).getNombre()){
            imageViewPokemon1.setImage(Entrenador.miEntrenador.getEquipoPrincipal().get(2).getImage());
        }
    }

    public void motrarImg4() {
        if (Entrenador.miEntrenador.getEquipoPrincipal().size() < 4) {
            System.out.println("No hay ningun pokemon aqui");
        }else if (botones.get(3).getText() == Entrenador.miEntrenador.getEquipoPrincipal().get(3).getNombre()){
            imageViewPokemon2.setImage(Entrenador.miEntrenador.getEquipoPrincipal().get(3).getImage());
        }
    }

    public void motrarImg5() {
        if (Entrenador.miEntrenador.getEquipoPrincipal().size() < 5) {
            System.out.println("No hay ningun pokemon aqui");
        }else if (botones.get(4).getText() == Entrenador.miEntrenador.getEquipoPrincipal().get(4).getNombre()){
            imageViewPokemon2.setImage(Entrenador.miEntrenador.getEquipoPrincipal().get(4).getImage());
        }
    }

    public void motrarImg6() {
        if (Entrenador.miEntrenador.getEquipoPrincipal().size() < 6) {
            System.out.println("No hay ningun pokemon aqui");
        }else if (botones.get(5).getText() == Entrenador.miEntrenador.getEquipoPrincipal().get(5).getNombre()){
            imageViewPokemon2.setImage(Entrenador.miEntrenador.getEquipoPrincipal().get(5).getImage());
        }
    }
}
