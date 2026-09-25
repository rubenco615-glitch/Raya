import java.util.Scanner;

public class Main {

    // Devuelve "Jugador 1 (X)" o "Jugador 2 (O)" según la ficha.
    private static String nombreJugador(Ficha ficha) {
        if (ficha == Ficha.X) {
            return "Jugador 1 (X)";
        } else {
            return "Jugador 2 (O)";
        }
    }

    /**
     * Pide al usuario un número entre min y max (inclusive) hasta que introduzca
     * un valor válido. Rechaza entradas vacías, no numéricas o fuera de rango.
     */
    private static int leerNumero(Scanner scanner, String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            String linea = scanner.nextLine().trim();
            try {
                int valor = Integer.parseInt(linea);
                if (valor >= min && valor <= max) {
                    return valor;
                }
            } catch (NumberFormatException e) {
                // No era un número entero; se vuelve a pedir.
            }
            System.out.println("Entrada no válida. Introduce un número entre " + min + " y " + max + ".");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Partida partida = new Partida(3);

        System.out.println("=== TRES EN RAYA ===");
        System.out.println(partida);

        while (!partida.terminada()) {
            String jugador = nombreJugador(partida.getTurno());
            System.out.println("--- Turno de " + jugador + " ---");

            int fila    = leerNumero(scanner, "Introduce fila (1-3): ",    1, 3) - 1;
            int columna = leerNumero(scanner, "Introduce columna (1-3): ", 1, 3) - 1;

            if (!partida.jugar(fila, columna)) {
                System.out.println("⚠ Posición ya ocupada. Elige otra casilla.");
                continue;
            }
            System.out.println(partida);
        }

        Ficha ganador = partida.ganador();
        if (ganador != null) {
            System.out.println("¡Ha ganado " + nombreJugador(ganador) + "!");
        } else {
            System.out.println("¡Empate!");
        }

        scanner.close();
    }
}
