import java.lang.reflect.Array;
import java.util.ArrayList;

public class TFR1D {

    private boolean debut = true;

    public TFR1D(){

    }

    /**
     * @param tableauR1D tableau 1D que l'on veut trier pour la transformée rapide 1D
     * @// TODO: 26/10/2021 Clairement cette méthode fait de la merde
     * @return le tableau trié pour les calculs de la transformée rapide 1D
     */
//    public ArrayList<Complexe> TransformeeRapide1D(ArrayList<Complexe> tableauR1D, int N){
//         /*
//        Explication succinte de la TRF-1D :
//
//        1) On prend chaques valeurs de l'ArrayList puis on la sépare dans deux autres ArrayList (paires et impaires)
//        /!\ pas les valeurs, les rangs : [1,3,2,4] [1,2] et [3,4]
//        2) On répète l'étape 1 jusqu'à obtenir un size d'ArrayList qui vaut 1
//        Exemple : [1] [2] | [3] [4]
//        3) voir doc : http://adrian.gaudebert.fr/downloads/licence3/maths/rapport-despret-gaudebert.pdf
//        */
//
//        ArrayList<Complexe> part1 = new ArrayList<>();
//        ArrayList<Complexe> part2 = new ArrayList<>();
//        ArrayList<Complexe> res = new ArrayList<>();
//
//        double c = 1; // Coefficient de calcul de la transformée
//
//        for(int i = 0; i < tableauR1D.size(); i++) {
//            if (i % 2 != 0) { // si rang impaire
//                part1.add(tableauR1D.get(i));
//            } else { // si rang impaire
//                part2.add(tableauR1D.get(i));
//            }
//        }
//            //if(part1.size() != N && part2.size() != N || debut) { // quand PAS réuni en 1 seule partie
//
//                ArrayList<Complexe> resPart1;
//                ArrayList<Complexe> resPart2;
//                if(part1.size() != 2 && part2.size() != 2){ // On divise en branche jusqu'à obtenir une branche de taille 2
//                    resPart1 = TransformeeRapide1D(part1, N);
//                    resPart2 = TransformeeRapide1D(part2, N);
//                }
//                else {
//                    resPart1 = part1;
//                    resPart2 = part2;
//                }
//                if(resPart1.size() == 2 && resPart2.size() == 2){
//
//                    // Cas le plus bas dans l'arbre
//                    res.add(resPart1.get(0).add(resPart1.get(1).multiply(new Complexe(c,0))));
//                    res.add(resPart1.get(0).minus(resPart1.get(1).multiply(new Complexe(c,0))));
//
//                    res.add(resPart2.get(0).add(resPart2.get(1).multiply(new Complexe(c,0))));
//                    res.add(resPart2.get(0).minus(resPart2.get(1).multiply(new Complexe(c,0))));
//                }
//                else {
//                        // les autres cas
//                        for(int i = 0; i < resPart1.size() - 2; i++){
//                            res.add(resPart1.get(i).add(resPart2.get(i).multiply(new Complexe(c,0))));
//                            res.add(resPart1.get(i+1).add(resPart2.get(i+1).multiply(new Complexe(c,0))));
//
//                            res.add(resPart1.get(i).minus(resPart2.get(i).multiply(new Complexe(c,0))));
//                            res.add(resPart1.get(i+1).minus(resPart2.get(i+1).multiply(new Complexe(c,0))));
//                        }
//                }
//                if(resPart1.size() + resPart2.size() == 8){
//                    res.clear();
//                    for(int i = 0; i < resPart1.size(); i++) {
//                        res.add(resPart1.get(i).add(resPart2.get(i).multiply(new Complexe(c, 0))));
//                        res.add(resPart1.get(i).minus(resPart2.get(i).multiply(new Complexe(c, 0))));
//                    }
//
//                    for(int i = 1; i < (N / 2); i++){
//                        int SENSFFT = 1;
//                        Complexe coef = new Complexe(SENSFFT * 2, Math.PI*i);
//                        res.set(i,res.get(i).add(resPart1.get(i).multiply(coef)));
//                        res.set(i + N/2, resPart1.get(i).minus(coef.multiply(resPart2.get(i))));
//                    }
//                }
//                else
//                {
//
//                }
//        return res;
//    }


    public ArrayList<Complexe> TransformeeRapide1D(ArrayList<Complexe> tableauR1D, int SensTransformee){
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

    public ArrayList<Complexe> CalculTransformeeRapide1D(ArrayList<Complexe> tableauR1D, int SensTransformee){
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
            ArrayList<Complexe> resPart1 = this.CalculTransformeeRapide1D(part1, SensTransformee);
            ArrayList<Complexe> resPart2 = this.CalculTransformeeRapide1D(part2, SensTransformee);

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

    public ArrayList<Complexe> InversionTableau(ArrayList<Complexe> tableau){
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
