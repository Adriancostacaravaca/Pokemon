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
import javafx.stage.Stage;
import org.proyectopokemon.model.Login;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

public class ControladorRegistro {

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
    private ImageView imagenUsuario;
    @FXML
    private ImageView imagenPk1;
    @FXML
    private Label lblComprobacion;
    private Login login = new Login();
    private boolean registroCorrecto = false;

    public void initialize() {
        File f = new File("src/main/resources/imagenes/iconoUsuario.png");
        Image image = new Image(f.toURI().toString());
        imagenUsuario.setImage(image);
        File y = new File("src/main/resources/imagenes/PokeballConSombra.png");
        Image imagen2 = new Image(y.toURI().toString());
        imagenPk1.setImage(imagen2);
    }

    @FXML
    public void irAVentanaLogin(ActionEvent event) throws IOException {
        if (login.comprobarRegistro(txtUsuario, txtContrasenya, lblComprobacion)) {
            registrarUsuario();
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/VentanaLogin.fxml")));
            scene = new Scene(root, 459, 533);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Login - The Crüe");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void registrarUsuario() {
        login.setUsuario(this.txtUsuario.getText());
        login.setContrasenya(this.txtContrasenya.getText());
    }
}