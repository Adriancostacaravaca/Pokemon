package org.proyectopokemon.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.proyectopokemon.logger.Logger;
import org.proyectopokemon.pokemon.Login;

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
    private Label lblContrasenya;
    @FXML
    private PasswordField txtContrasenya;
    @FXML
    private Label lblComprobacion;
    @FXML
    private ImageView imagenUsuario;
    @FXML
    private Hyperlink hyperLinkCredenciales;
    private Login login = new Login();
    private Media musicaMenuPrincipal = new Media(Paths.get("src/main/resources/musica/musicaLogin.mp3").toUri().toString());
    private MediaPlayer mediaPlayer = new MediaPlayer(musicaMenuPrincipal);

    public void initialize() throws IOException {
        Logger.write("Has entrado al login");
        File f = new File("src/main/resources/imagenes/iconoUsuario.png");
        Image image = new Image(f.toURI().toString());
        imagenUsuario.setImage(image);
        musicaLogin();
    }

    // MÚSICA DEL LOGIN
    @FXML
    private void musicaLogin() {
        mediaPlayer.play();
    }

    @FXML
    public void irAVentanaAplicacion(ActionEvent event) throws IOException {
        if (login.comprobarCredenciales(txtUsuario, txtContrasenya, lblComprobacion)) {
            Logger.write("Las credenciales introducidas son correctas");
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Menuprincipal.fxml")));
            scene = new Scene(root, 788, 477);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Menú Principal - The Crüe");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
            mediaPlayer.stop();
        }
    }
    @FXML
    public void olvidarCredenciales(ActionEvent event) throws IOException {
            Logger.write("No te acuerdas de las credenciales");
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaRegistro.fxml")));
            scene = new Scene(root, 419, 491);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Registro - The Crüe");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
            mediaPlayer.stop();
    }
}
