package arreglos;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EjemploArregloInt {

    static boolean estado = false;


    public static void main(String[] args) {

        //1. Declaramos una variable de tipo arreglo, tipo int
        Integer numeros[] = new Integer[0];
        String palabras[] = new String[0];
        boolean estadoRellenarArray = false;
        int tamañoArray;

        Scanner sc = new Scanner(System.in);
        MetodosPrincipalesArreglos mparr = new MetodosPrincipalesArreglos();

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
                    System.out.println("7. Sumar elementos (Solo para numeros)");
                    System.out.println("8. Valor promedio (Solo para numeros)");
                    System.out.println("9. Elemento mayor");
                    System.out.println("10. Elemento menor");
                    System.out.println("11. Verificar igualdad entre arrays");
                    System.out.println("12. Salir");
                    System.out.print("Su opcion es:");
                    int opcion = sc.nextInt();
                    sc.nextLine();

                    switch (opcion) {

                        case 1 -> {


                            do {

                                System.out.print("Ingrese el tamaño del array:");
                                tamañoArray = sc.nextInt();

                                if (tamañoArray == 0) {

                                    System.out.println("Ingrese un valor mayor a cero");

                                } else {
                                    estadoRellenarArray = true;
                                }
                            } while (!estadoRellenarArray);

                            //2. instanciamos el arreglo int
                            numeros = new Integer[tamañoArray];
                            //Para pruebas
                            palabras = new String[tamañoArray];

                            //Rellenamos arreglo
                            System.out.println("RELLENANDO ARRAY NUMEROS. INGRESE NUMEROS:");
                            mparr.rellenarEstructura(numeros, Integer.class);
                            System.out.println("RELLENANDO ARRAY PALABRAS. INGRESE PALABRAS:");
                            mparr.rellenarEstructura(palabras, String.class);
                        }

                        case 2 -> {

                            //4. Imprimimos los valores del arreglo
                            System.out.println("IMPRESION DEL ARRAY:");
                            System.out.println("IMPRESION DEL ARRAY NUMEROS:");
                            mparr.imprimir(numeros);
                            System.out.println("IMPRESION DEL ARRAY PALABRAS:");
                            mparr.imprimir(palabras);
                        }

                        case 3 -> {

                            System.out.println("ARRAY EDADES MENOR A MAYOR");
                            mparr.ordenAscendente(numeros);
                            mparr.imprimir(numeros);
                            System.out.println("ARRAY PALABRAS MENOR A MAYOR");
                            mparr.ordenAscendente(palabras);
                            mparr.imprimir(palabras);



                        }
                        case 4 -> {

                            System.out.println("ARRAY MAYOR A MENOR");
                            System.out.println("Desea:");
                            System.out.println("1. Solo ordenar de mayor a menor");
                            System.out.println("2. Ordenar de mayor a menor e imprimir array");
                            System.out.print("Su opcion es:");
                            int opcion2 = sc.nextInt();

                            switch (opcion2) {

                                case 1 -> {

                                    mparr.ordenDescendente(numeros);
                                    System.out.println("ARRAY PALABRAS MAYOR A MENOR");
                                    mparr.ordenDescendente(palabras);
                                }

                                case 2 -> {

                                    System.out.println("ARRAY EDADES MAYOR A MENOR");
                                    mparr.ordenDescendente(numeros);
                                    mparr.imprimir(numeros);
                                    System.out.println("ARRAY PALABRAS MAYOR A MENOR");
                                    mparr.ordenDescendente(palabras);
                                    mparr.imprimir(palabras);
                                }
                            }
                        }

                        case 5 -> {

                            //BUSCANDO NUMERO
                            System.out.println();
                            System.out.print("Ingrese el numero que desea buscar:");
                            int elementoBuscar = sc.nextInt();
                            sc.nextLine();
                            int indice = mparr.buscar(numeros, elementoBuscar);
                            if (indice >= 0) {

                                System.out.println("El elemento " + elementoBuscar + " se encuentra en el indice " + indice);

                            } else {

                                System.out.println("El elemento " + elementoBuscar + " NO se encuentra en el indice ");
                            }

                            //BUSCANDO NOMBRE
                            System.out.print("Ingrese el nombre que desea buscar:");
                            String  NombreBuscar = sc.nextLine();
                            
                            int indice2 = mparr.buscar(palabras, NombreBuscar);
                            if (indice >= 0) {

                                System.out.println("El elemento " + NombreBuscar + " se encuentra en el indice " + indice2);

                            } else {

                                System.out.println("El elemento " + NombreBuscar + " NO se encuentra en el indice ");
                            }
                        }

                        case 6 ->{

                            System.out.println("COPIAR ARRAY");
                            Integer[] arrayCopia = mparr.copiar(numeros);

                            System.out.println("ARRAY EDADES");
                            for (int i = 0; i < numeros.length; i++) {
                                System.out.println("Posicion " + i + ": " + numeros[i]);
                            }

                            System.out.println("ARRAY COPIA");
                            for (int i = 0; i < arrayCopia.length; i++) {
                                System.out.println("Posicion " + i + ": " + arrayCopia[i]);
                            }

                            System.out.println("************************************");

                            String[] arrayCopia2 = mparr.copiar(palabras);

                            System.out.println("ARRAY Nombres");
                            for (int i = 0; i < palabras.length; i++) {
                                System.out.println("Posicion " + i + ": " + palabras[i]);
                            }

                            System.out.println("ARRAY COPIA");
                            for (int i = 0; i < arrayCopia2.length; i++) {
                                System.out.println("Posicion " + i + ": " + arrayCopia2[i]);
                            }
                        }

                        case 7 -> {

                            System.out.println("SUMA ARREGLO");
                            double sumaArreglo = mparr.sumar(numeros);
                            System.out.println("La suma del arreglo es: " + sumaArreglo);
                        }

                        case 8 -> {

                            double promArray = mparr.promedio(numeros);
                            System.out.println("El promedio del arreglo es: " + promArray);
                        }

                        case 9 -> {

                            System.out.println();
                            System.out.println("ARRAY NUMEROS: ELEMENTO MAYOR");
                            Integer mayor = mparr.elementoMayor(numeros);
                            System.out.println("El elemento mayor es: " + mayor);

                            System.out.println();
                            System.out.println("ARRAY PALABRAS: ELEMENTO MAYOR");
                            String mayor2 = mparr.elementoMayor(palabras);
                            System.out.println("El elemento mayor es: " + mayor2);
                        }

                        case 10 -> {

                            System.out.println("ARRAY NUMEROS: ELEMENTO MENOR");
                            int menor = mparr.elementoMenor(numeros);
                            System.out.println("El elemento menor es: " + menor);
                            System.out.println("ARRAY PALABRAS: ELEMENTO MENOR");
                            String menor2 = mparr.elementoMenor(palabras);
                            System.out.println("El elemento menor es: " + menor2);

                        }
//
//                        case 11:
//
//                            System.out.println("Estableceremos un segundo array para comparar");
//                            System.out.print("Ingrese el tamaño del array:");
//                            int array2 = sc.nextInt();
//                            int[] arrayComparativo = new int[array2];
//
//                            for (int i = 0; i < arrayComparativo.length; i++) {
//
//                                System.out.println("Ingrese el valor de la posicion " + i + ":");
//                                arrayComparativo[i] = sc.nextInt();
//                            }
//
//                            boolean igualdadArray = arrayIgual(edades, arrayComparativo);
//
//                            if (igualdadArray == true) {
//
//                                System.out.println("Los arrays son iguales");
//
//                            } else {
//
//                                System.out.println("Los arrays no son iguales");
//                            }
//
//                            break;
//
                        case 12 -> {

                            estado = true;
                        }

                        default-> {
                            System.out.println("Ingrese una opcion valida de acuerdo a la tabla");
                        }
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


//    //Elemento mayor
//    public static int elementoMayor(int array[]) {
////        int mayor = Arrays.stream(array).max().orElse(Integer.MAX_VALUE);
////        return mayor;
//        Arrays.sort(array);
//
//        int j = array.length - 1;
//        int mayor = array[j];
//        return mayor;
//    }
//
//    public static int elementoMenor(int array[]) {
////        Elemento mayor con metodos Java
////        int mayor = Arrays.stream(array).max().orElse(Integer.MAX_VALUE);
////        return mayor;
//
//        Arrays.sort(array);
//
//        int i = 0;
//        int menor = array[i];
//        return menor;
//    }
//
//    public static boolean arrayIgual(int array1[], int array2[]) {
//        boolean igualdad = Arrays.equals(array1, array2);
//        return igualdad;
//    }
}
