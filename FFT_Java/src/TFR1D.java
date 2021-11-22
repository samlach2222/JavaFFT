import java.util.ArrayList;

/**
 * Classe pour la Transormée de Fourier Rapide 1D et Rapide 1D Inverse
 * @author Samuel LACHAUD
 * @version 1.2
 */
public final class TFR1D {

    /**
     * Constructeur de la classe TFR1D
     * @throws  Exception si quelqu'un essaye d'utiliser le constructeur de la classe statique
     */
    private TFR1D() throws Exception{
        throw new Exception("Cette classe est statique et ne doit pas être initialiser");
    }

    /**
     * Méthode pour lancer la transformée de Fourier rapide avec les données préparées au préalable.
     * Lance la méthode "CalculTransformeeRapide1D".
     * @param tableauR1D tableau 1D auquel on veut appliquer la transformée de Fourier rapide.
     * @param SensTransformee sens de la transformée -1 pour transformée normale et 1 pour transformée inverse
     * @return le résultat de la transformée de Fourier rapide
     */
    public static ArrayList<Complexe> TransformeeRapide1D(ArrayList<Complexe> tableauR1D, int SensTransformee){
        // sensTransformee vaux -1 si on fait une transformée rapide 1D
        // sensTransformee vaux +1 si on fait une transformée rapide inverse 1D

        // tableau temporaire pour inverser les valeurs du tableau
        ArrayList<Complexe> tableauTemp = InversionTableau(tableauR1D);


        // On calcule maintenant la transforméeRapide1D
        tableauTemp = CalculTransformeeRapide1D(tableauTemp, SensTransformee);

        // Il faut ré-inverser l'ordre du tableau pour obtenir le résultat du calcul
        //ArrayList<Complexe> resultatTransformee = InversionTableau(tableauTemp);
        ArrayList<Complexe> resultatTransformee = tableauTemp;

        // si le sens de la transformée est inverse, on divise chaque élément du tableau par la taille du tableau
        if(SensTransformee == 1){
            for(int i =0; i < tableauR1D.size(); i++){
                Complexe c = new Complexe(tableauR1D.size(), 0);
                resultatTransformee.set(i, resultatTransformee.get(i).divide(c));
            }
        }

        return resultatTransformee;
    }

    /**
     * Méthode calculant la transformée de Fourier rapide.
     * Lancée par la méthode "TransformeeRapide1D".
     * @param tableauR1D tableau 1D auquel on veut appliquer la transformée de Fourier rapide.
     * @param SensTransformee sens de la transformée -1 pour transformée normale et 1 pour transformée inverse
     * @return le résultat de la transformée de Fourier rapide
     */
    private static ArrayList<Complexe> CalculTransformeeRapide1D(ArrayList<Complexe> tableauR1D, int SensTransformee){
        // taille du tableau de complexe
        int tailleTableau = tableauR1D.size();

        // Création du tableau de résultat
        ArrayList<Complexe> tableauTransforme = tableauR1D;

        if(tailleTableau != 1){ // si la taille est de 1, on a pas à traiter le tableau
            ArrayList<Complexe> part1 = new ArrayList<>();
            ArrayList<Complexe> part2 = new ArrayList<>();
            for(int x = 0; x < tailleTableau / 2; x++){ // initialisation tableau
                part1.add(null);
                part2.add(null);
            }

            for(int i = 0; i < tableauR1D.size(); i++) {
                if (i % 2 != 0) { // si rang impaire
                    part1.set(i / 2, tableauR1D.get(i));
                }
                else { // si rang impaire
                    part2.set((i + 1 ) / 2, tableauR1D.get(i));
                }
            }

            // Appel récursif pour calcul de la transformée
            ArrayList<Complexe> resPart1 = CalculTransformeeRapide1D(part1, SensTransformee);
            ArrayList<Complexe> resPart2 = CalculTransformeeRapide1D(part2, SensTransformee);

            // On applique alors la formule de la transformée
            for(int u = 0; u < tailleTableau / 2; u++){
                double teta = SensTransformee * 2 * Math.PI * u / tailleTableau;
                Complexe coef = new Complexe(Math.cos(teta), Math.sin(teta));

                tableauTransforme.set(u,resPart1.get(u).add(coef.multiply(resPart2.get(u))));
                tableauTransforme.set(u + (tailleTableau / 2),resPart1.get(u).minus(coef.multiply(resPart2.get(u))));
            }
        }
        return tableauTransforme;
    }

    /**
     * Méthode servant à ranger le tableau dans le sens inverse et de le retourner.
     * Exemple : [1 - 2 - 4 - 3] -→ [3 - 4 - 2 - 1]
     * @param tableau tableau que l'on doit renverser pour le ranger dans le sens inverse
     * @return le tableau rangé dans le sens inverse
     */
    private static ArrayList<Complexe> InversionTableau(ArrayList<Complexe> tableau){
        int tailleTableau = tableau.size();
        ArrayList<Complexe> nouveauTableau = new ArrayList<Complexe>();
        for(int x = 0; x < tailleTableau; x++){ // initialisation tableau
            nouveauTableau.add(null);
        }
        for(int i = 0; i < tailleTableau ; i++){
            nouveauTableau.set(i,tableau.get((tailleTableau - 1) - i));
        }
        return nouveauTableau;
    }
}
