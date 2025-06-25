import java.util.Random;
import java.util.Scanner;

class RuletaBwinCompleta {
    public static void main(String[] args) {
        final int[] ORDEN_RULETA = {
            0, 32, 15, 19, 4, 21, 2, 25, 17, 34,
            6, 27, 13, 36, 11, 30, 8, 23, 10, 5,
            24, 16, 33, 1, 20, 14, 31, 9, 22, 18,
            29, 7, 28, 12, 35, 3, 26
        };

        final String[] COLORES = {
            "VERDE", "ROJO", "NEGRO", "ROJO", "NEGRO", "ROJO", "NEGRO", "ROJO", "NEGRO", "ROJO",
            "NEGRO", "ROJO", "NEGRO", "ROJO", "NEGRO", "ROJO", "NEGRO", "ROJO", "NEGRO", "ROJO",
            "NEGRO", "ROJO", "NEGRO", "ROJO", "NEGRO", "ROJO", "NEGRO", "ROJO", "NEGRO", "ROJO",
            "NEGRO", "ROJO", "NEGRO", "ROJO", "NEGRO", "ROJO", "NEGRO"
        };

        final int MULTIPLICADOR_NUMERO = 36;
        final int MULTIPLICADOR_COLOR = 2;
        final int MULTIPLICADOR_PARIDAD = 2;
        final int MULTIPLICADOR_MITAD = 2;
        final int MULTIPLICADOR_COLUMNA = 3;
        final int MULTIPLICADOR_DOCENA = 3;
        final int TOTAL_NUMEROS = ORDEN_RULETA.length;
        final int RADIO = 12;
        final int CENTRO_X = 40;
        final int CENTRO_Y = 15;

        double saldo = 500.0;
        Scanner entrada = new Scanner(System.in);
        Random aleatorio = new Random();

        while (true) {
            mostrarMenuPrincipal(saldo);
            int opcion = entrada.nextInt();
            entrada.nextLine();

            if (opcion == 9) {
                System.out.println("Gracias por jugar. Tu saldo final es de " + saldo + " euros.");
                break;
            }

            System.out.print("¿Cuánto deseas apostar?: ");
            double apuesta = entrada.nextDouble();
            entrada.nextLine();

            if (apuesta > saldo || apuesta <= 0) {
                System.out.println("Apuesta no válida. Inténtalo de nuevo.");
                continue;
            }

            int eleccion = -1;
            String eleccionTexto = "";
            int columnaElegida = -1;
            int docenaElegida = -1;

            if (opcion == 1) {
                System.out.print("Introduce el número (0-36): ");
                eleccion = entrada.nextInt();
                entrada.nextLine();
            } else if (opcion == 2) {
                System.out.print("ROJO o NEGRO: ");
                eleccionTexto = entrada.nextLine().toUpperCase();
            } else if (opcion == 3) {
                System.out.print("PAR o IMPAR: ");
                eleccionTexto = entrada.nextLine().toUpperCase();
            } else if (opcion == 4) {
                System.out.print("BAJA (1-18) o ALTA (19-36): ");
                eleccionTexto = entrada.nextLine().toUpperCase();
            } else if (opcion == 5) {
                System.out.print("Introduce columna (1, 2 o 3): ");
                columnaElegida = entrada.nextInt();
                entrada.nextLine();
            } else if (opcion == 6) {
                System.out.print("Introduce docena (1=1-12, 2=13-24, 3=25-36): ");
                docenaElegida = entrada.nextInt();
                entrada.nextLine();
            }

            int posicionBola = aleatorio.nextInt(TOTAL_NUMEROS);
            for (int i = 0; i < 100; i++) {
                limpiarPantalla();
                imprimirAnillo(ORDEN_RULETA, posicionBola, RADIO, CENTRO_X, CENTRO_Y);
                esperar(15 + i / 2);
                posicionBola = (posicionBola + 1) % TOTAL_NUMEROS;
            }

            int numeroGanador = ORDEN_RULETA[posicionBola];
            String colorGanador = COLORES[posicionBola];

            System.out.println();
            System.out.println("La bola cayó en: " + numeroGanador + " (" + colorGanador + ")");

            boolean haGanado = false;

            if (opcion == 1 && numeroGanador == eleccion) {
                saldo += apuesta * MULTIPLICADOR_NUMERO;
                haGanado = true;
            } else if (opcion == 2 && colorGanador.equals(eleccionTexto)) {
                saldo += apuesta * MULTIPLICADOR_COLOR;
                haGanado = true;
            } else if (opcion == 3 && numeroGanador != 0) {
                boolean esPar = (numeroGanador % 2 == 0);
                if ((eleccionTexto.equals("PAR") && esPar) || (eleccionTexto.equals("IMPAR") && !esPar)) {
                    saldo += apuesta * MULTIPLICADOR_PARIDAD;
                    haGanado = true;
                }
            } else if (opcion == 4 && numeroGanador != 0) {
                if ((eleccionTexto.equals("BAJA") && numeroGanador >= 1 && numeroGanador <= 18) ||
                    (eleccionTexto.equals("ALTA") && numeroGanador >= 19 && numeroGanador <= 36)) {
                    saldo += apuesta * MULTIPLICADOR_MITAD;
                    haGanado = true;
                }
            } else if (opcion == 5 && numeroGanador != 0) {
                if ((numeroGanador - 1) % 3 + 1 == columnaElegida) {
                    saldo += apuesta * MULTIPLICADOR_COLUMNA;
                    haGanado = true;
                }
            } else if (opcion == 6 && numeroGanador != 0) {
                if ((docenaElegida == 1 && numeroGanador >= 1 && numeroGanador <= 12) ||
                    (docenaElegida == 2 && numeroGanador >= 13 && numeroGanador <= 24) ||
                    (docenaElegida == 3 && numeroGanador >= 25 && numeroGanador <= 36)) {
                    saldo += apuesta * MULTIPLICADOR_DOCENA;
                    haGanado = true;
                }
            } else {
                saldo -= apuesta;
            }

            if (haGanado) {
                System.out.println("¡Felicidades! Has ganado.");
            } else {
                System.out.println("Lo siento, has perdido.");
            }

            System.out.println("Saldo actual: " + saldo + " euros");
            System.out.println("Pulsa ENTER para continuar...");
            entrada.nextLine();
        }
    }

    static void mostrarMenuPrincipal(double saldo) {
        System.out.println("\n=== SIMULADOR RUEDA BWIN ===");
        System.out.println("Saldo disponible: " + saldo + " euros");
        System.out.println("1. Apostar a NÚMERO (x36)");
        System.out.println("2. Apostar a COLOR ROJO/NEGRO (x2)");
        System.out.println("3. Apostar a PAR/IMPAR (x2)");
        System.out.println("4. Apostar a MITAD (BAJA/ALTA) (x2)");
        System.out.println("5. Apostar a COLUMNA (1,2,3) (x3)");
        System.out.println("6. Apostar a DOCENA (1-12 / 13-24 / 25-36) (x3)");
        System.out.println("9. Salir");
        System.out.print("Elige una opción: ");
    }

    static void imprimirAnillo(int[] orden, int bola, int radio, int centroX, int centroY) {
        String[][] pantalla = new String[30][90];
        for (int i = 0; i < pantalla.length; i++) {
            for (int j = 0; j < pantalla[0].length; j++) {
                pantalla[i][j] = " ";
            }
        }
        for (int i = 0; i < orden.length; i++) {
            double angulo = 2 * Math.PI * i / orden.length;
            int x = (int)(centroX + radio * Math.cos(angulo));
            int y = (int)(centroY + radio * Math.sin(angulo));
            String texto = (i == bola) ? "@" : String.valueOf(orden[i]);
            if (!texto.equals("@") && orden[i] < 10) {
                texto = " " + texto;
            }
            if (x >= 0 && x + 1 < pantalla[0].length && y >= 0 && y < pantalla.length) {
                pantalla[y][x] = texto;
            }
        }
        for (int i = 0; i < pantalla.length; i++) {
            for (int j = 0; j < pantalla[0].length; j++) {
                System.out.print(pantalla[i][j]);
            }
            System.out.println();
        }
    }

    static void esperar(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }

    static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}