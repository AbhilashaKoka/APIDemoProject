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

import java.util.List;

public class AccordionPage {

    WebDriver driver;
    static Actions action;


    @FindBy(how = How.XPATH, using = "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]")
    private  WebElement Widgets_Frames;

    @FindBy(how = How.XPATH, using =  "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Accordian\")]")
    private  WebElement Accordian_span;

    @FindBy(how = How.XPATH, using = "//*[@id=\"accordianContainer\"]")
    private WebElement accordianContainer;


    @FindBy(how = How.XPATH, using = "//div[@id=\"accordianContainer\"]//following::div[@class=\"accordion\"]")
    private  List<WebElement> accordiansLIst;



    public AccordionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public boolean AccordionLandingPage()
    {
        boolean bol=false;
        DriverManager.scrollWindowUp(Widgets_Frames);
        Widgets_Frames.click();
        Accordian_span.click();
        bol=true;
        return bol;
    }


    public Boolean HandlingAccordion(){
        Boolean bol=false;

        Widgets_Frames.click();

        Accordian_span.click();

        System.out.println(accordianContainer.getAttribute("innerText"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");


        int size=accordiansLIst.size();

        for(WebElement ele:accordiansLIst){
            action.moveToElement(ele).perform();
            action.moveToElement(ele.findElement(By.xpath("//*[@class=\"card-header\"]"))).clickAndHold().perform();
            WebElement accordianBody=driver.findElement(By.xpath("//*[@id=\"section1Heading\"]/following::div[starts-with(@class,'collapse')]"));
            action.moveToElement(accordianBody.findElement(By.xpath("//*[@class=\"card-body\" and @id=\"section1Content\"]/p"))).perform();
            action.build();
            System.out.println(driver.findElement(By.xpath("//*[@class=\"card-body\" and @id=\"section1Content\"]/p")).getAttribute("class"));
//            System.out.println(driver.findElement(By.xpath("//*[@class=\"card-body\" and @id=\"section1Content\"]/p")).getAttribute("autocomplete"));
//            System.out.println(driver.findElement(By.xpath("//*[@class=\"card-body\" and @id=\"section1Content\"]/p")).getAttribute("nonExistingAttribute"));

        }
        bol=true;
        return bol;
    }
}
