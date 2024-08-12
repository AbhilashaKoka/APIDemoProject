package SeleniumGrid;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public  class SeleniumGridDemo {

    @Test
    public  void GridTest() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setCapability("browserVersion", "100");
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.setCapability("se:name", "My simple test");
        chromeOptions.setCapability("se:sampleMetadata", "Sample metadata value");
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/"), chromeOptions);
        driver.get("http://www.google.com");
        driver.quit();
    }
}
