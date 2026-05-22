package fr.sdv.state;

public class EtatCreation implements State {

    @Override
    public void ajouterProduit(Commande commande, Produit produit) {
        commande.getProduits().add(produit);
        System.out.println("Produit ajouté : " + produit.getNom());
    }

    @Override
    public void payer(Commande commande) {
        double montant = commande.getProduits().size() * 0.5;
        commande.setMontant(montant);
        commande.setEtat(new EtatPaiement());
        System.out.println("Paiement effectué. Montant : " + montant + "€");
    }

    @Override
    public void livrer(Commande commande, String adresse) {
        System.out.println("Impossible de livrer : la commande n'a pas encore été payée.");
    }

    @Override
    public void annuler(Commande commande) {
        commande.setEtat(new EtatAnnulee());
        System.out.println("Commande annulée.");
    }
}
