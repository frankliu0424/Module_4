package CSV;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CSV {
    public static void generateCSV(String dPath, List<List<String>> dataLines) throws IOException {//"dPath" denotes destination path
        StringBuilder csvContent = new StringBuilder();
        for (List<String> line : dataLines) {
            StringBuilder lB = new StringBuilder();//"lB" denotes line Builders
            for (String field : line) {
                lB.append(field).append(",");
            }
            //Replace the last comma with a newline character
            lB.replace(lB.length() - 1, lB.length(), "\n");
            csvContent.append(lB);
        }
        //Remove the final newline character
        csvContent.delete(csvContent.length() - 1, csvContent.length());
        Files.writeString(Path.of(dPath), csvContent);
    }
    public static List<List<String>> readCSVContent(String sourcePath) throws IOException {
        List<List<String>> data = new ArrayList<>();
        for (String line : Files.readAllLines(Path.of(sourcePath))) {
            List<String> fields = List.of(line.split(","));
            data.add(fields);
        }
        return data;
    }

    public static List<String> fetchRow(String sourcePath, int rowIndex) throws IOException {
        List<List<String>> data = readCSVContent(sourcePath);
        List<String> selectedRow = new ArrayList<>();
        //Start at i = 1 because i = 0 is the header
        for (int i = 1; i < data.size(); i++) {
            List<String> currentRow = data.get(i);
            selectedRow.add(currentRow.get(rowIndex));
        }
        return selectedRow;
    }

}
