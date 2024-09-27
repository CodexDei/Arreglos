package arreglos;

import lectores.LectorGenerico;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;

public class MetodosPrincipalesArreglos {

    public <T> void rellenarEstructura(T[] arreglo, Class<T> tipo){

        LectorGenerico lectorGenerico = new LectorGenerico();

        for (int i = 0; i < arreglo.length; i++){

            System.out.println("Ingrese el dato " + (i + 1) + ":");

            arreglo[i] = lectorGenerico.leerDato(tipo);
        }

    }

    public <T> void imprimir(T[] array){

        for (T t : array){

            System.out.println(t);
        }
    }

    public <T extends Comparable<T>> T[] ordenAscendente(T[] array) {

        List<T> lista = Arrays.asList(array);

        Collections.sort(lista);

        return lista.toArray(array);
    }



    public <T extends Comparable<T>> T[] ordenDescendente(T[] array) {

        List<T> lista = Arrays.asList(array);

        Collections.sort(lista, Collections.reverseOrder());

        return lista.toArray(array);
    }

    public <T extends Comparable<T>> int buscar(T[] arreglo,T dato){

        Arrays.sort(arreglo);

        int resultado = Arrays.binarySearch(arreglo, dato);

        return resultado;
    }

    public <T> T[] copiar(T[] array){

        return (T[]) Arrays.copyOf(array, array.length);
    }

    public <T extends Number> double sumar(T[] arreglo){

        double suma = 0.0;

        for (T elemento : arreglo){

            suma += elemento.doubleValue();
        }
        return suma;
    }

    public <T extends Number> double promedio(T[] arreglo){

        double suma = 0.0;
        double promedio = 0.0;

        for (T elemento : arreglo){

            suma += elemento.doubleValue();
        }

        promedio = suma / arreglo.length;

        return promedio;
    }

    public <T> T elementoMayor(T[] arreglo, Class<T> tipo){


        if (tipo == Integer.class){

            List lista = Arrays.asList(arreglo);

            Collections.sort(lista, Collections.reverseOrder());

            lista.toArray((IntFunction) lista);

            return arreglo[0];

        } else if (tipo == String.class) {

            List lista = Arrays.asList(arreglo);

            Collections.sort(lista, Collections.reverseOrder());

            lista.toArray(arreglo);

            return arreglo[0];
        }else {
        // Lanza una excepción si el tipo no es soportado
        throw new IllegalArgumentException("Tipo no soportado: " + tipo.getName());
        }

    }

    public <T> T elementoMenor(T[] arreglo, Class<T> tipo){

        if (tipo == Integer.class){

            Arrays.sort(arreglo);

        } else if (tipo == String.class) {

            List lista = Arrays.asList(arreglo);

            Collections.sort(lista, Collections.reverseOrder());

            lista.toArray(arreglo);

            return arreglo[0];

        }else {
            // Lanza una excepción si el tipo no es soportado
            throw new IllegalArgumentException("Tipo no soportado: " + tipo.getName());
        }

    }


}
