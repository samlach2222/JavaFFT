/**
 * Classe gérant un nombre complexe composée d'une partie réelle et une partie imaginaire
 * Elle décrit également les différentes opérations que l'on peut lui appliquer (addition, soustraction, multiplication, division)
 * @author Samuel LACHAUD
 * @version 1.1
 */
public class Complexe {

    /**
     * partie réelle du complexe
     */
    private double real =0;
    /**
     * partie imaginaire du complexe
     */
    private double imag =0; //real, imag sont des variables d'instances

    /**
     * Constructeur de la classe Complexe
     */
    public Complexe() {
    } // on utilise la valeur par défaut 0 + i0

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
     * @return retourne la somme des deux complexes
     */
    public Complexe add(Complexe c) {
        //le résultat est aussi un complexe, il faut donc introduire une autre variable de type Complexe
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
     * @param c nombre qui soustrait le complexe
     * @return le reste de la soustraction
     */
    public Complexe minus(Complexe c) {
        //le résultat est aussi un complexe, il faut donc introduire une autre variable de type Complexe
        Complexe sum = new Complexe();
        sum.real = real - c.real;
        sum.imag = imag - c.imag;
        return sum;
    }

    /**
     * Méthode permettant de multiplier ce complexe par celui en paramètre
     * @param c nombre qui multiplie
     * @return le produit des deux complexes
     */
    public Complexe multiply(Complexe c) {
        Complexe product = new Complexe();
        product.real = (real * c.real) - (imag * c.imag);
        product.imag = (real * c.imag) + (imag * c.imag);
        return product;
    }

    /**
     * Méthode permettant de retourner sous forme de String un nombre complexe sous la forme x.x+iy.y
     * @return le nombre compexe en chaine de caractères
     */
    public String toString() {
        // exemple de la méthode prépondérante
        double roundReal = Math.round(this.real*100.0)/100.0;
        double roundImag = Math.round(this.imag*100.0)/100.0;
        if (imag>=0)
            return roundReal + "+i" + Math.abs(roundImag);
        else
            return roundReal + "-i" + Math.abs(roundImag);
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
