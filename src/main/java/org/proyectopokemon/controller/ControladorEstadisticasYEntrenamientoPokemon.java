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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.proyectopokemon.logger.Logger;
import org.proyectopokemon.pokemon.Entrenador;
import org.proyectopokemon.pokemon.Entrenamiento;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.DecimalFormat;
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
    @FXML
    private Button btnObj1;
    private List<Button> botones;
    private List<Button> objetos;
    @FXML
    private Label lblPokedolares;
    private Entrenamiento entrenamiento = new Entrenamiento();
    private static final DecimalFormat decfor = new DecimalFormat("0.00");
    private Media musicaEfecto = new Media(Paths.get("src/main/resources/musica/efectoEntrenamiento.mp3").toUri().toString());
    private MediaPlayer mediaPlayer = new MediaPlayer(musicaEfecto);

    public void initialize() throws IOException {
        Logger.write("Estás revisando las estadísticas de tu Pokémon y puede que elijas entrenarlos");
        musicaEfecto();
        botones = new ArrayList<>();
        botones.add(this.btnPokemon1);
        botones.add(this.btnPokemon2);
        botones.add(this.btnPokemon3);
        botones.add(this.btnPokemon4);
        botones.add(this.btnPokemon5);
        botones.add(this.btnPokemon6);
        objetos = new ArrayList<>();
        objetos.add(this.btnObj1);
        for (int i = 0; i < botones.size(); i++) {
            this.botones.get(i).setDisable(true);
        }
        if (Entrenador.miEntrenador.getCajaObjetos().size() < 1) {
            btnObj1.setDisable(true);
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
        mediaPlayer.stop();
    }
    @FXML
    private void musicaEfecto() {
        mediaPlayer.play();
    }
    @FXML
    public void aplicarObjetoAPokemon(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaElegirObjetoAAplicar.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Elegir Objeto - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public void actualizarEstadisticas(){
        lblNombre.setText(entrenamiento.getPokemonElegido().getNombre());
        lblAtaque.setText("Ataque: " + decfor.format(entrenamiento.getPokemonElegido().getAtaque()));
        lblDefensa.setText("Defensa: " + decfor.format(entrenamiento.getPokemonElegido().getDefensa()));
        lblAtaqueEsp.setText("Ataque Especial: " + decfor.format(entrenamiento.getPokemonElegido().getAtaqueEsp()));
        lblDefensaEsp.setText("Defensa Especial: " + decfor.format(entrenamiento.getPokemonElegido().getDefensaEsp()));
        lblVitalidad.setText("Vitalidad: " + decfor.format(entrenamiento.getPokemonElegido().getVitalidad()));
        lblVelocidad.setText("Velocidad: " + decfor.format(entrenamiento.getPokemonElegido().getVelocidad()));
        lblNivel.setText("Nivel: " + entrenamiento.getPokemonElegido().getNivel());
        imageViewPokemon.setImage(entrenamiento.getPokemonElegido().getImage());
        lblPokedolares.setText("Pokedólares: " + Entrenador.miEntrenador.getPokedollar());
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

    public void escogerPokemon1() throws IOException {
        entrenamiento.setPokemonElegido(Entrenador.miEntrenador.getEquipoPrincipal().get(0));
        actualizarEstadisticas();
        Logger.write("Has elegido a " + Entrenador.miEntrenador.getEquipoPrincipal().get(0).getNombre() + " para entrenar");
    }
    public void escogerPokemon2() throws IOException {
        entrenamiento.setPokemonElegido(Entrenador.miEntrenador.getEquipoPrincipal().get(1));
        actualizarEstadisticas();
        Logger.write("Has elegido a " + Entrenador.miEntrenador.getEquipoPrincipal().get(1).getNombre() + " para entrenar");
    }
    public void escogerPokemon3() throws IOException {
        entrenamiento.setPokemonElegido(Entrenador.miEntrenador.getEquipoPrincipal().get(2));
        actualizarEstadisticas();
        Logger.write("Has elegido a " + Entrenador.miEntrenador.getEquipoPrincipal().get(2).getNombre() + " para entrenar");
    }
    public void escogerPokemon4() throws IOException {
        entrenamiento.setPokemonElegido(Entrenador.miEntrenador.getEquipoPrincipal().get(3));
        actualizarEstadisticas();
        Logger.write("Has elegido a " + Entrenador.miEntrenador.getEquipoPrincipal().get(3).getNombre() + " para entrenar");
    }
    public void escogerPokemon5() throws IOException {
        entrenamiento.setPokemonElegido(Entrenador.miEntrenador.getEquipoPrincipal().get(4));
        actualizarEstadisticas();
        Logger.write("Has elegido a " + Entrenador.miEntrenador.getEquipoPrincipal().get(4).getNombre() + " para entrenar");
    }
    public void escogerPokemon6() throws IOException {
        entrenamiento.setPokemonElegido(Entrenador.miEntrenador.getEquipoPrincipal().get(5));
        actualizarEstadisticas();
        Logger.write("Has elegido a " + Entrenador.miEntrenador.getEquipoPrincipal().get(5).getNombre() + " para entrenar");
    }

    @FXML
    public void aplicarEntPesado() throws IOException {
        Logger.write("Le has aplicado un entrenamiento pesado a " + entrenamiento.getPokemonElegido().getNombre());
        entrenamiento.aplicarEntPesado();
        actualizarEstadisticas();
    }
    @FXML
    public void aplicarEntFurioso() throws IOException {
        Logger.write("Le has aplicado un entrenamiento furioso a " + entrenamiento.getPokemonElegido().getNombre());
        entrenamiento.aplicarEntFurioso();
        actualizarEstadisticas();
    }
    @FXML
    public void aplicarEntFuncional() throws IOException {
        Logger.write("Le has aplicado un entrenamiento funcional a " + entrenamiento.getPokemonElegido().getNombre());
        entrenamiento.aplicarEntFuncional();
        actualizarEstadisticas();
    }
    @FXML
    public void aplicarEntOnirico() throws IOException {
        Logger.write("Le has aplicado un entrenamiento onírico a " + entrenamiento.getPokemonElegido().getNombre());
        entrenamiento.aplicarEntOnirico();
        actualizarEstadisticas();
    }

}
