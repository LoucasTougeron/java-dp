package fr.sdv.strategy;

import java.util.Arrays;

public class DemoTri {

    public static void main(String[] args) {
        Tri tri = new Tri();

        int[] tableau1 = {5, 3, 8, 1, 9, 2};
        System.out.println("Avant Bubble Sort  : " + Arrays.toString(tableau1));
        tri.exec(TypeTri.BUBBLE_SORT, tableau1);
        System.out.println("Après Bubble Sort  : " + Arrays.toString(tableau1));

        int[] tableau2 = {5, 3, 8, 1, 9, 2};
        System.out.println("Avant Insertion Sort : " + Arrays.toString(tableau2));
        tri.exec(TypeTri.INSERTION_SORT, tableau2);
        System.out.println("Après Insertion Sort : " + Arrays.toString(tableau2));

        int[] tableau3 = {5, 3, 8, 1, 9, 2};
        System.out.println("Avant Selection Sort : " + Arrays.toString(tableau3));
        tri.exec(TypeTri.SELECTION_SORT, tableau3);
        System.out.println("Après Selection Sort : " + Arrays.toString(tableau3));
    }
}
