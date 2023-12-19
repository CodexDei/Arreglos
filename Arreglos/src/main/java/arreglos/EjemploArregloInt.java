package arreglos;

import java.util.Arrays;
import java.util.Scanner;

public class EjemploArregloInt {
    
    static boolean estado = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //1. Declaramos una variable de tipo arreglo, tipo int
        int edades[];

        //2. instanciamos el arreglo int
        edades = new int[10];

        //3. Inicializamos valores del arreglo
        edades[0] = 20;
        edades[1] = 8;
        edades[2] = 11;
        edades[3] = 30;
        edades[4] = 155;
        edades[5] = 15;
        edades[6] = 20;
        edades[7] = 45;
        edades[8] = 87;
        edades[9] = 1000;
//      Se agregamos uno mas marcara error porque el array es de 3, por lo que su indice seria: 0,1,2
//      edades[3] = 7;

        //4. Imprimimos los valores del arreglo
        for (int i = 0; i < edades.length; i++) {
            System.out.println("Posicion " + i + ": " + edades[i]);
        }

        System.out.println("ARRAY EDADES ORDEN DESCENDENTE");
        ordenDescendente(edades);
        for (int i = 0; i < edades.length; i++) {
            System.out.println("Posicion " + i + ": " + edades[i]);
        }

        System.out.println("ARRAY EDADES ORDEN ASCENDENTE");
        ordenAscendente(edades);

        for (int i = 0; i < edades.length; i++) {
            System.out.println("Posicion " + i + ": " + edades[i]);
        }

        do {
            System.out.println();
            System.out.println("BUSQUEDA ELEMENTO");
            System.out.println("Desea buscar un numero en el array?");
            System.out.println("1. Hacer busqueda");
            System.out.println("2. Salir");
            System.out.print("Su opcion es:");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:

                    System.out.println();
                    System.out.print("Ingrese el numero que desea buscar:");
                    int elementoBuscar = sc.nextInt();
                    sc.nextLine();
                    int indice = buscarElemento(edades, elementoBuscar);
                    if (indice >= 0) {

                        System.out.println("El elemento " + elementoBuscar + " se encuentra en el indice " + indice);
                        

                    } else {

                        System.out.println("El elemento " + elementoBuscar + " NO se encuentra en el indice ");
                    }
                    break;
                    
                case 2:
                    
                    estado = true;
                    break;
                    
                default:
                    System.out.println("Ingrese solo 1 ó 2");
                    break;
            }

        } while (!estado);
    }

    //metodo ordena array forma ascendente
    public static void ordenAscendente(int array[]) {
        Arrays.sort(array);
    }

    //metodo ordena array forma descendente
    public static void ordenDescendente(int array[]) {

        Arrays.sort(array);
        //ordena array metodo mas eficiente pero complejo
//        for (int i = 0; i < array.length / 2; i++) {
//            // Se intercambian los elementos de las posiciones i y (longitud - 1 - i)
//            int temp = array[i];
//            array[i] = array[array.length - 1 - i];
//            array[array.length - 1 - i] = temp;
//        }

        //ordena descendente simplificado, luego de un Arrays.sort
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    //metodo para buscar un elemento de un array
    public static int buscarElemento(int array[], int elemento) {
        Arrays.sort(array);
        return Arrays.binarySearch(array, elemento);
    }

}
