package fr.sdv.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryTest {

    private ElementFactory factory;

    @BeforeEach
    void setUp() {
        factory = new ElementFactory();
    }

    @Test
    void creerElement_ingredient_retourneIngredient() {
        Element element = factory.creerElement(TypeElement.INGREDIENT, "Farine", 50.0, Unite.MILLI_GRAMMES);

        assertInstanceOf(Ingredient.class, element);
        assertEquals("Farine", element.getNom());
        assertEquals(50.0, element.getValeur());
        assertEquals(Unite.MILLI_GRAMMES, element.getUnite());
    }

    @Test
    void creerElement_allergene_retourneAllergene() {
        Element element = factory.creerElement(TypeElement.ALLERGENE, "Gluten", 5.0, Unite.MICRO_GRAMMES);

        assertInstanceOf(Allergene.class, element);
        assertEquals("Gluten", element.getNom());
        assertEquals(5.0, element.getValeur());
        assertEquals(Unite.MICRO_GRAMMES, element.getUnite());
    }

    @Test
    void creerElement_additif_retourneAdditif() {
        Element element = factory.creerElement(TypeElement.ADDITIF, "E150a", 2.5, Unite.MILLI_GRAMMES);

        assertInstanceOf(Additif.class, element);
        assertEquals("E150a", element.getNom());
        assertEquals(2.5, element.getValeur());
        assertEquals(Unite.MILLI_GRAMMES, element.getUnite());
    }

    @Test
    void creerElement_retourneToujours_uneInstanceDElement() {
        Element i = factory.creerElement(TypeElement.INGREDIENT, "Sucre", 10.0, Unite.MILLI_GRAMMES);
        Element a = factory.creerElement(TypeElement.ALLERGENE, "Lait", 3.0, Unite.MICRO_GRAMMES);
        Element d = factory.creerElement(TypeElement.ADDITIF, "E471", 1.0, Unite.MILLI_GRAMMES);

        assertInstanceOf(Element.class, i);
        assertInstanceOf(Element.class, a);
        assertInstanceOf(Element.class, d);
    }
}
