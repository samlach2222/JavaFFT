import java.util.ArrayList;

/**
 * Classe Main
 */
public class Main {
    /**
     * Méthode principale
     * @param args arguments de lancement
     */
    public static void main(String[] args) {
        /*--------------------------*/
        /* Initialisation attributs */
        /*--------------------------*/
        final int ranMin = -5;
        final int ranMax = 5;
        final int N = 8; // N = taille du tableau

        ArrayList<Complexe> tableau1D = new ArrayList<Complexe>();

        /*----------------------------------------------------*/
        /* Remplissage du tableau avec des valeurs aléatoires */
        /*----------------------------------------------------*/
        /*
        for(int i = 0; i < N; i++) {
	        tableau1D.add(new Complexe(Math.random()*(ranMax-ranMin+1)+ranMin,Math.random()*(ranMax-ranMin+1)+ranMin)); // nonbre complexe aléatoire entre -5 et 5 sur ses deux parties
        }
        */

        /*------------------------*/
        /*   DEBUG INSERT VALUES  */
        /*------------------------*/

        // Valeurs initiales --> valeur transformées (TF)
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

        OU

        tableau1D.add(new Complexe(-2.0,0.0)); // -1.0 + i0.0
        tableau1D.add(new Complexe(0.0,0.0));  //  0.0 + i0.0
        tableau1D.add(new Complexe(-4.0,0.0)); //  1.0 + i0.0
        tableau1D.add(new Complexe(0.0,0.0));  // -1.0 + i0.0
        tableau1D.add(new Complexe(2.0,0.0));  // -1.0 + i0.0
        tableau1D.add(new Complexe(0.0,0.0));  //  0.0 + i0.0
        tableau1D.add(new Complexe(-4.0,0.0)); //  1.0 + i0.0
        tableau1D.add(new Complexe(0.0,0.0));  // -1.0 + i0.0
        */

        // PERMET DE METTRE LA TRANSFORMEE DANS LE TABLEAU POUR UNE APPLICATION FUTURE DE LA TRANSFORMEE INVERSE
        tableau1D = TF1D.Transformee1D(tableau1D, -1);

        /*----------------------------------------*/
        /* Affichage du tableau avant transfomrée */
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
        }*/


        /*------------------------------------------------------*/
        /* Affichage des résultats de TF1D.Transformee1D en mode Inverse */
        /*------------------------------------------------------*/

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

    }
}
