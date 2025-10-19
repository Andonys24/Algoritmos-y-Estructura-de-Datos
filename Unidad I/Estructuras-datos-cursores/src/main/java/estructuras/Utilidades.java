package estructuras;

import estructuras.tda.Cola;
import estructuras.tda.Lista;
import estructuras.tda.Pila;

public class Utilidades {

    public static void imprimirTitulo(final String title) {
        String asterisk = "*".repeat(title.length() * 3);
        String spaces = " ".repeat(title.length() - 1);

        System.out.println("\n" + asterisk);
        System.out.println("*" + spaces + title + spaces + "*");
        System.out.println(asterisk + "\n");
    }

    public static <T> Pila<T> invertirPila(Pila<T> pila) {
        Pila<T> pilaInvertida = new Pila<>(pila.getTamano());

        while (!pila.VACIA()) {
            pilaInvertida.METE(pila.SACA());
        }

        return pilaInvertida;
    }

    public static void probarLista() {
        System.out.println("----- PRUEBAS DE LA LISTA -----");
        Lista<String> lista = new Lista<>();

        System.out.println("Lista vacía:");
        lista.imprimir();

        // Agregar elementos
        System.out.println("\nAgregando elementos:");
        lista.INSERTA("A", lista.FIN());
        lista.INSERTA("B", lista.FIN());
        lista.INSERTA("C", lista.FIN());
        lista.INSERTA("D", 2);
        lista.imprimir();

        // Recuperar y localizar
        System.out.println("\nRecuperando el elemento en la posición 3: " + lista.RECUPERA(3));
        System.out.println("Localizando el elemento 'C': " + lista.LOCALIZA("C"));
        System.out.println("Localizando el elemento 'X': " + lista.LOCALIZA("X"));

        // Eliminar elementos
        System.out.println("\nEliminando el primer elemento:");
        lista.SUPRIME(lista.PRIMERO());
        lista.imprimir();

        System.out.println("\nEliminando el tercer elemento:");
        lista.SUPRIME(3);
        lista.imprimir();

        System.out.println("\nAnulando la lista:");
        lista.ANULA();
        lista.imprimir();

        System.out.println("\n-------------------------------------------");
    }

    public static void probarPila() {
        System.out.println("----- PRUEBAS DE LA PILA -----");
        Pila<Integer> pila = new Pila<>();

        System.out.println("Pila vacía? " + pila.VACIA());

        System.out.println("\nAgregando elementos a la pila...");
        pila.METE(10);
        pila.METE(20);
        pila.METE(30);

        System.out.println("\nPila original:");
        pila.imprimir();

        System.out.println("\nPila invertida:");
        pila = Utilidades.invertirPila(pila);
        pila.imprimir();

        System.out.println("El elemento en el TOPE es: " + pila.TOPE());

        System.out.println("Sacando un elemento: " + pila.SACA());
        pila.imprimir();

        System.out.println("\nMetemos 40 en la pila:");
        pila.METE(40);
        pila.imprimir();

        System.out.println("\nAnulando la pila:");
        pila.ANULA();
        pila.imprimir();
        System.out.println("Pila vacía? " + pila.VACIA());

        System.out.println("\n-------------------------------------------");
    }

    public static void probarCola() {
        System.out.println("----- PRUEBAS DE LA COLA -----");
        Cola<Character> cola = new Cola<>();

        System.out.println("Cola vacía? " + cola.VACIA());

        System.out.println("\nAgregando elementos a la cola...");
        cola.poneEnCola('A');
        cola.poneEnCola('B');
        cola.poneEnCola('C');
        cola.poneEnCola('D');

        System.out.println("\nCola original:");
        cola.imprimir();

        System.out.println("El elemento en el FRENTE es: " + cola.FRENTE());

        System.out.println("Sacando un elemento: " + cola.quitaDeCola());
        cola.imprimir();

        System.out.println("\nMetemos 'F' en la cola:");
        cola.poneEnCola('F');
        cola.imprimir();

        System.out.println("El elemento en el FRENTE es: " + cola.FRENTE());

        System.out.println("\nAnulando la Cola:");
        cola.ANULA();
        cola.imprimir();
        System.out.println("Cola vacía? " + cola.VACIA());

        System.out.println("\n-------------------------------------------");
    }
}
