package org.proyectopokemon.model;

import javafx.scene.control.TextField;

public class Login {

    public boolean comprobarCredenciales(TextField txtFldUsuario, TextField txtFldContraseña) {

        if (txtFldUsuario.equals(txtFldUsuario) && txtFldContraseña.equals(txtFldContraseña)) {
            return true;
        }
        return false;
    }
}
