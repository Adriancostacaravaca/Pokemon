package org.proyectopokemon.model;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Login {

    private static String usuario;
    private static String contrasenya;
    private boolean login;

    /**
     * MÉTODO PARA COMPROBAR QUE LAS CREDENCIALES INTRODUCIDAS EN EL REGISTRO CONCUERDAN CON LAS INTRODUCIDAS EN EL LOGIN
     * SI CONCUERDAN, EL BOOLEAN DEVUELVE VERDADERO Y SINO, FALSO
     * @param txtFldUsuario TEXT DONDE ESTÁ EL NOMBRE DE USUARIO
     * @param txtFldContrasenya TEXT DONDE ESTÁ LA CONTRASEÑA
     * @param lblComprobacion LABEL DONDE MOSTRAREMOS UN MENSAJE DANDO DETALLES RESPECTO AL LOGIN
     * @return DEVUELVE VERDADERO SI CONCUERDAN LAS CREDENCIALES Y FALSO EN CASO ERRÓNEO
     */

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

    /**
     * MÉTODO PARA CREAR UN NUEVO USUARIO CON EL QUE PODREMOS INTRODUCIR LOS DATOS EN EL LOGIN
     * @param txtFldUsuario TEXT DONDE INTRODUCIREMOS EL NOMBRE DE USUARIO
     * @param txtFldContrasenya TEXT DONDE INTRODUCIREMOS LA CONTRASEÑA
     * @param lbl LABEL DONDE MOSTRAREMOS UN MENSAJE DANDO DETALLES RESPECTO AL REGISTRO
     * @return BOOLEAN QUE SE PONDRÁ COMO VERDADERO SI NOS HEMOS REGISTRADO CORRECTAMENTE, DANDO PASO AL LOGIN
     */

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
