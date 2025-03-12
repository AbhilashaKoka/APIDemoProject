package seleniumperfTest;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SeleniumBrowserMobWithProxy extends BaseproxySetUp{

    static WebDriver driver;
     static JavascriptExecutor js ;

    public static void main(String[] args) throws IOException, InterruptedException {
        // Step 1: Start BrowserMob Proxy
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        // Start proxy on a random available port
        proxy.start(0);
        // Enable HAR capture (headers, content, cookies, etc.)
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        // Step 2: Start recording HAR
        proxy.newHar("exampleTest");
        // Step 3: Configure Selenium to use the proxy
        Proxy seleniumProxy = new Proxy();
        seleniumProxy.setHttpProxy("localhost:" + proxy.getPort());
        ChromeOptions options = new ChromeOptions();
        options.setCapability("proxy", seleniumProxy);
        options.addArguments("start-maximized");
        // Set WebDriver path and initialize it
        System.setProperty("webdriver.chrome.driver", "src/test/resource/driver/chromedriver.exe");
         driver = new ChromeDriver(options);
        // Step 4: Navigate to a website
        driver.get("https://demoqa.com");
         js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
        try
        {
            HandlingForm();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        // Step 5: Stop recording and save HAR file
        File harFile = new File("network_capture.har");
        proxy.getHar().writeTo(harFile);
        // Clean up resources
        driver.quit();
        proxy.stop();
    }



        public static Boolean HandlingForm() throws InterruptedException {
        Boolean bol=false;
        WebElement Forms_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Forms\")]"));
        Forms_Frames.click();
        WebElement PracticeForm_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Practice Form\")]"));
        PracticeForm_span.click();
        WebElement PracticeForm = driver.findElement(By.xpath("//*[@class=\"practice-form-wrapper\"]"));
        js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", PracticeForm);
        WebElement InputBox_FirstName = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        InputBox_FirstName.sendKeys("XYZ", Keys.TAB);
        WebElement InputBox_LastName = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        InputBox_LastName.sendKeys("ABC", Keys.TAB);
        WebElement Email = driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));
        Email.sendKeys("XYZ@gmail.com", Keys.TAB);
        WebElement RadioButton_Male = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]//following::label[contains(text(),\"Male\")]//preceding-sibling::input[@name=\"gender\"]"));
        if (!RadioButton_Male.isSelected())
        {   Actions action=new Actions(driver);
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
            Actions action=new Actions(driver);
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
        WebElement modalBox=driver.findElement(By.xpath("//*[@class=\"modal-dialog modal-lg\"]"));
        WebElement modalCloseButton=driver.findElement(By.xpath(" //*[@class=\"modal-dialog modal-lg\"]/div/div[3]/button[@type=\"button\"]"));
            Actions action=new Actions(driver);
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

        bol=true;
        return bol;

    }
}

