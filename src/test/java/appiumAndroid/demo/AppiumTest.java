package appiumAndroid.demo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTest {
    public static void main(String[] args) {

DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "7.0");
        cap.setCapability("DeviceName", "Android 7.0");
        cap.setCapability("UDID", "emulator-5554");
        cap.setCapability("appPackage", "com.google.android.calculator");
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");
        AppiumDriver<MobileElement> driver = null;
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Interact with the calculator app
        MobileElement digit2 = driver.findElementById("com.android.calculator2:id/digit_2");
        MobileElement plus = driver.findElementById("com.android.calculator2:id/op_add");
        MobileElement digit3 = driver.findElementById("com.android.calculator2:id/digit_3");
        MobileElement equals = driver.findElementById("com.android.calculator2:id/eq");

        digit2.click();
        plus.click();
        digit3.click();
        equals.click();

        // Close the driver
        driver.quit();
    }
}

