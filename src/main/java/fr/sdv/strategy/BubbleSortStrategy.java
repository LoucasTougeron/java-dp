package fr.sdv.strategy;

public class BubbleSortStrategy implements Strategy {

    @Override
    public void trier(int[] tableau) {
        int n = tableau.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (tableau[j] > tableau[j + 1]) {
                    int temp = tableau[j];
                    tableau[j] = tableau[j + 1];
                    tableau[j + 1] = temp;
                }
            }
        }
    }
}
