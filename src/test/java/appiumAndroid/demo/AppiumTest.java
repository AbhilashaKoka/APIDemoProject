package appiumAndroid.demo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;


public class AppiumTest{
      static AppiumDriver driver;
      static AppiumDriverLocalService appiumLocalService =
        new AppiumServiceBuilder().usingAnyFreePort().build();
        static DesiredCapabilities cap = new DesiredCapabilities();

    public static void openCalculator() {

      try {
          cap = new DesiredCapabilities();
          cap.setCapability("platformName", "Android");
          cap.setCapability("platformVersion", "7.0");
          cap.setCapability("DeviceName", "Android 7.0");
          cap.setCapability("UDID", "emulator-5554");
          cap.setCapability("appPackage", "com.google.android.calculator");
          cap.setCapability("appActivity", "com.android.calculator2.Calculator");
//          cap.setCapability("appPackage", "com.android.chrome");
//          cap.setCapability("NEW_COMMAND_TIMEOUT", 60);
//          cap.setCapability("appium:browserName", "CHROME");
//          cap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
//          cap.setCapability("appium:automationName", "UIAutomator2");
//          cap.setCapability("appium:options", "--use-plugins");


          if(appiumLocalService.isRunning()) {
                 Runtime.getRuntime().exec("cmd /c  TASKKILL /F /IM node.exe");
                 appiumLocalService.start();
          }

          driver = new AndroidDriver(appiumLocalService, cap);
           driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);

          driver = new AndroidDriver( cap);
          System.out.println("Browser Started...........");

      }
      catch (Exception ex)
      {
          ex.printStackTrace();

      }

    }
    public static void main(String[] args) throws IOException {
        openCalculator();
    }
}

