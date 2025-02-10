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


public class RemoteDriverTest {
    static String jarPath = "src/test/resource/driver/selenium-server-4.25.0.jar";
    public static WebDriver driver;


    public static void startStandaloneSeleniumServer(String jarPath) throws IOException, InterruptedException {
        killExistingJavaProcesses();
        Process process = startSeleniumServer(jarPath);
        logServerOutput(process);
        int exitCode = process.waitFor();
        System.out.println("Process exited with code: " + exitCode);
    }

    private static void killExistingJavaProcesses() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("tasklist");
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("java.exe")) {
                    String[] parts = line.split("\\s+");
                    String pid = parts[1];
                    new ProcessBuilder("taskkill","/PID", pid).start();
                    System.out.println("Killed process with PID: " + pid);
                }
            }
        }
    }

    private static Process startSeleniumServer(String jarPath) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", jarPath, "standalone");
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        System.out.println("Selenium Standalone Server started.");
        return process;
    }

    private static void logServerOutput(Process process) {
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
    }


 @BeforeSuite
    public static void setup(String browser) throws IOException, InterruptedException {

        try{ startStandaloneSeleniumServer(jarPath);
 } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }

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




