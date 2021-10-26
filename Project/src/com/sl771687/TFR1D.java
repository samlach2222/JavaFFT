package com.sl771687;

import com.sl771687.Complexe;

import java.util.ArrayList;

public class TFR1D {

    public TFR1D(){

    }

    /**
     * @param tableauR1D tableau 1D de valeurs auquel on veut appliquer la transformée rapide 1D
     * @return le resultat de la transformée rapide 1D
     */
    public ArrayList<Complexe> TransformeeRapide1D(ArrayList<Complexe> tableauR1D){
        /*
        Explication succinte de la TRF-1D :

        1) On prend chaques valeurs de l'ArrayList puis on la sépare dans deux autres ArrayList (paires et impaires)
        /!\ pas les valeurs, les rangs : [1,3,2,4] [1,2] et [3,4]
        2) On répète l'étape 1 jusqu'à obtenir un size d'ArrayList qui vaut 1
        Exemple : [1] [2] | [3] [4]
        3) voir doc : http://adrian.gaudebert.fr/downloads/licence3/maths/rapport-despret-gaudebert.pdf
        */

        ArrayList<Complexe> tableauR1D_Divise = DivisionDuTableau(tableauR1D);
        return null;
    }

    /**
     * @param tableauR1D tableau 1D que l'on veut trier pour la transformée rapide 1D
     * @// TODO: 26/10/2021 Clairement cette méthode fait de la merde
     * @return le tableau trié pour les calculs de la transformée rapide 1D
     */
    public ArrayList<Complexe> DivisionDuTableau(ArrayList<Complexe> tableauR1D){ // Pour Diviser le tableau avec des séparateurs null
        ArrayList<Complexe> part1 = new ArrayList<>();
        ArrayList<Complexe> part2 = new ArrayList<>();
        ArrayList<Complexe> res = new ArrayList<>();

        double c = 1; // Coefficient de calcule de la transformée

        for(int i = 0; i < tableauR1D.size(); i++) {
            if (i % 2 != 0) { // si rang impaire
                part1.add(tableauR1D.get(i));
            } else { // si rang impaire
                part2.add(tableauR1D.get(i));
            }
        }
            ArrayList<Complexe> resPart1 = DivisionDuTableau(part1); // Ici y'a un pb !!
            ArrayList<Complexe> resPart2 = DivisionDuTableau(part2);


            if(resPart1.size() == 2 && resPart2.size() == 2){
                // Cas le plus bas dans l'arbre
                res.add(resPart1.get(0).add(resPart1.get(1).multiply(new Complexe(c,0))));
                res.add(resPart1.get(0).minus(resPart1.get(1).multiply(new Complexe(c,0))));

                res.add(resPart2.get(0).add(resPart2.get(1).multiply(new Complexe(c,0))));
                res.add(resPart2.get(0).minus(resPart2.get(1).multiply(new Complexe(c,0))));
            }
            else{
                // les autres cas
                res.add(resPart1.get(0).add(resPart2.get(0).multiply(new Complexe(c,0))));
                res.add(resPart1.get(1).add(resPart2.get(1).multiply(new Complexe(c,0))));

                res.add(resPart1.get(0).minus(resPart2.get(0).multiply(new Complexe(c,0))));
                res.add(resPart1.get(1).minus(resPart2.get(1).multiply(new Complexe(c,0))));
            }
        return res; // OSCOUR JE SAIS PAS COMMENT SORTI DE CETTE MERDE !!!!!
        //[1,3,2,5,4,6,7,8,9,2,5,6]
        //[1,2,4,7,9,5,|,3,5,6,8,2,6]
        //[1,4,9,|,2,7,5,|,3,6,2,|,5,8,6]
        //[1,9,|,4,|,2,5,|,3,2,|,6,|5,6,|,8] // inférieur à size = 3, garder l'ordre
        //[1,|,9,|,4,|,2,|,5,|,3,|,2,|,6,|5,|,6,|,8]
    }
}

/*
DEROULEMENT :
On divise en deux les tableaux jusqu'à obtenir une subdivision de size()=2
if(size()==2){
    //SUITE
}

SUITE :
on calcul chaque membre puis on le retourne dans un tableau de Complexes
 */