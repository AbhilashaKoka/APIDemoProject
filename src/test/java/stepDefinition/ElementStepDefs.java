package stepDefinition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import testData.TextBoxDetails;

import java.util.List;
import java.util.Map;


public class ElementStepDefs{

    static WebDriver driver;
    static JavascriptExecutor js;
    static Actions action;


    @Given("User is on Landing Page")
    public void user_is_on_landing_page() {
        System.out.println("User is Landing Page!!");
        System.setProperty("Webdriver.driver.chrome", "D:\\Users\\akoka\\IdeaProjects\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com");
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        WebElement ele= driver.findElement(By.xpath("//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]"));
        ele.click();
        WebElement textbox=driver.findElement(By.xpath("//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Text Box\")]"));
        textbox.click();
    }

    @When("User enter details username, email, current address, permanent address")
    public void user_enter_details_username_email_current_address_permanent_address() throws InterruptedException {

        // HomePage homePage=new HomePage();
//        String username="Sita";
//        TextBoxDetails textBoxDetails= FileReaderManager.getInstance().getJsonDataReader().getTextBoxDetailsByUserName(username);
//      if(homePage.SubmitDetails(textBoxDetails))

        String sText=js.executeScript("return document.title;").toString();
        WebElement element= driver.findElement(By.xpath("//*[contains(text(),\"Text Box\")]"));
        String sText1=js.executeScript("return document.title;").toString();
        System.out.println(sText1);
        String sText2=js.executeScript("return document.domain;").toString();
        System.out.println(sText2);
        String sText3=js.executeScript("return document.URL;").toString();
        System.out.println(sText3);
        js.executeScript("arguments[0].scrollIntoView;",element);
        js.executeScript("location.reload()");
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

//    @When("User enter details {string}, {string}, {string}, {string}")
//    public void user_enter_details(String string, String string2, String string3, String string4) {
//        // Write code here that turns the phrase above into concrete actions
//
//    }
//
//
//    @When("User enter details {string}, {string}, {string}, {string}")
//    public void user_enter_details(String string, String string2, String string3, String string4) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

//    @When("User enter details")
//    public void user_enter_details(DataTable dataTable) {
//        // Write code here that turns the phrase above into concrete actions
//        // For automatic transformation, change DataTable to one of
//        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
//        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
//        // Double, Byte, Short, Long, BigInteger or BigDecimal.
//        //
//        // For other transformations you can register a DataTableType.
//
//        List<List<String>> data=dataTable.asLists();
//                                data.get(0).get(0);//first row first coloumn
//
//        throw new PendingException();
//    }

//    @When("User enter details")
//    public void user_enter_details(DataTable dataTable) {
//        // Write code here that turns the phrase above into concrete actions
//        // For automatic transformation, change DataTable to one of
//        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
//        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
//        // Double, Byte, Short, Long, BigInteger or BigDecimal.
//        //
//        // For other transformations you can register a DataTableType.
//
//       List<Map<String, String>> data=dataTable.asMaps();
//
//
//        throw new io.cucumber.java.PendingException();
//    }


//    @When("User enter details")
//    public void user_enter_details(DataTable dataTable) {
//        // Write code here that turns the phrase above into concrete actions
//        // For automatic transformation, change DataTable to one of
//        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
//        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
//        // Double, Byte, Short, Long, BigInteger or BigDecimal.
//        //
//        // For other transformations you can register a DataTableType.
//
//
//        for(Map<String, String> data:dataTable.asMaps(String.class,String.class))
//        {
//            data.get("uname");
//            data.get("email");
//            data.get("curraddr");
//            data.get("permaddr");
//        }
//        throw new io.cucumber.java.PendingException();
//    }


    @When("User enter details")
    public void user_enter_details(List<TextBoxDetails> textBoxDetails) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.


        for (TextBoxDetails textBoxDetails1 : textBoxDetails) {
            textBoxDetails1.getUsername();
            textBoxDetails1.getEmail();
            textBoxDetails1.getCurrentaddress();
            textBoxDetails1.getPermanentaddress();
        }
    }


}
