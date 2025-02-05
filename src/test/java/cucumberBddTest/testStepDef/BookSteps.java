package cucumberBddTest.testStepDef;

import cucumberBddTest.utility.ExcelUtils;
import cucumberBddTest.utility.TestBook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

public class BookSteps {
    private List<List<String>> excelData;

    @Given("I have the Excel file")
    public void iHaveTheExcelFile() {
    }

    @When("I read the books data from the Excel file")
    public void i_read_the_books_data_from_the_excel_file() throws IOException {
        excelData = ExcelUtils.readExcelData("C:\\Users\\Abhilasha\\Documents\\DOCUMENT\\StudyDocumentFolder\\IDE\\IdeaProjects\\Spring_Course-master\\APIDemoProject\\src\\test\\resource\\testdata\\file.xlsx");  // Update path as needed
    }

    @Then("the books data should be processed correctly")
    public void the_books_data_should_be_processed_correctly() {
        // Process the books data
        for (List<String> row : excelData) {
            TestBook book = new TestBook(

                   row.get(0),  // ISBN
                    row.get(1),  // Title
                    row.get(2),  // SubTitle
                    row.get(3),  // Author
                    row.get(4),  // Publish Date
                    row.get(5),  // Publisher
                 //   Integer.parseInt(row.get(6)),
                    row.get(6),//Pages
                    row.get(7),  // Description
                    row.get(8)   // Website
            );
            // Add your logic to process the book object
            System.out.println(book.getIsbn());
            System.out.println(book.getTitle());
            System.out.println(book.getSubTitle());
            System.out.println(book.getAuthor());
            System.out.println(book.getPublishDate());
            System.out.println(book.getPublisher());
            System.out.println(book.getPages());
            System.out.println(book.getDescription());
            System.out.println(book.getWebsite());
     }
    }


}
