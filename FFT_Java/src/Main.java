import java.util.ArrayList;

/**
 * Classe Main
 */
public class Main {
    /**
     * Méthode principale
     * @param args arguments de lancement
     */
    public static void main(String[] args) throws Exception {
        /*--------------------------*/
        /* Initialisation attributs */
        /*--------------------------*/
        final int ranMin = -5;
        final int ranMax = 5;
        int N = 8; // N = taille du tableau

        ArrayList<Complexe> tableau1D = new ArrayList<Complexe>();

        /*----------------------------------------------------*/
        /* Remplissage du tableau avec des valeurs aléatoires */
        /*----------------------------------------------------*/
        /*
        for(int i = 0; i < N; i++) {
	        tableau1D.add(new Complexe(Math.random()*(ranMax-ranMin+1)+ranMin,Math.random()*(ranMax-ranMin+1)+ranMin)); // Nombre complexe aléatoire entre -5 et 5 sur ses deux parties
        }
        */

        /*---------------------*/
        /* DEBUG INSERT VALUES */
        /*---------------------*/

        // Valeurs initiales --> valeurs transformées (TF)
        tableau1D.add(new Complexe(-1.0,0.0)); // -2.0 + i0.0
        tableau1D.add(new Complexe(0.0,0.0));  //  0.0 + i0.0
        tableau1D.add(new Complexe(1.0,0.0));  // -4.0 + i0.0
        tableau1D.add(new Complexe(-1.0,0.0)); //  0.0 + i0.0
        tableau1D.add(new Complexe(-1.0,0.0)); //  2.0 + i0.0
        tableau1D.add(new Complexe(0.0,0.0));  //  0.0 + i0.0
        tableau1D.add(new Complexe(1.0,0.0));  // -4.0 + i0.0
        tableau1D.add(new Complexe(-1.0,0.0)); //  0.0 + i0.0

        // Valeurs transformées --> valeurs initiales (TFI)
        /*
        tableau1D.add(new Complexe(-2.0,0.0)); // -1.0 + i0.0
        tableau1D.add(new Complexe(0.0,0.0));  //  0.0 + i0.0
        tableau1D.add(new Complexe(-4.0,0.0)); //  1.0 + i0.0
        tableau1D.add(new Complexe(0.0,0.0));  // -1.0 + i0.0
        tableau1D.add(new Complexe(2.0,0.0));  // -1.0 + i0.0
        tableau1D.add(new Complexe(0.0,0.0));  //  0.0 + i0.0
        tableau1D.add(new Complexe(-4.0,0.0)); //  1.0 + i0.0
        tableau1D.add(new Complexe(0.0,0.0));  // -1.0 + i0.0
        */

        // PERMET DE METTRE LA TRANSFORMÉE DANS LE TABLEAU POUR UNE APPLICATION FUTURE DE LA TRANSFORMÉE INVERSE
        tableau1D = TF1D.Transformee1D(tableau1D, -1);

        /*----------------------------------------*/
        /* Affichage du tableau avant transformée */
        /*----------------------------------------*/
        /*
        System.out.println("Tableau avant transformée :");
        for (Complexe c : tableau1D){
            System.out.println(c);
        }
        */

        /*-----------------------------------------------*/
        /* Affichage des résultats de TF1D.Transformee1D */
        /*-----------------------------------------------*/
        /*
        System.out.println("Transformée 1D:");
        for (Complexe c : TF1D.Transformee1D(tableau1D,-1)) {
            System.out.println(c.toString());
        }
        */


        /*------------------------------------------------------*/
        /* Affichage des résultats de TFR1D.TransformeeRapide1D */
        /*------------------------------------------------------*/
        /*
        System.out.println("Transformée rapide I1D:");
        for (Complexe c : TFR1D.TransformeeRapide1D(tableau1D,-1)){
            System.out.println(c.toString());
        }
        */


        /*---------------------------------------------------------------*/
        /* Affichage des résultats de TF1D.Transformee1D en mode Inverse */
        /*---------------------------------------------------------------*/

        System.out.println("Transformée inverse I1D:");
        for (Complexe c : TF1D.Transformee1D(tableau1D,1)){
            System.out.println(c.toString());
        }




        /*----------------------------------------------------------------------*/
        /* Affichage des résultats de TFR1D.TransformeeRapide1D en mode Inverse */
        /*----------------------------------------------------------------------*/
        /*
        System.out.println("Transformée rapide I1D:");
        for (Complexe c : TFR1D.TransformeeRapide1D(tableau1D,1)){
            System.out.println(c.toString());
        }
        */

        /*-----------------------------------------------------------------*/
        /*-----------------------------------------------------------------*/
        /*                   CALCUL DU TEMPS D'EXECUTION                   */
        /*-----------------------------------------------------------------*/
        /*-----------------------------------------------------------------*/
        /*
        N = (int) Math.pow(2,14); // Pour avoir une réelle différence sur le temps d'exécution
        tableau1D.clear();
        for(int i = 0; i < N; i++) {
            tableau1D.add(new Complexe(Math.random()*(ranMax-ranMin+1)+ranMin,Math.random()*(ranMax-ranMin+1)+ranMin)); // Nombre complexe aléatoire entre -5 et 5 sur ses deux parties
        }

        long startTF1D = System.nanoTime();
        tableau1D = TF1D.Transformee1D(tableau1D, -1);
        long stopTF1D = System.nanoTime();
        long timeElapsedTF1D = stopTF1D - startTF1D;
        System.out.println("TF1D Time : " + timeElapsedTF1D + " nanosecondes");

        long startTFI1D = System.nanoTime();
        tableau1D = TF1D.Transformee1D(tableau1D, 1);
        long stopTFI1D = System.nanoTime();
        long timeElapsedTFI1D = stopTFI1D - startTFI1D;
        System.out.println("TFI1D Time : " + timeElapsedTFI1D + " nanosecondes");

        long startTFR1D = System.nanoTime();
        tableau1D = TFR1D.TransformeeRapide1D(tableau1D, -1);
        long stopTFR1D = System.nanoTime();
        long timeElapsedTFR1D = stopTFR1D - startTFR1D;
        System.out.println("TFR1D Time : " + timeElapsedTFR1D + " nanosecondes");

        long startTFRI1D = System.nanoTime();
        tableau1D = TFR1D.TransformeeRapide1D(tableau1D, 1);
        long stopTFRI1D = System.nanoTime();
        long timeElapsedTFRI1D = stopTFRI1D - startTFRI1D;
        System.out.println("TFRI1D Time : " + timeElapsedTFRI1D + " nanosecondes");

        double ratioTFR_TF = (double) timeElapsedTF1D / (double) timeElapsedTFR1D;
        double ratioTFRI_TFI = (double) timeElapsedTFI1D / (double) timeElapsedTFRI1D;
        System.out.println("Transformée Fourier Rapide /\uD835\uDD4D\uD835\uDD4A\\ Transformée Fourier 🔥 : " + (long) ratioTFR_TF + " fois plus rapide");
        System.out.println("Transformée Fourier Rapide Inverse /\uD835\uDD4D\uD835\uDD4A\\ Transformée Fourier Inverse 🔥 : " + (long) ratioTFRI_TFI + " fois plus rapide");
        */
    }
}
