package seleniumTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Droppable extends BaseSetUp {


    public static void HandlingDroppable(){
        WebElement Interactions_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Interactions\")]"));
        Interactions_Frames.click();
        WebElement Droppable_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Droppable\")]"));
        Droppable_span.click();

    }

}
