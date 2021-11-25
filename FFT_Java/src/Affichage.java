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
}
