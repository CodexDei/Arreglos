package arreglos;

public class EjemploArreglos {
    
    public static void main(String[] args) {
        
        //1. Declaramos una variable de tipo arreglo, tipo int
        int edades[];
        
        //2. instanciamos el arreglo int
        edades = new int[3];
        
        //3. Inicializamos valores del arreglo
        edades[0] = 20;
        edades[1] = 18;
        edades[2] = 11;
//      Se agregamos uno mas marcara error porque el array es de 3, por lo que su indice seria: 0,1,2
//      edades[3] = 7;
        
        //4. Imprimimos los valores del arreglo
        for (int i = 0; i < edades.length; i++) {
            System.out.println("Posicion "+ i + ": " + edades[i]);
        }
        
        //ARREGLO OBJECT
        System.out.println();
        System.out.println("ARREGLO OBJECT");
        //1. Declarar e instanciar un array tipo object
        Persona[] personas = new Persona[4];
        
        //2. Inicializar los valores del arreglo
        personas[0] = new Persona("Juan");
        personas[1] = new Persona("Paquito");
//      personas[2] = new Persona("Chamo");
        personas[3] = new Persona("Petunio");
        
        for (int i = 0; i < personas.length; i++) {
            System.out.println("Posicion " + i + ": " + personas[i]);
        }
        
    }
}
