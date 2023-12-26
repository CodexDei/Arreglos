package arreglos;

import java.util.Arrays;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;

public class EjemploArrayString {

    //atributos de la clase
    public static String nombres[];
    public static int tamañoArray;
    private static boolean estadoArray = false;
    private static boolean estadoPrograma = false;

    public static void main(String[] args) {

        StringBuilder mensaje;

        do {
            try {

                int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                        "INGRESE LA OPCION QUE DESEE RESPECTO AL ARRAY:\n\n"
                        + "1. Rellenar Array\n"
                        + "2. Imprimir Array\n"
                        + "3. Ordenar menor a mayor\n"
                        + "4. Ordenar mayor a menor\n"
                        + "5. Buscar elemento en el array\n"
                        + "6. Copiar array\n"
                        + "7. cuento con los elementos\n"
                        + "8. Valor promedio\n"
                        + "9. Elemento mayor\n"
                        + "10. Elemento menor\n"
                        + "11. Verificar igualdad entre arrays\n"
                        + "12. Salir\n"));

                switch (opcion) {

                    case 1:

                        do {
                            //tamaño array
                            tamañoArray = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del array:"));

                            if (tamañoArray < 0) {
                                JOptionPane.showMessageDialog(null, "Ingrese un valor mayor a cero");
                            } else {
                                estadoArray = true;
                            }
                        } while (!estadoArray);

                        //instanciar array
                        nombres = new String[tamañoArray];

                        //Rellenar array
                        for (int i = 0; i < nombres.length; i++) {

                            nombres[i] = JOptionPane.showInputDialog("Ingrese valor para la posicion " + i + ":");
                        }

                        break;

                    case 2:

                        mensaje = new StringBuilder("IMPRESION DEL ARRAY\n\n");

                        for (int i = 0; i < nombres.length; i++) {
                            mensaje.append("Valor posicion " + i + ": " + nombres[i] + "\n");
                        }
                        JOptionPane.showMessageDialog(null, mensaje);
                        break;

                    case 3:

                        mensaje = new StringBuilder("ORDENADO ALFABETICAMENTE:\n\n");

                        menorMayor(nombres);

                        for (String nombre : nombres) {
                            mensaje.append(nombre).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, mensaje);

                        break;

                    case 4:

                        mensaje = new StringBuilder("Ordenado Mayor a menor:\n");

                        mayorMenor(nombres);

                        for (String nombre : nombres) {
                            mensaje.append(nombre).append("\n");
                        }

                        JOptionPane.showMessageDialog(null, mensaje);

                        break;

                    case 5:

                        mensaje = new StringBuilder("BUSQUEDA EN EL ARRAY: ");

                        String valorBusqueda = JOptionPane.showInputDialog("Ingrese el valor a buscar: ");
                        int resultadoBusqueda = buscarElemento(nombres, valorBusqueda);

                        if (resultadoBusqueda >= 0) {

                            JOptionPane.showMessageDialog(null, "El elemento " + valorBusqueda
                                    + " se encuentra en la posicion: " + resultadoBusqueda);

                        } else {
                            JOptionPane.showMessageDialog(null, "El elemento " + valorBusqueda
                                    + " NO se encuentra en el Array");
                        }

                        break;

                    case 6:
                        
                        String[] arrayCopiar = new String[tamañoArray];
                        copiarArray(nombres, arrayCopiar);
                        
                        mensaje = new StringBuilder("COPIA DE ARRAY\n");
                        
                        mensaje.append("ARRAY ORIGINAL\n");
                        
                        for (int i = 0; i < nombres.length; i++) {
                            
                            mensaje.append("El elemento de la posicion " + i + " es:" + nombres[i] + "\n");
                        }
                        
                        mensaje.append("ARRAY COPIA\n");
                        
                        for (int i = 0; i < arrayCopiar.length; i++) {
                            mensaje.append("El elemento de la posicion " + i + " es:" + nombres[i] + "\n");
                        }
                        
                        JOptionPane.showMessageDialog(null, mensaje);
                        
                        break;
                    
                    case 7:
                        
                        mensaje = new StringBuilder("CUENTO CON LOS ELEMENTOS\n");
                        
                        mensaje.append("Habia una vez un@ niñ@ llamada " + nombres[0] + "\n tenia los pies grandes como "
                        + nombres[1] + " y los labios como " + nombres[2] + ", era juicios@ como " + nombres[1] + "\n, jugaba xbox como "
                        + nombres[2] + ", le gustaba arreglar uñas como a " + nombres[1] + ", buena para el parques como " + nombres[2]
                        + ", poco al estudio como " + nombres[1] + "\n...pero se han como sean " + nombres[0] + ", " + nombres[1] + " y "
                        + nombres[2] + " son una familia feliz");
                        
                        JOptionPane.showMessageDialog(null, mensaje);
                        
                        break;
                        
                    case 8:

                        estadoPrograma = true;
                        break;

                    default:

                        JOptionPane.showMessageDialog(null, "INGRESE SOLO LOS NUMEROS DE LA TABLA");
                        break;
                }

            } catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(null, "ERROR!!! INGRESE UN VALOR VALIDO");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR EN LA EJECUCION: " + e.getMessage());
            }
        } while (!estadoPrograma);
    }

    private static void menorMayor(String array[]) {
        Arrays.sort(array);
    }

    private static String[] mayorMenor(String[] nombres) {

        Arrays.sort(nombres);

        for (int i = 0, j = nombres.length - 1; i < j; i++, j--) {

            String mayorMenor = nombres[i];
            nombres[i] = nombres[j];
            nombres[j] = mayorMenor;
        }
        return nombres;
    }

    private static int buscarElemento(String array[], String nombre) {
        Arrays.sort(array);
        return Arrays.binarySearch(array, nombre);
    }

    private static String[] copiarArray(String[] array, String[] CopiaArray) {
        return Arrays.copyOf(nombres, tamañoArray);
    }

}
