package estructuras.tda;

public class Cola<T> extends AbstractTDA<T> {

    // ===== Contructores =====
    public Cola() {
        super();
    }

    public Cola(int capacidad) {
        super(capacidad);
    }

    // ===== Metodos Publicos =====
    public void ANULA() {
        elementos.ANULA();
    }

    public T FRENTE() {
        if (VACIA()) {
            throw new RuntimeException("La cola está vacía");
        }
        return elementos.RECUPERA(elementos.PRIMERO());
    }

    public void poneEnCola(T valor) {
        if (valor == null) {
            throw new IllegalArgumentException("No se puede insertar un valor nulo");
        }
        elementos.INSERTA(valor, elementos.FIN());
    }

    public T quitaDeCola() {
        if (VACIA()) {
            throw new RuntimeException("La cola está vacía, no se puede quitar elemento");
        }
        return elementos.SUPRIME(elementos.PRIMERO());
    }

    @Override
    public void imprimir() {
        System.out.println("\nContenido de la Cola:");
        elementos.imprimir();
    }
}
