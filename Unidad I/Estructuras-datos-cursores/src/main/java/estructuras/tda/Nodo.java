package estructuras.tda;

public class Nodo<T> {
    // ===== Atributos =====
    private T valor;
    private int siguiente;

    // ===== Constructores =====
    public Nodo() {
        this(null);
    }

    public Nodo(T valor) {
        this.valor = valor;
        siguiente = -1;
    }

    public Nodo(T valor, int siguiente) {
        this.valor = valor;
        this.siguiente = siguiente;
    }

    // ===== Getters Y Setters =====
    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public int getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(int siguiente) {
        this.siguiente = siguiente;
    }

    // ===== Metodos de Comportamiento =====
    @Override
    public String toString() {
        return "Nodo [valor=" + valor + ", siguiente=" + siguiente + "]";
    }

}
