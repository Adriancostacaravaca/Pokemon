package org.proyectopokemon.shop;
/**
 * CLASE OBJETO DONDE CREAREMOS CUALQUIER METODO QUE REQUIERA LA INTERVENCION DE ESTA CLASE
 */
public class Objeto {

    private String nombre;
    private double aumenta;
    private double disminuye;
    private int coste;
    private String descripcion;

    /**
     * CONSTRUCTOR DE UN OBJETO
     * @param nombre NOMBRE DEL OBJETO
     * @param aumenta CANTIDAD QUE AUMENTAN LAS ESTADÍSTICAS
     * @param disminuye CANTIDAD QUE DISMINUYEN LAS ESTADÍSTICAS
     * @param coste CANTIDAD DE POKEDOLLAR QUE CUESTA COMPRARLO
     * @param descripcion DESCRIPCIÓN DEL OBJETO
     */
    public Objeto(String nombre, double aumenta, double disminuye, int coste, String descripcion){
        this.nombre = nombre;
        this.aumenta = aumenta;
        this.disminuye = disminuye;
        this.coste = coste;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCoste() {
        return coste;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Objeto{" +
                "nombre='" + nombre + '\'' +
                ", aumenta=" + aumenta +
                ", disminuye=" + disminuye +
                ", coste=" + coste +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
