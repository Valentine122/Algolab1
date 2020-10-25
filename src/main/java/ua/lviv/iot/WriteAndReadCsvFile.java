package ua.lviv.iot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadCsvFile {

    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final int BRAND_OF_OSCILLOGRAPH = 0;
    private static final int SPEED_PROCESSOR = 1;
    private static final int MEMORY_CAPACITY_IN_KB = 2;
    private static final int MAX_BAND_WIDTH_SIGNAL_IN_MEGAHERTZ = 3;

    private static final String FILE_HEADER = "brand,maxBandWidthSignalInMegahertz,speedProcessor";

    protected static void writeOscillographToCsvFile(String fileName) {

        Oscillograph oscillograph = new Oscillograph("Ukraine", 2D, 3, 121);
        Oscillograph oscillograph1 = new Oscillograph("Poland", 3D, 20, 414);
        Oscillograph oscillograph2 = new Oscillograph("USA", 4D, 2, 322);
        Oscillograph oscillograph3 = new Oscillograph("France", 5D, 41, 221);
        Oscillograph oscillograph4 = new Oscillograph("Russian", 2D, 42, 332);
        Oscillograph oscillograph5 = new Oscillograph("India", 8D, 45, 123);
        Oscillograph oscillograph6 = new Oscillograph("Spain", 7D, 23,124);
        Oscillograph oscillograph7 = new Oscillograph("Germany", 8D, 21,321);
        Oscillograph oscillograph8 = new Oscillograph("Italy", 2D, 18,234);
        Oscillograph oscillograph9 = new Oscillograph("Canada", 4D, 19,157);

        List<Oscillograph> oscillographs = new ArrayList<>();
        oscillographs.add(oscillograph);
        oscillographs.add(oscillograph1);
        oscillographs.add(oscillograph2);
        oscillographs.add(oscillograph3);
        oscillographs.add(oscillograph4);
        oscillographs.add(oscillograph5);
        oscillographs.add(oscillograph6);
        oscillographs.add(oscillograph7);
        oscillographs.add(oscillograph8);
        oscillographs.add(oscillograph9);

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Oscillograph oscillographToCsv : oscillographs) {
                fileWriter.append(String.valueOf(oscillographToCsv.getBrand()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(oscillographToCsv.getMaxBandWidthSignalInMegahertz().toString());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(oscillographToCsv.getMemoryCapacityInKb().toString());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(oscillographToCsv.getSpeedProcessor().toString());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                assert fileWriter != null;
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    protected static List<Oscillograph> getOscillographFromCsvFile(String fileName) {
        BufferedReader fileReader = null;
        List<Oscillograph> oscillographs = new ArrayList<>();
        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(fileName));
            //Read the CSV file header to skip it
            fileReader.readLine();

            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(",");
                if (tokens.length > 0) {
                    //Create a new oscillograph object and fill his  data
                    Oscillograph student = new Oscillograph(tokens[BRAND_OF_OSCILLOGRAPH],
                            Double.parseDouble(tokens[SPEED_PROCESSOR]),
                            Integer.parseInt(tokens[MEMORY_CAPACITY_IN_KB]),
                            Integer.parseInt(tokens[MAX_BAND_WIDTH_SIGNAL_IN_MEGAHERTZ]));
                    oscillographs.add(student);
                }
            }
        } catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                assert fileReader != null;
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        return oscillographs;
    }
}
