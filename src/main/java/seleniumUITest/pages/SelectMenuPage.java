package seleniumUITest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import seleniumUITest.manager.DriverManager;

public class SelectMenuPage {
    static WebDriver driver;
    static Actions action;
    static JavascriptExecutor js;

    @FindBy(how= How.XPATH,using="//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]")
    private WebElement  Widgets_Frames;
  @FindBy(how= How.XPATH,using="//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Select Menu\")]")
  private WebElement  SelectMenu_span;


    public void SelectMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean SelectMenuLandingPage()
    {
        boolean bol=false;
        DriverManager.scrollWindowUp(Widgets_Frames);
        Widgets_Frames.click();
        SelectMenu_span.click();
        bol=true;
        return bol;
    }



    public static Boolean HandlingSelectMenu() {
        Boolean bol=false;
        WebElement Widgets_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]"));
        Widgets_Frames.click();
        WebElement SelectMenu_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Select Menu\")]"));
        SelectMenu_span.click();
        bol=true;
        return bol;

    }
}
