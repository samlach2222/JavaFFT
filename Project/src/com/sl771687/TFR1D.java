package com.sl771687;

import com.sl771687.Complexe;

import java.util.ArrayList;

public class TFR1D {

    public TFR1D(){

    }

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

    public ArrayList<Complexe> DivisionDuTableau(ArrayList<Complexe> tableauR1D){ // Pour Diviser le tableau avec des séparateurs null
        ArrayList<Complexe> part1 = new ArrayList<>();
        ArrayList<Complexe> part2 = new ArrayList<>();
        ArrayList<Complexe> res = new ArrayList<>();

        boolean fini = false;
        while (fini == false) {
            int indexNull = part1.indexOf(null);
            if(indexNull <3 && indexNull != -1) {
                fini = true;
            }
            else {
                if(indexNull == -1) { // Cas du début où il n'y a pas le séparateur null
                    indexNull = tableauR1D.size();
                }
                for(int i = 0; i < indexNull; i++) { // cas pour chaque séparateur
                    if (i+1 % 2 == 0) {
                        part1.add(tableauR1D.get(i));
                    } else {
                        part2.add(tableauR1D.get(i));
                    }
                    tableauR1D.remove(i);
                }
                tableauR1D.remove(indexNull);
                res.addAll(part1);
                res.add(null);
                res.addAll(part2);
            }
        }
        return res;

        //[1,3,2,5,4,6,7,8,9,2,5,6]
        //[1,2,4,7,9,5,|,3,5,6,8,2,6]
        //[1,4,9,|,2,7,5,|,3,6,2,|,5,8,6]
        //[1,9,|,4,|,2,5,|,3,2,|,6,|5,6,|,8] // inférieur à size = 3, garder l'ordre
        //[1,|,9,|,4,|,2,|,5,|,3,|,2,|,6,|5,|,6,|,8]
    }
}
