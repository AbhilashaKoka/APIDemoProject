package seleniumperfTest;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class SeleniumBrowserMobWithProxy {
    public static void main(String[] args) throws IOException {

        // Step 1: Start BrowserMob Proxy
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(0); // Start proxy on a random available port

        // Enable HAR capture (headers, content, cookies, etc.)
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

        // Step 2: Start recording HAR
        proxy.newHar("exampleTest");

        // Step 3: Configure Selenium to use the proxy
        Proxy seleniumProxy = new Proxy();
        seleniumProxy.setHttpProxy("localhost:" + proxy.getPort());

        ChromeOptions options = new ChromeOptions();
        options.setCapability("proxy", seleniumProxy);

        // Set WebDriver path and initialize it
        System.setProperty("webdriver.chrome.driver", "src/test/resource/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        // Step 4: Navigate to a website
        driver.get("https://www.google.com");

        // Step 5: Stop recording and save HAR file
        File harFile = new File("network_capture.har");
        proxy.getHar().writeTo(harFile);

        // Clean up resources
        driver.quit();
        proxy.stop();
    }
}

