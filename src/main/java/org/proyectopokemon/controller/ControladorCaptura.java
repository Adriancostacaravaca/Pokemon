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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.proyectopokemon.logger.Logger;
import org.proyectopokemon.pokemon.Entrenador;
import org.proyectopokemon.pokemon.Pokedex;
import org.proyectopokemon.pokemon.Pokemon;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

public class ControladorCaptura {
    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    private Button btnVolver;
    @FXML
    private Button btnMostrarPokemon;
    @FXML
    private Button btnCapturar;
    @FXML
    private Label lblPokemon;
    @FXML
    private Label lblIntentos;
    @FXML
    private Label lblComprobacion;
    @FXML
    private ImageView imgPokemonAzar;
    @FXML
    private ImageView imageViewFondo;
    @FXML
    private ImageView imageViewHierba;
    private Pokedex pokedex;
    private Pokemon p;
    private Media musicaCaptura = new Media(Paths.get("src/main/resources/musica/combatePokemonSalvaje.mp3").toUri().toString());
    private MediaPlayer mediaPlayer = new MediaPlayer(musicaCaptura);

    public void initialize() throws IOException {
        Logger.write("Estás en la ventana de captura");
        pokedex = new Pokedex();
        actualizarPokeballs();
        mostrarPokemonACapturar();
        musicaCaptura();
        File x = new File("src/main/resources/imagenes/FondoPrincipal.jpg");
        File y = new File("src/main/resources/imagenes/Hierba.png");
        Image imagePrincipal = new Image(x.toURI().toString());
        Image imageHierba = new Image(y.toURI().toString());
        imageViewFondo.setImage(imagePrincipal);
        imageViewHierba.setImage(imageHierba);
    }

    @FXML
    private void musicaCaptura() {
        mediaPlayer.play();
    }
    @FXML
    public void volverAVentanaPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menuprincipal.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Menú Principal - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        mediaPlayer.stop();
    }

    // MOSTRAR POKEMON CREADOS
    public void actualizarPokeballs() {
        lblIntentos.setText("Pokeballs disponibles: " + Entrenador.miEntrenador.getPokeballs());
    }

    @FXML
    public void nuevoPokemonACapturar(){
        p = pokedex.presentarPokemonAzar();
    }

    @FXML
    public void mostrarPokemonACapturar() throws IOException {
        nuevoPokemonACapturar();
        lblPokemon.setText(p.getNombre());
        imgPokemonAzar.setImage(p.getImage());
        btnCapturar.setDisable(false);
        lblComprobacion.setText(" ");
        Logger.write("Un " + p.getNombre() + " salvaje ha aparecido");
    }

    @FXML
    public void capturar() throws IOException {
        boolean capturaHecha = Entrenador.miEntrenador.capturar(p, lblComprobacion);

        if (capturaHecha) {
            lblComprobacion.setText("¡Has capturado un " + p.getNombre() + " salvaje!");
            btnCapturar.setDisable(true);
            Logger.write("Has capturado un " + p.getNombre() + " salvaje");
        }


        actualizarPokeballs();
    }
}




