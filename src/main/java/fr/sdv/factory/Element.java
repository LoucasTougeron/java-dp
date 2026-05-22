package fr.sdv.factory;

/**
 * Classe mère abstraite représentant un élément alimentaire.
 */
public abstract class Element {

    private String nom;
    private double valeur;
    private Unite unite;

    public Element(String nom, double valeur, Unite unite) {
        this.nom = nom;
        this.valeur = valeur;
        this.unite = unite;
    }

    public String getNom() {
        return nom;
    }

    public double getValeur() {
        return valeur;
    }

    public Unite getUnite() {
        return unite;
    }
}
