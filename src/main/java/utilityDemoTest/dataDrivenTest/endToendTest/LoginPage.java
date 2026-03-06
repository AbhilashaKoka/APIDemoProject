package utilityDemoTest.dataDrivenTest.endToendTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.time.Duration;

public class LoginPage {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.driver.chrome", "\\src\\test\\resource\\driver\\chromedriver-win64\\chromedriver.exe");
        WebDriver  driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement Input_Box= driver.findElement(By.cssSelector("input[placeholder=\"Username\"]"));
        Input_Box.sendKeys("Admin");

        WebElement Pwd_Box= driver.findElement(By.cssSelector("input[placeholder=\"Password\"]"));
        Pwd_Box.sendKeys("admin123");

        WebElement Submit_Button= driver.findElement(By.cssSelector("button[type=\"submit\"]"));

        Submit_Button.submit();
        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"),"Dasboard Page is Present!!");

        driver.close();

    }
}
