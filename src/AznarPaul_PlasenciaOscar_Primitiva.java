import java.util.Scanner;

/**
 * Programa de simulació de La Primitiva
 * @auhor Paul Aznar - Oscar Plasencia
 * @version 1.0
 * @date 16/02/2024
 */
//TODO: Fer refractor per canviar el nom de la classe
public class AznarPaul_PlasenciaOscar_Primitiva {

    static Scanner input = new Scanner(System.in);

    /**
     * Mètode main executable
     * @param args
     * @since 1.0
     */
    public static void main(String[] args) {
        menuPrincipal();
    }

    /**
     * //TODO: Completar
     * @since 1.0
     */
    private static void menuPrincipal(){
        System.out.println("***** PRIMITIVA ******");

        int[] aposta = introduirAposta();
        int[] combinacioGuanyadora = calcularCombinacioGuanyadora();
        int premi;

        if (combinacioGuanyadora != null) {
            System.out.println("La combinació ganadora és: ");

            for (int i = 0; i < combinacioGuanyadora.length - 1; i++) {
                System.out.print(combinacioGuanyadora[i] + " ");
            }

            System.out.println("Reintegrament " + combinacioGuanyadora[combinacioGuanyadora.length - 1]);
        }

        premi = comprovarEncerts(aposta, combinacioGuanyadora);
        System.out.println("El teu premi és: "+premi+" €");
    }

    /**
     * Permet a l'usuari introduir la seva aposta per consola amb control d'errors
     * @return array de 7 int
     * @since 1.0
     */
    private static int[] introduirAposta(){
        System.out.println("Introdueix la teva aposta: ");
        int[] aposta = new int[7];

        for (int i=0; i<6; i++) {
            int error = 0;
            do {
                error = 0;

                System.out.println("Introdueix el numero " + (i+1) + " de la teva aposta: ");
                boolean esInt = input.hasNextInt();

                if (esInt) {
                    aposta[i] = input.nextInt();

                    if (aposta[i] < 1 || aposta[i] > 49) {
                        System.out.println("Ha de ser un numero entre 0 i 50 (no inclosos)");
                    }

                    for (int j=0; j < i; j++) {
                        if (aposta[j] == aposta[i]) {
                            System.out.println("El numero que has introduit ja esta registrat");
                            error += 1;
                        }
                    }

                } else {
                    System.out.println("No has introduit un enter.");
                    error += 1;
                    input.nextLine();
                }

            } while (error != 0);

            do {
                error = 0;

                System.out.println("Introdueix el numero 7 de la teva aposta: ");
                boolean esInt = input.hasNextInt();

                if (esInt) {
                    aposta[i] = input.nextInt();

                    if (aposta[i] < 0 || aposta[i] > 9) {
                        System.out.println("Ha de ser un numero entre 0 i 9 (inclosos)");
                    }

                } else {
                    System.out.println("No has introduit un enter.");
                    error += 1;
                    input.nextLine();
                }

            } while (error != 0);
        }

        return aposta;
    }

    /**
     * //TODO: Completar
     * @return //TODO: Completar
     * @since 1.0
     */
    private static int[] calcularCombinacioGuanyadora(){
        int[] combinacio = null;

        //TODO: Fer el codi del mètode

        return combinacio;
    }

    /**
     * //TODO: Completar
     * @param aposta //TODO: Completar
     * @param combinacioGuanyadora //TODO: Completar
     * @return //TODO: Completar
     * @since 1.0
     */
    private static int comprovarEncerts(int[] aposta, int[] combinacioGuanyadora){
        int premi = 0;
        int encerts = 0;
        boolean reintregrament = false;

        //Comprobar encerts a la combinació
        //TODO: Fer el codi del mètode

        //Comprobar reintegrament
        //TODO: Fer el codi del mètode

        //Calcular premi
        //TODO: Fer el codi del mètode

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
                System.out.println("ERROR: Valor no enter.");
                llegir.nextLine();
            }else{ // Tinc un enter
                x = llegir.nextInt();
                llegir.nextLine();
                if (x < min || x > max){
                    System.out.println("Opció no vàlida");
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
