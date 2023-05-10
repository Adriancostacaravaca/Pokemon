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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.proyectopokemon.controller.factories.ElegirMovimientoCeldas;
import org.proyectopokemon.controller.factories.ElegirPokemonCeldas;
import org.proyectopokemon.model.Entrenador;
import org.proyectopokemon.model.Pokedex;
import org.proyectopokemon.model.Pokemon;

import java.io.File;
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
    @FXML
    private Button btnDescansar;
    @FXML
    private Button btnCambiarPokemon;
    @FXML
    private ImageView imageViewFondo;
    @FXML
    private ImageView imageViewVS;
    private Pokedex pokedex;
    private Pokemon p;
    private Media combatePokemonSalvaje = new Media(Paths.get("src/main/resources/musica/combatePokemonSalvaje.mp3").toUri().toString());
    private MediaPlayer mediaPlayer = new MediaPlayer(combatePokemonSalvaje);
    @FXML
    private ProgressBar vitalidadMiPokemon = new ProgressBar();
    @FXML
    private Label lblMiPokemonVitalidad;
    @FXML
    private Label lblMiPokemonEstamina;

    public void initialize(){
        musicaCombate();
        pokedex = new Pokedex();
        pokemonACombatir();
        mostrarNombresPokemon();
        mostrarEstaminaYVitalidad();
        File y = new File("src/main/resources/imagenes/PeleaEntrenador.png");
        Image imagePrincipal = new Image(y.toURI().toString());
        imageViewFondo.setImage(imagePrincipal);
        File x = new File("src/main/resources/imagenes/ImagenVS.png");
        Image imageVS = new Image(x.toURI().toString());
        imageViewVS.setImage(imageVS);
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

    @FXML
    public void mostrarNombresPokemon(){
            lblMiPokemon.setText(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getNombre());
            lblPokemonRival.setText(Entrenador.rivalEntrenador1.getEquipoPrincipal().get(0).getNombre());
    }

    @FXML
    public void pokemonACombatir() {
        imagenP1.setImage(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getImage());
        imagenP2.setImage(Entrenador.rivalEntrenador1.getEquipoPrincipal().get(0).getImage());
    }

    public void mostrarEstaminaYVitalidad(){
        lblMiPokemonEstamina.setText("Estamina: " + Entrenador.miEntrenador.getEquipoPrincipal().get(0).getEstamina());
        lblMiPokemonVitalidad.setText("Vitalidad: " + Entrenador.miEntrenador.getEquipoPrincipal().get(0).getVitalidad());
    }

    public void combatir() {
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).atacarAPokemon(Entrenador.rivalEntrenador1.getEquipoPrincipal().get(0));
        mostrarEstaminaYVitalidad();
    }

    @FXML
    public void descansar(){
        Entrenador.miEntrenador.getEquipoPrincipal().get(0).descansar();
        mostrarEstaminaYVitalidad();
    }
}
