package fr.sdv.factory;

/**
 * Factory qui instancie un {@link Element} en fonction du {@link TypeElement} fourni.
 *
 * Pattern Factory Method : le choix de la classe concrète à instancier est
 * centralisé ici ; l'appelant ne manipule que l'interface {@link Element}.
 */
public class ElementFactory {

    /**
     * Crée et retourne une instance d'Element selon le type demandé.
     *
     * @param type   le type d'élément à créer (énumération {@link TypeElement})
     * @param nom    le nom de l'élément
     * @param valeur la quantité présente dans le produit
     * @param unite  l'unité de mesure ({@link Unite})
     * @return une instance concrète d'Element
     * @throws IllegalArgumentException si le type est inconnu
     */
    public Element creerElement(TypeElement type, String nom, double valeur, Unite unite) {
        switch (type) {
            case INGREDIENT:
                return new Ingredient(nom, valeur, unite);
            case ALLERGENE:
                return new Allergene(nom, valeur, unite);
            case ADDITIF:
                return new Additif(nom, valeur, unite);
            default:
                throw new IllegalArgumentException("Type d'élément inconnu : " + type);
        }
    }
}
