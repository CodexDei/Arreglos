package arreglos;

import javax.swing.*;
import java.util.ArrayList;

public class MayorOcurrencia10Num {

    public static boolean estadoPrograma = false;

    public static void main(String[] args) {

        do {

            try {

                int menu = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la accion que desee:\n" +
                        "1. Hallar la mayor concurrencia\n" +
                        "2. SALIR"));

                switch (menu){

                    case 1:

                            mayorConcurrencia();
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

    private static void mayorConcurrencia() {

        int numeros[] = new int[10];
        int contador[] = new int[10];

        for(int i = 0; i < numeros.length; i++) {

            numeros[i] = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingrese solo numeros enteros del 1 al 9\n Numero " + (i + 1)));


            if (numeros[i] <= 0 || numeros[i] > 9) {

                JOptionPane.showMessageDialog(null,
                        "Ingrese solo numeros del 1 al 9", "Recuerde",
                        JOptionPane.WARNING_MESSAGE);
                --i;
            }
        }

        // Contar las ocurrencias de cada número en el arreglo
        for (int i = 0; i < numeros.length; i++) {
            contador[numeros[i]]++;
        }

        // Encontrar el número con más ocurrencias
        int maxOcurrencias = 0;
        for (int i = 1; i < contador.length; i++) {
            if (contador[i] > maxOcurrencias) {
                maxOcurrencias = contador[i];
            }
        }

        // Recopilar todos los números con la cantidad máxima de ocurrencias
        ArrayList<Integer> numerosMaxOcurrencias = new ArrayList<>();

        for (int i = 1; i < contador.length; i++) {
            if (contador[i] == maxOcurrencias && maxOcurrencias > 1) {
                numerosMaxOcurrencias.add(i);
            }
        }

        // Mostrar el resultado usando JOptionPane
        String mensaje;
        if (numerosMaxOcurrencias.isEmpty()) {
            mensaje = "No hay números que se repitan en el arreglo.";
        } else {
            mensaje = "Números con más ocurrencias:\n";
            for (int numero : numerosMaxOcurrencias) {
                mensaje += "Número " + numero + " aparece " + maxOcurrencias + " veces\n";
            }
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }
}
