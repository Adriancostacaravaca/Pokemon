package org.proyectopokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import org.proyectopokemon.model.Login;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

public class ControladorLogin {

    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    private Button btnEntrar;
    @FXML
    private Label lblUsuario;
    @FXML
    private TextField txtUsuario;
    @FXML
    private Label lblContraseña;
    @FXML
    private PasswordField txtContraseña;
    @FXML
    private Label lblComprobacion;
    @FXML
    private ImageView imagenUsuario;
    private Login login = new Login();

    public void initialize() {
        File f = new File("src/main/resources/imagenes/iconoUsuario.png"); // FIXME: RESPONSIVE, CAMBIAR ATRIBUTO PRESERVE RATIO EN SCENE BUILDER
        Image image = new Image(f.toURI().toString());
        imagenUsuario.setImage(image);
        musicaInicio();
    }

    @FXML
    private void musicaInicio() {
        Media m = new Media(Paths.get("src/main/resources/musica/pokemonLogin.mp3").toUri().toString());
        new MediaPlayer(m).play();
    }

    @FXML
    public void irAVentanaAplicacion(ActionEvent event) throws IOException {
        if (login.comprobarCredenciales(txtUsuario, txtContraseña, lblComprobacion)) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menuprincipal.fxml")));
            scene = new Scene(root, 650, 400);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("The Crüe - Menú Principal");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }
    }
}
