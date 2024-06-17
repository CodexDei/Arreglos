package arreglos;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class HistogramaV1 {

    // Variable para controlar el estado del programa
    public static boolean estadoPrograma = false;

    public static void main(String[] args) {
        do {
            try {
                // Mostrar un menú al usuario y leer su elección
                int menu = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la accion que desee:\n" +
                        "1. Visualizar un histograma\n" +
                        "2. SALIR"));

                // Evaluar la elección del usuario
                switch (menu) {
                    case 1:
                        // Llamar al método para encontrar la mayor concurrencia
                        // CUANDO LA CANTIDAD DE NUMERO DE ESTABLECE POR EL USUARIO
                        mayorConcurrencia();
                        break;
                    case 2:
                        // Cambiar el estado del programa para salir del bucle
                        estadoPrograma = true;
                        break;
                    default:
                        // Mostrar un mensaje de advertencia si la opción no es válida
                        JOptionPane.showMessageDialog(null,
                                "Ingrese una opcion valida de acuerdo al menu", "Cuidado",
                                JOptionPane.WARNING_MESSAGE);
                        break;
                }
            } catch (NumberFormatException e) {
                // Mostrar un mensaje de error si la entrada no es un número
                JOptionPane.showMessageDialog(null,
                        "El valor ingresado no es un numero", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                // Mostrar un mensaje de error para cualquier otro tipo de excepción
                JOptionPane.showMessageDialog(null,
                        "ERROR EN LA EJECUCION: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!estadoPrograma); // Repetir el bucle hasta que el usuario elija salir
    }

    // Método para encontrar la mayor concurrencia de números
    private static void mayorConcurrencia() {
        // Pedir al usuario la cantidad de números que desea ingresar
       // int tamanoArrays = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de numeros que desea ingresar"));
        // Crear un array para almacenar los números ingresados
        int[] numeros = new int[6];

        // Leer los números ingresados por el usuario
        for (int i = 0; i < numeros.length; i++) {

            numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero entero del 1 al 6:\n" +
                    "Numero " + (i + 1) + ":"));

            if (numeros[i] < 1 || numeros[i] > 6){

                JOptionPane.showMessageDialog(null,
            "Ingrese un numero del 1 al 6", "RECUERDE", JOptionPane.WARNING_MESSAGE);
             --i;
            }
        }

        //contar frecuencia
        Map<Integer, Integer> frecuencia = new HashMap<>();

        for (int num : numeros){

            frecuencia.put(num, frecuencia.getOrDefault(num, 0) + 1);
        }

        //crear histograma
        StringBuilder histograma = new StringBuilder("HISTOGRAMA\n\n");

        for (int i = 1; i <= 6; i++){

            histograma.append(i).append(": ");

            if (frecuencia.containsKey(i)){

                for (int j = 0; j < frecuencia.get(i); j++){

                    histograma.append("*");
                }
            }
            histograma.append("\n");
        }
        JOptionPane.showMessageDialog(null, histograma.toString());
    }
}
