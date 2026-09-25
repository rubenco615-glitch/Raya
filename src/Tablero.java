public class Tablero {

    private Ficha[][] casillas;
    private int tamaño;

    public Tablero(int tamaño) {
        this.tamaño = tamaño;
        this.casillas = new Ficha[tamaño][tamaño];
    }

    // Coloca la ficha si la casilla está libre. Devuelve true si tuvo éxito.
    public boolean jugar(Ficha ficha, int fila, int columna) {
        if (casillas[fila][columna] != null) {
            return false;
        }
        casillas[fila][columna] = ficha;
        return true;
    }

    // Devuelve true si todas las casillas están ocupadas.
    public boolean estaLleno() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if (casillas[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    // Comprueba si la ficha dada ha ganado en alguna dirección.
    public boolean gana(Ficha ficha) {
        return ganaHorizontal(ficha)
                || ganaVertical(ficha)
                || ganaDiagonalDirecta(ficha)
                || ganaDiagonalIndirecta(ficha);
    }

    // Comprueba victorias en filas.
    protected boolean ganaHorizontal(Ficha ficha) {
        for (int i = 0; i < tamaño; i++) {
            boolean lineaCompleta = true;
            for (int j = 0; j < tamaño; j++) {
                if (casillas[i][j] != ficha) {
                    lineaCompleta = false;
                    break;
                }
            }
            if (lineaCompleta) {
                return true;
            }
        }
        return false;
    }

    // Comprueba victorias en columnas.
    protected boolean ganaVertical(Ficha ficha) {
        for (int j = 0; j < tamaño; j++) {
            boolean lineaCompleta = true;
            for (int i = 0; i < tamaño; i++) {
                if (casillas[i][j] != ficha) {
                    lineaCompleta = false;
                    break;
                }
            }
            if (lineaCompleta) {
                return true;
            }
        }
        return false;
    }

    // Comprueba la diagonal principal (↘).
    protected boolean ganaDiagonalDirecta(Ficha ficha) {
        for (int i = 0; i < tamaño; i++) {
            if (casillas[i][i] != ficha) {
                return false;
            }
        }
        return true;
    }

    // Comprueba la diagonal secundaria (↙).
    protected boolean ganaDiagonalIndirecta(Ficha ficha) {
        for (int i = 0; i < tamaño; i++) {
            if (casillas[i][tamaño - 1 - i] != ficha) {
                return false;
            }
        }
        return true;
    }

    // Devuelve la representación de una ficha como String (o punto si está vacía).
    protected Object valueOf(Ficha ficha) {
        if (ficha == null) {
            return ".";
        }
        return ficha.name();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                sb.append(" ").append(valueOf(casillas[i][j]));
                if (j < tamaño - 1) {
                    sb.append(" |");
                }
            }
            sb.append("\n");
            if (i < tamaño - 1) {
                sb.append("---+---+---\n");
            }
        }
        return sb.toString();
    }
}
