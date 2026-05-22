package fr.sdv.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProduitBuilderTest {

    // -------------------------------------------------------------------------
    // Cas nominal : produit complet
    // -------------------------------------------------------------------------

    @Test
    void build_casnominal_retourneProduitComplet() {
        Produit produit = new ProduitBuilder()
                .nom("Coca-Cola")
                .grade("A")
                .categorie("Boisson")
                .marque("Coca-Cola Company")
                .ajouterAdditif("E150a", 2.5)
                .ajouterIngredient("Eau gazeuse", 330.0)
                .ajouterAllergene("Gluten", 0.0)
                .build();

        assertEquals("Coca-Cola", produit.getNom());
        assertEquals("A", produit.getGrade());
        assertEquals("Boisson", produit.getCategorie().getNom());
        assertEquals("Coca-Cola Company", produit.getMarque().getNom());
        assertEquals(1, produit.getAdditifs().size());
        assertEquals("E150a", produit.getAdditifs().get(0).getNom());
        assertEquals(1, produit.getIngredients().size());
        assertEquals(1, produit.getAllergenes().size());
    }

    // -------------------------------------------------------------------------
    // Cas alternatifs
    // -------------------------------------------------------------------------

    @Test
    void build_sansCategorieNiMarque_retourneNull() {
        Produit produit = new ProduitBuilder()
                .nom("Produit générique")
                .grade("B")
                .build();

        assertNull(produit.getCategorie());
        assertNull(produit.getMarque());
    }

    @Test
    void build_plusieursIngredients_tousPresents() {
        Produit produit = new ProduitBuilder()
                .nom("Jus d'orange")
                .ajouterIngredient("Eau", 200.0)
                .ajouterIngredient("Jus d'orange concentré", 50.0)
                .ajouterIngredient("Vitamine C", 10.0)
                .build();

        assertEquals(3, produit.getIngredients().size());
    }

    @Test
    void build_plusieursAdditifs_tousPresents() {
        Produit produit = new ProduitBuilder()
                .nom("Biscuit")
                .ajouterAdditif("E471", 1.0)
                .ajouterAdditif("E322", 0.5)
                .build();

        assertEquals(2, produit.getAdditifs().size());
    }

    @Test
    void build_sansFluent_produitVide() {
        Produit produit = new ProduitBuilder().build();

        assertNull(produit.getNom());
        assertNull(produit.getGrade());
        assertTrue(produit.getAdditifs().isEmpty());
        assertTrue(produit.getIngredients().isEmpty());
        assertTrue(produit.getAllergenes().isEmpty());
    }
}
