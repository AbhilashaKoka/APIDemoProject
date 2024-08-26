package seleniumTestNG;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Button extends BaseSetUp {

    public Button(){

    }

    public static void HandlingButton() {
        setup();
        driver.get("https://demoqa.com/buttons");
        WebElement title = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/h1[contains(text(), \"Buttons\")]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", title);
        String titleOfPage = title.getText();
        Assertions.assertEquals("Buttons", titleOfPage);
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[@id=\"doubleClickBtn\"]"));
        if (doubleClickButton.isEnabled()) {
            action.moveToElement(doubleClickButton);
            action.doubleClick().build().perform();

        }
        WebElement outputForDoubleClick = driver.findElement(By.xpath("//*[@id=\"doubleClickMessage\"]"));
        String text = outputForDoubleClick.getAttribute("innerText");
        Assertions.assertEquals("You have done a double click", text);
        WebElement RightClickButton = driver.findElement(By.xpath("//button[@id=\"rightClickBtn\"]"));
        if (doubleClickButton.isEnabled()) {
            action.moveToElement(RightClickButton);
            action.contextClick().build().perform();

        }
        WebElement outputForRightClick = driver.findElement(By.xpath(" //*[@id=\"rightClickMessage\"]"));
        String text2 = outputForRightClick.getAttribute("innerText");
        Assertions.assertEquals("You have done a right click", text2);

        WebElement ClickMeButton = driver.findElement(By.xpath("//button[@id=\"rightClickBtn\"]//following::button"));
        if (ClickMeButton.isDisplayed()) {
            ClickMeButton.click();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id=\"rightClickBtn\"]//following::button")));
        if (ClickMeButton.isEnabled()) {
            action.moveToElement(ClickMeButton);
            action.click().build().perform();

        }
        WebElement outputForClick = driver.findElement(By.xpath(" //*[@id=\"dynamicClickMessage\"]"));
        String text3 = outputForClick.getAttribute("innerText");
        Assertions.assertEquals("You have done a dynamic click", text3);
        shutDown();
    }

}