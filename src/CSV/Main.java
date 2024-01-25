package CSV;

import java.io.IOException;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        List<List<String>> dataLines = List.of(
                List.of("Name", "Occupation", "Age"),
                List.of("Zaremba", "Teacher", "39"),
                List.of("John", "Teacher", "30"),
                List.of("Frank", "Student", "16"),
                List.of("Alice","棉","114514")
        );
        try {
            CSV.generateCSV("test.csv", dataLines);
            System.out.println(CSV.readCSVContent("test.csv"));
            System.out.println(CSV.fetchRow("test.csv", 2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



