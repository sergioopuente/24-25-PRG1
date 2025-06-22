
import java.util.Scanner;

class RetoPiedraPapelTijera {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Bienvenido a Piedra, Papel o Tijera");
        System.out.println("===================================");
        System.out.println("Elige: 1 para Piedra, 2 para Papel, 3 para Tijera:");

        int seleccionJugador = teclado.nextInt();
        int seleccionComputadora = generarEleccionComputadora();

        mostrarElecciones(seleccionJugador, seleccionComputadora);
        System.out.println(determinarResultado(seleccionJugador, seleccionComputadora));
    }

    
    public static int generarEleccionComputadora() {
        return (int)(Math.random() * 3) + 1;  
    }

    
    public static void mostrarElecciones(int jugador, int computadora) {
        String[] opciones = {"Piedra", "Papel", "Tijera"};
        System.out.println("Tu elección fue: " + opciones[jugador - 1]);
        System.out.println("La elección del ordenador fue: " + opciones[computadora - 1]);
    }

    
    public static String determinarResultado(int jugador, int computadora) {
        if (jugador == computadora) {
            return "¡Es un empate!";
        }

        
        if ((jugador == 1 && computadora == 3) || 
            (jugador == 3 && computadora == 2) || 
            (jugador == 2 && computadora == 1)) {
            return "¡Felicidades,  has ganado!";
        } else {
            return "Lo siento, has perdido.";
        }
    }
}

