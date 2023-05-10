package org.proyectopokemon.model;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Login {

    private boolean login;

    public boolean comprobarCredenciales(TextField txtFldUsuario, TextField txtFldContrasenya, Label lblComprobacion) {

        if (txtFldUsuario.getText().equals("1") && txtFldContrasenya.getText().equals("1")) {
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
}
