package selenium.demo.stepDefinition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class FormSteps {
    static WebDriver driver;
    static JavascriptExecutor js;
    static Actions action;


    @Given("I am in from landing page")
    public void i_am_in_from_landing_page() {
        System.out.println("User is in Landing Page!!!");
        System.setProperty("Webdriver.driver.chrome", "D:\\Users\\akoka\\IdeaProjects\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        action = new Actions(driver);
        js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com");
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
         WebElement formFrames= driver.findElement(By.xpath("//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Forms\")]"));
         formFrames.click();
         WebElement PracticeForms=driver.findElement(By.xpath("//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Practice Form\")]"));
         PracticeForms.click();
    }

    @When("I fill all valid credential and click on submit")
    public void i_fill_all_valid_credential_and_click_on_submit(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        WebElement PracticeForm = driver.findElement(By.xpath("//*[@class=\"practice-form-wrapper\"]"));
        js.executeScript("window.scrollBy(0,350)", PracticeForm);
        WebElement InputBox_FirstName = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        InputBox_FirstName.sendKeys("XYZ", Keys.TAB);
        WebElement InputBox_LastName = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        InputBox_LastName.sendKeys("ABC", Keys.TAB);
        WebElement Email = driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));
        Email.sendKeys("XYZ@gmail.com", Keys.TAB);
        WebElement RadioButton_Male = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]//following::label[contains(text(),\"Male\")]//preceding-sibling::input[@name=\"gender\"]"));
        if (!RadioButton_Male.isSelected())
        {
            action.moveToElement(RadioButton_Male).click().perform();
            RadioButton_Male.sendKeys(Keys.TAB);
        }
        WebElement Mobile = driver.findElement(By.xpath("//*[@id=\"userNumber\"]"));
        Mobile.sendKeys("90249234234", Keys.TAB);
        WebElement DateOfBirth = driver.findElement(By.xpath("//*[@id=\"dateOfBirthInput\"]"));
        DateOfBirth.sendKeys("25 JAN 2024",Keys.TAB,Keys.ENTER,Keys.TAB);
        Thread.sleep(5000);
        WebElement Subject = driver.findElement(By.xpath("//div[@class=\"subjects-auto-complete__input\"]/input[@type=\"text\"]"));
        Subject.sendKeys("Computer Science");
        Subject.sendKeys(Keys.TAB,Keys.TAB);
        js.executeScript("window.scrollBy(0,350)");
        Thread.sleep(8000);
        WebElement  CheckBox_Hobbies=driver.findElement(By.xpath("//div[@id=\"hobbiesWrapper\"]//label[contains(text(),\"Reading\")]//preceding-sibling::input"));
        if (!CheckBox_Hobbies.isSelected()) {
            action.moveToElement(CheckBox_Hobbies).click().perform();
            CheckBox_Hobbies.sendKeys(Keys.TAB,Keys.TAB);
        }
        js.executeScript("window.scrollBy(0,350)");
        WebElement  Upload_Picture=driver.findElement(By.xpath("//*[@id=\"uploadPicture\" and @type=\"file\"]"));
        Upload_Picture.sendKeys("D:\\Users\\akoka\\Downloads\\sampleFile.jpeg");
        js.executeScript("window.scrollBy(0,350)");
        WebElement  TextArea_CurrentAdress=driver.findElement(By.xpath("//textArea[@id=\"currentAddress\"]"));
        TextArea_CurrentAdress.sendKeys("adafafdhdlhdgl");
        TextArea_CurrentAdress.sendKeys(Keys.TAB);
        js.executeScript("window.scrollBy(0,350)");
        Thread.sleep(5000);
        WebElement  DropDown_States= driver.findElement(By.xpath("//input[@id=\"react-select-3-input\"]"));
        DropDown_States.sendKeys("Uttar Pradesh");
        DropDown_States.sendKeys(Keys.TAB);
        WebElement  DropDown_City= driver.findElement(By.xpath("//*[@id=\"react-select-4-input\"]"));
        DropDown_City.sendKeys("Lucknow");
        DropDown_City.sendKeys(Keys.TAB);
        WebElement submitButton=driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        submitButton.click();

    }
    @Then("I am able to verify form details successfully")
    public void i_am_able_to_verify_form_details_successfully() {
        WebElement modalBox=driver.findElement(By.xpath("//*[@class=\"modal-dialog modal-lg\"]"));
        WebElement modalCloseButton=driver.findElement(By.xpath(" //*[@class=\"modal-dialog modal-lg\"]/div/div[3]/button[@type=\"button\"]"));
        action.moveToElement(modalBox).perform();
        List<WebElement> coloumn=driver.findElements(By.xpath("//table[@class=\"table table-dark table-striped table-bordered table-hover\"]/tbody/tr"));
        for(WebElement rows:coloumn) {
            String str1 = rows.findElement(By.xpath("td[1]")).getAttribute("innerText");
            String str2 = rows.findElement(By.xpath("td[2]")).getAttribute("innerText");
            System.out.println(str1 + ":" + str2);
        }
        action.moveToElement(modalCloseButton).click().perform();
        modalCloseButton.sendKeys(Keys.ESCAPE);
        js.executeScript("window.scrollBy(0,-350)");
        System.out.println("User successfully filled the forms");
    }


}