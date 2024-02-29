package arreglos;

import java.util.*;
import javax.swing.JOptionPane;

public class EjemploArrayString {

    private static String[] nombres;
    private static int tamañoArray;
    private static boolean estado = false;
    private static StringBuilder mensaje;

    public static void main(String[] args) {

        do {

            try {

                int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "INGRESE LA OPCION QUE DESEEE:\n\n"
                        + "1. RELLENAR ARRAY\n"
                        + "2. MOSTRAR ARRAY\n"
                        + "3. ORDENAR ALFABETICAMENTE A to Z\n"
                        + "4. ORDENAR ALFABETICAMENTE Z to A\n"
                        + "5. COPIAR ARRAY\n"
                        + "6. BUSCAR ELEMENTO\n"
                        + "7. CUENTO ARRAY\n"
                        + "8. COMPARAR ARRAYS\n"
                        + "9. SALIR\n"));

                switch (opcion) {

                    case 1:

                        tamañoArray = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del array"));

                        //instanciamos array
                        nombres = new String[tamañoArray];

                        rellenarArray(nombres);

                        break;

                    case 2:

                        mensaje = new StringBuilder("IMPRESION DEL ARRAY\n\n");

                        imprimirArray(nombres);

                        break;

                    case 3:

                        mensaje = new StringBuilder("ORDEN ALFABETICO DE LA A to Z\n\n");

                        ordenAtoZ(nombres);
                        concatenarMensaje(nombres);
                        imprimirMensaje();

                        break;

                    case 4:

                        mensaje = new StringBuilder("ORDEN ALFABETICO DE LA Z to A\n\n");

                        ordenZtoA(nombres);
                        concatenarMensaje(nombres);
                        imprimirMensaje();

                        break;

                    case 5:

                        mensaje = new StringBuilder("COPIANDO ARRAY\n\n");

                        String[] arrayCopia = copiarArray(nombres);

                        mensaje.append("\nArray Original:\n");
                        concatenarMensaje(nombres);

                        mensaje.append("\nArray copia:\n");
                        concatenarMensaje(arrayCopia);

                        imprimirMensaje();

                        break;

                    case 6:

                        mensaje = new StringBuilder("BUSCANDO EN EL ARRAY");

                        String elementoBuscado = JOptionPane.showInputDialog("Ingrese el dato a buscar");
                        int resultadoBusqueda = buscarArray(nombres, elementoBuscado);

                        if (resultadoBusqueda >=  0) {

                            mensaje = new StringBuilder("Buscador de elementos\n\n");

                            mensaje.append("El elemento " + elementoBuscado + " esta en la posicion "
                                    + resultadoBusqueda + "\n");

                            mensaje.append("Posicion " + resultadoBusqueda + ": " + elementoBuscado);

                            JOptionPane.showMessageDialog(null, mensaje);

                        } else {

                            JOptionPane.showMessageDialog(null, "El elemento " + elementoBuscado
                                    + " NO esta en el Array");
                        }

                        break;

                    case 7:

                        mensaje = new StringBuilder("CUENTO CON LOS ELEMENTOS\n");

                        mensaje.append("Habia una vez un@ niñ@ llamad@ " + nombres[0] + "\n tenia los pies grandes como "
                                + nombres[1] + " y los labios como " + nombres[2] + ", era juicios@ como " + nombres[1] + "\n, jugaba xbox como "
                                + nombres[2] + " su pasion era lavar la losa como " + nombres[1] + ", le gustaba arreglar uñas como a " + nombres[2]
                                + ", buena para el parques como " + nombres[1] + ", poco al estudio como " + nombres[2]
                                + "\n...pero se han como sean " + nombres[0] + ", " + nombres[1] + " y "
                                + nombres[2] + " son una familia feliz");

                        imprimirMensaje();

                        break;

                    case 8:

                        String[] nuevoArray;

                        tamañoArray = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del nuevo array:"));

                        nuevoArray = new String[tamañoArray];

                        rellenarArray(nuevoArray);

                        boolean comparacion = compararArrays(nombres, nuevoArray);

                        if (comparacion) {

                            JOptionPane.showMessageDialog(null, "LOS ARRAYS SON IGUALES");

                        } else {

                            JOptionPane.showMessageDialog(null, "NO SON IGUALES LOS ARRAYS");
                        }

                        break;

                    case 9:

                        estado = true;

                        break;

                    default:

                        JOptionPane.showMessageDialog(null, "INGRESE UN VALOR QUE ESTE EN EL MENU, PINCHE");

                        break;
                }

            } catch (InputMismatchException e) {
                JOptionPane.showMessageDialog(null, "ERROR!!! INGRESE UN VALOR VALIDO");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR EN LA EJECUCION: " + e.getMessage());
            }

        } while (!estado);
    }

    public static void rellenarArray(String array[]){

        for (int i = 0; i < nombres.length; i++){

            array[i] = JOptionPane.showInputDialog("Ingrese el elemento en la posicion "+ i + ":");

        }

    }

    public static void concatenarMensaje(String[] array){

        if (array != null){

            for (int i = 0; i < array.length; i++){

                mensaje.append("El valor de la posicion " + i + " es: " + array[i]).append("\n");
            }
        }else {

            JOptionPane.showMessageDialog(null,
                    "El array esta vacio","ARRAY VACIO", JOptionPane.WARNING_MESSAGE);
        }

    }

    public static void imprimirArray(String[] array){

        if (array != null){

            for (int i = 0; i < array.length; i++){

                mensaje.append("El valor de la posicion " + i + " es: " + array[i]).append("\n");
            }
            JOptionPane.showMessageDialog(null
                    ,mensaje,"IMPRESION ARRAY",JOptionPane.INFORMATION_MESSAGE);

        }else {
            JOptionPane.showMessageDialog(null,"El array esta vacio","ARRAY VACIO",JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void imprimirMensaje(){

        JOptionPane.showMessageDialog(null,
                mensaje,"IMPRESION ARRAY", JOptionPane.INFORMATION_MESSAGE);
    }

    private static String[] ordenAtoZ(String[] array) {

        Arrays.sort(array);
        return array;
    }

    private static String[] ordenZtoA(String[] array) {


        Arrays.sort(array);

        List<String> list = Arrays.asList(array);

        //Collections.reverseOrder es un comparador, es decir como una regla que indica
        //como se deben organizar los elementos, en este caso de forma descendente
        Collections.sort(list, Collections.reverseOrder());

//        OTRA FORMA DE ORDENAR DESCENDENTEMENTE
//        Arrays.sort(array);
//
//        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
//
//            String temp = array[i];
//            array[i] = array[j];
//            array[j] = temp;
//        }
        return array;
    }


    private static String[] copiarArray(String[] array) {

        return Arrays.copyOf(array, tamañoArray);
    }

    private static int buscarArray(String[] array, String dato) {

        Arrays.sort(array);
        int resultadoDato = Arrays.binarySearch(array, dato);
        return resultadoDato;
    }

    private static boolean compararArrays(String[] Array1, String[] Array2) {

        return Arrays.equals(Array1, Array2);
    }



}
