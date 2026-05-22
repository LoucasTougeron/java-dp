package fr.sdv.state;

import java.util.ArrayList;
import java.util.List;

public class Commande {

    private double montant;
    private String adresseLivraison;
    private List<Produit> produits;
    private State etat;

    public Commande() {
        this.produits = new ArrayList<>();
        this.etat = new EtatCreation();
    }

    public void ajouterProduit(Produit produit) {
        etat.ajouterProduit(this, produit);
    }

    public void payer() {
        etat.payer(this);
    }

    public void livrer(String adresse) {
        etat.livrer(this, adresse);
    }

    public void annuler() {
        etat.annuler(this);
    }

    // Getters & Setters
    public double getMontant() { return montant; }
    public void setMontant(double montant) { this.montant = montant; }

    public String getAdresseLivraison() { return adresseLivraison; }
    public void setAdresseLivraison(String adresseLivraison) { this.adresseLivraison = adresseLivraison; }

    public List<Produit> getProduits() { return produits; }

    public State getEtat() { return etat; }
    public void setEtat(State etat) { this.etat = etat; }
}
