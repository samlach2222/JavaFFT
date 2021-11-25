import java.util.ArrayList;

/**
 * Classe pour afficher des tableaux sous forme de... tableaux
 * @author Loïs PAZOLA
 * @version 1.1
 */
public final class Affichage {

    /**
     * Constructeur de la classe Affichage
     * @throws Exception si quelqu'un essaye d'utiliser le constructeur de la classe statique
     */
    private Affichage() throws Exception {
        throw new Exception("Cette classe est statique et ne doit pas être initialiser");
    }

    /**
     * Affiche un tableau 1D sous forme de... tableau
     * @param tableau1D tableau 1D à afficher
     */
    public static void AfficherTableau1D(ArrayList<Complexe> tableau1D) {
        String separateurLigneHaut = "┌";
        String lignePrincipal = "|";
        String separateurLigneBas = "└";

        for (int i = 0; i < tableau1D.size(); i++) {
            final String complexe = tableau1D.get(i).toString();
            separateurLigneHaut += "-".repeat(complexe.length());
            lignePrincipal += tableau1D.get(i).toString() + "|";
            separateurLigneBas += "-".repeat(complexe.length());

            if (i != tableau1D.size() - 1) {
                separateurLigneHaut += "┬";
                separateurLigneBas += "┴";
            }
        }
        separateurLigneHaut += "┐";
        separateurLigneBas += "┘";

        System.out.println(separateurLigneHaut);
        System.out.println(lignePrincipal);
        System.out.println(separateurLigneBas);
    }

    /**
     * Affiche un tableau 2D sous forme de... tableau
     * @param tableau2D tableau 2D à afficher
     */
    public static void AfficherTableau2D(ArrayList<ArrayList<Complexe>> tableau2D) {
        ArrayList<String> lignes = new ArrayList<String>();
        final int X = tableau2D.get(0).size();  //Longueur
        final int Y = tableau2D.size();  //Hauteur

        for (int i = 0; i < Y + 2; i++){
            String ligne;
            if (i == 0) ligne = "┌";
            else if (i == Y + 1) ligne = "└";
            else ligne = "|";

            for (int j = 0; j < X; j++) {
                final String complexe;
                if (i == 0) complexe = tableau2D.get(0).get(j).toString();  //Ligne du bas
                else if (i == Y + 1) complexe = tableau2D.get(Y - 1).get(j).toString();  //Ligne du haut
                else complexe = tableau2D.get(i - 1).get(j).toString()+ "|";  //Ligne avec valeurs

                if (i != 0 && i != Y + 1) ligne += complexe;
                else ligne += "-".repeat(complexe.length());

                if (j != X - 1) {
                    if (i == 0) ligne += "┬";  //Ligne du haut
                    else if (i == Y+1) ligne += "┴";  //Ligne du bas
                    //else ligne += "┼";  //Ligne séparatrice
                }
            }
            if (i == 0) ligne += "┐";
            else if (i == Y+1) ligne += "┘";

            lignes.add(ligne);
        }

        for (String ligne : lignes){
            System.out.println(ligne);
        }
    }
}
