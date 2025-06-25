
import java.util.Scanner;
public class SumaNumeros {
    public static void main(String[] args) {
        double numero1, numero2, suma;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dime el numero1: ");
        numero1 = scanner.nextDouble();
        System.out.println("Dime el numero2: ");
        numero2 = scanner.nextDouble();
        suma = numero1 + numero2;
        System.out.println("La suma de " + numero1 + " y " + numero2 + " es: " + suma);
    
}
}