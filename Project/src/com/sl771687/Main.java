package com.sl771687;

import java.util.ArrayList;
import java.lang.Math;

public class Main {

     static final int ranMin = -5;
     static final int ranMax = 5;
     static final int N = 20; // N = taille du tableau

    public static void main(String[] args) {

        ArrayList<Complexe> tableau1D = new ArrayList<Complexe>();
        ArrayList<Complexe> tableauI1D = new ArrayList<Complexe>();

        /*------------------------*/
        /* Remplissage du tableau */
        /*------------------------*/
        for(int i = 0; i < N; i++) {
            tableau1D.add(new Complexe(Math.random()*(ranMax-ranMin+1)+ranMin,Math.random()*(ranMax-ranMin+1)+ranMin)); // nonbre complexe aléatoire entre -5 et 5 sur ses deux parties
            //tableauI1D.add((Double) Math.random()*(ranMax-ranMin+1)+ranMin);
        }

        /*------------------------*/
        /*   DEBUG INSERT VALUES  */
        /*------------------------*/
        /*tableau1D.add(new Complexe(-1.0,0));
        tableau1D.add(new Complexe(0.0,0));
        tableau1D.add(new Complexe(1.0,0));*/

        /*-------------------------*/
        /* Affichage des resultats */
        /*-------------------------*/
        System.out.println("Transformée inverse I1D:");
        for (Complexe c : Transformee1D(tableau1D)) {
            System.out.println(c.toString());
        }
        /*System.out.println("Transformée inverse I1D:");
        /*for (Complexe c : TransformeeInverse1D(tableauI1D)){
            System.out.println(c.toString());
        }*/
    }

    /**
     * @param tableau1D
     * @return le résultat de la Transformée de Fourrier 1D
     */
    static private ArrayList<Complexe> Transformee1D(ArrayList<Complexe> tableau1D){
        // Création tableau resultats
        ArrayList<Complexe> resultat = new ArrayList<Complexe>();

        for(int i = 0; i < N; i++) {
            // Création de la variable de somme des éléments du tableau
            Complexe additionLocale = new Complexe(0,0);
            for(int j = 0; j < N; j++) {
                double teta = -2.0*Math.PI*i*j/N; // angle teta
                double realPart = tableau1D.get(j).getReal() * Math.cos(teta); // partie réelle
                double imagPart = tableau1D.get(j).getImag() * Math.sin(teta); // partie imaginaire
                Complexe a = new Complexe(realPart,imagPart); // création du nombre complexe

                additionLocale = additionLocale.add(a); // addition avec les nombres complexes précédents
            }
            resultat.add(additionLocale);
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
