import java.util.ArrayList;

/**
 * Classe pour la Transformée de Fourier 2D et 2D Inverse
 * @author Loïs PAZOLA
 * @version 1.1
 */
public final class TF2D {

    /**
     * Constructeur de la classe TF2D
     * @throws Exception si quelqu'un essaye d'utiliser le constructeur de la classe statique
     */
    private TF2D() throws Exception {
        throw new Exception("Cette classe est statique et ne doit pas être initialiser");
    }

    /**
     * Méthode permettant de calculer la Transformée de Fourier 2D
     * @param tableau2D tableau 2D de valeurs auquel on veut appliquer la transformée 2D
     * @param sensTransformee sens de la transformée (-1 pour transformée normale, 1 pour transformée inverse)
     * @return le résultat de la Transformée de Fourier 2D
     */
    public static ArrayList<ArrayList<Complexe>> Transformee2D(ArrayList<ArrayList<Complexe>> tableau2D, int sensTransformee) {
        // Récupération de la taille du tableau
        int X = tableau2D.size();
        int Y = tableau2D.get(0).size();

        // Création du tableau de résultat et initialisation de ses colonnes
        ArrayList<ArrayList<Complexe>> resultat = new ArrayList<ArrayList<Complexe>>();
        for (int i = 0; i < X; i++){
            resultat.add(new ArrayList<Complexe>());
        }

        for (int i = 0; i < X; i++) {  //i correspond au rang horizontal du prochain résultat
            for (int j = 0 ; j < Y; j++) {  //j correspond au rang vertical du prochain résultat
                // Création de la variable de somme des éléments du tableau
                Complexe additionLocale = new Complexe(0, 0);
                for (int k = 0; k < X; k++) {  //horizontal
                    for (int l = 0; l < Y; l++) {  //vertical
                        double theta = (sensTransformee * 2.0 * Math.PI * (((double) j*l/Y) + ((double) i*k/X))); // Angle thêta

                        final Complexe complexeOriginal = tableau2D.get(k).get(l);
                        double realPart = complexeOriginal.getReal() * Math.cos(theta) + complexeOriginal.getImag() * Math.sin(theta); // Partie réelle
                        double imagPart = -complexeOriginal.getReal() * Math.sin(theta) + complexeOriginal.getImag() * Math.cos(theta); // Partie imaginaire
                        Complexe a = new Complexe(realPart, imagPart); // Création du nombre complexe

                        additionLocale = additionLocale.add(a); // Addition avec les nombres complexes précédents
                    }
                }
                if(sensTransformee == 1){ // Si sens transformé inverse
                    additionLocale = additionLocale.multiply(1.0/(X*Y));
                }
                resultat.get(i).add(additionLocale);
            }
        }
        return resultat;
    }
}
