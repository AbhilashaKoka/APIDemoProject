package seleniumGridTest;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.URL;

public class GridProxyExample {
    public static void main(String[] args) throws Exception {
        // Define proxy settings
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("myproxy.example.com:8080");
        proxy.setSslProxy("myproxy.example.com:8080");

        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();
        options.setProxy(proxy);

        // Combine with desired capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.merge(options);

        // Connect to Selenium Grid Hub
        WebDriver driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"), // Hub URL
                capabilities
        );

        // Run a test
        driver.get("http://www.google.com");
        System.out.println("Title: " + driver.getTitle());

        driver.quit();
    }

}
