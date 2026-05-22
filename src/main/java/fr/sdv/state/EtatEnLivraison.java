package fr.sdv.state;

public class EtatEnLivraison implements State {

    @Override
    public void ajouterProduit(Commande commande, Produit produit) {
        System.out.println("Impossible d'ajouter un produit : la commande est en cours de livraison.");
    }

    @Override
    public void payer(Commande commande) {
        System.out.println("Impossible de payer : la commande est en cours de livraison.");
    }

    @Override
    public void livrer(Commande commande, String adresse) {
        System.out.println("Impossible de livrer : la commande est déjà en cours de livraison.");
    }

    @Override
    public void annuler(Commande commande) {
        System.out.println("Annulation impossible : la commande est déjà en cours de livraison.");
    }
}
