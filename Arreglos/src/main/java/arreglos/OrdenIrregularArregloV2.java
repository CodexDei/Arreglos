package arreglos;

import java.util.Scanner;

public class OrdenIrregularArregloV2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int i, j, numeros[];
        numeros = new int[10];
        for (i = 0; i < numeros.length; i++) {
            System.out.println("Ingrese un numero: ");
            numeros[i] = scanner.nextInt();
        }

        // como en cada iteración del for se muestran dos números
        // solo necesitaremos recorrer la mitad de iteraciones, con eso es suficiente.
        System.out.println("El resultado es:");
        for (i = 0, j = numeros.length - 1; i < numeros.length / 2; i++, j--) {

            System.out.print(" " + numeros[j] + " " + numeros[i]);
        }
    }
}