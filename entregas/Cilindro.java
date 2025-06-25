public class Cilindro {
public static void main(String[] args) {
double altura, area, volumen;
final double pi = 3.1416;
final double radio = 3.5;
altura = 20;
area = 2 * pi * radio * (radio + altura);
volumen= pi * radio * radio * altura;
System.out.println("------------------------------------------");
System.out.println(" Cilindro ");
System.out.println("------------------------------------------");
System.out.println("Radio: "+radio);
System.out.println(" ");
System.out.println("Altura: "+altura+"cm");
System.out.println(" ");
System.out.println("Area del cilindro: "+area+"cm");
System.out.println(" ");
System.out.println("Volumen del cilindro: "+volumen+"cm");
System.out.println("------------------------------------------");
System.out.println(" ");
}
}