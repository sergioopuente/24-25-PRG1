
import java.util.Scanner;

public class AdivinaNota {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double examenFinal, examenParcial, evaluacionContinua, notaProfesor;

        final double EXAMEN_FINAL_PONDERADO = 0.5;
        final double EXAMEN_PARCIAL_PONDERADO = 0.25;
        final double EVALUACION_CONTINUA_PONDERADO = 0.2;
        final double NOTA_PROFESOR_PONDERADO = 0.05;
    

        System.out.println("Dime tu examen parcial: ");
        examenParcial = scanner.nextDouble();
        System.out.println("Dime tu examen final: ");
        examenFinal = scanner.nextDouble();
        System.out.println("Dime tu evaluacion continua: ");
        evaluacionContinua = scanner.nextDouble();
        System.out.println("Dime tu nota del profesor: ");
        notaProfesor = scanner.nextDouble();

        double notaFinal = 0;
        notaFinal = examenParcial * EXAMEN_PARCIAL_PONDERADO 
        + examenFinal* EXAMEN_FINAL_PONDERADO +
        evaluacionContinua*EVALUACION_CONTINUA_PONDERADO
        +notaProfesor *NOTA_PROFESOR_PONDERADO ;

        System.out.println("La nota final es: "+ notaFinal);


    }   
}
