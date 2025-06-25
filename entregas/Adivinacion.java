
import java.util.Scanner;
public class Adivinacion {
    
    static int MAXIMO = 100;
    static int MINIMO = 1;
    static int INTENTOS_MAXIMOS = 10;

    public static void main(String[] args) {
        instrucciones();
        int numeroPensado = obtenerNumero();
        jugar(numeroPensado);
    }

    public static void instrucciones (){
        System.out.println("¡Bienvenido al juego de Adivina el Número!");
        System.out.println("Estoy pensando en un número entre "+MINIMO+" y "+MAXIMO);
        System.out.println("Tienes "+INTENTOS_MAXIMOS+" intentos para adivinarlo. ¡Buena suerte!");
    }

    public static int obtenerNumero(){
        return (int)(Math.random()* (MAXIMO - MINIMO+1))+ MINIMO ; 
    }

    public static void jugar (int numeroPensado){
        Scanner scanner = new Scanner(System.in);
        int intentosRestantes = INTENTOS_MAXIMOS;
        boolean haGanado = false; 
        while (intentosRestantes > 0 && !haGanado) {
            System.out.println("\nIntentos restantes: " + intentosRestantes);
            int numeroUsuario = preguntarNumero(scanner);
            int diferencia = Math.abs(numeroPensado - numeroUsuario);

            if (numeroUsuario == numeroPensado) {
                System.out.println("¡Felicidades! Has adivinado el número en el intento " + (INTENTOS_MAXIMOS - intentosRestantes + 1) + ".");
                haGanado = true; 
            } else {
                if (numeroUsuario < numeroPensado) {
                    System.out.println("Pista: El número es mayor.");
                } else {
                    System.out.println("Pista: El número es menor.");
                }

                if (diferencia <= 5) {
                    System.out.println("¡Caliente! Estás muy cerca.");
                } else if (diferencia <= 10) {
                    System.out.println("Tibio. Te estás acercando.");
                } else {
                    System.out.println("Frío. Aún estás lejos.");
                }
            }
            intentosRestantes--;
        }

        if (!haGanado) {
            System.out.println("\nLo siento, se han agotado los intentos. El número era: " + numeroPensado);
        }
        scanner.close();
    }

    public static int preguntarNumero (Scanner scanner){
        int numeroUsuario = 0;
        do { 
            System.out.print("Introduce tu número: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next(); // descarta la entrada no válida
                System.out.print("Introduce tu número: ");
            }
            numeroUsuario = scanner.nextInt();
            if (numeroUsuario<MINIMO || numeroUsuario>MAXIMO) {
                System.out.println("Número no válido");
            }
        } while (numeroUsuario<MINIMO || numeroUsuario>MAXIMO);
        return numeroUsuario;
    }    
}