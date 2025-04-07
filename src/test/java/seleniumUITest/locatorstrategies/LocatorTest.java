package seleniumUITest.locatorstrategies;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorTest {

    public static void main(String[] args) {
        // Setup WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to a test page
            driver.get("https://example.com");

            // Using generalized methods to find elements
            WebElement elementById = driver.findElement(CSSSelectorUtility.locateById("submit-button"));
            WebElement elementByClassName = driver.findElement(CSSSelectorUtility.locateByClassName("form-control"));
            WebElement elementByAttribute = driver.findElement(CSSSelectorUtility.locateByAttribute("data-testid", "username"));
            WebElement elementByParentChild = driver.findElement(CSSSelectorUtility.locateByParentChild("div", "span"));
            WebElement elementBySibling = driver.findElement(CSSSelectorUtility.locateBySibling("label", "input"));

            // Perform actions
            elementById.click();
            System.out.println("Element interaction completed.");

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}