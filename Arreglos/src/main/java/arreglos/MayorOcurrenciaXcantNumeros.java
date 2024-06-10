package arreglos;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class MayorOcurrenciaXcantNumeros {

    // Variable para controlar el estado del programa
    public static boolean estadoPrograma = false;

    public static void main(String[] args) {
        do {
            try {
                // Mostrar un menú al usuario y leer su elección
                int menu = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la accion que desee:\n" +
                        "1. Hallar la mayor concurrencia\n" +
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
        int tamanoArrays = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de numeros que desea ingresar"));
        // Crear un array para almacenar los números ingresados
        int[] numeros = new int[tamanoArrays];

        // Leer los números ingresados por el usuario
        for (int i = 0; i < tamanoArrays; i++) {
            numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero entero:\n" +
                    "Numero " + (i + 1) + ":"));
        }

        // Crear un HashMap para contar las ocurrencias de cada número
        Map<Integer, Integer> contadorNumeros = new HashMap<>();

        // Contar las ocurrencias de cada número en el array
        for (int numero : numeros) {
            contadorNumeros.put(numero, contadorNumeros.getOrDefault(numero, 0) + 1);
        }

        // Encontrar el valor máximo de ocurrencias
        int mayorOcurrencia = 0;
        for (int ocurrencias : contadorNumeros.values()) {
            if (ocurrencias > mayorOcurrencia) {
                mayorOcurrencia = ocurrencias;
            }
        }

        // Construir el mensaje para mostrar al usuario
        StringBuilder mensaje = new StringBuilder();
        if (mayorOcurrencia > 1) {
            mensaje.append("Los numeros con mayor concurrencia son:\n");
            // Recorrer todas las entradas del HashMap
            for (Map.Entry<Integer, Integer> entry : contadorNumeros.entrySet()) {
                // Añadir al mensaje los números que tienen la mayor concurrencia
                if (entry.getValue() == mayorOcurrencia) {
                    mensaje.append("El numero ").append(entry.getKey()).append(" se repite ").append(mayorOcurrencia).append(" veces\n");
                }
            }
        } else {
            // Si no hay números repetidos, añadir un mensaje informativo
            mensaje.append("No hay números que se repitan en el arreglo.");
        }

        // Mostrar el mensaje final al usuario
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}
