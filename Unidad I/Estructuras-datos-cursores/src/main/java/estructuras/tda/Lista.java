package estructuras.tda;

// La lista ve a los nodos como una estructura logica enlazada por indices
public class Lista<T> {
    // ===== Atributos =====
    private static final int CAPACIDAD_DEFAULT = 100;
    private static final int POSICION_NULA = -1;

    private Nodo<T>[] nodos;
    private Cursor cursor;
    private int encabezado; // índice del primer elemento
    private int tamano;

    // ===== Constructores =====
    public Lista() {
        this(CAPACIDAD_DEFAULT);
    }

    @SuppressWarnings("unchecked")
    public Lista(int capacidad) {
        if (capacidad <= 0)
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0");

        nodos = new Nodo[capacidad];
        cursor = new Cursor(capacidad);
        encabezado = POSICION_NULA;
        tamano = 0;
    }

    // ===== Gettters =====
    public int getTamano() {
        return tamano;
    }

    // ===== Metodos Privados =====
    private boolean esPosicionValida(int posicion) {
        return posicion >= 1 && posicion <= FIN();
    }

    private int obtenerIndiceAnterior(int posicion) {
        if (posicion <= 1 || !esPosicionValida(posicion) || VACIA()) {
            return POSICION_NULA;
        }

        int actual = encabezado;
        int anterior = POSICION_NULA;

        for (int i = 1; i < posicion && actual != POSICION_NULA; i++) {
            anterior = actual;
            actual = nodos[actual].getSiguiente();
        }

        return anterior;
    }

    // ===== Metodos Publicos =====
    public void INSERTA(T valor, int posicion) {
        if (!esPosicionValida(posicion))
            throw new IndexOutOfBoundsException("Posición inválida: " + posicion);

        try {
            int nuevoIndice = cursor.reservarMemoria();
            nodos[nuevoIndice] = new Nodo<>(valor);

            if (posicion == 1) {
                // Caso 1: Nuevo encabezado
                nodos[nuevoIndice].setSiguiente(encabezado);
                encabezado = nuevoIndice;
            } else {
                // Caso 2: Inserta en medio o al final
                int indiceAnterior = obtenerIndiceAnterior(posicion);
                if (indiceAnterior == POSICION_NULA) {
                    cursor.liberarPosicion(nuevoIndice);
                    throw new RuntimeException("Error al obtener nodo anterior");
                }

                // Nuevo nodo apunta al indice siguiente
                nodos[nuevoIndice].setSiguiente(nodos[indiceAnterior].getSiguiente());

                // El Nodo anterior apunta al nuevo Nodo
                nodos[indiceAnterior].setSiguiente(nuevoIndice);
            }

            tamano++;
        } catch (RuntimeException e) {
            throw new RuntimeException("No se pudo insertar el elemento: " + e.getMessage());
        }
    }

    public int LOCALIZA(T valor) {
        if (valor == null)
            return POSICION_NULA;

        int actual = encabezado;
        int posicion = 1;

        while (actual != POSICION_NULA) {
            if (nodos[actual].getValor().equals(valor)) {
                return posicion;
            }
            actual = nodos[actual].getSiguiente();
            posicion++;
        }

        return POSICION_NULA; // No se encontrarion coincidencias
    }

    public T RECUPERA(int posicion) {
        if (VACIA())
            throw new RuntimeException("La lista está vacía");

        if (!esPosicionValida(posicion) || posicion == FIN())
            throw new IndexOutOfBoundsException("Posición fuera de rango: " + posicion);

        int indice;

        if (posicion == 1) {
            indice = encabezado;
        } else {
            indice = nodos[obtenerIndiceAnterior(posicion)].getSiguiente();
        }

        return indice != POSICION_NULA ? nodos[indice].getValor() : null;
    }

    public T SUPRIME(int posicion) {
        if (VACIA())
            throw new RuntimeException("La lista está vacía");

        if (!esPosicionValida(posicion) || posicion == FIN())
            throw new IndexOutOfBoundsException("Posición fuera de rango: " + posicion);

        int indiceAEliminar;
        T valorELiminado;

        if (posicion == 1) {
            // Caso 1: Eliminar el Primer Nodo
            indiceAEliminar = encabezado;
            valorELiminado = nodos[indiceAEliminar].getValor();
            encabezado = nodos[indiceAEliminar].getSiguiente();
        } else {
            // Caso 2: Eliminar cualquier otro Nodo
            int indiceAnterior = obtenerIndiceAnterior(posicion);
            indiceAEliminar = nodos[indiceAnterior].getSiguiente();
            valorELiminado = nodos[indiceAEliminar].getValor();
            nodos[indiceAnterior].setSiguiente(nodos[indiceAEliminar].getSiguiente());
        }

        cursor.liberarPosicion(indiceAEliminar);
        nodos[indiceAEliminar] = null; // Limpiar Referencia
        tamano--;

        return valorELiminado;

    }

    public int SIGUIENTE(int posicion) {
        return (VACIA() || !esPosicionValida(posicion) || posicion >= tamano) ? FIN() : posicion + 1;
    }

    public int ANTERIOR(int posicion) {
        return (VACIA() || !esPosicionValida(posicion) || posicion <= 1) ? PRIMERO() : posicion - 1;
    }

    public int PRIMERO() {
        return VACIA() ? FIN() : 1;
    }

    public void ANULA() {
        while (!VACIA()) {
            SUPRIME(1);
        }
    }

    public boolean VACIA() {
        return encabezado == POSICION_NULA;
    }

    public int FIN() {
        return tamano + 1;
    }

    // ===== Metodos de Comportamiento =====
    public void imprimir() {
        System.out.print("Lista<");
        int actual = encabezado;
        boolean primero = true;

        while (actual != POSICION_NULA) {
            if (!primero)
                System.out.print(", ");
            System.out.print("'" + nodos[actual].getValor() + "'");
            actual = nodos[actual].getSiguiente();
            primero = false;
        }
        System.out.println(">");
    }
}
