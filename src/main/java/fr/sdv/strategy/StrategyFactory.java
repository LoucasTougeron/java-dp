package fr.sdv.strategy;

public class StrategyFactory {

    public static Strategy getStrategy(TypeTri typeTri) {
        switch (typeTri) {
            case BUBBLE_SORT:
                return new BubbleSortStrategy();
            case INSERTION_SORT:
                return new InsertionSortStrategy();
            case SELECTION_SORT:
                return new SelectionSortStrategy();
            default:
                throw new IllegalArgumentException("Type de tri inconnu : " + typeTri);
        }
    }
}