package Entrega1;

public class Partido {

    //Atributos
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEq1;
    private int golesEq2;

    //Constructor
    public Partido(Equipo equipo1, Equipo equipo2, int golesEq1, int golesEq2) {
        super();
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEq1 = golesEq1;
        this.golesEq2 = golesEq2;
    }

    // Creamos una instancia de la clase "Partido" sin especificar los goles de cada equipo ya que los inicializamos en cero.
    public Partido(Equipo equipo1, Equipo equipo2) {
        this(equipo1, equipo2, 0, 0);
    }


    //Métodos Get y Set
    public Equipo getEquipo1() {
        return equipo1;
    }
    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }
    public Equipo getEquipo2() {
        return equipo2;
    }
    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }
    public int getGolesEq1() {
        return golesEq1;
    }
    public void setGolesEq1(int golesEq1) {
        this.golesEq1 = golesEq1;
    }
    public int getGolesEq2() {
        return golesEq2;
    }
    public void setGolesEq2(int golesEq2) {
        this.golesEq2 = golesEq2;
    }

    //Resultados: Usamos la clase EnumResultado para establecer GANADOR, PERDEDOR, EMPATE
    public EnumResultado resultado(Equipo equipo) {
        //EMPATE
        if(golesEq1 == golesEq2) {
            return EnumResultado.EMPATE;
        }

        if(equipo.getNombre().equals(equipo1.getNombre())) { //.equals se usa para comparar objetos

            //GANADOR-PERDERDOR equipo1
            if(golesEq1>golesEq2) {
                return EnumResultado.GANADOR;
            }	else {
                return EnumResultado.PERDEDOR;
            }

        } else {
            // como equipo no es equipo1, entonces es equipo2

            //GANADOR-PERDERDOR equipo2
            if(golesEq2>golesEq1) {
                return EnumResultado.GANADOR;
            }	else {
                return EnumResultado.PERDEDOR;
            }
        }

    }


}
