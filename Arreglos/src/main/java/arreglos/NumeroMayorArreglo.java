package arreglos;

import javax.swing.*;

public class NumeroMayorArreglo {


    public static void main(String[] args) {

        int tamanioArreglo = Integer.parseInt(
                JOptionPane.showInputDialog("Cuantos numeros desea comparar para saber cual es mayor")
        );

        int[] numeros = new int[tamanioArreglo];

        for (int i = 0; i < numeros.length; i++) {

            numeros[i] = Integer.parseInt(
                    JOptionPane.showInputDialog("Ingrese el numero " + (i + 1) + ":"
            ));
        }
        int max = 0;

        for (int i = 1; i < numeros.length; i++) {

            //Se busca el nuemro mayor con un operador ternario
            max = (numeros[max] > numeros[i]) ? numeros[max] : numeros[i];

            //Otra forma usando la clase Max para hallar el numero mayor en el arreglo
//            max = Math.max(numeros[max], numeros[i]);
        }

        JOptionPane.showMessageDialog(null, "EL numero mayor es: " + max);
    }
}
