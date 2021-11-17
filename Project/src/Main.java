import java.lang.reflect.Array;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        /*--------------------------*/
        /* Initialisation attributs */
        /*--------------------------*/
        final int ranMin = -5;
        final int ranMax = 5;
        final int N = 5; // N = taille du tableau

        ArrayList<Complexe> tableau1D = new ArrayList<Complexe>();
        //ArrayList<Complexe> tableauI1D = new ArrayList<Complexe>();

        TF1D tf1d = new TF1D();
        TFR1D tfr1d = new TFR1D();

        /*------------------------*/
        /* Remplissage du tableau */
        /*------------------------*/
        /*for(int i = 0; i < N; i++) {
            tableau1D.add(new Complexe(Math.random()*(ranMax-ranMin+1)+ranMin,Math.random()*(ranMax-ranMin+1)+ranMin)); // nonbre complexe aléatoire entre -5 et 5 sur ses deux parties
            //tableauI1D.add((Double) Math.random()*(ranMax-ranMin+1)+ranMin);
        }*/

        /*------------------------*/
        /*   DEBUG INSERT VALUES  */
        /*------------------------*/
        tableau1D.add(new Complexe(-1.0,0));
        tableau1D.add(new Complexe(0.0,0));
        tableau1D.add(new Complexe(1.0,0));

        /*-----------------------------------------------*/
        /* Affichage des resultats de TF1D.Transformee1D */
        /*-----------------------------------------------*/
        System.out.println("Transformée 1D:");
        ArrayList<Complexe> tableauDontLinverseDoitRevenirSur_tableau1D = tf1d.Transformee1D(tableau1D);
        for (Complexe c : tableauDontLinverseDoitRevenirSur_tableau1D) {
            System.out.println(c.toString());
        }

        /*------------------------------------------------------*/
        /* Affichage des resultats de TF1D.TransformeeInverse1D */
        /*------------------------------------------------------*/
        System.out.println("Transformée inverse I1D:");
        for (Complexe c : tf1d.TransformeeInverse1D(tableauDontLinverseDoitRevenirSur_tableau1D)){
            System.out.println(c.toString());
        }

        /*------------------------------------------------------*/
        /* Affichage des resultats de TFR1D.TransformeeRapide1D */
        /*------------------------------------------------------*/
        /*System.out.println("Transformée rapide I1D:");
        for (Complexe c : tfr1d.TransformeeRapide1D(tableauI1D,N)){
            System.out.println(c.toString());
        }*/
    }
}