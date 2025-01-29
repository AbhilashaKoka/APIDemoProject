package seleniumUITest.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import seleniumUITest.manager.DriverManager;

import java.util.List;

public class DataPickerPage {
    static WebDriver driver;
    static Actions action;
    static JavascriptExecutor js;


    @FindBy(how = How.XPATH, using =  "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]")
    private WebElement   Widgets_Frames;

    @FindBy(how = How.XPATH, using = "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Date Picker\")]")
    private WebElement   DatePicker_span;

    @FindBy(how = How.XPATH, using ="//*[@id=\"datePickerContainer\"]")
    private WebElement dataPickerContainer;

    @FindBy(how = How.XPATH, using =" //*[@id=\"datePickerMonthYearInput\" and @type=\"text\"]")
    private WebElement dataPickerMonthYearInput;

    @FindBy(how = How.XPATH, using ="//*[@class=\"react-datepicker__month\" and @role=\"listbox\"]")
    private List<WebElement> dataPickerWeeks ;

    @FindBy(how = How.XPATH, using ="//*[@class=\"react-datepicker__week\"]/div[@role=\"option\"]")
    private WebElement  day;


    public void DataPickerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean DataPickerLandingPage()
    {
        boolean bol=false;
        DriverManager.scrollWindowUp(Widgets_Frames);
        Widgets_Frames.click();
        DatePicker_span.click();
        bol=true;
        return bol;
    }



    public  Boolean HandlingDataPicker(){
        Boolean bol=false;
        Widgets_Frames.click();

        DatePicker_span.click();


        for (WebElement week : dataPickerWeeks) {
             day.getAttribute("innerText");
        }

        bol=true;
        return bol;
    }
}
