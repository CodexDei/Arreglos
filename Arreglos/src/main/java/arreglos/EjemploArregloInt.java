package arreglos;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EjemploArregloInt {

    //1. Declaramos una variable de tipo arreglo, tipo int
    static int edades[];
    static boolean estado = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        do {

            try {

                System.out.print("Ingrese el tamaño del array:");
                int tamañoArray = sc.nextInt();

                //2. instanciamos el arreglo int
                edades = new int[tamañoArray];

                for (int i = 0; i < edades.length; i++) {
                    System.out.print("Ingrese el valor para la posicion " + i + ":");
                    edades[i] = sc.nextInt();
                }
                
                do{
                
                    
                System.out.println();
                System.out.println("INGRESE LA OPCION QUE DESEE RESPECTO AL ARRAY");
                System.out.println("1. Imprimir Array");
                System.out.println("2. Ordenar menor a mayor");
                System.out.println("3. Ordenar mayor a menor");
                System.out.println("4. Buscar elemento en el array");
                System.out.println("5. Copiar array");
                System.out.println("6. Salir");
                System.out.print("Su opcion es:");
                int opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {

                    case 1:

                        //4. Imprimimos los valores del arreglo
                        System.out.println("IMPRESION DEL ARRAY:");
                        for (int i = 0; i < edades.length; i++) {
                            System.out.println("Posicion " + i + ": " + edades[i]);
                        }
                        break;

                    case 2:

                        System.out.println("ARRAY EDADES MENOR A MAYOR");
                        menorMayor(edades);

                        for (int i = 0; i < edades.length; i++) {
                            System.out.println("Posicion " + i + ": " + edades[i]);
                        }
                        break;

                    case 3:

                        System.out.println("ARRAY EDADES MAYOR A MENOR");
                        mayorMenor(edades);
                        for (int i = 0; i < edades.length; i++) {
                            System.out.println("Posicion " + i + ": " + edades[i]);
                        }
                        break;

                    case 4:

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

                    case 5:

                        System.out.println("COPIAR ARRAY");
                        int[] arrayCopia = copiarArray(edades);

                        System.out.println("ARRAY EDADES");
                        for (int i = 0; i < edades.length; i++) {
                            System.out.println("Posicion " + i + ": " + edades[i]);
                        }

                        System.out.println("ARRAY COPIA");
                        for (int i = 0; i < arrayCopia.length; i++) {
                            System.out.println("Posicion " + i + ": " + arrayCopia[i]);
                        }
                        break;

                    case 6:

                        estado = true;
                        break;

                    default:
                        System.out.println("Ingrese una opcion valida de acuerdo a la tabla");
                        break;
                }
                
                }while(!estado);

            } catch (InputMismatchException e) {
                System.out.println("ERROR!!!! INGRESE UN VALOR VALIDO");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("ERROR DE COMPILACION: " + e.getMessage());
                sc.nextLine();
            }

        } while (!estado);
    }

    //metodo ordena array forma ascendente
    public static void menorMayor(int array[]) {
        Arrays.sort(array);
    }

    //metodo ordena array forma descendente
    public static void mayorMenor(int array[]) {

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

    //copiar array
    public static int[] copiarArray(int array[]) {
        int[] copia = Arrays.copyOf(array, array.length);
        return copia;
    }

}
