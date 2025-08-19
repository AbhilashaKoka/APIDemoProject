package seleniumperfTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class BaseproxySetUp extends SeleniumBrowserMobWithProxy{
    static WebDriver driver;

    public BaseproxySetUp() {
        driver=createDriver();
    }

    @Test
    public void testWithProxy() throws InterruptedException, IOException {
        startBrowserMobProxy();
        createDriver();
        runScript();
        writeHarFile();
        cleanUp();
    }

}
