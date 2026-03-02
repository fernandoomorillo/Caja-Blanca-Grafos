package guiaviajero;
import java.util.*;

public class GuiaViajero {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random dado = new Random();
		int casilla = 1; 
		int galaxiaActual = 0;
		boolean juegoTerminado = false;
		System.out.println("Buenas, que empiece el juego");
		System.out.println("Estas en la casilla 1, galaxia 000.");

		while (!juegoTerminado) {

			System.out.println("\nPulsa ENTER para tirar los dados...");
			sc.nextLine();
			int dado1 = dado.nextInt(9) + 1;
			int dado2 = dado.nextInt(9) + 1;
			int dado3 = dado.nextInt(9) + 1;
			System.out.println("Has obtenido la galaxia: " + dado1 + "" + dado2 + "" + dado3);
			int suma = dado1 + dado2 + dado3;
			int direccionNueva = (suma / 10) + (suma % 10);
			System.out.println("Dirección reducida: " + direccionNueva);
			int distancia = Math.abs(direccionNueva - galaxiaActual);
			System.out.println("Distancia a la nueva galaxia: " + distancia);

			if (distancia <= 4) {
				casilla += distancia;
				System.out.println("Avanzas " + distancia + " casillas. Ahora estás en la casilla " + casilla);
			} else {
				System.out.println("Galaxia demasiado lejana, no puedes avanzar.");
			}
			galaxiaActual = direccionNueva;

			if (casilla == 31) {
				System.out.println("Te encuentras con Extraterrestres.");
				System.out.println("Te retrasan a la casilla 13.");
				casilla = 13;
			}
			if (casilla == 33) {
				System.out.println("Has caído en un agujero negro. Game Over.");
				juegoTerminado = true;
				break;
			}

			if (casilla > 42) {
				System.out.println("Te has pasado. Vuelta pa atrás, a la casilla 1.");
				casilla = 1;
			}

			if (casilla == 42) {
				System.out.println("Has llegado a la casilla 42. Fin del juego");
				juegoTerminado = true;
			}
		}
		sc.close();
	}
}