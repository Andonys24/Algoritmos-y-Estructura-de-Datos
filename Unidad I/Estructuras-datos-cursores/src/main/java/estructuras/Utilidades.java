package estructuras;

import estructuras.tda.Pila;

public class Utilidades {
    public static <T> Pila<T> invertirPila(Pila<T> pila) {
        Pila<T> pilaInvertida = new Pila<>(pila.getTamano());

        while (!pila.VACIA()) {
            pilaInvertida.METE(pila.SACA());
        }

        return pilaInvertida;
    }
}
