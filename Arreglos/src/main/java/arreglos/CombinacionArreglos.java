package arreglos;

import javax.swing.*;

public class CombinacionArreglos {

    public static void main(String[] args) {

        int [] a, b, c;

        a = new int[10];
        b = new int[10];
        c = new int[20];

        for (int i = 0; i < a.length; i++) {

            //genera un numero aleatorio entre 0 y 99
//            a[i] = (int) (Math.random() * 100);
            a[i] = (i + 1);
        }

        for (int i = 0; i < b.length; i++) {

            //genera un numero aleatorio entre 0 y 99
//            b[i] = (int) (Math.random() * 100);
            b[i] = (i + 1 ) * 5;
        }

        int aux = 0;

        //Este for combina los dos anteriores, el incremento del for externo y el interno deben tener el mismo numero
        //El tamaño de los arreglos debe ser del multiplo del incrementador, entonces si es 2, el tamaño del arreglo dede ser multiplo de 2
        for (int i = 0; i < b.length; i += 2) {

           for (int j = 0; j < 2; j++) {
               c[aux++] = a[i+j];
           }

           for (int j = 0; j < 2; j++) {
               c[aux++] = b[i+j];
           }

        }

        for (int i = 0; i < c.length; i++) {

            System.out.println(c[i]);
        }

    }
}
