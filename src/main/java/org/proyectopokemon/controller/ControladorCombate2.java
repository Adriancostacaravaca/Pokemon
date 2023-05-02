package org.proyectopokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.proyectopokemon.controller.factories.ElegirMovimientoCeldas;
import org.proyectopokemon.controller.factories.ElegirPokemonCeldas;
import org.proyectopokemon.model.Pokedex;
import org.proyectopokemon.model.Pokemon;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.Objects;

public class ControladorCombate2 {

    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private Button btnVolver;
    @FXML
    private Label lblMiPokemon;
    @FXML
    private Label lblPokemonRival;
    @FXML
    private ImageView imagenP1;
    @FXML
    private ImageView imagenP2;
    @FXML
    private Button btnPelear;
    @FXML
    private Button btnAtaque1;
    @FXML
    private Button btnAtaque2;
    @FXML
    private Button btnAtaque3;
    @FXML
    private Button btnAtaque4;
    private Pokedex pokedex;
    private Pokemon p;
    private Media combatePokemonSalvaje = new Media(Paths.get("src/main/resources/musica/combatePokemonSalvaje.mp3").toUri().toString());
    private MediaPlayer mediaPlayer = new MediaPlayer(combatePokemonSalvaje);
    @FXML
    private ProgressBar vitalidadMiPokemon = new ProgressBar();
    private double progress;
    @FXML
    private Label lblMiPokemonVitalidad;
    @FXML
    private Label lblMiPokemonEstamina;

    public void initialize(){
        musicaCombate();
        pokedex = new Pokedex();
        pokedex.rellenarPokedex();
        pokemonACombatir();
        mostrarNombresPokemon();
        mostrarEstaminaYVitalidad();
        }

    @FXML
    private void musicaCombate() {
        mediaPlayer.play();
    }

    @FXML
    public void volverAVentanaPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menuprincipal.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Pokemon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        mediaPlayer.stop();
    }
    @FXML
    public void volverAVentanaAnterior(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCombate.fxml")));
        scene = new Scene(root, 650, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Pokemon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        mediaPlayer.stop();
    }

    // MOSTRAMOS LOS NOMBRES DE LOS POKEMON ENCIMA DE SU IMAGEN
    // FIXME: MUESTRA EL NOMBRE DE UN POKEMON PORQUE SOLO CREAMOS UN OBJETO POKEMON
    @FXML
    public void mostrarNombresPokemon(){
            lblMiPokemon.setText(p.getNombre());
            lblPokemonRival.setText(p.getNombre());
    }

    @FXML
    public void pokemonAzar(){
        p = pokedex.presentarPokemonAzar();
    }
    @FXML
    public void pokemonACombatir() {
        pokemonAzar();
        imagenP1.setImage(p.getImage());
        imagenP2.setImage(p.getImage());
    }

    @FXML
    public void mostrarVidaEnProgressBar(){
        progress += 0.1;
        vitalidadMiPokemon.setProgress(progress);
    }

    public void mostrarEstaminaYVitalidad(){
        lblMiPokemonEstamina.setText("Estamina: " + p.getEstamina());
        lblMiPokemonVitalidad.setText("Vitalidad: " + p.getVitalidad());
    }

    public void combatir() {
        mostrarVidaEnProgressBar();
        p.atacarAPokemon(p);
        mostrarEstaminaYVitalidad();
    }

    @FXML
    public void descansar(){
        p.descansar();
        mostrarEstaminaYVitalidad();
        if(p.getEstamina() < 20){
            System.out.println("Has recuperado 5 de estamina");
        }
    }
}
