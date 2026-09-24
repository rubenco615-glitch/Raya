import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Partida partida = new Partida(3);

        System.out.println("=== TRES EN RAYA ===");
        System.out.println(partida);

        while (!partida.terminada()) {
            System.out.print("Introduce fila (1-3): ");
            int fila = scanner.nextInt() - 1;

            System.out.print("Introduce columna (1-3): ");
            int columna = scanner.nextInt() - 1;

            if (fila < 0 || fila > 2 || columna < 0 || columna > 2) {
                System.out.println("Posición fuera del tablero. Inténtalo de nuevo.");
                continue;
            }

            partida.jugar(fila, columna);
            System.out.println(partida);
        }

        Ficha ganador = partida.ganador();
        if (ganador != null) {
            System.out.println("¡Ha ganado: " + ganador + "!");
        } else {
            System.out.println("¡Empate!");
        }

        scanner.close();
    }
}
