package fr.sdv.strategy;

public class SelectionSortStrategy implements Strategy {

    @Override
    public void trier(int[] tableau) {
        int n = tableau.length;
        for (int i = 0; i < n - 1; i++) {
            int indexMin = i;
            for (int j = i + 1; j < n; j++) {
                if (tableau[j] < tableau[indexMin]) {
                    indexMin = j;
                }
            }
            int temp = tableau[indexMin];
            tableau[indexMin] = tableau[i];
            tableau[i] = temp;
        }
    }
}
