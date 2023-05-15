package org.proyectopokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.proyectopokemon.model.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
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
    private List<Button> botones;
    private MovimientosDisponiblesParaPokemon movimientosDisponiblesParaPokemon;
    private int posicionActual;
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
    @FXML
    private Label lblRivalPokemonVitalidad;
    @FXML
    private Label lblRivalPokemonEstamina;

    public void initialize(){
        posicionActual  = 0;
        cambiarPosicionActual();
        movimientosDisponiblesParaPokemon = new MovimientosDisponiblesParaPokemon();
        botones = new ArrayList<>();
        botones.add(btnAtaque1);
        botones.add(btnAtaque2);
        botones.add(btnAtaque3);
        botones.add(btnAtaque4);
        musicaCombate();
        pokedex = new Pokedex();

        rellenarAtaques();
        nombrarAtaques();
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
    public void volverAVentanaAnterior(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaCombate.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Pokemon - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        mediaPlayer.stop();
    }

    @FXML
    public void mostrarNombresPokemon(){
            lblMiPokemon.setText(Combate.getP().getNombre());
            lblPokemonRival.setText(Entrenador.rivalEntrenador1.getEquipoPrincipal().get(0).getNombre());
    }

    @FXML
    public void pokemonACombatir() {
        imagenP1.setImage(Combate.getP().getImage());
        imagenP2.setImage(Entrenador.rivalEntrenador1.getEquipoPrincipal().get(0).getImage());
    }

    public void mostrarEstaminaYVitalidad(){
        lblMiPokemonEstamina.setText("Estamina: " + Combate.getP().getEstamina());
        lblMiPokemonVitalidad.setText("Vitalidad: " + Combate.getP().getVitalidad());
        lblRivalPokemonEstamina.setText("Estamina: " + Combate.getP().getEstamina());
        lblRivalPokemonVitalidad.setText("Vitalidad: " + Combate.getP().getVitalidad());
    }

    public void combatir() {
        Combate.getP().atacarAPokemon(Entrenador.rivalEntrenador1.getEquipoPrincipal().get(posicionActual));
        mostrarEstaminaYVitalidad();
    }

    @FXML
    public void descansar(){
        Combate.getP().descansar();
        mostrarEstaminaYVitalidad();
    }
    public void rellenarAtaques(){
        for(int i = 0; i < Entrenador.miEntrenador.getEquipoPrincipal().size(); i++){
            Combate.getP().rellenarAtaques();
        }
    }

    public void nombrarAtaques(){
        for(int i = 0; i < botones.size();i++){
            botones.get(i).setText(Combate.getP().getListaCuatroAtaques().get(i).getNombre());
        }
        System.out.println(Entrenador.miEntrenador.getEquipoPrincipal().get(0).getListaCuatroAtaques().toString());
    }

    public void cambiarPosicionActual(){
        posicionActual++;
        if(posicionActual > Entrenador.miEntrenador.getEquipoPrincipal().size()){
            posicionActual = 0;
        }
        Combate.setP(Entrenador.miEntrenador.getEquipoPrincipal().get(posicionActual));
        pokemonACombatir();
        mostrarNombresPokemon();
        mostrarEstaminaYVitalidad();

    }





}
