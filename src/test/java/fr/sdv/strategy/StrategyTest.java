package fr.sdv.strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class StrategyTest {

    private final Tri tri = new Tri();

    @Test
    void testBubbleSort() {
        int[] tableau = {5, 3, 8, 1, 9, 2};
        tri.exec(TypeTri.BUBBLE_SORT, tableau);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8, 9}, tableau);
    }

    @Test
    void testInsertionSort() {
        int[] tableau = {5, 3, 8, 1, 9, 2};
        tri.exec(TypeTri.INSERTION_SORT, tableau);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8, 9}, tableau);
    }

    @Test
    void testSelectionSort() {
        int[] tableau = {5, 3, 8, 1, 9, 2};
        tri.exec(TypeTri.SELECTION_SORT, tableau);
        assertArrayEquals(new int[]{1, 2, 3, 5, 8, 9}, tableau);
    }
}