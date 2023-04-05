package org.proyectopokemon.model;

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



    public Pokemon(String nombre, String mote,char sexo) {
        Random rd = new Random();
        this.nombre = nombre;
        this.mote = mote;
        this.vitalidad = 50;
        this.ataque = rd.nextInt(5);
        this.defensa = rd.nextInt(5);
        this.ataqueEsp = rd.nextInt(5);
        this.defensaEsp = rd.nextInt(5);
        this.velocidad = rd.nextInt(5);
        this.estamina = 20;
        this.nivel = 1;
        this.fertilidad = 5;
        this.sexo = sexo;
        this.experiencia = 0;
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

    public int getDefensaEsp() {
        return defensaEsp;
    }

    public void setDefensaEsp(int defensaEsp) {
        this.defensaEsp = defensaEsp;
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

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public void asignarValoresDePokemon(){
        Random rd = new Random();

        vitalidad = rd.nextInt(100);
        setVitalidad(vitalidad);

        ataque = rd.nextInt(100);
        setAtaque(ataque);

        ataqueEsp = rd.nextInt(100);
        setAtaqueEsp(ataqueEsp);

        defensaEsp= rd.nextInt(100);
        setDefensaEsp(defensaEsp);

        velocidad = rd.nextInt(100);
        setVelocidad(velocidad);

        estamina = rd.nextInt(100);
        setEstamina(estamina);
    }
    // MÉTODO PARA SUBIR DE NIVEL CADA VEZ QUE GANAS UN COMBATE
    public void subirNivel(){
        Random rd = new Random();
        experiencia += 5;
        int incremento = rd.nextInt(4) +1;

        if(this.nivel == 1 && experiencia == 10){
            vitalidad += incremento;
            ataque +=  incremento;
            defensa += incremento;
            ataqueEsp += incremento;
            defensaEsp += incremento;
            velocidad += incremento;
            setNivel(2);
            setExperiencia(0);
            System.out.println("Has subido al nivel: " + getNivel());
        }
        else if(this.nivel == 2 && experiencia == 20){
            vitalidad += incremento;
            ataque +=  incremento;
            defensa += incremento;
            ataqueEsp += incremento;
            defensaEsp += incremento;
            velocidad += incremento;
            setNivel(3);
            setExperiencia(0);
            System.out.println("Has subido al nivel: " + getNivel());
        } else if (this.nivel == 3 && experiencia == 30) {
            vitalidad += incremento;
            ataque +=  incremento;
            defensa += incremento;
            ataqueEsp += incremento;
            defensaEsp += incremento;
            velocidad += incremento;
            setNivel(4);
            setExperiencia(0);
            System.out.println("Has subido al nivel: " + getNivel());
        }else if (this.nivel == 4 && experiencia == 40) {
            vitalidad += incremento;
            ataque +=  incremento;
            defensa += incremento;
            ataqueEsp += incremento;
            defensaEsp += incremento;
            velocidad += incremento;
            setNivel(5);
            setExperiencia(0);
            System.out.println("Has subido al nivel: " + getNivel());
        }else if (this.nivel == 5 && experiencia == 50) {
            vitalidad += incremento;
            ataque +=  incremento;
            defensa += incremento;
            ataqueEsp += incremento;
            defensaEsp += incremento;
            velocidad += incremento;
            setNivel(6);
            setExperiencia(0);
            System.out.println("Has subido al nivel: " + getNivel());
        }
    }
    // AÑADIMOS EN LA LISTA DE ATAQUES UN NUEVO MOVIMIENTO CADA 3 NIVELES
    public void añadirAtaque() {
            System.out.println("Has aprendido un nuevo ataque");
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
        if(getEstamina() <= 0){
            setEstamina(0);
        }
        if(getEstamina() >= 0 && getEstamina() < 20){
            setEstamina(getEstamina()+5);
            System.out.println("Tu estamina es: " + getEstamina());
        } else if (getEstamina() == 20) {
            System.out.println("Tu estamina esta a tope, no puedes recuperar más");

        }

    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", mote: " + mote + ", nivel: " + nivel + ", género: " + sexo;
    }
}