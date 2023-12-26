package arreglos;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EjemploArregloInt {

    //1. Declaramos una variable de tipo arreglo, tipo int
    static int edades[];
    static boolean estado = false;
    static boolean estadoRellenarArray = false;
    static int tamañoArray;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        do {

            try {

                do {

                    System.out.println();
                    System.out.println("INGRESE LA OPCION QUE DESEE RESPECTO AL ARRAY");
                    System.out.println("1. Rellenar Array");
                    System.out.println("2. Imprimir Array");
                    System.out.println("3. Ordenar menor a mayor");
                    System.out.println("4. Ordenar mayor a menor");
                    System.out.println("5. Buscar elemento en el array");
                    System.out.println("6. Copiar array");
                    System.out.println("7. Sumar elementos");
                    System.out.println("8. Valor promedio");
                    System.out.println("9. Elemento mayor");
                    System.out.println("10. Elemento menor");
                    System.out.println("11. Verificar igualdad entre arrays");
                    System.out.println("12. Salir");
                    System.out.print("Su opcion es:");
                    int opcion = sc.nextInt();
                    sc.nextLine();

                    switch (opcion) {

                        case 1:

                          do{  
                            
                            System.out.print("Ingrese el tamaño del array:");
                            tamañoArray = sc.nextInt();

                            if (tamañoArray == 0) {

                                System.out.println("Ingrese un valor mayor a cero");

                            } else {
                                estadoRellenarArray = true;
                            }
                          }while(!estadoRellenarArray);  

                            //2. instanciamos el arreglo int
                            edades = new int[tamañoArray];

                            //Rellenamos arreglo
                            for (int i = 0; i < edades.length; i++) {
                                System.out.print("Ingrese el valor para la posicion " + i + ":");
                                edades[i] = sc.nextInt();
                            }
                           
                            break;

                        case 2:

                            //4. Imprimimos los valores del arreglo
                            System.out.println("IMPRESION DEL ARRAY:");
                            for (int i = 0; i < edades.length; i++) {
                                System.out.println("Posicion " + i + ": " + edades[i]);
                            }
                            break;

                        case 3:

                            System.out.println("ARRAY EDADES MENOR A MAYOR");
                            menorMayor(edades);

                            for (int i = 0; i < edades.length; i++) {
                                System.out.println("Posicion " + i + ": " + edades[i]);
                            }
                            break;

                        case 4:

                            System.out.println("ARRAY EDADES MAYOR A MENOR");
                            mayorMenor(edades);
                            for (int i = 0; i < edades.length; i++) {
                                System.out.println("Posicion " + i + ": " + edades[i]);
                            }
                            break;

                        case 5:

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

                        case 6:

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

                        case 7:

                            System.out.println("SUMA ARREGLO");
                            int sumaArreglo = sumaArray(edades);
                            System.out.println("La suma del arreglo es: " + sumaArreglo);
                            break;

                        case 8:

                            double promArray = promedioArray(edades);
                            System.out.println("El promedio del arreglo es: " + promArray);
                            break;

                        case 9:

                            System.out.println();
                            System.out.println("ELEMENTO MAYOR");
                            int mayor = elementoMayor(edades);
                            System.out.println("El elemento mayor es: " + mayor);
                            break;

                        case 10:

                            System.out.println("ELEMENTO MENOR");
                            int menor = elementoMenor(edades);
                            System.out.println("El elemento menor es: " + menor);

                            break;

                        case 11:

                            System.out.println("Estableceremos un segundo array para comparar");
                            System.out.print("Ingrese el tamaño del array:");
                            int array2 = sc.nextInt();
                            int[] arrayComparativo = new int[array2];

                            for (int i = 0; i < arrayComparativo.length; i++) {

                                System.out.println("Ingrese el valor de la posicion " + i + ":");
                                arrayComparativo[i] = sc.nextInt();
                            }

                            boolean igualdadArray = arrayIgual(edades, arrayComparativo);

                            if (igualdadArray == true) {

                                System.out.println("Los arrays son iguales");

                            } else {

                                System.out.println("Los arrays no son iguales");
                            }

                            break;

                        case 12:

                            estado = true;
                            break;

                        default:
                            System.out.println("Ingrese una opcion valida de acuerdo a la tabla");
                            break;
                    }

                } while (!estado);

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

    //suma array
    public static int sumaArray(int array[]) {
        int suma = Arrays.stream(array).sum();
        return suma;
    }

    //promedio array
    public static double promedioArray(int array[]) {
        double suma = Arrays.stream(array).sum();
        double promedio = suma / array.length;
        return promedio;
    }

    //Elemento mayor
    public static int elementoMayor(int array[]) {
//        int mayor = Arrays.stream(array).max().orElse(Integer.MAX_VALUE);
//        return mayor;
        Arrays.sort(array);

        int j = array.length - 1;
        int mayor = array[j];
        return mayor;
    }

    public static int elementoMenor(int array[]) {
//        Elemento mayor con metodos Java
//        int mayor = Arrays.stream(array).max().orElse(Integer.MAX_VALUE);
//        return mayor;

        Arrays.sort(array);

        int i = 0;
        int menor = array[i];
        return menor;
    }

    public static boolean arrayIgual(int array1[], int array2[]) {
        boolean igualdad = Arrays.equals(array1, array2);
        return igualdad;
    }
}
