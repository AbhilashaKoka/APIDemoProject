package seleniumTestNG;
import org.openqa.selenium.*;


public class AutoComplete extends BaseSetUp {

    public AutoComplete() {
    }

    public static Boolean HandlingAutomComplete(){
        Boolean bol=false;
        WebElement Widgets_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]"));
        Widgets_Frames.click();
        WebElement Accordian_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Auto Complete\")]"));
        Accordian_span.click();

        WebElement firstPlaceholder=driver.findElement(By.xpath("//div[@class=\"auto-complete__input\"]//input[@id=\"autoCompleteMultipleInput\" and @type=\"text\"]"));
        firstPlaceholder.sendKeys("Green");
        firstPlaceholder.sendKeys(Keys.TAB);
        firstPlaceholder.sendKeys(Keys.TAB);
        WebElement secondPlaceHolder=driver.findElement(By.xpath("//*[@class=\"css-1g6gooi\"]/div[@class=\"auto-complete__input\"]/input[@id=\"autoCompleteMultipleInput\" and @type =\"text\"]"));
        secondPlaceHolder.sendKeys("Green");
       // secondPlaceHolder.sendKeys(Keys.TAB);
        bol=true;
        return bol;

    }
}
