import java.util.ArrayList;

/**
 * Classe pour la Transormée de Fourrier 1D et 1D Inverse
 * @author Loïs PAZOLA
 * @author Samuel LACHAUD
 * @version 1.3
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
     * Méthode permettant de calculer la Transformée de Fourrier 1D
     * @param tableau1D tableau 1D de valeurs auquel on veut appliquer la transformée 1D
     * @return le résultat de la Transformée de Fourrier 1D
     */
    public static ArrayList<Complexe> Transformee1D(ArrayList<Complexe> tableau1D){
        // Récupération de la taille du tableau
        int N = tableau1D.size();
        // Création tableau resultats
        ArrayList<Complexe> resultat = new ArrayList<Complexe>();

        for(int i = 0; i < N; i++) {
            // Création de la variable de somme des éléments du tableau
            Complexe additionLocale = new Complexe(0, 0);
            for (int j = 0; j < N; j++) {
                double teta = (-2.0 * Math.PI * i * j) / N; // angle teta
                double realPart = tableau1D.get(j).getReal() * Math.cos(teta); // partie réelle
                double imagPart = tableau1D.get(j).getImag() * Math.sin(teta); // partie imaginaire
                Complexe a = new Complexe(realPart, imagPart); // création du nombre complexe

                additionLocale = additionLocale.add(a); // addition avec les nombres complexes précédents
            }
            resultat.add(additionLocale);
        }
        return resultat;
    }

    /**
     * Méthode permettant de calculer la Transformée de Fourrier 1D Inverse
     * @param tableauI1D tableau 1D de valeurs auquel on veut appliquer la transformée inverse 1D
     * @return le résultat de la Transformée de Fourrier Inverse 1D
     */
    public static ArrayList<Complexe> TransformeeInverse1D(ArrayList<Complexe> tableauI1D){
        // Récupération de la taille du tableau
        int N = tableauI1D.size();
        // Création tableau resultat
        ArrayList<Complexe> resultat = new ArrayList<Complexe>();

        for(int i = 0; i < N; i++) {
            // Création de la variable de somme des éléments du tableau
            Complexe additionLocale = new Complexe(0, 0);
            for (int j = 0; j < N; j++) {
                double teta = (2.0 * Math.PI * i * j) / N; // angle teta
                double realPart = tableauI1D.get(j).getReal() * Math.cos(teta);  //partie réelle
                double imagPart = tableauI1D.get(j).getReal() * Math.sin(teta);  //partie imaginaire
                Complexe a = new Complexe(realPart, imagPart); // création du nombre complexe

                additionLocale = additionLocale.add(a); // addition avec les nombres complexes précédents
            }
            additionLocale = additionLocale.multiply(new Complexe((double) 1/N, 0));

            resultat.add(additionLocale);
        }

        return resultat;
    }
}
