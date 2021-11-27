import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe Main
 */
public class Main {
    /**
     * Méthode principale
     * @param args arguments de lancement
     * @throws Exception si une exception se produit
     */
    public static void main(String[] args) throws Exception {
        /*--------------------------*/
        /* Initialisation attributs */
        /*--------------------------*/
        final int ranMin = -5;
        final int ranMax = 5;
        int N = 8; // N = taille du tableau 1D et longueur du tableau 2D
        int M = 4; // M = hauteur du tableau 2D
        ArrayList<Complexe> tableau1D = new ArrayList<Complexe>();
        ArrayList<ArrayList<Complexe>> tableau2D = new ArrayList<ArrayList<Complexe>>();
        for (int i = 0; i < N; i++) tableau2D.add(new ArrayList<Complexe>());  //Initialise tableau2D en ajoutant N ArrayLists

        /*----------------------------*/
        /*  Remplissage des tableaux  */
        /*----------------------------*/

        // REMPLISSAGE DU TABLEAU 1D AVEC DES VALEURS ALEATOIRES
        /*
        for(int i = 0; i < N; i++) {
	        tableau1D.add(new Complexe(Math.random()*(ranMax-ranMin+1)+ranMin,Math.random()*(ranMax-ranMin+1)+ranMin)); // Nombre complexe aléatoire entre -5 et 5 sur ses deux parties
        }
        */

        // REMPLISSAGE DU TABLEAU 2D AVEC DES VALEURS ALEATOIRES
        /*
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++){
                tableau2D.get(i).add(new Complexe(Math.random()*(ranMax-ranMin+1)+ranMin,Math.random()*(ranMax-ranMin+1)+ranMin)); // Nombre complexe aléatoire entre -5 et 5 sur ses deux parties
            }
        }
        */

        /*-------------------------------*/
        /* Affichage des transformées 1D */
        /*-------------------------------*/

        // AFFICHAGE DU TABLEAU DE DEPART
        /*
        System.out.println("Tableau 1D avant transformées :");
        Affichage.AfficherTableau1D(tableau1D);
        */

        //AFFICHAGE DU RESULTAT DE TF1D.Transformee1D
        /*
        System.out.println("Transformée 1D:");
        Affichage.AfficherTableau1D(TF1D.Transformee1D(tableau1D, -1));
        */

        //AFFICHAGE DU RESULTAT DE TFR1D.TransformeeRapide1D
        /*
        System.out.println("Transformée rapide 1D:");
        Affichage.AfficherTableau1D(TFR1D.TransformeeRapide1D(tableau1D, -1));
        */

        // AFFICHAGE DU RESULTAT DE TF1D.Transformee1D EN MODE INVERSE
        /*
        System.out.println("Transformée inverse I1D:");
        Affichage.AfficherTableau1D(TF1D.Transformee1D(TF1D.Transformee1D(tableau1D, -1), 1));
        */

        // AFFICHAGE DU RESULTAT DE TFR1D.TransformeeRapide1D EN MODE INVERSE
        /*
        System.out.println("Transformée rapide I1D:");
        Affichage.AfficherTableau1D(TFR1D.TransformeeRapide1D(TFR1D.TransformeeRapide1D(tableau1D, -1), 1));
        */

        /*---------------------------------*/
        /*   Calcul du temps d'exécution   */
        /*---------------------------------*/

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
        System.out.println("TF1D Time : " + timeElapsedTF1D/1000000 + " milliseconds");

        long startTFI1D = System.nanoTime();
        tableau1D = TF1D.Transformee1D(tableau1D, 1);
        long stopTFI1D = System.nanoTime();
        long timeElapsedTFI1D = stopTFI1D - startTFI1D;
        System.out.println("TFI1D Time : " + timeElapsedTFI1D/1000000 + " milliseconds");

        long startTFR1D = System.nanoTime();
        tableau1D = TFR1D.TransformeeRapide1D(tableau1D, -1);
        long stopTFR1D = System.nanoTime();
        long timeElapsedTFR1D = stopTFR1D - startTFR1D;
        System.out.println("TFR1D Time : " + timeElapsedTFR1D/1000000 + " milliseconds");

        long startTFRI1D = System.nanoTime();
        tableau1D = TFR1D.TransformeeRapide1D(tableau1D, 1);
        long stopTFRI1D = System.nanoTime();
        long timeElapsedTFRI1D = stopTFRI1D - startTFRI1D;
        System.out.println("TFRI1D Time : " + timeElapsedTFRI1D/1000000 + " milliseconds");

        TraitementImage ti = new TraitementImage();
        ti.ImageToGray();
        ArrayList<ArrayList<Complexe>> image = ti.GetArrayListFromImage();
        long startTF2D = System.nanoTime();
        tableau2D = TF2D.Transformee2D(image, -1);
        long stopTF2D = System.nanoTime();
        long timeElapsedTF2D = stopTF2D - startTF2D;
        System.out.println("TF2D Time for 40*59 image : " + timeElapsedTF2D/1000000 + " milliseconds");

        long startTFI2D = System.nanoTime();
        tableau2D = TF2D.Transformee2D(image, 1);
        long stopTFI2D = System.nanoTime();
        long timeElapsedTFI2D = stopTFI2D - startTFI2D;
        System.out.println("TFI2F Time for 40*59 image : " + timeElapsedTFI2D/1000000 + " milliseconds\n");

        double ratioTFR_TF = (double) timeElapsedTF1D / (double) timeElapsedTFR1D;
        double ratioTFRI_TFI = (double) timeElapsedTFI1D / (double) timeElapsedTFRI1D;
        System.out.println("Transformée Fourier Rapide /\uD835\uDD4D\uD835\uDD4A\\ Transformée Fourier 🔥 : " + (long) ratioTFR_TF + " fois plus rapide");
        System.out.println("Transformée Fourier Rapide Inverse /\uD835\uDD4D\uD835\uDD4A\\ Transformée Fourier Inverse 🔥 : " + (long) ratioTFRI_TFI + " fois plus rapide");
        */

        /*------------------------------------------------------------------------------------------*/
        /* Image --> ArrayList<ArrayList<Complexe>> | TF2D(ArrayList) | TFI2D(ArrayList) --> Image2 */
        /*------------------------------------------------------------------------------------------*/

        /*
        TraitementImage ti = new TraitementImage();
        ti.ImageToGray();
        ArrayList<ArrayList<Complexe>> image = ti.GetArrayListFromImage();
        ArrayList<ArrayList<Complexe>> imageTransformed = new ArrayList<>(TF2D.Transformee2D(image, -1)) ;
        ArrayList<ArrayList<Complexe>> imageFinal= new ArrayList<>(TF2D.Transformee2D(imageTransformed, 1));
        ti.createImageFromArrayList(imageFinal);
        System.out.println("avant transformée");
        Affichage.AfficherTableau2D(image);
        System.out.println("Après transformée");
        Affichage.AfficherTableau2D(imageTransformed);
        System.out.println("Après transformée inverse");
        Affichage.AfficherTableau2D(imageFinal);
        */
    }
}
