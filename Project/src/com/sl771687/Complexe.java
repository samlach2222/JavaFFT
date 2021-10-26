package com.sl771687;

public class Complexe {

    private double real =0;
    private double imag =0; //real, imag sont des variables d'instances

    public Complexe() {
    } // on utilise la valeur par défaut 0 + i0

    public Complexe(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public void conjugate() {imag = -imag;}

    public Complexe add(Complexe c) {
        //le résultat est aussi un complexe, il faut donc introduire une autre variable de type Complexe
        Complexe sum = new Complexe();
        sum.real = real + c.real;
        sum.imag = imag + c.imag;
        return sum;
    }

    public Complexe minus(Complexe c) {
        //le résultat est aussi un complexe, il faut donc introduire une autre variable de type Complexe
        Complexe sum = new Complexe();
        sum.real = real - c.real;
        sum.imag = imag - c.imag;
        return sum;
    }

    public Complexe multiply(Complexe c) {
        Complexe product = new Complexe();
        product.real = (real * c.real) - (imag * c.imag);
        product.imag = (real * c.imag) + (imag * c.imag);
        return product;
    }

    public String toString() {
        // exemple de la méthode prépondérante
        if (imag>=0)
            return real + "+i" + Math.abs(imag);
        else
            return real + "-i" + Math.abs(imag);
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }
}