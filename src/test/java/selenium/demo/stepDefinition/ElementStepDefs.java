package selenium.demo.stepDefinition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import selenium.demo.cucumberContext.TestContext;
import selenium.demo.testData.TextBoxDetails;
import java.util.List;
import java.util.Map;


public class ElementStepDefs {


          WebDriver driver;
    static JavascriptExecutor js;
    static Actions action;

    public ElementStepDefs(TestContext testContext) {
        driver=testContext.getDriverManager().getDriver();
    }


    @Given("User is on Landing Page")
    public void user_is_on_landing_page() {
        System.out.println("User is Landing Page!!");
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        WebElement ele= driver.findElement(By.xpath("//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]"));
        ele.click();
        WebElement textbox=driver.findElement(By.xpath("//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Text Box\")]"));
        textbox.click();
    }

    @When("User enter details username, email, current address, permanent address")
    public void user_enter_details_username_email_current_address_permanent_address() throws InterruptedException {
        String sText=js.executeScript("return document.title;").toString();
        WebElement element= driver.findElement(By.xpath("//*[contains(text(),\"Text Box\")]"));
        js.executeScript("arguments[0].scrollIntoView;",element);
        js.executeScript("document.getElementById('userName').value='sita';");
        js.executeScript("document.getElementById('userEmail').value='sita@gmail.com';");
        js.executeScript("document.getElementById('currentAddress').value='sita@gmail.com';");
        js.executeScript("document.getElementById('permanentAddress').value='sita@gmail.com';");
        js.executeScript("document.getElementById('submit').click();");
        List<WebElement> ele3=driver.findElements(By.xpath("//*[@id=\"output\"]//p"));
        if(ele3.size()!=0){
            System.out.println(ele3.size()+"Element found as tag name as input \n");
            for(WebElement inputele:ele3)
            {
                System.out.println(inputele.getText());
            }
        }
        //  System.out.println(name.toString());
        Thread.sleep(1000);
    }

    @When("Click on Submit")
    public void click_on_submit() {
        System.out.println("Submitted!!");

    }
    @Then("user should able to verify the detail on output area")
    public void user_should_able_to_verify_the_detail_on_output_area() {
        System.out.println("Verfied!!");

    }

    @When("User TextBox Details {string}, {string}, {string}, {string}")
    public void user_text_box_details(String username, String email, String currAddr, String peraddr) {
        System.out.println("username:"+username);
        System.out.println("email:"+email);
        System.out.println("current Addr:"+currAddr);
        System.out.println("permanent Addr:"+peraddr);
    }



    @When("User TextBox values {string}, {string}, {string}, {string}")
    public void user_text_box_values(String username1, String email1, String currAddr1, String peraddr1) throws InterruptedException {
        String sText=js.executeScript("return document.title;").toString();
        WebElement element= driver.findElement(By.xpath("//*[contains(text(),\"Text Box\")]"));
        js.executeScript("arguments[0].scrollIntoView;",element);
        js.executeScript("document.getElementById('userName').value='"+username1+"';");
        js.executeScript("document.getElementById('userEmail').value='"+email1+"';");
        js.executeScript("document.getElementById('currentAddress').value='"+currAddr1+"';");
        js.executeScript("document.getElementById('permanentAddress').value='"+peraddr1+"';");
        js.executeScript("document.getElementById('submit').click();");
        List<WebElement> ele3=driver.findElements(By.xpath("//*[@id=\"output\"]//p"));
        if(ele3.size()!=0){
            System.out.println(ele3.size()+"Element found as tag name as input \n");
            for(WebElement inputele:ele3)
            {
                System.out.println(inputele.getText());
            }
        }
        //  System.out.println(name.toString());
        Thread.sleep(1000);
    }



    @When("User enter textBox values List of List")
    public void user_enter_text_box_values_list_of_list(DataTable dataTable) {
     List<List<String>> table=dataTable.asLists();
     table.get(0).get(0);

    }



    @When("User enter textbox values List of Map")
    public void user_enter_textbox_values_list_of_map(DataTable dataTable) {
     List<Map<String, String>> table2=dataTable.asMaps();
     table2.get(0).get("uname");
        table2.get(0).get("email");
        table2.get(0).get("curraddr");
        table2.get(0).get("permaddr");
    }



    @When("User enter details values using testdataClass")
    public void user_enter_details_values_using_testdata_class(List<TextBoxDetails> textBoxDetails) {

        for (TextBoxDetails textBoxDetails1 : textBoxDetails) {
            textBoxDetails1.getUsername();
            textBoxDetails1.getEmail();
            textBoxDetails1.getCurrentaddress();
            textBoxDetails1.getPermanentaddress();
        }
    }



}
