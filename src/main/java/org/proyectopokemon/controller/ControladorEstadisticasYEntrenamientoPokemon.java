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
import org.proyectopokemon.pokemon.Entrenador;
import org.proyectopokemon.pokemon.Entrenamiento;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControladorEstadisticasYEntrenamientoPokemon {

    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private Label lblNombre;
    @FXML
    private Label lblVitalidad;
    @FXML
    private Label lblAtaque;
    @FXML
    private Label lblDefensa;
    @FXML
    private Label lblAtaqueEsp;
    @FXML
    private Label lblDefensaEsp;
    @FXML
    private Label lblVelocidad;
    @FXML
    private Label lblNivel;
    @FXML
    private ImageView imageViewPokemon;
    @FXML
    private Button btnVolver;
    @FXML
    private Button btnEnt1;
    @FXML
    private Button btnEnt2;
    @FXML
    private Button btnEnt3;
    @FXML
    private Button btnEnt4;
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
    @FXML
    private Label lblPokedolares;
    private Entrenamiento entrenamiento = new Entrenamiento();

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
        escogerPokemon1();
    }

    @FXML
    public void volverAVentanaAnterior(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCentroPokemon.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Pokemon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public void actualizarEstadisticas(){
        lblNombre.setText(entrenamiento.getPokemonElegido().getNombre());
        lblAtaque.setText("Ataque: " + entrenamiento.getPokemonElegido().getAtaque());
        lblDefensa.setText("Defensa: " + entrenamiento.getPokemonElegido().getDefensa());
        lblAtaqueEsp.setText("Ataque Especial: " + entrenamiento.getPokemonElegido().getAtaqueEsp());
        lblDefensaEsp.setText("Defensa Especial: " + entrenamiento.getPokemonElegido().getDefensaEsp());
        lblVitalidad.setText("Vitalidad: " + entrenamiento.getPokemonElegido().getVitalidad());
        lblVelocidad.setText("Velocidad: " + entrenamiento.getPokemonElegido().getVelocidad());
        lblNivel.setText("Nivel: " + entrenamiento.getPokemonElegido().getNivel());
        imageViewPokemon.setImage(entrenamiento.getPokemonElegido().getImage());
        lblPokedolares.setText("Pokedolares: " + Entrenador.miEntrenador.getPokedollar());
        if (Entrenador.miEntrenador.getPokedollar() < 40) {
            btnEnt3.setDisable(true);
            btnEnt4.setDisable(true);
        }
        if (Entrenador.miEntrenador.getPokedollar() < 30) {
            btnEnt2.setDisable(true);
            btnEnt3.setDisable(true);
            btnEnt4.setDisable(true);
        }
        if (Entrenador.miEntrenador.getPokedollar() < 20) {
            btnEnt1.setDisable(true);
            btnEnt2.setDisable(true);
            btnEnt3.setDisable(true);
            btnEnt4.setDisable(true);
        }
    }

    public void escogerPokemon1(){
        entrenamiento.setPokemonElegido(Entrenador.miEntrenador.getEquipoPrincipal().get(0));
        actualizarEstadisticas();
    }
    public void escogerPokemon2(){
        entrenamiento.setPokemonElegido(Entrenador.miEntrenador.getEquipoPrincipal().get(1));
        actualizarEstadisticas();
    }
    public void escogerPokemon3(){
        entrenamiento.setPokemonElegido(Entrenador.miEntrenador.getEquipoPrincipal().get(2));
        actualizarEstadisticas();
    }
    public void escogerPokemon4(){
        entrenamiento.setPokemonElegido(Entrenador.miEntrenador.getEquipoPrincipal().get(3));
        actualizarEstadisticas();
    }
    public void escogerPokemon5(){
        entrenamiento.setPokemonElegido(Entrenador.miEntrenador.getEquipoPrincipal().get(4));
        actualizarEstadisticas();
    }
    public void escogerPokemon6(){
        entrenamiento.setPokemonElegido(Entrenador.miEntrenador.getEquipoPrincipal().get(5));
        actualizarEstadisticas();
    }

    @FXML
    public void aplicarEntPesado(){
        entrenamiento.aplicarEntPesado();
        actualizarEstadisticas();
    }
    @FXML
    public void aplicarEntFurioso(){
        entrenamiento.aplicarEntFurioso();
        actualizarEstadisticas();
    }
    @FXML
    public void aplicarEntFuncional(){
        entrenamiento.aplicarEntFuncional();
        actualizarEstadisticas();
    }
    @FXML
    public void aplicarEntOnirico(){
        entrenamiento.aplicarEntOnirico();
        actualizarEstadisticas();
    }

}
