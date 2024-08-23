package stepDefinition;
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

import java.util.List;


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



}
