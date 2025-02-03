package restassuredTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class RestApiTest {

    public static void main(String args[]){
        RestApiTest restcall=new RestApiTest();
         restcall.ReadingWithArrayOutOfBoundCheck();

    }



        public  void ReadUsingJsonFile(){
            String csvFile = "src/test/resource/testDataResources/Demo.csv";
            String jsonTemplateFile = "src/test/resource/testDataResources/Demo.json";
            String line;
            String csvSplitBy = ",";

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                // Read the CSV file header
                String headerLine = br.readLine();
                String[] headers = headerLine.split(csvSplitBy);

                // Read the JSON template
                String jsonTemplate = new String(Files.readAllBytes(Paths.get(jsonTemplateFile)));

                while ((line = br.readLine()) != null) {
                    String[] data = line.split(csvSplitBy);

                    Map<String, String> requestData = new HashMap<>();
                    for (int i = 0; i <headers.length; i++) {
                        requestData.put(headers[i], data[i]);
                    }

                    // Replace placeholders in the JSON template
                    String jsonPayload = jsonTemplate;
                    for (Map.Entry<String, String> entry : requestData.entrySet())
                    {
                        jsonPayload =
                                jsonPayload.replace("${" + entry.getKey() + "}", entry.getValue());
                    }

                    // Send the request with RestAssured
                    Response response = RestAssured.given()
                            .contentType("application/json")
                            .body(jsonPayload)
                            .post("https://reqres.in/api/users");

                    System.out.println(response.getBody().asString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    public  void ReadUsingCSVFile() {
        String csvFile = "src/test/resource/testDataResources/Demo.csv";
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);

                String name = data[0];
                String job = data[1];

                Response response = RestAssured.given()
                        .contentType("application/json")
                        .body("{\"name\":\"" + name + "\", \"job\":\"" + job + "\"}")
                        .post("https://reqres.in/api/users");

                System.out.println(response.getBody().asString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





        public  void ReadingWithArrayOutOfBoundCheck() {
            String csvFile = "src/test/resource/testDataResources/Demo.csv";
            String jsonTemplateFile = "src/test/resource/testDataResources/Demo.json";
            String line;
            String csvSplitBy = ",";

            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                // Read the CSV file header
                String headerLine = br.readLine();
                if (headerLine == null) {
                    System.err.println("CSV file is empty.");
                    return;
                }
                String[] headers = headerLine.split(csvSplitBy);

                // Read the JSON template
                String jsonTemplate = new String(Files.readAllBytes(Paths.get(jsonTemplateFile)));

                while ((line = br.readLine()) != null) {
                    String[] data = line.split(csvSplitBy);

                    // Debugging statement to check the contents of each line
                    System.out.println("CSV Line: " + line);
                    System.out.println("Parsed Data Length: " + data.length);

                    // Validate that the data array has the expected number of elements
                    if (data.length != headers.length) {
                        System.err.println("Mismatch between header length and data length: " + line);
                        continue;
                    }

                    Map<String, String> requestData = new HashMap<>();
                    for (int i = 0; i < headers.length; i++) {
                        requestData.put(headers[i], data[i]);
                    }

                    // Replace placeholders in the JSON template
                    String jsonPayload = jsonTemplate;
                    for (Map.Entry<String, String> entry : requestData.entrySet()) {
                        jsonPayload = jsonPayload.replace("${" + entry.getKey() + "}", entry.getValue());
                    }

                    // Debugging statement to check the JSON payload
                    System.out.println("JSON Payload: " + jsonPayload);

                    // Send the request with RestAssured
                    Response response = RestAssured.given()
                            .contentType("application/json")
                            .body(jsonPayload)
                            .post("https://reqres.in/api/users");

                    System.out.println(response.getBody().asString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



}


