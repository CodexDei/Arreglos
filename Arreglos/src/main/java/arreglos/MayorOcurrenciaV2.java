package arreglos;

import javax.swing.*;
import java.util.Scanner;

public class MayorOcurrenciaV2 {

    public static boolean estadoPrograma = false;

    public static void main(String[] args) {

        do {

            try {

                int numeros[] = new int[10];
                int contador[] = new int[10];


                int menu = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la accion que desee:\n" +
                        "1. Hallar la mayor concurrencia\n" +
                        "2. SALIR"));

                switch (menu){

                    case 1:

                        Scanner scanner = new Scanner(System.in);
                        int[] arreglo = new int[10];

                        // ingreamos los datos por ejemplo {1, 2, 3, 3, 4, 5, 5, 5, 6, 7}
                        for (int i = 0; i < 10; i++) {
                            System.out.println("Ingrese un numero de 1 a 9: ");
                            arreglo[i] = scanner.nextInt();
                        }

                        // creamos un segundo arreglo llamado arregloCantidadValores (de igual largo)
                        // para guardar las cantidades de veces que se repite cada elemento
                        // del arreglo principal
                        int[] arregloCantidadValores = new int[10];

                        // luego llenamos este segundo arreglo con las cantidades de ocurrencia
                        // de los elementos del primer arreglo
                        for (int i = 0; i < arreglo.length; i++) {
                            int cantidad = 0;
                            for (int j = 0; j < arreglo.length; j++) {
                                if (arreglo[i] == arreglo[j]) {
                                    cantidad++;
                                }
                            }
                            arregloCantidadValores[i] = cantidad;
                        }

                        // luego obtenemos el valor de la mayor ocurrencia (mas veces repetido)
                        // y el indice o pocicion para obtener el numero mas repetido
                        int indice = 0; // indice del elemento con la mayor ocurrencia (mas repetido)
                        int max = 0; // la cantidad mayor de veces (la mayor ocurrencia)
                        for (int i = 0; i < 10; i++) {
                            if (max < arregloCantidadValores[i]) {
                                max = arregloCantidadValores[i];
                                indice = i;
                            }
                        }
                        System.out.println("La mayor ocurrencia es: " + max);
                        System.out.println("El elemento que mas se repite es: " + arreglo[indice]);
                        System.out.println("el elemento " + arreglo[indice] + " esta repetido " + max + "veces!");


                        break;

                    case 2:

                        estadoPrograma = true;

                        break;

                    default:

                        JOptionPane.showMessageDialog(null,
                                "Ingrese una opcion valida de acuerdo al menu", "Cuidado",
                                JOptionPane.WARNING_MESSAGE);

                        break;

                }


            }catch (NumberFormatException e){

                JOptionPane.showMessageDialog(null,
                        "El valor ingresado no es un numero", "Error", JOptionPane.ERROR_MESSAGE);

            }catch (Exception e){

                JOptionPane.showMessageDialog(null,
                        "ERROR EN LA EJECUCION: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        }while (!estadoPrograma);
    }
}
