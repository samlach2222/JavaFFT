import java.util.ArrayList;

/**
 * Classe pour la Transformée de Fourier 1D et 1D Inverse
 * @author Loïs PAZOLA
 * @author Samuel LACHAUD
 * @version 1.4
 */
public final class TF1D {

    /**
     * Constructeur de la classe TF1D
     * @throws Exception si quelqu'un essaye d'utiliser le constructeur de la classe statique
     */
    private TF1D() throws Exception {
        throw new Exception("Cette classe est statique et ne doit pas être initialiser");
    }

    /**
     * Méthode permettant de calculer la Transformée de Fourier 1D
     * @param tableau1D tableau 1D de valeurs auquel on veut appliquer la transformée 1D
     * @param sensTransformee sens de la transformée (-1 pour transformée normale, 1 pour transformée inverse)
     * @return le résultat de la Transformée de Fourier 1D
     */
    public static ArrayList<Complexe> Transformee1D(ArrayList<Complexe> tableau1D, int sensTransformee) {
        // Récupération de la taille du tableau
        int N = tableau1D.size();

        // Création du tableau de résultat
        ArrayList<Complexe> resultat = new ArrayList<Complexe>();

        for(int i = 0; i < N; i++) {
            // Création de la variable de somme des éléments du tableau
            Complexe additionLocale = new Complexe(0, 0);
            for (int j = 0; j < N; j++) {
                double theta = (sensTransformee * 2.0 * Math.PI * i * j) / N; // Angle thêta

                final Complexe complexeOriginal = tableau1D.get(j);
                double realPart = complexeOriginal.getReal() * Math.cos(theta) + complexeOriginal.getImag() * Math.sin(theta); // Partie réelle
                double imagPart = -complexeOriginal.getReal() * Math.sin(theta) + complexeOriginal.getImag() * Math.cos(theta); // Partie imaginaire
                Complexe a = new Complexe(realPart, imagPart); // Création du nombre complexe

                additionLocale = additionLocale.add(a); // Addition avec les nombres complexes précédents
            }
            if(sensTransformee == 1){ // Si sens transformé inverse
                additionLocale = additionLocale.multiply(1.0/N);
            }
            resultat.add(additionLocale);
        }
        return resultat;
    }
}
