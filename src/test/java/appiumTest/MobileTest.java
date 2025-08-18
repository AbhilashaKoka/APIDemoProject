package appiumTest;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class MobileTest {



    public static void main(String[] args) throws Exception {
        AppiumServerManager.startAppiumServer();
        DesiredCapabilities caps = getDesiredCapabilitiesForBrowserApp();
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, caps);
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Automation");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        System.out.println("Test Completed...........");
        driver.quit();
        AppiumServerManager.stopAppiumServer();
    }

    private static DesiredCapabilities getDesiredCapabilitiesForBrowserApp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("automationName", "UIAutomator2");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("noReset", true);
        caps.setCapability("chromedriverAutodownload", true);
        return caps;
    }

    private static DesiredCapabilities getDesiredCapabilitiesForNativeApp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        return capabilities;
    }
}