package com.sl771687;

import java.util.ArrayList;
import java.lang.Math;

public class Main {

     static final int ranMin = -1;
     static final int ranMax = -1;
     static final int N = 3; // N = taille du tableau

    public static void main(String[] args) {

        ArrayList<Complexe> tableau1D = new ArrayList<Complexe>();
        ArrayList<Complexe> tableauI1D = new ArrayList<Complexe>();

        /*------------------------*/
        /* Remplissage du tableau */
        /*------------------------*/
        /*for(int i = 0; i < N; i++) {
            tableau1D.add(-1.0); //(Double) Math.random()*(ranMax-ranMin+1)+ranMin
            tableauI1D.add((Double) Math.random()*(ranMax-ranMin+1)+ranMin);
        }*/

        tableau1D.add(new Complexe(-1.0,0));
        tableau1D.add(new Complexe(0.0,0));
        tableau1D.add(new Complexe(1.0,0));

        /*-------------------------*/
        /* Affichage des resultats */
        /*-------------------------*/

        /*System.out.println("Transformée inverse I1D:");
        for (Complexe c : Transformee1D(tableau1D)) {
            System.out.println(c.toString());
        }*/
        /*System.out.println("Transformée inverse I1D:");
        /*for (Complexe c : TransformeeInverse1D(tableauI1D)){
            System.out.println(c.toString());
        }*/
    }

    static private ArrayList<Complexe> Transformee1D(ArrayList<Complexe> tableau1D){
        // Création tableau resultats
        ArrayList<Complexe> resultat = new ArrayList<Complexe>();

        for(int i = 0; i < N; i++) {
            // Création de la variable de somme des éléments du tableau
            Complexe additionLocale = new Complexe(0,0);
            for(int j = 0; j < N; j++) {
                double teta = -2.0*Math.PI*i*j/N;
                Complexe part1 = tableau1D.get(j).multiply(new Complexe(Math.cos(teta),0));
                Complexe part2 = tableau1D.get(j).multiply(new Complexe(Math.sin(teta),0));
                Complexe a = new Complexe(part1,part2); // Nombre complexe 3+2

                additionLocale = additionLocale.add(a);
            }
            resultat.add(additionLocale);
            additionLocale = new Complexe(0,0);
        }

        return resultat;
    }

    /**
     * @param tableauI1D
     * @return Le résultat de la transformation inverse 1D
     */
    private static ArrayList<Complexe> TransformeeInverse1D(ArrayList<Double> tableauI1D){
        ArrayList<Complexe> resultat = new ArrayList<Complexe>();
        for (int x = 0; x < N; x++){
            Complexe c = new Complexe(0,0);
            for (int u = 0; u < N-1; u++){
                double i_MaisJeSaisPasAQuoiIlCorrespond = 1;
                double valeurAExponentialise = (2*i_MaisJeSaisPasAQuoiIlCorrespond*Math.PI*u*x) / N;
                double reelle = tableauI1D.get(u)*Math.cos(valeurAExponentialise);
                double imaginaire = tableauI1D.get(u)*Math.sin(valeurAExponentialise);

                Complexe complexeAAjouter = new Complexe(reelle, imaginaire);

                c = c.add(complexeAAjouter);

            }
            resultat.add(c);
        }

        return resultat;
    }
}
