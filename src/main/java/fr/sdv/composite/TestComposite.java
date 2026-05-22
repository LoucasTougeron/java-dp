package fr.sdv.composite;

public class TestComposite {

    public static void main(String[] args) {

        // --- Employés DSIN ---
        Employe cecile   = new Employe("RASPEY",  "Cécile",  10000);
        Employe bilel    = new Employe("BECHKAR", "Bilel",    8000);

        // --- Employés Big Data ---
        Employe jbRanmey = new Employe("RANMEY",  "JB",       7500);
        Employe jane     = new Employe("DOE",     "Jane",     3500);

        // --- Employés Java Dev ---
        Employe kevin    = new Employe("GUINEAU", "Kevin",    7500);
        Employe paul     = new Employe("MARTIN",  "Paul",     3500);

        // --- Sous-services ---
        Service bigData = new Service("Big Data");
        bigData.ajouter(jbRanmey);
        bigData.ajouter(jane);

        Service javaDev = new Service("Java Dev");
        javaDev.ajouter(kevin);
        javaDev.ajouter(paul);

        // --- Service racine DSIN ---
        Service dsin = new Service("DSIN");
        dsin.ajouter(cecile);
        dsin.ajouter(bilel);
        dsin.ajouter(bigData);
        dsin.ajouter(javaDev);

        // --- Affichage ---
        System.out.println("=== Organisation ===");
        System.out.println(dsin);
        System.out.println("  " + bigData);
        System.out.println("    " + jbRanmey);
        System.out.println("    " + jane);
        System.out.println("  " + javaDev);
        System.out.println("    " + kevin);
        System.out.println("    " + paul);
        System.out.println();
        System.out.println("Salaire total DSIN     : " + dsin.calculerSalaire()    + "€");
        System.out.println("Salaire total Big Data : " + bigData.calculerSalaire() + "€");
        System.out.println("Salaire total Java Dev : " + javaDev.calculerSalaire() + "€");
    }
}
