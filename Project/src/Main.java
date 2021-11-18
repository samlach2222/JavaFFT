import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*--------------------------*/
        /* Initialisation attributs */
        /*--------------------------*/
        final int ranMin = -5;
        final int ranMax = 5;
        final int N = 8; // N = taille du tableau

        ArrayList<Complexe> tableau1D = new ArrayList<Complexe>();
        ArrayList<Complexe> tableauI1D = new ArrayList<Complexe>();

        /*------------------------*/
        /* Remplissage du tableau */
        /*------------------------*/
        /*for(int i = 0; i < N; i++) {
			tableau1D.add(new Complexe(Math.random()*(ranMax-ranMin+1)+ranMin,Math.random()*(ranMax-ranMin+1)+ranMin)); // nonbre complexe aléatoire entre -5 et 5 sur ses deux parties
            tableauI1D.add(new Complexe(Math.random()*(ranMax-ranMin+1)+ranMin,Math.random()*(ranMax-ranMin+1)+ranMin)); // nonbre complexe aléatoire entre -5 et 5 sur ses deux parties
        }*/

        /*------------------------*/
        /*   DEBUG INSERT VALUES  */
        /*------------------------*/
        tableau1D.add(new Complexe(-1.0,0));
        tableau1D.add(new Complexe(0.0,0));
        tableau1D.add(new Complexe(1.0,0));
        tableauI1D.add(new Complexe(0.0,0));
        tableauI1D.add(new Complexe(-1.5,0));
        tableauI1D.add(new Complexe(-1.5,0));

        /*------------------------------*/
        /* Affichage du tableau de base */
        /*------------------------------*/
        System.out.println("Tableau par défaut:");
        for (Complexe c : tableau1D){
            System.out.println(c);
        }

        /*-----------------------------------------------*/
        /* Affichage des résultats de TF1D.Transformee1D */
        /*-----------------------------------------------*/
        System.out.println("Transformée 1D:");
		//ArrayList<Complexe> tableauDontLinverseDoitRevenirSur_tableau1D = TF1D.Transformee1D(tableau1D);
        for (Complexe c : TF1D.Transformee1D(tableau1D)) {
            System.out.println(c.toString());
        }

        /*------------------------------------------------------*/
        /* Affichage des résultats de TF1D.TransformeeInverse1D */
        /*------------------------------------------------------*/
        System.out.println("Transformée inverse I1D:");
        for (Complexe c : TF1D.TransformeeInverse1D(tableauI1D)){
            System.out.println(c.toString());
        }

        /*------------------------------------------------------*/
        /* Affichage des résultats de TFR1D.TransformeeRapide1D */
        /*------------------------------------------------------*/
        /*System.out.println("Transformée rapide I1D:");
        for (Complexe c : TFR1D.TransformeeRapide1D(tableauI1D,-1)){
            System.out.println(c.toString());
        }*/
    }
}
