package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {
    private WebDriver driver;

    public WebDriverManager() {
    }

    public WebDriver getDriver() {
        if(driver==null) driver=createDriver();
        return driver;
    }

    public WebDriver createDriver( ) {
        System.setProperty("Webdriver.driver.chrome", "\\src\\test\\resource\\driver\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
      return  driver = new ChromeDriver(options);
        }
}
