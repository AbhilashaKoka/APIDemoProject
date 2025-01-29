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
import java.util.List;

public class CheckBoxPage {
    static WebDriver driver;
    static Actions action;
    static JavascriptExecutor js;

     @FindBy(how = How.XPATH, using ="//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]")
    private WebElement   Elements_Frames;
     @FindBy(how = How.XPATH, using = "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Check Box\")]")
     private WebElement   CheckBox_span;


    @FindBy(how = How.CSS, using ="  button[title=\"Toggle\"]")
    private WebElement sort;

    @FindBy(how = How.CSS, using ="input[type='checkbox']")
    private List<WebElement>  chkboxes;

    @FindBy(how = How.XPATH, using = "//span[@class=\"rct-title\"][ contains(text(),\"Desktop\")]//following::button[1][@title=\"Toggle\"]")
    private WebElement  sortDesktop;


    @FindBy(how = How.CSS, using ="input[type='checkbox']")
    private List<WebElement>  chkboxes2;

     @FindBy(how = How.XPATH, using ="//span[@class=\"rct-title\"][ contains(text(),\"WorkSpace\")]//following::button[1][@title=\"Toggle\"]")
    private WebElement sortDesktop2;

    @FindBy(how = How.XPATH, using ="//span[@class=\"rct-title\"][ contains(text(),\"React\")]//following::button[1][@title=\"Toggle\"]")
    private WebElement    sortDesktop3;

    public void CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean CheckBoxLandingPage()
    {
        boolean bol=false;
        DriverManager.scrollWindowUp(Elements_Frames);
        Elements_Frames.click();
        CheckBox_span.click();
        bol=true;
        return bol;
    }



    public  Boolean HandlingCheckBox(){
        Boolean bol=false;

        Elements_Frames.click();
        CheckBox_span.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("  button[title=\"Toggle\"]")));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("location.reload()");
        js.executeScript("window.scrollBy(0,250)",sort);
        sort.click();
         int size=chkboxes.size();
        System.out.println(size);


        sortDesktop.click();

        int size2=chkboxes2.size();
        System.out.println(size2);

        WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(60));
        wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector(" button[title=\"Toggle\"]")));

        sortDesktop2.click();

        sortDesktop3.click();
        bol=true;
        return bol;

    }
}
