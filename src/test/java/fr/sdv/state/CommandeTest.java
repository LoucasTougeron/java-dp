package fr.sdv.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommandeTest {

    private Commande commande;
    private Produit produit1;
    private Produit produit2;

    @BeforeEach
    void setUp() {
        commande = new Commande();
        produit1 = new Produit("Stylo", "A");
        produit2 = new Produit("Cahier", "B");
    }

    @Test
    void testAjouterProduitEnCreation() {
        commande.ajouterProduit(produit1);
        assertEquals(1, commande.getProduits().size());
    }

    @Test
    void testAjouterProduitApresPaiementImpossible() {
        commande.ajouterProduit(produit1);
        commande.payer();
        commande.ajouterProduit(produit2);
        assertEquals(1, commande.getProduits().size());
    }

    @Test
    void testPaiementCalculeMontant() {
        commande.ajouterProduit(produit1);
        commande.ajouterProduit(produit2);
        commande.payer();
        assertEquals(1.0, commande.getMontant());
        assertInstanceOf(EtatPaiement.class, commande.getEtat());
    }

    @Test
    void testLivraisonApresPaiement() {
        commande.ajouterProduit(produit1);
        commande.payer();
        commande.livrer("12 rue de la Paix");
        assertEquals("12 rue de la Paix", commande.getAdresseLivraison());
        assertInstanceOf(EtatEnLivraison.class, commande.getEtat());
    }

    @Test
    void testLivraisonSansPaiementImpossible() {
        commande.ajouterProduit(produit1);
        commande.livrer("12 rue de la Paix");
        assertInstanceOf(EtatCreation.class, commande.getEtat());
    }

    @Test
    void testAnnulationEnCreation() {
        commande.ajouterProduit(produit1);
        commande.annuler();
        assertInstanceOf(EtatAnnulee.class, commande.getEtat());
    }

    @Test
    void testAnnulationEnPaiement() {
        commande.ajouterProduit(produit1);
        commande.payer();
        commande.annuler();
        assertInstanceOf(EtatAnnulee.class, commande.getEtat());
    }

    @Test
    void testAnnulationEnLivraisonImpossible() {
        commande.ajouterProduit(produit1);
        commande.payer();
        commande.livrer("12 rue de la Paix");
        commande.annuler();
        assertInstanceOf(EtatEnLivraison.class, commande.getEtat());
    }

    @Test
    void testAnnulationDejaAnnuleeImpossible() {
        commande.annuler();
        commande.annuler();
        assertInstanceOf(EtatAnnulee.class, commande.getEtat());
    }
}
