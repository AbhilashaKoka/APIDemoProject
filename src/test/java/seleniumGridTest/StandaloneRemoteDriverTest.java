package seleniumGridTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


//Run Standalone mode -java -jar selenium-server-4.25.0.jar standalone
public class StandaloneRemoteDriverTest {

    public static WebDriver driver;


    public static void setup(String browser) throws MalformedURLException {
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions chromeOptions = new ChromeOptions();
            //    driver = (new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions));
                driver = (new RemoteWebDriver(new URL("http://192.168.1.4:4444"), chromeOptions));

            } else if (browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = (new RemoteWebDriver(new URL("http://localhost:4444"), firefoxOptions));

            } else if (browser.equalsIgnoreCase("edge")) {
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = (new RemoteWebDriver(new URL("http://localhost:4444"), edgeOptions));
            } else {
                throw new Error("Browser configuration is not defined!!");
            }
        }


    public static void main(String[] args) throws MalformedURLException {

    setup("chrome");
        driver.get("https://demoqa.com");
        JavascriptExecutor js=(JavascriptExecutor)driver;

        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        WebElement Element_Frames= driver.findElement(By.xpath("//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]"));
        Element_Frames.click();
        WebElement TextBox_Span=driver.findElement(By.xpath("//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Text Box\")]"));
        TextBox_Span.click();
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

        tearDown();
    }




    public static void tearDown() {
        driver.quit();
    }

}