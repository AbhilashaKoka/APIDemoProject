package appiumTest;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class MobileTest {

    private static AndroidDriver driver;

    public static void main(String[] args) throws Exception {

       AppiumServerManager.startAppiumServer();
        Thread.sleep(3000);

        DesiredCapabilities caps = getDesiredCapabilities();
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("Automation");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        System.out.println("Test Completed...........");
        driver.quit();
        AppiumServerManager.stopAppiumServer();
    }

    private static DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("automationName", "UIAutomator2");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("chromedriverExecutable", "C:\\ApplicationPath\\drivers\\chromedriver_74\\chromedriver.exe");
        caps.setCapability("noReset", true);
        return caps;
    }
}