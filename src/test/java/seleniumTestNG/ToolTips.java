package seleniumTestNG;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ToolTips extends BaseSetUp {

    public static void HandlingToolTip() {
        WebElement Widgets_Frames = driver.findElement(By.xpath("//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]"));
        Widgets_Frames.click();
        WebElement ToolTips_Span = driver.findElement(By.xpath("//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Tool Tips\")]"));
        ToolTips_Span.click();
    }
}
