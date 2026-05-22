package fr.sdv.strategy;

public class Tri {

    public void exec(TypeTri typeTri, int[] tableau) {
        Strategy strategy = StrategyFactory.getStrategy(typeTri);
        strategy.trier(tableau);
    }
}
