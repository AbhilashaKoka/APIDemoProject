package Selenium.Interactions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Dynamic {
    public static void main(String args[]) {
        System.setProperty("Webdriver.driver.chrome", "D:\\Users\\akoka\\IdeaProjects\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        Actions action = new Actions(driver);
        driver.get("https://demoqa.com/dynamic-properties");
        WebElement captureText=driver.findElement(By.xpath("//*[@id=\"enableAfter\"]/preceding::p"));
        System.out.println(captureText.getAttribute("innerText"));
    }
}
