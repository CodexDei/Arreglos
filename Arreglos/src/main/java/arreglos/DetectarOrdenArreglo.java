package arreglos;

import javax.swing.*;
import java.util.InputMismatchException;

public class DetectarOrdenArreglo {

    public static boolean estatusPorgrama = false;

    public static void main(String[] args) {

        do {

            try{

                int estado = Integer.parseInt(JOptionPane.showInputDialog(
                        "Ingrese la opcion que desee:\n" +
                                "1. DETECTAR ORDEN DEL ARREGLO\n" +
                                "2. SALIR\n"
                ));

                switch (estado){

                    case 1:

                        int tamanioArreglo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del arreglo"));
                        int[] numeros = new int[tamanioArreglo];
                        boolean ordenAscendente = false;
                        boolean ordenDescendente = false;

                        for (int i = 0; i < numeros.length; i++) {
                            numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero " + (i + 1)));
                        }

                        for (int i = 0; i < numeros.length - 1; i++) {

                            if (numeros[i] > numeros[i+1]){

                                ordenDescendente = true;
                            }

                            if (numeros[i] < numeros[i+1]){

                                ordenAscendente = true;
                            }
                        }

                        if (ordenAscendente == true && ordenDescendente == false){

                            JOptionPane.showMessageDialog(null,
                                    "El arreglo esta ordenado ascendentemente");
                        }

                        if (ordenAscendente == false && ordenDescendente == true){

                            JOptionPane.showMessageDialog(null,
                                    "El arreglo esta ordenado descendentemente");
                        }


                        if (ordenAscendente == true && ordenDescendente == true){

                            JOptionPane.showMessageDialog(null,
                                    "El arreglo esta desordenado");
                        }

                        if (ordenAscendente == false && ordenDescendente == false){

                            JOptionPane.showMessageDialog(null,
                                    "Los elementos son iguales");
                        }

                        break;

                    case 2:

                        estatusPorgrama = true;

                        break;

                    default:

                        JOptionPane.showMessageDialog(null,
                                "Ingrese una opcion valida de acuerdo a la tabla");

                        break;

                }

            }catch (InputMismatchException e){

                JOptionPane.showMessageDialog(null,
                        "ERROR!!!! INGRESE UN VALOR VALIDO", "ERROR!!!", JOptionPane.ERROR_MESSAGE);

            }catch (Exception e){

                JOptionPane.showMessageDialog(null,
                        "ERROR DE COMPILACION: " + e.getMessage(), "ERROR!!!", JOptionPane.ERROR_MESSAGE);
            }

        }while (!estatusPorgrama);
    }
}
