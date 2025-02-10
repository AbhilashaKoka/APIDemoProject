package seleniumGridTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class StandaloneRemoteDriverTest {
    static String jarPath = "src/test/resource/driver/selenium-server-4.25.0.jar";
    public static WebDriver driver;

    public static boolean StartSeleniumServer() throws IOException {
        boolean bol=false;
        ProcessBuilder processBuilder = new ProcessBuilder("pkill", "-f", "java.exe");
        processBuilder.redirectErrorStream(true);
        ProcessBuilder processBuilder2 = new ProcessBuilder("java", "-jar", jarPath, "standalone");
        processBuilder.redirectErrorStream(true);
        try {

          Process  process = processBuilder.start();
            System.out.println("Selenium Server started.");
            // Optionally, you can read the output of the process
            new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();

                }
            }).start();
            // Wait for the process to complete (if needed)
            int exitCode = process.waitFor();
            System.out.println("Process exited with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
           // e.printStackTrace();

       }
        bol=true;
        return bol;
 }


 @BeforeSuite
    public static void setup(String browser) throws IOException {
        StartSeleniumServer();
        if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions chromeOptions = new ChromeOptions();
                   driver = (new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions));
             //   driver = (new RemoteWebDriver(new URL("http://IPStandalone:4444"), chromeOptions));
              }
            else if (browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = (new RemoteWebDriver(new URL("http://localhost:4444"), firefoxOptions));

            } else if (browser.equalsIgnoreCase("edge")) {
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = (new RemoteWebDriver(new URL("http://localhost:4444"), edgeOptions));
            }
            else {
                throw new Error("Browser configuration is not defined!!");
            }
        }




@AfterSuite
    public static void tearDown() throws InterruptedException {
        driver.quit();


    }
    }




