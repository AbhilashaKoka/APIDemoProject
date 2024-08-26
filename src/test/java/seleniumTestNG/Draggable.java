package seleniumTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Draggable extends BaseSetUp {



    public static Boolean HandlingDraggable(){
        Boolean bol=false;
        WebElement Interactions_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Interactions\")]"));
        Interactions_Frames.click();
        WebElement Dragabble_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Dragabble\")]"));
        Dragabble_span.click();
        bol=true;
        return bol;


    }

}
