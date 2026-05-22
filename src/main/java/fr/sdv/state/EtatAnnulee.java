package fr.sdv.state;

public class EtatAnnulee implements State {

    @Override
    public void ajouterProduit(Commande commande, Produit produit) {
        System.out.println("Impossible d'ajouter un produit : la commande a déjà été annulée.");
    }

    @Override
    public void payer(Commande commande) {
        System.out.println("Impossible de payer : la commande a déjà été annulée.");
    }

    @Override
    public void livrer(Commande commande, String adresse) {
        System.out.println("Impossible de livrer : la commande a déjà été annulée.");
    }

    @Override
    public void annuler(Commande commande) {
        System.out.println("Impossible d'annuler : la commande a déjà été annulée.");
    }
}
