package StepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;


public class ElementStepDefs {

 static WebDriver driver;
 static  JavascriptExecutor js;
    @Given("User is on Landing Page")
    public void user_is_on_landing_page() {
        System.setProperty("Webdriver.driver.chrome","D:\\Users\\akoka\\IdeaProjects\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        driver=new ChromeDriver(options);
        driver.get("https://demoqa.com/text-box");

    }
    @When("User enter details username, email, current address, permanent address")
    public void user_enter_details_username_email_current_address_permanent_address() {
        js=(JavascriptExecutor) driver;
        WebElement element= driver.findElement(By.xpath("//*[contains(text(),\"Text Box\")]"));
        js.executeScript("arguments[0].scrollIntoView;",element);
//        js.executeScript("location.reload()");
        WebElement username= driver.findElement(By.xpath("//*[@id='userName']"));
        username.sendKeys("sita");
        WebElement Email= driver.findElement(By.xpath("//*[@id='userEmail']"));
        Email.sendKeys("sita@gmail.com");
        WebElement currentAddr= driver.findElement(By.xpath("//*[@id='currentAddress']"));
        currentAddr.sendKeys("sita@gmail.com");
        WebElement permanentAddr= driver.findElement(By.xpath("//*[@id='permanentAddress']"));
        permanentAddr.sendKeys("sita@gmail.com",Keys.TAB);

    }
    @When("Click on Submit")
    public void click_on_submit() {
        WebElement submitButton= driver.findElement(By.xpath("//*[@id='submit']"));
        js.executeScript("document.getElementById('submit').click();");

    }
    @Then("user should able to verify the detail on output area")
    public void user_should_able_to_verify_the_detail_on_output_area() {
        List<WebElement> ele=driver.findElements(By.xpath("//*[@id=\"output\"]//p"));
        if(ele.size()!=0){
            System.out.println(ele.size()+"Element found as tag name as input \n");
            for(WebElement inputele:ele)
            {
                System.out.println(inputele.getText());
            }
        }

    }


}
