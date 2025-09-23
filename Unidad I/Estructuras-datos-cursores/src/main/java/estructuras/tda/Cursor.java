package estructuras.tda;

public class Cursor {
    // ===== Atributos =====
    private final int capacidad;
    private final boolean[] ocupado; // true si la posicion esta ocupada
    private int espaciosOcupados;

    // ===== Contructores =====
    public Cursor(int capacidad) {
        if (capacidad <= 0)
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0.");

        this.capacidad = capacidad;
        ocupado = new boolean[capacidad];
        this.espaciosOcupados = 0;
    }

    // ===== Getters =====
    public int getCapacidad() {
        return capacidad;
    }

    public int getEspaciosOcupados() {
        return espaciosOcupados;
    }

    // ===== Metodos de comportamiento =====
    public boolean validarRango(int index) {
        return index >= 0 && index < capacidad;
    }

    public boolean estaOcupado(int index) {
        return validarRango(index) && ocupado[index];
    }

    public boolean hayEspacioDisponible() {
        return espaciosOcupados < capacidad;
    }

    public int reservarMemoria() {
        if (!hayEspacioDisponible())
            throw new RuntimeException("No hay mas espacios disponibles en el cursor.");

        for (int i = 0; i < capacidad; i++) {
            if (!ocupado[i]) {
                ocupado[i] = true;
                espaciosOcupados++;
                return i;
            }
        }

        throw new RuntimeException("Error interno: no se pudo reservar memoria.");
    }

    public void liberarPosicion(int index) {
        if (!validarRango(index) || !ocupado[index])
            return; // esta fuera de rango o no esta ocupado

        ocupado[index] = false;
        espaciosOcupados--;
    }

    public void reiniciar() {
        for (int i = 0; i < capacidad; i++)
            ocupado[i] = false;

        espaciosOcupados = 0;
    }

    public void mostrarEstado() {
        System.out.println("Espacios ocupados: " + espaciosOcupados + "/" + capacidad);
        for (int i = 0; i < capacidad; i++) {
            System.out.print((ocupado[i] ? "[X]" : "[ ]") + " ");
            if ((i + 1) % 10 == 0)
                System.out.println();
        }
        if (capacidad % 10 != 0)
            System.out.println();
    }
}
