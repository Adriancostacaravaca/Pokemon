package org.proyectopokemon.pokemon;

import javafx.scene.image.Image;
import org.proyectopokemon.enums.Estado;
import org.proyectopokemon.enums.Tipo;
import org.proyectopokemon.movements.Movimiento;
import org.proyectopokemon.movements.MovimientosDisponiblesParaPokemon;

import java.util.*;

/**
 * CLASE POKEMON DONDE CREAREMOS CUALQUIER METODO QUE REQUIERA LA INTERVENCION DE ESTA CLASE
 */

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
    private static List<Movimiento> listaCuatroAtaques;
    private MovimientosDisponiblesParaPokemon movimientosDisponiblesParaPokemon = new MovimientosDisponiblesParaPokemon();
    private Tipo tipo;
    private Estado estado;
    private Image image;

    // MÉTODO PARA COMPROBAR VENTAJA
    private static HashMap<Tipo, List<Tipo>> tablaDebiles;
    private static HashMap<Tipo, List<Tipo>> tablaFuertes;

    /**
     * CONSTRUCTOR DE POKEMON PASANDO LOS PARAMETROS LISTADOS DEBAJO
     * @param nombre NOMBRE DEL POKEMON, NO PUEDE SER NULL
     * @param tipo1 PRIMER TIPO DEL POKEMON, NO PUEDE SER NULL
     * @param tipo2 PRIMER TIPO DEL POKEMON, PUEDE SER NULL
     //* @param image IMAGEN REFERENTE AL POKEMON
     */

    public Pokemon(String nombre, Tipo tipo1, Tipo tipo2,Image image) {
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
        this.image = image;
        // this.listaCuatroAtaques = listaMovs;

    }

    /**
     * CONSTRUCTOR DE POKEMON VACIO
     */

    public Pokemon(){}

    public String getNombre() {
        return nombre;
    }

    public int getVitalidad() {
        return vitalidad;
    }

    public void setVitalidad(int vitalidad) {
        this.vitalidad = vitalidad;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setDefensaEsp(int defensaEsp) {
        this.defensaEsp = defensaEsp;
    }

    public int getDefensaEsp() {
        return defensaEsp;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setAtaqueEsp(int ataqueEsp) {
        this.ataqueEsp = ataqueEsp;
    }

    public int getAtaqueEsp() {
        return ataqueEsp;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
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

    public Image getImage() {
        return image;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public int getDefensa() {
        return defensa;
    }


    public int getVelocidad() {
        return velocidad;
    }


    public static List<Movimiento> getListaCuatroAtaques() {
        return listaCuatroAtaques;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    private static HashMap<Tipo, List<Tipo>> getTablaDebiles(){
        if (tablaDebiles == null) {
            tablaDebiles = new HashMap<>();
            // DEBILES FRENTE AL TIPO AGUA
            tablaDebiles.put(Tipo.AGUA, new LinkedList<>());
            tablaDebiles.get(Tipo.AGUA).add(Tipo.FUEGO);
            tablaDebiles.get(Tipo.AGUA).add(Tipo.ROCA);
            tablaDebiles.get(Tipo.AGUA).add(Tipo.TIERRA);
            // DEBILES FRENTE AL TIPO BICHO
            tablaDebiles.put(Tipo.BICHO, new LinkedList<>());
            tablaDebiles.get(Tipo.BICHO).add(Tipo.PLANTA);
            tablaDebiles.get(Tipo.BICHO).add(Tipo.PSIQUICO);
            tablaDebiles.get(Tipo.BICHO).add(Tipo.VENENO);
            // DEBILES FRENTE AL TIPO DRAGÓN
            tablaDebiles.put(Tipo.DRAGON, new LinkedList<>());
            tablaDebiles.get(Tipo.DRAGON).add(Tipo.DRAGON);
            // DEBILES FRENTE AL TIPO ELÉCTRICO
            tablaDebiles.put(Tipo.ELECTRICO, new LinkedList<>());
            tablaDebiles.get(Tipo.ELECTRICO).add(Tipo.AGUA);
            tablaDebiles.get(Tipo.ELECTRICO).add(Tipo.VOLADOR);
            // DEBILES FRENTE AL TIPO FANTASMA
            tablaDebiles.put(Tipo.FANTASMA, new LinkedList<>());
            tablaDebiles.get(Tipo.FANTASMA).add(Tipo.FUEGO);
            // DEBILES FRENTE AL TIPO FUEGO
            tablaDebiles.put(Tipo.FUEGO, new LinkedList<>());
            tablaDebiles.get(Tipo.FUEGO).add(Tipo.BICHO);
            tablaDebiles.get(Tipo.FUEGO).add(Tipo.HIELO);
            tablaDebiles.get(Tipo.FUEGO).add(Tipo.PLANTA);
            // DEBILES FRENTE AL TIPO HIELO
            tablaDebiles.put(Tipo.HIELO, new LinkedList<>());
            tablaDebiles.get(Tipo.HIELO).add(Tipo.DRAGON);
            tablaDebiles.get(Tipo.HIELO).add(Tipo.PLANTA);
            tablaDebiles.get(Tipo.HIELO).add(Tipo.TIERRA);
            tablaDebiles.get(Tipo.HIELO).add(Tipo.VOLADOR);
            // DEBILES FRENTE AL TIPO LUCHA
            tablaDebiles.put(Tipo.LUCHA, new LinkedList<>());
            tablaDebiles.get(Tipo.LUCHA).add(Tipo.HIELO);
            tablaDebiles.get(Tipo.LUCHA).add(Tipo.NORMAL);
            tablaDebiles.get(Tipo.LUCHA).add(Tipo.ROCA);
            // DEBILES FRENTE AL TIPO PLANTA
            tablaDebiles.put(Tipo.PLANTA, new LinkedList<>());
            tablaDebiles.get(Tipo.PLANTA).add(Tipo.AGUA);
            tablaDebiles.get(Tipo.PLANTA).add(Tipo.ROCA);
            tablaDebiles.get(Tipo.PLANTA).add(Tipo.TIERRA);
            // DEBILES FRENTE AL TIPO PSIQUICO
            tablaDebiles.put(Tipo.PSIQUICO, new LinkedList<>());
            tablaDebiles.get(Tipo.PSIQUICO).add(Tipo.LUCHA);
            tablaDebiles.get(Tipo.PSIQUICO).add(Tipo.VENENO);
            // DEBILES FRENTE AL TIPO ROCA
            tablaDebiles.put(Tipo.ROCA, new LinkedList<>());
            tablaDebiles.get(Tipo.ROCA).add(Tipo.BICHO);
            tablaDebiles.get(Tipo.ROCA).add(Tipo.FUEGO);
            tablaDebiles.get(Tipo.ROCA).add(Tipo.HIELO);
            tablaDebiles.get(Tipo.ROCA).add(Tipo.VOLADOR);
            // DEBILES FRENTE AL TIPO TIERRA
            tablaDebiles.put(Tipo.TIERRA, new LinkedList<>());
            tablaDebiles.get(Tipo.TIERRA).add(Tipo.ELECTRICO);
            tablaDebiles.get(Tipo.TIERRA).add(Tipo.FUEGO);
            tablaDebiles.get(Tipo.TIERRA).add(Tipo.ROCA);
            tablaDebiles.get(Tipo.TIERRA).add(Tipo.VENENO);
            // DEBILES FRENTE AL TIPO VENENO
            tablaDebiles.put(Tipo.VENENO, new LinkedList<>());
            tablaDebiles.get(Tipo.VENENO).add(Tipo.BICHO);
            tablaDebiles.get(Tipo.VENENO).add(Tipo.PLANTA);
            // DEBILES FRENTE AL TIPO VOLADOR
            tablaDebiles.put(Tipo.VOLADOR, new LinkedList<>());
            tablaDebiles.get(Tipo.VOLADOR).add(Tipo.BICHO);
            tablaDebiles.get(Tipo.VOLADOR).add(Tipo.LUCHA);
            tablaDebiles.get(Tipo.VOLADOR).add(Tipo.PLANTA);
        }
        return tablaDebiles;
    }

    private static HashMap<Tipo, List<Tipo>> getTablaFuertes() {
        if (tablaFuertes == null) {
            tablaFuertes = new HashMap<>();
            // FUERTES FRENTE AL TIPO AGUA
            tablaFuertes.put(Tipo.AGUA, new LinkedList<>());
            tablaFuertes.get(Tipo.AGUA).add(Tipo.AGUA);
            tablaFuertes.get(Tipo.AGUA).add(Tipo.DRAGON);
            tablaFuertes.get(Tipo.AGUA).add(Tipo.PLANTA);
            // FUERTES FRENTE AL TIPO BICHO
            tablaFuertes.put(Tipo.BICHO, new LinkedList<>());
            tablaFuertes.get(Tipo.BICHO).add(Tipo.FANTASMA);
            tablaFuertes.get(Tipo.BICHO).add(Tipo.FUEGO);
            tablaFuertes.get(Tipo.BICHO).add(Tipo.LUCHA);
            tablaFuertes.get(Tipo.BICHO).add(Tipo.VOLADOR);
            // FUERTES FRENTE AL TIPO ELÉCTRICO
            tablaFuertes.put(Tipo.ELECTRICO, new LinkedList<>());
            tablaFuertes.get(Tipo.ELECTRICO).add(Tipo.DRAGON);
            tablaFuertes.get(Tipo.ELECTRICO).add(Tipo.ELECTRICO);
            tablaFuertes.get(Tipo.ELECTRICO).add(Tipo.PLANTA);
            // FUERTES FRENTE AL TIPO FUEGO
            tablaFuertes.put(Tipo.FUEGO, new LinkedList<>());
            tablaFuertes.get(Tipo.FUEGO).add(Tipo.AGUA);
            tablaFuertes.get(Tipo.FUEGO).add(Tipo.DRAGON);
            tablaFuertes.get(Tipo.FUEGO).add(Tipo.FUEGO);
            tablaFuertes.get(Tipo.FUEGO).add(Tipo.ROCA);
            // DEBILES FRENTE AL TIPO HIELO
            tablaFuertes.put(Tipo.HIELO, new LinkedList<>());
            tablaFuertes.get(Tipo.HIELO).add(Tipo.AGUA);
            tablaFuertes.get(Tipo.HIELO).add(Tipo.HIELO);
            // DEBILES FRENTE AL TIPO LUCHA
            tablaFuertes.put(Tipo.LUCHA, new LinkedList<>());
            tablaFuertes.get(Tipo.LUCHA).add(Tipo.BICHO);
            tablaFuertes.get(Tipo.LUCHA).add(Tipo.PSIQUICO);
            tablaFuertes.get(Tipo.LUCHA).add(Tipo.VENENO);
            tablaFuertes.get(Tipo.LUCHA).add(Tipo.VOLADOR);
            // DEBILES FRENTE AL TIPO PLANTA
            tablaFuertes.put(Tipo.PLANTA, new LinkedList<>());
            tablaFuertes.get(Tipo.PLANTA).add(Tipo.BICHO);
            tablaFuertes.get(Tipo.PLANTA).add(Tipo.DRAGON);
            tablaFuertes.get(Tipo.PLANTA).add(Tipo.FUEGO);
            tablaFuertes.get(Tipo.PLANTA).add(Tipo.PLANTA);
            tablaFuertes.get(Tipo.PLANTA).add(Tipo.VENENO);
            tablaFuertes.get(Tipo.PLANTA).add(Tipo.VOLADOR);
            // DEBILES FRENTE AL TIPO PSIQUICO
            tablaFuertes.put(Tipo.PSIQUICO, new LinkedList<>());
            tablaFuertes.get(Tipo.PSIQUICO).add(Tipo.PSIQUICO);
            // DEBILES FRENTE AL TIPO ROCA
            tablaFuertes.put(Tipo.ROCA, new LinkedList<>());
            tablaFuertes.get(Tipo.ROCA).add(Tipo.ROCA);
            tablaFuertes.get(Tipo.ROCA).add(Tipo.TIERRA);
            // DEBILES FRENTE AL TIPO TIERRA
            tablaFuertes.put(Tipo.TIERRA, new LinkedList<>());
            tablaFuertes.get(Tipo.TIERRA).add(Tipo.BICHO);
            tablaFuertes.get(Tipo.TIERRA).add(Tipo.PLANTA);
            // DEBILES FRENTE AL TIPO VENENO
            tablaFuertes.put(Tipo.VENENO, new LinkedList<>());
            tablaFuertes.get(Tipo.VENENO).add(Tipo.FANTASMA);
            tablaFuertes.get(Tipo.VENENO).add(Tipo.ROCA);
            tablaFuertes.get(Tipo.VENENO).add(Tipo.TIERRA);
            tablaFuertes.get(Tipo.VENENO).add(Tipo.VENENO);
            // DEBILES FRENTE AL TIPO VOLADOR
            tablaFuertes.put(Tipo.VOLADOR, new LinkedList<>());
            tablaFuertes.get(Tipo.VOLADOR).add(Tipo.ELECTRICO);
            tablaFuertes.get(Tipo.VOLADOR).add(Tipo.ROCA);
        }
        return tablaFuertes;
    }

    /**
     * METODO PARA COMPROBAR LA VENTAJA ENTRE DOS POKEMON
     * @param p2 EL POKEMON CON EL QUE VAMOS A COMPARARNOS
     * @return DEVUELVE EL VALOR DE LA VENTAJA O DESVENTAJA
     */
    // FIXME: HAY QUE COMPROBAR EL TIPO DEL POKÉMON Y EL TIPO DEL ATAQUE PARA AMBOS CASOS DE ATAQUE (JUGADOR/RIVAL)
    public float comprobarVentaja(Pokemon p2) {
        if (getTablaDebiles().get(this.getTipo()).contains(p2.getTipo()))
            return 2.0f;
        if (getTablaFuertes().get(this.getTipo()).contains(p2.getTipo()))
            return 0.5f;
        return 1.0f;
    }

    /**
     * METODO PARA OBTENER EXPERIENCIA Y SUBIR DE NIVEL CADA VEZ QUE SE GANA UN COMBATE
     */

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

    public void atacarAPokemon(Pokemon pokemon) {
        if(estamina <= 0){
            System.out.println("Necesitas descansar para realizar otro ataque");
        }else {
            pokemon.setVitalidad(pokemon.getVitalidad() - 5);
            this.estamina -= 5;
            System.out.println(getListaCuatroAtaques());
        }
    }
    public void rellenarAtaques(){
        movimientosDisponiblesParaPokemon.anyadirMovimientos();
        Random rd = new Random();
        for (int i = 0; i < 4; i++) {

        }
    }

    /**
     * METODO PARA DESCANSAR Y PODER RECUPERAR ESTAMINA EN NUESTRO POKÉMON
     */

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