package seleniumUITest.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import seleniumUITest.pages.HomePage;
import seleniumUITest.pages.PracticeFormPage;

public class PageObjectManager {
    private HomePage homePage;
    private PracticeFormPage practiceFormPage;
    WebDriver driver;

    public PageObjectManager(WebDriver driver) {
       this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public HomePage getHomePage()
    {
        return (homePage==null)?homePage=new HomePage(driver):homePage;

    }

    public PracticeFormPage getPracticePage()
    {
        return (practiceFormPage==null)?practiceFormPage=new PracticeFormPage(driver):practiceFormPage;

    }




}
