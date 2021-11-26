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
     * @throws Exception quand le numéro envoyé pour obtenir le caractère associé est incorect.
     */
    public static void AfficherTableau2D(ArrayList<ArrayList<Complexe>> tableau2D) throws Exception {

        //Remplis une ArrayList d'Integer avec la longueur maximale de chaque colonne
        ArrayList<Integer> longestLengths = new ArrayList<Integer>();
        for (int x = 0; x < tableau2D.get(0).size(); x++){
            int length = 11;
            for (int y = 0; y < tableau2D.size(); y++) {
                final int lengthActuel = tableau2D.get(y).get(x).toString().length();

                if (lengthActuel > length) length = lengthActuel;
            }

            longestLengths.add(length);
        }

        //Affiche chaque ligne avec la méthode AfficherLigneTableau
        AfficherLigneTableau(tableau2D.get(0), 0, longestLengths);
        for (ArrayList<Complexe> ac : tableau2D){
            AfficherLigneTableau(ac, 1, longestLengths);
        }
        AfficherLigneTableau(tableau2D.get(tableau2D.size() - 1), 2, longestLengths);
    }

    /**
     * Affiche une ligne d'un tableau 1D
     * @param tableau1D ligne à afficher
     * @param type 0 pour séparateur haut, 1 pour ligne de valeur, 2 pour séparateur bas
     * @param longestLengths longueurs maximales de chaque colonne
     * @throws Exception quand le numéro envoyé pour obtenir le caractère associé est incorect.
     */
    private static void AfficherLigneTableau(ArrayList<Complexe> tableau1D, int type, ArrayList<Integer> longestLengths) throws Exception {
        if (type < 0 || type > 2) throw new Exception("Type "+type+" incorrect");

        String ligne = "";
        switch (type) {
            case 0:
                ligne = "┌";
                break;
            case 1:
                ligne = "|";
                break;
            case 2:
                ligne = "└";
                break;
        }

        for (int i = 0; i < tableau1D.size(); i++) {
            final String complexe = tableau1D.get(i).toString();

            switch (type) {
                case 1:
                    ligne += complexe;

                    //Ajout des espaces jusqu'à être arrivé au séprateur de colonne
                    final int espacesRestants = longestLengths.get(i) - complexe.length();
                    if (espacesRestants > 0) {
                        ligne += " ".repeat(espacesRestants);
                    }
                    ligne += "|";
                    break;
                default:
                    ligne += "-".repeat(longestLengths.get(i));
                    break;
            }

            if (i != tableau1D.size() - 1) {
                if (type == 0) ligne += "┬";
                else if (type == 2) ligne += "┴";
            }
        }
        if (type == 0) ligne += "┐";
        else if (type == 2) ligne += "┘";

        System.out.println(ligne);
    }
}
