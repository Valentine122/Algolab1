package ua.lviv.iot;

import java.util.List;

public class BubbleSorting {

    protected static void bubbleSortingBySpeedProcessor(List<Oscillograph> oscillographList) {
        System.out.println("=============================================================");
        System.out.println("BUBBLE_SORT");
        int numberOfComparisons = 0;
        int numberOfReplacements = 0;
        int sizeOfList = oscillographList.size();
        Oscillograph tempOscillograph;

        long startTime = System.nanoTime();
        for (int i = 0; i < sizeOfList; i++) {
            for (int j = 1; j < (sizeOfList - i); j++) {

                if (oscillographList.get(j - 1).getSpeedProcessor() < oscillographList.get(j).getSpeedProcessor()) {
                    tempOscillograph = oscillographList.get(j - 1);
                    oscillographList.set(j - 1, oscillographList.get(j));
                    oscillographList.set(j, tempOscillograph);
                    numberOfReplacements++;
                }
                numberOfComparisons++;
            }
        }
        long endTime = System.nanoTime();

        double duration = (endTime - startTime) / 1000D;
        System.out.println("Execution time in seconds: " + duration);
        System.out.println("Number of comparisons: " + numberOfComparisons);
        System.out.println("Number of replacements: " + numberOfReplacements);
        for (Oscillograph oscillograph : oscillographList) {
            System.out.println(oscillograph.toString());
        }
        System.out.println("=============================================================");
    }

}
