package seleniumUITest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumUITest.manager.DriverManager;

import java.time.Duration;

public class ButtonPage {
    static WebDriver driver;
    static Actions action;
    static JavascriptExecutor js;



     @FindBy(how = How.XPATH, using ="//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]")
    private WebElement  Elements_Frames;

     @FindBy(how = How.XPATH, using =" //*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Buttons\")]")
    private WebElement Button_span;

    @FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div/div/div[2]/div[2]/h1[contains(text(), \"Buttons\")]")
     private WebElement title;

    @FindBy(how = How.XPATH, using ="//button[@id=\"doubleClickBtn\"]")
    private WebElement doubleClickButton;

    @FindBy(how = How.XPATH, using ="//*[@id=\"doubleClickMessage\"]")
    private WebElement outputForDoubleClick;

    @FindBy(how = How.XPATH, using ="//button[@id=\"rightClickBtn\"]")
    private WebElement RightClickButton;

    @FindBy(how = How.XPATH, using =" //*[@id=\"rightClickMessage\"]")
    private WebElement outputForRightClick;

    @FindBy(how = How.XPATH, using ="//button[@id=\"rightClickBtn\"]//following::button")
    private WebElement ClickMeButton;

    @FindBy(how = How.XPATH, using ="//*[@id=\"dynamicClickMessage\"]")
    private WebElement outputForClick;



    public void BrowserWindowPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean BrowserWindowLandingPage()
    {
        boolean bol=false;
        DriverManager.scrollWindowUp(Elements_Frames);
        Elements_Frames.click();
        Button_span.click();
        bol=true;
        return bol;
    }


    public static Boolean HandlingButton(){
        Boolean bol=false;
        WebElement Elements_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]"));
        Elements_Frames.click();
        WebElement Button_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Buttons\")]"));
        Button_span.click();

        WebElement title = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/h1[contains(text(), \"Buttons\")]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", title);
        String titleOfPage = title.getText();
      //  Assertions.assertEquals("Buttons", titleOfPage);
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[@id=\"doubleClickBtn\"]"));
        if (doubleClickButton.isEnabled()) {
            action.moveToElement(doubleClickButton);
            action.doubleClick().build().perform();

        }
        WebElement outputForDoubleClick = driver.findElement(By.xpath("//*[@id=\"doubleClickMessage\"]"));
        String text = outputForDoubleClick.getAttribute("innerText");
      //  Assertions.assertEquals("You have done a double click", text);
        WebElement RightClickButton = driver.findElement(By.xpath("//button[@id=\"rightClickBtn\"]"));
        if (doubleClickButton.isEnabled()) {
            action.moveToElement(RightClickButton);
            action.contextClick().build().perform();

        }
        WebElement outputForRightClick = driver.findElement(By.xpath(" //*[@id=\"rightClickMessage\"]"));
        String text2 = outputForRightClick.getAttribute("innerText");
       // Assertions.assertEquals("You have done a right click", text2);

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
      //  Assertions.assertEquals("You have done a dynamic click", text3);
        bol=true;
        return bol;
    }


}
