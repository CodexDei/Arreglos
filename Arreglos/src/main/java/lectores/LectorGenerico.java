package lectores;

import java.util.Scanner;

public class LectorGenerico {

    private Scanner scanner;

    public LectorGenerico() {
        scanner = new Scanner(System.in);
    }

    @SuppressWarnings("unchecked")
    public <T> T leerDato(Class<T> tipo) {
        if (tipo == Integer.class) {
            return (T) Integer.valueOf(scanner.nextInt());
        } else if (tipo == Double.class) {
            return (T) Double.valueOf(scanner.nextDouble());
        } else if (tipo == String.class) {
            return (T) scanner.nextLine();
        } else if (tipo == Boolean.class) {
            return (T) Boolean.valueOf(scanner.nextBoolean());
        } else {
            throw new IllegalArgumentException("Tipo no soportado: " + tipo);
        }
    }

    public static void main(String[] args) {
        LectorGenerico lector = new LectorGenerico();

        System.out.println("Introduce un número entero:");
        Integer entero = lector.leerDato(Integer.class);
        System.out.println("Has introducido: " + entero);

        System.out.println("Introduce un número decimal:");
        Double decimal = lector.leerDato(Double.class);
        System.out.println("Has introducido: " + decimal);

        System.out.println("Introduce una cadena de texto:");
        String texto = lector.leerDato(String.class);
        System.out.println("Has introducido: " + texto);
    }
}



