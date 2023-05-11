package org.proyectopokemon.model;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Login {

    private static String usuario;
    private static String contrasenya;
    private boolean login;
    private boolean registro;

    public boolean comprobarCredenciales(TextField txtFldUsuario, TextField txtFldContrasenya, Label lblComprobacion) {

        if (txtFldUsuario.getText().equals(this.usuario) && txtFldContrasenya.getText().equals(this.contrasenya)) {
            this.login = true;
        }
        else if (txtFldUsuario.getText().isEmpty() || txtFldContrasenya.getText().isEmpty()) {
            this.login = false;
            lblComprobacion.setText("Rellena correctamente los campos");
        }
        else {
            this.login = false;
            lblComprobacion.setText("Error");
        }
        return login;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public boolean comprobarRegistro(TextField txtFldUsuario, TextField txtFldContrasenya, Label lbl){
        if (txtFldUsuario.getText().isEmpty() || txtFldContrasenya.getText().isEmpty()) {
            this.login = false;
            lbl.setText("No puedes introducir campos vacíos");
        }
        else {
            this.login = true;
        }
        return login;
    }

}
