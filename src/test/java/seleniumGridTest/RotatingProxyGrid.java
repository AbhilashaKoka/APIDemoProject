package seleniumGridTest;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class RotatingProxyGrid {
    public static void main(String[] args) throws Exception {
        // List of proxies to rotate
        List<String> proxies = Arrays.asList(
                "proxy1.example.com:8080",
                "proxy2.example.com:8080",
                "proxy3.example.com:8080"
        );

        for (String proxyAddress : proxies) {
            Proxy proxy = new Proxy();
            proxy.setHttpProxy(proxyAddress);
            proxy.setSslProxy(proxyAddress);

            ChromeOptions options = new ChromeOptions();
            options.setProxy(proxy);

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.merge(options);

            WebDriver driver = new RemoteWebDriver(
                    new URL("http://localhost:4444/wd/hub"), // Selenium Grid Hub
                    capabilities
            );

            driver.get("http://www.google.com");
            System.out.println("Proxy: " + proxyAddress + " - Title: " + driver.getTitle());
            driver.quit();
        }
    }
}