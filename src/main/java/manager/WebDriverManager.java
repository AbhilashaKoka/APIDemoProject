package manager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {
    private static WebDriver driver;

    public WebDriverManager() {
    }

    public WebDriver getDriver() {
        if(driver==null) {
            driver=createDriver();
        }
        return driver;
    }

       private WebDriver createDriver( ) {
        System.setProperty("Webdriver.driver.chrome", "\\src\\test\\resource\\driver\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return driver = new ChromeDriver(options);
        }


        public void quiteDriver()
       {
        driver.quit();
        }

        public  void launchBaseUrl(){
        driver.get("https://demoqa.com");
        }
}
