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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.proyectopokemon.controller.factories.EquipoPrincipalCeldas;
import org.proyectopokemon.logger.Logger;
import org.proyectopokemon.shop.Objeto;
import org.proyectopokemon.pokemon.Pokedex;
import org.proyectopokemon.pokemon.Pokemon;
import javafx.scene.input.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

public class ControladorPokedex {
    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    private Button btnVolver;
    @FXML
    private ListView<Pokemon> listViewPokemon;
    @FXML
    private ImageView imageViewPokemon;
    @FXML
    private ImageView imageViewFondo;
    private Media musicaFondo = new Media(Paths.get("src/main/resources/musica/musicaPokedex.mp3").toUri().toString());
    private MediaPlayer mediaPlayer = new MediaPlayer(musicaFondo);

    @FXML
    public void volverAVentanaPrincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menuprincipal.fxml")));
        scene = new Scene(root, 788, 477);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Menú Principal - The Crüe");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        mediaPlayer.stop();
    }

    public void initialize() throws IOException {
        Logger.write("Estás en la ventana Pokedex");
        musicaFondo();
        File x = new File("src/main/resources/imagenes/Pokedex.jpg");
        Image imagePrincipal = new Image(x.toURI().toString());
        imageViewFondo.setImage(imagePrincipal);
        listViewPokemon.setItems(Pokedex.getPokedex());
        listViewPokemon.setCellFactory(new EquipoPrincipalCeldas());
    }
    @FXML
    private void musicaFondo() {
        mediaPlayer.play();
    }

    @FXML
    private void onListViewMouseClicked(MouseEvent event){
        Pokemon pokemon = listViewPokemon.getSelectionModel().getSelectedItem();
        if(pokemon != null){
            imageViewPokemon.setImage(pokemon.getImage());
        }
    }


}
