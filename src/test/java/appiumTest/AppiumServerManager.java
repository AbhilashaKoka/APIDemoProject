package appiumTest;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.io.File;
import java.io.IOException;

import static io.appium.java_client.service.local.flags.GeneralServerFlag.BASEPATH;


public class AppiumServerManager {

    private static AppiumDriverLocalService service;

    public static void startAppiumServer() throws InterruptedException, IOException {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1"); // Or use .usingAnyFreePort()
        builder.usingPort(4723); // Or use .usingAnyFreePort()
        builder.withAppiumJS(new File("C:\\Users\\Abhilasha\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")); // Replace with your Appium path
        builder.withArgument(BASEPATH, "/wd/hub"); // Standard base path
        // Add other server arguments as needed, e.g., builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        service = AppiumDriverLocalService.buildService(builder);
        if(!service.isRunning()) {
            service.start();
            System.out.println("Appium server started at: " + service.getUrl());
        }
        else {
            stopAppiumServer();
            service.start();
        }
    }

    public static void stopAppiumServer() {
        if (service != null && service.isRunning()) {
            service.stop();
            System.out.println("Appium server stopped.");
        }
    }
}