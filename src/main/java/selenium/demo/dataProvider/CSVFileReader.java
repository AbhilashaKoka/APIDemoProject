package selenium.demo.dataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CSVFileReader {
    private static final String CSV_FILE_PATH = "src/main/java/javaProgram/demo/testDemo/testdata.csv";

    public static List<String[]> readCSV(String filePath) throws IOException {
        List<String[]> data = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        }
        return data;
    }

    // Method to provide test data from CSV file
    public static Stream<String[]> provideTestData() throws IOException {
        List<String[]> data = CSVFileReader.readCSV(CSV_FILE_PATH);
        return data.stream();
    }





}

