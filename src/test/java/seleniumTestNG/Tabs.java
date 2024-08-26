package seleniumTestNG;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Tabs extends BaseSetUp {


    public static Boolean  HandlingTabs() {
        Boolean bol=false;
        WebElement Widgets_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]"));
        Widgets_Frames.click();
        WebElement Tab_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Tabs\")]"));
    bol=true;
        return bol;
    }
}
