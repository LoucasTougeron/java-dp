package fr.sdv.strategy;

public class InsertionSortStrategy implements Strategy {

    @Override
    public void trier(int[] tableau) {
        int n = tableau.length;
        for (int i = 1; i < n; i++) {
            int cle = tableau[i];
            int j = i - 1;
            while (j >= 0 && tableau[j] > cle) {
                tableau[j + 1] = tableau[j];
                j--;
            }
            tableau[j + 1] = cle;
        }
    }
}
