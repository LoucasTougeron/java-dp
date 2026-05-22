package fr.sdv.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder fluent pour construire une instance de {@link Produit}.
 *
 * Les méthodes de build n'acceptent que des types primitifs ou énumérations,
 * jamais des instances de classes — le builder les crée lui-même.
 */
public class ProduitBuilder {

    private String nom;
    private String grade;
    private String categorieNom;
    private String marqueNom;
    private final List<Additif>    additifs    = new ArrayList<>();
    private final List<Ingredient> ingredients = new ArrayList<>();
    private final List<Allergene>  allergenes  = new ArrayList<>();

    public ProduitBuilder nom(String nom) {
        this.nom = nom;
        return this;
    }

    public ProduitBuilder grade(String grade) {
        this.grade = grade;
        return this;
    }

    public ProduitBuilder categorie(String nomCategorie) {
        this.categorieNom = nomCategorie;
        return this;
    }

    public ProduitBuilder marque(String nomMarque) {
        this.marqueNom = nomMarque;
        return this;
    }

    public ProduitBuilder ajouterAdditif(String nom, double qteMilligrammes) {
        this.additifs.add(new Additif(nom, qteMilligrammes));
        return this;
    }

    public ProduitBuilder ajouterIngredient(String nom, double qteMilligrammes) {
        this.ingredients.add(new Ingredient(nom, qteMilligrammes));
        return this;
    }

    public ProduitBuilder ajouterAllergene(String nom, double qteMilligrammes) {
        this.allergenes.add(new Allergene(nom, qteMilligrammes));
        return this;
    }

    public Produit build() {
        Produit produit = new Produit();
        produit.setNom(nom);
        produit.setGrade(grade);
        produit.setCategorie(categorieNom != null ? new Categorie(categorieNom) : null);
        produit.setMarque(marqueNom != null ? new Marque(marqueNom) : null);
        produit.setAdditifs(new ArrayList<>(additifs));
        produit.setIngredients(new ArrayList<>(ingredients));
        produit.setAllergenes(new ArrayList<>(allergenes));
        return produit;
    }
}
