package Entrega1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;

public class Ronda {
    public static void main(String[] args) {

        Collection<Partido> partidos = new ArrayList<Partido>();

        // Define la ruta del archivo CSV
        // Al utilizar la clase Path en lugar de una cadena de caracteres (String) simple para representar una ruta de archivo, obtenemos una serie de beneficios que nos permiten trabajar con rutas de archivo de manera más eficiente, segura y portátil.
        Path rutaArchivo = Paths.get("C:/Users/Bruno/OneDrive/Programacion/Argentina Programa/Java/Trabajo Practico/Entrega 1/Entrega1/resulatdos.csv");
        // Una vez que hayas importado la clase Paths, puedes utilizar el método Paths.get() para crear un objeto Path a partir de una cadena de caracteres que representa una ruta de archivo.
        // Para poder utilizar este método en tu código, debes importar la clase java.nio.file.Paths en tu archivo Java

        List<String> lineas = null;

        try {
            // Lee todas las líneas del archivo CSV y las almacena en una lista de cadenas de texto
             lineas = Files.readAllLines(rutaArchivo);
        } catch (IOException e) {
            // Maneja cualquier excepción que pueda ocurrir al leer el archivo CSV, utilizando la subclase IOException y declarando la variable e
            System.err.println("Error al leer el archivo: " + e.getMessage()); //La expresión 'e.getMessage()' se utiliza para obtener el mensaje de error específico asociado con la excepción capturada. Este mensaje de error puede proporcionar información valiosa sobre el problema que causó la excepción y puede ser útil para el usuario o el desarrollador para diagnosticar el problema.
            System.exit(1); //Nuevamente demostramos que ocurrió un error.
            //  Codigo de salida = 0 = Exitoso
            // Codigo de salida distinto de 0 = ha ocurrido un error
        }

        boolean primera = true; //1) Esto lo hacemos para que cuando itere la primera linea no la escriba, y no nos muestra la linea de equipo1, equipo2 y bla

        // Itera sobre cada línea del archivo CSV
        for (String linea : lineas) {

            if (primera) {
                primera = false;// 1)
            } else {
                // Nota: Argentina,1,2,Arabia Saudita
                // Divide la línea en sus valores individuales utilizando el carácter ","
                String[] valores = linea.split(",");

                Equipo equipo1 = new Equipo(valores[0]); //Aca definimos que equipo1 sea el primer index
                Equipo equipo2 = new Equipo(valores[3]); //Aca definimos que equipo2 sea el cuarto index

                Partido partido = new Partido(equipo1, equipo2); // Creamos el objeto partido que represente el enfrentamiento

                // Se establece el numero de goles anotados teniendo en cuenta el index donde se encutra dicha información
                partido.setGolesEq1(Integer.parseInt(valores[1]));
                partido.setGolesEq2(Integer.parseInt(valores[2]));

                // Esto agrega el objeto "partido" a la colección "partidos", lo que permite almacenar y procesar múltiples objetos "Partido".
                partidos.add(partido);
            }

        }

        // ---------------------------------------- Leer pronostico ----------------------------------------

        int puntos = 0; // total puntos pesona

        Path pathPronostico = Paths.get(args[1]); //Aca hacemos que tome como parametro la primer ruta, que seria pronostico.csv, en vez de darle la ruta entera en la linea de codigo

        List<String> lineasPronostico = null;

        try {
            lineasPronostico = Files.readAllLines(pathPronostico); // Intentamos leer el archivo de pronostico
        } catch (IOException e) {
            System.out.println("No se pudo leer la linea de pronosticos...");
            System.out.println(e.getMessage());
            System.exit(1);
        }

        primera = true; //Hacemos que saltee la primer linea. No hace falta declararla con la palabra Boolean porque ya lo hicimos anteiormente. Pues, esta variable ya está declarada
        for (String lineaPronostico : lineasPronostico) { // Itera linea por linea
            if (primera) {
                primera = false;
            } else {
                // Aca vamos a sumar los puntos correspondientes
                String[] campos = lineaPronostico.split(","); //Separamos por "," con el método split
                Equipo equipo1 = new Equipo(campos[0]); // Creamos el objeto de equipo1 en base al numero de index
                Equipo equipo2 = new Equipo(campos[4]); // Creamos el objeto de equipo2 en base al numero de index

                Partido partido = null; //Simplemente declaramos la variable partido

                // Recorro la colección para comparar los partidos
                for (Partido partidoCol : partidos) {
                    if (partidoCol.getEquipo1().getNombre().equals(equipo1.getNombre()) //Comparamos y comprobamos que Equipo1 sea equipo1, o sea, que el pronostico y el resultado esten "hablando" del mismo partido
                            && // esto es como "AND" o en español "y"
                            partidoCol.getEquipo2().getNombre().equals(equipo2.getNombre())) {//Comparamos y comprobamos que Equipo2 sea equipo2, o sea, que el pronostico y el resultado esten "hablando" del mismo partido

                        partido = partidoCol; // Asignamos partido a partidoCol que proviene de la iteracion
                // Esto que estamos haciendo se agrega a la colección de partido gracias a la linea que pusimos que dice: partidos.add(partido);
                    }
                }

                //Inicializo las variables equipo y resultado para trabajar con ellas dentro de los if
                Equipo equipo = null;
                EnumResultado resultado = null;

                // Lo que vamos a hacer aca es que dependiendo de donde se ecnuentre la X en el archivo csv vamos a saber que equipo se pronostico que ganaba
                if("X".equals(campos[1])) {
                    equipo = equipo1;
                    resultado = EnumResultado.GANADOR;
                }
                if("X".equals(campos[2])) {
                    equipo = equipo1;
                    resultado = EnumResultado.EMPATE;
                }
                if("X".equals(campos[3])) {
                    equipo = equipo1;
                    resultado = EnumResultado.PERDEDOR;
                }

                Pronostico pronostico = new Pronostico(partido, equipo, resultado);

                // sumar los puntos correspondientes en base al metodo puntos() creado en la clase Pronostico
                puntos += pronostico.puntos();
            }
        }

        // Mostramos los puntos
        System.out.println("Los puntos obtenidos por el usuario fueron:");
        System.out.println(puntos);

    }
    }

