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
import org.proyectopokemon.model.Entrenamiento;

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
        actualizarEstadisticasPkm1();
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

    public void actualizarEstadisticasPkm1(){
        lblNombre.setText(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getNombre());
        lblAtaque.setText("Ataque: " + Entrenador.miEntrenador.getEquipoPrincipal().get(0).getAtaque());
        lblDefensa.setText("Defensa: " + Entrenador.miEntrenador.getEquipoPrincipal().get(0).getDefensa());
        lblAtaqueEsp.setText("Ataque Especial: " + Entrenador.miEntrenador.getEquipoPrincipal().get(0).getAtaqueEsp());
        lblDefensaEsp.setText("Defensa Especial: " + Entrenador.miEntrenador.getEquipoPrincipal().get(0).getDefensaEsp());
        lblVitalidad.setText("Vitalidad: " + Entrenador.miEntrenador.getEquipoPrincipal().get(0).getVitalidad());
        lblVelocidad.setText("Velocidad: " + Entrenador.miEntrenador.getEquipoPrincipal().get(0).getVelocidad());
        lblNivel.setText("Nivel: " + Entrenador.miEntrenador.getEquipoPrincipal().get(0).getNivel());
        imageViewPokemon.setImage(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getImage());
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
    @FXML
    public void aplicarEntPesado(){
        entrenamiento.aplicarEntPesado();
    }
    @FXML
    public void aplicarEntFurioso(){
        entrenamiento.aplicarEntFurioso();
    }
    @FXML
    public void aplicarEntFuncional(){
        entrenamiento.aplicarEntFuncional();
    }
    @FXML
    public void aplicarEntOnirico(){
        entrenamiento.aplicarEntOnirico();
    }

}
