package arreglos;

import java.util.Scanner;

public class OrdenIrregularArreglo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] a, b, c;

        a = new int[5];
        b = new int[5];
        c = new int[10];

        System.out.println("Ingrese 10 numeros enteros");


        for (int i = 0; i < a.length; i++) {

          //Ingresamos los primeros 5 numeros
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < b.length; i++) {

            //genera un numero aleatorio entre 0 y 99
//            b[i] = (int) (Math.random() * 100);
            b[i] = sc.nextInt();
        }

        int aux = 0;

        //Este for combina los dos anteriores, el incremento del for externo y el interno deben tener el mismo numero
        //El tamaño de los arreglos debe ser del multiplo del incrementador, entonces si es 2, el tamaño del arreglo dede ser multiplo de 2

        System.out.println("Los numeros se han ordenado asi: " +
        "el último, el primero, el penúltimo, el segundo, el antepenúltimo, el tercero, y así sucesivamente.");
        
        for (int i = 0; i < b.length; i += 1) {

            for (int j = b.length - 1; j > b.length -2; j--) {
                c[aux++] = b[j - i];
            }

            for (int j = 0; j < 1; j++) {
                c[aux++] = a[i + j];
            }
        }

        for (int i = 0; i < c.length; i++) {

            System.out.println(c[i]);
        }
    }

}
