package estructuras;

import estructuras.tda.Cola;
import estructuras.tda.Lista;
import estructuras.tda.Pila;

public class App {
    public static void main(String[] args) {

        Utilidades.imprimirTitulo("Prueba de Palabra Palindroma");
        Lista<Character> palabra1 = new Lista<>();
        String test1 = "anilina";

        for (char c : test1.toCharArray()) {
            palabra1.INSERTA(c, palabra1.FIN());
        }

        System.out.println("¿'" + test1 + "' es palindromo? " + esPalindromo(palabra1));

        Lista<Character> palabra2 = new Lista<>();
        String test2 = "radar";

        for (char c : test2.toCharArray()) {
            palabra2.INSERTA(c, palabra2.FIN());
        }

        System.out.println("¿'" + test2 + "' es palindromo? " + esPalindromo(palabra2));

        Lista<Character> palabra3 = new Lista<>();
        String test3 = "hola";

        for (char c : test3.toCharArray()) {
            palabra3.INSERTA(c, palabra3.FIN());
        }

        System.out.println("¿'" + test3 + "' es palindromo? " + esPalindromo(palabra3));

        Utilidades.imprimirTitulo("Prueba de Invertir Lista con una Cola");
        Lista<Integer> numeros = new Lista<>();
        numeros.INSERTA(1, numeros.FIN());
        numeros.INSERTA(2, numeros.FIN());
        numeros.INSERTA(3, numeros.FIN());
        numeros.INSERTA(4, numeros.FIN());
        numeros.INSERTA(5, numeros.FIN());
        numeros.imprimir();

        invertirListaConCola(numeros);

        numeros.imprimir();
    }

    private static boolean esPalindromo(Lista<Character> lista) {
        // Validación inicial
        if (lista == null || lista.VACIA()) {
            return false;
        }

        Pila<Character> pila = new Pila<>();
        int indice = 1;

        // Primera pasada: llenar la pila
        while (indice < lista.FIN()) {
            pila.METE(lista.RECUPERA(indice));
            indice++;
        }

        // Segunda pasada: comparar mientras la pila no esté vacia
        indice = 1;
        while (!pila.VACIA()) {
            if (Character.toLowerCase(lista.RECUPERA(indice)) != Character.toLowerCase(pila.SACA())) {
                return false;
            }
            indice++;
        }

        return true;
    }

    // Invierte una Lista usando exclusivamente una Cola (in-place)
    public static <T> void invertirListaConCola(Lista<T> lista) {
        if (lista == null || lista.VACIA())
            return;

        Cola<T> cola = new Cola<>(lista.getTamano());

        // Mover todos los elementos a la cola (preserva orden original en la cola)
        while (!lista.VACIA()) {
            cola.poneEnCola(lista.SUPRIME(lista.PRIMERO()));
        }

        // Reconstruir la lista insertando siempre al inicio => queda invertida
        while (!cola.VACIA()) {
            lista.INSERTA(cola.quitaDeCola(), lista.PRIMERO());
        }
    }

}