package Entrega1;
public class Equipo {

    //Atributos
    private String nombre;
    private String descripcion;

    //Constructor
    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    //Métodos Get y Set
    //No creamos un método Set para nombre por logica. Un equipo no debria cambiar su nombre
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}