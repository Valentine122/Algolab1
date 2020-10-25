package ua.lviv.iot;

import java.util.ArrayList;
import java.util.List;

public class MergeSorting {

    private static int numberOfComparisons = 0;
    private static int numberOfReplacements = 0;

    protected static void mergeSortingByMaxBandWidthSignalInMegahertz(List<Oscillograph> oscillographList) {
        System.out.println("=============================================================");
        System.out.println("MERGE_SORT");

        long startTime = System.nanoTime();
        List<Oscillograph> sortedOscillographList = sorted(oscillographList);
        long endTime = System.nanoTime();

        double duration = (endTime - startTime) / 1000D;
        System.out.println("Execution time in seconds: " + duration);
        System.out.println("Number of comparisons: " + numberOfComparisons);
        System.out.println("Number of replacements: " + numberOfReplacements);
        for (Oscillograph oscillograph : sortedOscillographList) {
            System.out.println(oscillograph.toString());
        }
        System.out.println("=============================================================");
    }

    private static List<Oscillograph> sorted(List<Oscillograph> list) {
        if (list.size() < 2) {
            return list;
        }
        int mid = list.size() / 2;
        return merged(
                sorted(list.subList(0, mid)),
                sorted(list.subList(mid, list.size())));
    }

    private static List<Oscillograph> merged(List<Oscillograph> left, List<Oscillograph> right) {
        int leftIndex = 0;
        int rightIndex = 0;
        List<Oscillograph> merged = new ArrayList<>();
        while (leftIndex < left.size() && rightIndex < right.size()) {
            numberOfReplacements++;
            if (left.get(leftIndex).getMaxBandWidthSignalInMegahertz() < right.get(rightIndex).getMaxBandWidthSignalInMegahertz()) {
                numberOfComparisons++;
                merged.add(left.get(leftIndex++));
            } else {
                merged.add(right.get(rightIndex++));
            }
        }
        merged.addAll(left.subList(leftIndex, left.size()));
        merged.addAll(right.subList(rightIndex, right.size()));
        return merged;
    }
}
