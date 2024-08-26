package seleniumTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Slider extends BaseSetUp {

    public static Boolean HandlingSlider() {
        Boolean bol=false;
        WebElement Widgets_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]"));
        Widgets_Frames.click();
        WebElement Slider_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Slider\")]"));
        Slider_span.click();

        bol=true;
        return  bol;

    }
}
