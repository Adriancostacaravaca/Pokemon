package org.proyectopokemon.model;

import java.util.Random;

public class Pokemon {
    private String nombre;
    private String mote;
    private int vitalidad;
    private int ataque;
    private int ataqueEsp;
    private int desfensaEsp;
    private int velocidad;
    private int estamina;
    private int nivel;


    private int fertilidad;
    private char sexo;
    private Tipo tipo;
    private Estado estado;


    public Pokemon(String nombre, String mote,char sexo) {
        this.nombre = nombre;
        this.mote = mote;
        this.vitalidad = vitalidad;
        this.ataque = ataque;
        this.ataqueEsp = ataqueEsp;
        this.desfensaEsp = desfensaEsp;
        this.velocidad = velocidad;
        this.estamina = estamina;
        this.nivel = 1;
        this.fertilidad = 5;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMote() {
        return mote;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public int getVitalidad() {
        return vitalidad;
    }

    public void setVitalidad(int vitalidad) {
        this.vitalidad = vitalidad;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getAtaqueEsp() {
        return ataqueEsp;
    }

    public void setAtaqueEsp(int ataqueEsp) {
        this.ataqueEsp = ataqueEsp;
    }

    public int getDesfensaEsp() {
        return desfensaEsp;
    }

    public void setDesfensaEsp(int desfensaEsp) {
        this.desfensaEsp = desfensaEsp;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getEstamina() {
        return estamina;
    }

    public void setEstamina(int estamina) {
        this.estamina = estamina;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getFertilidad() {
        return fertilidad;
    }

    public void setFertilidad(int fertilidad) {
        this.fertilidad = fertilidad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void asignarValoresDePokemon(){
        Random rd = new Random();

        vitalidad = rd.nextInt(100);
        setVitalidad(vitalidad);

        ataque = rd.nextInt(100);
        setAtaque(ataque);

        ataqueEsp = rd.nextInt(100);
        setAtaqueEsp(ataqueEsp);

        desfensaEsp= rd.nextInt(100);
        setDesfensaEsp(desfensaEsp);

        velocidad = rd.nextInt(100);
        setVelocidad(velocidad);

        estamina = rd.nextInt(100);
        setEstamina(estamina);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", mote='" + mote + '\'' +
                ", vitalidad=" + vitalidad +
                ", ataque=" + ataque +
                ", ataqueEsp=" + ataqueEsp +
                ", desfensaEsp=" + desfensaEsp +
                ", velocidad=" + velocidad +
                ", estamina=" + estamina +
                ", nivel=" + nivel +
                ", fertilidad=" + fertilidad +
                ", sexo=" + sexo +
                '}';
    }
}
