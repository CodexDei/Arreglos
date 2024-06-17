package arreglos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HistogramaXNumeros {

    // Variable para controlar el estado del programa
    public static boolean estadoPrograma = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                // Mostrar un menú al usuario y leer su elección
                System.out.println("Ingrese la acción que desee:");
                System.out.println("1. Visualizar un histograma");
                System.out.println("2. SALIR");
                System.out.print("Su opcion es:");
                int menu = Integer.parseInt(scanner.nextLine());

                // Evaluar la elección del usuario
                switch (menu) {
                    case 1:
                        // Llamar al método para generar el histograma
                        generarHistograma(scanner);
                        break;
                    case 2:
                        // Cambiar el estado del programa para salir del bucle
                        estadoPrograma = true;
                        break;
                    default:
                        // Mostrar un mensaje de advertencia si la opción no es válida
                        System.out.println("Ingrese una opción válida de acuerdo al menú");
                        break;
                }
            } catch (NumberFormatException e) {
                // Mostrar un mensaje de error si la entrada no es un número
                System.out.println("El valor ingresado no es un número");
            } catch (Exception e) {
                // Mostrar un mensaje de error para cualquier otro tipo de excepción
                System.out.println("ERROR EN LA EJECUCIÓN: " + e.getMessage());
            }
        } while (!estadoPrograma); // Repetir el bucle hasta que el usuario elija salir

        scanner.close();
    }

    // Método para generar el histograma
    private static void generarHistograma(Scanner scanner) {
        // Pedir al usuario la cantidad de números que desea ingresar
        System.out.println("Ingrese la cantidad de números que desea ingresar:");
        int tamanoArrays = Integer.parseInt(scanner.nextLine());
        // Crear un array para almacenar los números ingresados
        int[] numeros = new int[tamanoArrays];

        // Leer los números ingresados por el usuario
        for (int i = 0; i < tamanoArrays; i++) {
            System.out.println("Ingrese un número entero:");
            System.out.println("Número " + (i + 1) + ":");
            numeros[i] = Integer.parseInt(scanner.nextLine());
        }

        // Crear un HashMap para contar las ocurrencias de cada número
        Map<Integer, Integer> frecuencias = new HashMap<>();

        // Contar la frecuencia de cada número ingresado
        for (int numero : numeros) {
            frecuencias.put(numero, frecuencias.getOrDefault(numero, 0) + 1);
        }

        // Determinar el rango de números ingresados para incluir los que no están presentes
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int numero : numeros) {
            if (numero < min) {
                min = numero;
            }
            if (numero > max) {
                max = numero;
            }
        }

        // Crear un StringBuilder para construir el histograma
        StringBuilder histograma = new StringBuilder();
        // Construir el histograma
        for (int i = min; i <= max; i++) {
            histograma.append(i).append(": ");
            if (frecuencias.containsKey(i)) {
                for (int j = 0; j < frecuencias.get(i); j++) {
                    histograma.append("*");
                }
            }
            histograma.append("\n");
        }

        // Mostrar el histograma en la consola
        System.out.println("Histograma:");
        System.out.println(histograma.toString());
    }
}
