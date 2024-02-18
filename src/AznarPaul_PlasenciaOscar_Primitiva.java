import java.util.Scanner;
import java.util.Random;

/**
 * Programa de simulació de La Primitiva
 * @auhor Paul Aznar i Oscar Plasencia
 * @version 1.0
 * @date 17/02/2024
 */

public class AznarPaul_PlasenciaOscar_Primitiva {

    static Scanner input = new Scanner(System.in);


    /**
     * Mètode main executable
     * @param args pasar argumentos de línea de comandos al programa cuando se ejecuta.
     * @since 1.0
     */
    public static void main(String[] args) {
        menuPrincipal();
    }

    /**
     * //TODO: Completar
     * @since 1.0
     */
    private static void menuPrincipal() {
        boolean salir = false;
        while (!salir) {
            System.out.println("***** PRIMITIVA ******");
            System.out.println("1. Introducir apuesta");
            System.out.println("2. Mostrar combinación ganadora");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = input.nextInt();
            input.nextLine(); // Consumir la nueva línea después de nextInt()

            switch (opcion) {
                case 1:
                    int[] aposta = introduirAposta();
                    break;
                case 2:
                    int[] ganadora = calcularCombinacioGuanyadora();
                    mostrarCombinacionGanadora(ganadora);

                    System.out.println("Has ganado " + comprovarEncerts(aposta, ganadora));
                    break;
                case 3:
                    System.out.println("¡Gracias por jugar! ¡Hasta luego!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    /**
     * //TODO: Completasr
     * @return //TODO: Completar
     * @since 1.0
     */
    private static int[] introduirAposta(){
        System.out.println("Introduce tu apuesta: ");
        int[] aposta = new int[7];

        for (int i=0; i<6; i++) {
            int error = 0;
            int temporal;
            do {
                error = 0;

                System.out.println("Introduce el numero " + (i + 1) + " de tu apuesta: ");
                boolean esInt = input.hasNextInt();

                if (esInt) {
                    temporal = input.nextInt();

                    if (temporal < 1 || temporal > 49) {
                        System.out.println("Tiene que ser un numero entre 0 i 50 (no incluidos)");
                        error += 1;
                    }

                    for (int j = 0; j < i; j++) {
                        if (temporal == aposta[j]) {
                            System.out.println("El numero que has introducido ya esta registrado");
                            error += 1;
                        }
                    }

                    if (error == 0) { aposta[i] = temporal; };

                } else {
                    System.out.println("No has introducido un entero.");
                    error += 1;
                    input.nextLine();
                }

            } while (error != 0);
        }

        int error = 0;
        do {
            error = 0;
                System.out.println("Introduce el numero 7 de tu apuesta: ");
                boolean esInt = input.hasNextInt();

                if (esInt) {
                    int temporal = input.nextInt();

                    if (temporal < 0 || temporal > 9) {
                        System.out.println("Tiene que ser un numero entre 0 i 9 (incluidos)");
                        error += 1;
                    }

                    if (error == 0) { aposta[6] = temporal; };

                } else {
                    System.out.println("No has introducido un entero.");
                    error += 1;
                    input.nextLine();
                }

            } while (error != 0);


        return aposta;
    }

    /**
     * Muestra la combinación ganadora generada aleatoriamente.
     */
    private static void mostrarCombinacionGanadora(int[] combinacionGanadora) {
        int[] combinacion = combinacionGanadora;
        System.out.println("Combinación ganadora: ");
        for (int i = 0; i < 6; i++) {
            System.out.print(combinacion[i] + " ");
        }
        System.out.println("Reintegro: " + combinacion[6]);
    }
    /**
     * /
     * @return Muestra la combinación ganadora generada aleatoriamente.
     * @since 1.0
     */
    private static int[] calcularCombinacioGuanyadora() {
        int[] combinacio = new int[7];
        Random random = new Random();


        for (int i = 0; i < 6; i++) {
            combinacio[i] = random.nextInt(49) + 1;
        }


        combinacio[6] = random.nextInt(10);

        return combinacio;
    }

    /**
     * @param max especifica el valor máximo que puede tener el número aleatorio generado.
     * @param min especifica el valor mínimo que puede tener el número aleatorio generado.
     * @return retorna un nombre aleatori entre els valors màxims i minims establerts
     * @since 1.0
     */
    public static int getRandomNumberUsingNextInt(int min, int max){
        Random random = new Random();
        return random.nextInt((max+1)-min)+min;
    }

    /**
     * Busca quants numeros ha encertat l'usuari i diu quina es la suma total del premi
     * @param aposta array de 6 int (entre 1 i 49) i un int (entre 0 i 9) introduit per l'usuari per consola
     * @param combinacioGuanyadora array de 6 int (entre 1 i 49) i un int (entre 0 i 9) (tot aleatori)
     * @return int (premi total)
     * @since 1.0
     */


    private static int comprovarEncerts(int[] aposta, int[] combinacioGuanyadora){
        int premi = 0;
        int encerts = 0;
        boolean reintregrament = false;

        //Comprobar encerts a la combinació
        for (int i=0; i<6; i++) {
            for (int j=0; j<6; j++) {
                if (aposta[i] == combinacioGuanyadora[j]) {
                    encerts += 1;
                }
            }
        }

        //Comprobar reintegrament
        if (aposta[6] == combinacioGuanyadora[6]) {
            reintregrament = true;
        }

        //Calcular premi
        if (reintregrament == true) {
            premi += 6;
        }
        premi = premi + encerts * 20;

        return premi;
    }

    /**
     * Aquest mètode llegeix un enter per teclat dins d'un domini determinat
     * @param missatge parametritzat per a mostrar a l'usuari@
     * @param min valor min acceptat
     * @param max valor max acceptat
     * @return retorna un int
     * @since 1.0
     */
    private static int llegirInt(String missatge, int min, int max) {
        Scanner llegir = new Scanner(System.in);
        int x = 0;
        boolean valorCorrecte = false;
        do{
            System.out.println(missatge);
            valorCorrecte = llegir.hasNextInt();
            if (!valorCorrecte){
                System.out.println("ERROR: Valor no entero.");
                llegir.nextLine();
            }else{ // Tinc un enter
                x = llegir.nextInt();
                llegir.nextLine();
                if (x < min || x > max){
                    System.out.println("Opción no valida");
                    valorCorrecte = false;
                }
            }
        }while(!valorCorrecte);

        return x;
    }

    /**
     * Aquest mètode serveix per capturar floats des de teclat amb control d'errors
     * @param missatge
     * @return
     * @since 1.0
     */
    private static float llegirFloat(String missatge){
        Scanner llegir = new Scanner(System.in);
        float x = 0;
        boolean valorCorrecte = false;
        do{
            System.out.print(missatge);
            valorCorrecte = llegir.hasNextFloat();

            if (!valorCorrecte){
                System.out.println("ERROR: Valor no float.");
            }else{
                x = llegir.nextFloat();
            }
            llegir.nextLine();
        }while(!valorCorrecte);

        return x;
    }

}
