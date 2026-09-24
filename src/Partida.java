public class Partida {

    private Tablero tablero;
    private Ficha turno;

    public Partida(int tamaño) {
        this.tablero = new Tablero(tamaño);
        this.turno = Ficha.X; // X siempre empieza
    }

    // Realiza la jugada. Solo cambia el turno si la jugada fue válida.
    public void jugar(int fila, int columna) {
        boolean jugadaValida = tablero.jugar(turno, fila, columna);
        if (jugadaValida) {
            turno = turno.siguiente();
        }
    }

    // Devuelve true si la partida ha terminado (alguien ganó o tablero lleno).
    public boolean terminada() {
        return tablero.gana(Ficha.X)
            || tablero.gana(Ficha.O)
            || tablero.estaLleno();
    }

    // Devuelve la ficha ganadora, o null si no hay ganador (empate o en curso).
    public Ficha ganador() {
        if (tablero.gana(Ficha.X)) {
            return Ficha.X;
        }
        if (tablero.gana(Ficha.O)) {
            return Ficha.O;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Turno: " + turno + "\n" + tablero.toString();
    }
}
