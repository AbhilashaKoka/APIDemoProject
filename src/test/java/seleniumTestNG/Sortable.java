package seleniumTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Sortable extends BaseSetUp {

    public static Boolean  HandlingSortable() {
        Boolean bol=false;
        WebElement Interactions_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Interactions\")]"));
        Interactions_Frames.click();
        WebElement Sortable_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Sortable\")]"));
        Sortable_span.click();
        bol=true;
        return bol;

    }}

