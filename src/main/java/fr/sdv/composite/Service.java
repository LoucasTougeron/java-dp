package fr.sdv.composite;

import java.util.ArrayList;
import java.util.List;

public class Service implements IElement {

    private String nom;
    private List<IElement> elements;

    public Service(String nom) {
        this.nom = nom;
        this.elements = new ArrayList<>();
    }

    public void ajouter(IElement element) {
        elements.add(element);
    }

    public void retirer(IElement element) {
        elements.remove(element);
    }

    @Override
    public double calculerSalaire() {
        double total = 0;
        for (IElement element : elements) {
            total += element.calculerSalaire();
        }
        return total;
    }

    public String getNom() { return nom; }
    public List<IElement> getElements() { return elements; }

    @Override
    public String toString() {
        return "Service " + nom + " (masse salariale: " + calculerSalaire() + "€)";
    }
}
