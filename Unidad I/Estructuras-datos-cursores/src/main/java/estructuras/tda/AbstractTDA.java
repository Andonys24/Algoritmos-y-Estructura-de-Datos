package estructuras.tda;

public abstract class AbstractTDA<T> {
    // ===== Atributos =====
    protected final Lista<T> elementos;

    // ===== Contructores =====
    protected AbstractTDA() {
        this.elementos = new Lista<>();
    }

    protected AbstractTDA(int capacidad) {
        this.elementos = new Lista<>(capacidad);
    }

    // ===== Getters =====
    public int getTamano() {
        return elementos.getTamano();
    }

    // ===== Metodos de Comportamiento ========
    public void ANULA() {
        elementos.ANULA();
    }

    public boolean VACIA() {
        return elementos.VACIA();
    }

    public abstract void imprimir();
}
