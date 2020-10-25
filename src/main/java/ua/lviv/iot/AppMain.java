package ua.lviv.iot;

import java.util.List;

public class AppMain {
    public static final String CSV_FILE_NAME = "data.csv";

    public static void main(String[] args) {
        WriteAndReadCsvFile.writeOscillographToCsvFile(CSV_FILE_NAME);
        List<Oscillograph> oscillographs = WriteAndReadCsvFile.getOscillographFromCsvFile(CSV_FILE_NAME);
        BubbleSorting.bubbleSortingBySpeedProcessor(oscillographs);
        MergeSorting.mergeSortingByMaxBandWidthSignalInMegahertz(oscillographs);
    }

}
