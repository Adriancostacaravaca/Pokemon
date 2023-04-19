package org.proyectopokemon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pokemon {
    private String nombre;
    private String mote;
    private int vitalidad;
    private int ataque;
    private int defensa;
    private int ataqueEsp;
    private int defensaEsp;
    private int velocidad;
    private int estamina;
    private int nivel;
    private int fertilidad;
    private char sexo;
    private int experiencia;
    private Tipo tipo;
    private Estado estado;
    private List<MovimientoAtaque> listaMovimientosDisp = new ArrayList<>();

    public Pokemon(String nombre, String mote,char sexo, Tipo tipo) {
        Random rd = new Random();
        this.nombre = nombre;
        this.mote = mote;
        this.vitalidad = 50;
        this.ataque = rd.nextInt(10) + 1;
        this.defensa = rd.nextInt(10) + 1;
        this.ataqueEsp = rd.nextInt(10) + 1;
        this.defensaEsp = rd.nextInt(10) + 1;
        this.velocidad = rd.nextInt(10) + 1;
        this.estamina = 20;
        this.nivel = 1;
        this.fertilidad = 5;
        this.sexo = sexo;
        this.experiencia = 0;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
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

    public int getEstamina() {
        return estamina;
    }

    public int getNivel() {
        return nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    // MÉTODO PARA SUBIR DE NIVEL CADA VEZ QUE GANAS UN COMBATE
    public void subirNivel(){
        Random rd = new Random();
        experiencia += 5;
        int incremento = rd.nextInt(4) +1;

        if(this.experiencia == this.nivel*10){
            vitalidad += incremento;
            ataque +=  incremento;
            defensa += incremento;
            ataqueEsp += incremento;
            defensaEsp += incremento;
            velocidad += incremento;
            this.nivel++;
            this.experiencia = 0;
            System.out.println("Has subido al nivel: " + getNivel());
        }

    }

    // AÑADIMOS EN LA LISTA DE ATAQUES UN NUEVO MOVIMIENTO CADA 3 NIVELES
    private List<MovimientoAtaque> listaCuatroAtaques = new ArrayList<>();

    public List<MovimientoAtaque> getListaCuatroAtaques() {
        return listaCuatroAtaques;
    }

    public void atacarAPokemon(Pokemon pokemon) {

        if(estamina <= 0){
            System.out.println("Necesitas descansar para realizar otro ataque");
        }else {
            pokemon.setVitalidad(pokemon.getVitalidad() - 1);
            this.estamina -= 5;
        }
    }
    public void descansar(){
        this.estamina = 20;

        if (getEstamina() == 20) {
            System.out.println("Tu estamina está llena, no puedes recuperar más");
        }

    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", mote: " + mote + ", nivel: " + nivel + ", género: " + sexo;
    }
}