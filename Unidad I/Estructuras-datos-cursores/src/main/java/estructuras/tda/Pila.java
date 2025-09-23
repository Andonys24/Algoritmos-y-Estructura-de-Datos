package estructuras.tda;

public class Pila<T> extends AbstractTDA<T> {

    // ===== Contructores =====
    public Pila() {
        super();
    }

    public Pila(int capacidad) {
        super(capacidad);
    }

    // ===== Metodos Publicos =====
    public void METE(T valor) {
        if (valor == null) {
            throw new IllegalArgumentException("No se puede insertar un valor nulo");
        }
        elementos.INSERTA(valor, elementos.PRIMERO());
    }

    public T SACA() {
        if (VACIA()) {
            throw new RuntimeException("La pila está vacía, no se puede sacar elemento");
        }
        return elementos.SUPRIME(elementos.PRIMERO());
    }

    public T TOPE() {
        if (VACIA()) {
            throw new RuntimeException("La pila está vacía");
        }
        return elementos.RECUPERA(elementos.PRIMERO());
    }

    @Override
    public void imprimir() {
        System.out.println("\nContenido de la Pila:");
        elementos.imprimir();
    }
}
