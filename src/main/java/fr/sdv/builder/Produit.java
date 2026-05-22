package fr.sdv.builder;

import java.util.List;

public class Produit {
    private String nom;
    private String grade;
    private Categorie categorie;
    private Marque marque;
    private List<Additif> additifs;
    private List<Ingredient> ingredients;
    private List<Allergene> allergenes;

    // Constructeur package-private : seul le builder peut instancier
    Produit() {}

    public String getNom() { return nom; }
    void setNom(String nom) { this.nom = nom; }

    public String getGrade() { return grade; }
    void setGrade(String grade) { this.grade = grade; }

    public Categorie getCategorie() { return categorie; }
    void setCategorie(Categorie categorie) { this.categorie = categorie; }

    public Marque getMarque() { return marque; }
    void setMarque(Marque marque) { this.marque = marque; }

    public List<Additif> getAdditifs() { return additifs; }
    void setAdditifs(List<Additif> additifs) { this.additifs = additifs; }

    public List<Ingredient> getIngredients() { return ingredients; }
    void setIngredients(List<Ingredient> ingredients) { this.ingredients = ingredients; }

    public List<Allergene> getAllergenes() { return allergenes; }
    void setAllergenes(List<Allergene> allergenes) { this.allergenes = allergenes; }
}
