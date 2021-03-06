import java.util.Locale;

/**
 * Classe gérant un nombre complexe composée d'une partie réelle et d'une partie imaginaire
 * Elle décrit également les différentes opérations que l'on peut lui appliquer (addition, soustraction, multiplication, division)
 * @author Samuel LACHAUD
 * @version 1.1
 */
public class Complexe {

    /**
     * Partie réelle du complexe
     */
    private double real = 0;
    /**
     * Partie imaginaire du complexe
     */
    private double imag = 0; // real, imag sont des variables d'instances

    /**
     * Constructeur de la classe Complexe
     */
    public Complexe() {
    } // On utilise la valeur par défaut 0 + i0

    /**
     * Constructeur de la classe Complexe
     * @param real partie réelle du nombre complexe
     * @param imag partie imaginaire du nombre complexe
     */
    public Complexe(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    /**
     * Méthode permettant d'obtenir le conjugué
     */
    public void conjugate() {imag = -imag;}

    /**
     * Méthode permettant d'ajouter un complexe à celui-ci
     * @param c complexe à ajouter
     * @return la somme des deux complexes
     */
    public Complexe add(Complexe c) {
        // Le résultat est aussi un complexe, il faut donc introduire une autre variable de type Complexe
        Complexe sum = new Complexe();
        sum.real = real + c.real;
        sum.imag = imag + c.imag;
        return sum;
    }

    /**
     * Méthode permettant de diviser ce complexe par celui passé en paramètre
     * @param c diviseur de l'opération
     * @return le quotient de la division
     */
    public Complexe divide(Complexe c){
        double x = this.real * c.real + this.imag * c.imag;
        double y = this.imag * c.real - this.real * c.imag;
        double z = c.real * c.real + c.imag * c.imag;
        this.real = x / z;
        this.imag = y / z;
        return this;
    }

    /**
     * Méthode permettant de soustraire à ce complexe celui passé en paramètre
     * @param c complexe à soustraire
     * @return le reste de la soustraction
     */
    public Complexe minus(Complexe c) {
        // Le résultat est aussi un complexe, il faut donc introduire une autre variable de type Complexe
        Complexe sum = new Complexe();
        sum.real = real - c.real;
        sum.imag = imag - c.imag;
        return sum;
    }

    /**
     * Méthode permettant de multiplier ce complexe par celui en paramètre
     * @param c multiplicateur de l'opération
     * @return le produit des deux complexes
     */
    public Complexe multiply(Complexe c) {
        Complexe product = new Complexe();
        product.real = (real * c.real) - (imag * c.imag);
        product.imag = (real * c.imag) + (imag * c.real);
        return product;
    }

    /**
     * Méthode permettant de multiplier ce complexe par un nombre
     * @param d multiplicateur de l'opération
     * @return le produit du complexe par le nombre
     */
    public Complexe multiply(double d) {
        Complexe product = new Complexe();
        product.real = real*d;
        product.imag = imag*d;
        return product;
    }

    /**
     * Méthode permettant de retourner sous forme de String un nombre complexe sous la forme x.xx+iy.yy
     * @return le nombre complexe en chaine de caractères
     */
    public String toString() {
        //Locale.ROOT permet d'avoir des "." pour les séparateurs décimaux
        if (imag>=0)
            return String.format(Locale.ROOT,"%+.2f",real) + "+i" + String.format(Locale.ROOT,"%.2f",Math.abs(imag));
        else
            return String.format(Locale.ROOT,"%+.2f",real) + "-i" + String.format(Locale.ROOT,"%.2f",Math.abs(imag));
    }

    /**
     * Getteur de la partie imaginaire du complexe
     * @return la partie imaginaire du complexe
     */
    public double getImag() {
        return imag;
    }

    /**
     * Setter de la partie imaginaire du complexe
     * @param imag partie imaginaire à mettre au complexe
     */
    public void setImag(double imag) {
        this.imag = imag;
    }

    /**
     * Getteur de la partie réelle du complexe
     * @return la partie réelle du complexe
     */
    public double getReal() {
        return real;
    }

    /**
     * Setteur de la partie réelle du complexe
     * @param real partie réelle à mettre au complexe
     */
    public void setReal(double real) {
        this.real = real;
    }
}
