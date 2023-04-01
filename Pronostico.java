package Entrega1;

public class Pronostico {

    //Atributos
    private Partido partido;
    private Equipo equipo;
    private EnumResultado resultado;

    //Constructor
    public Pronostico(Partido partido, Equipo equipo, EnumResultado resultado) {
        super();
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
    }

    //Métodos Get
    public Partido getPartido() {
        return this.partido;
    }

    public Equipo getEquipo() {
        return this.equipo;
    }

    public EnumResultado getResultado() {
        return this.resultado;
    }

    //Calculamos el puntaje a traves de un metodo llamado puntos()
    public int puntos() {
        // this.resultado -> pred
        EnumResultado resultadoReal = this.partido.resultado(this.equipo); //Almacenamos en una variable al método resultado() del objeto "partido" pasando como argumento el objeto "equipo"
        if (this.resultado.equals(resultadoReal)) { //Usamos equals para comparar objetos. En este caso se realiza una comparación entre el valor del atributo "resultado" del objeto actual (referido por la palabra clave "this") y el valor almacenado en la variable "resultadoReal".
            return 1; //Retornamos 1 ya que el pronostico fue correcto
        } else {
            return 0; //Retornamos 0 ya que el pronostico fue incorrecto
        }

    }

}