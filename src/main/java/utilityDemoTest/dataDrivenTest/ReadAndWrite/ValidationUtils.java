package utilityDemoTest.dataDrivenTest.ReadAndWrite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ValidationUtils {

    /**
     * Utility method to validate the validation message on clicking an element.
     * @param driver        WebDriver instance
     * @param clickableBy   Locator for the clickable element
     * @param validationBy  Locator for the validation message element
     * @param expectedMsg   Expected validation message
     * @param timeoutSecs   Timeout in seconds for waiting for the message
     * @return true if the validation message matches the expected message, otherwise false
     */
    public static boolean validateMessage(WebDriver driver, By clickableBy, By validationBy, String expectedMsg, int timeoutSecs) {
        try {
            // Click the target element
            WebElement clickableElement = driver.findElement(clickableBy);
            clickableElement.click();

            // Wait for the validation message to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSecs));
            WebElement validationMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(validationBy));

            // Retrieve the validation message text
            String actualMessage = validationMessageElement.getText();

            // Return true if the message matches the expected message
            return actualMessage.equals(expectedMsg);
        } catch (Exception e) {
            System.err.println("Error during validation message check: " + e.getMessage());
            return false;
        }
    }

    // Example usage
    public static void main(String[] args) {
        // Example setup (update the WebDriver path and locators accordingly)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://example.com"); // Replace with your application URL

            // Example locators (update according to your application)
            By buttonLocator = By.id("buttonId");
            By messageLocator = By.id("messageId");

            // Expected validation message
            String expectedValidationMessage = "This field is required";

            // Call the utility method
            boolean isMessageValid = validateMessage(driver, buttonLocator, messageLocator, expectedValidationMessage, 10);

            // Print the result
            if (isMessageValid) {
                System.out.println("Validation message is correct.");
            } else {
                System.out.println("Validation message is incorrect or not displayed.");
            }
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}