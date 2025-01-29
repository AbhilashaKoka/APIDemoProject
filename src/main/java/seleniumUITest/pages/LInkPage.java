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

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class LInkPage {
    static WebDriver driver;
    static Actions action;
    static JavascriptExecutor js;
     @FindBy(how= How.XPATH,using="//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]")
    private WebElement  Elements_Frames;
    @FindBy(how= How.XPATH,using="//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Links\")]")
    private WebElement  Links_span;

    @FindBy(how= How.XPATH,using="//*[@id=\"linkWrapper\"]/p/a")
    private  List<WebElement> Links;

    public void LInkPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean LInkPageLandingPage()
    {
        boolean bol=false;
        DriverManager.scrollWindowUp(Elements_Frames);
        Elements_Frames.click();
        Links_span.click();
        bol=true;
        return bol;
    }



    public  static Boolean HandlingLInk(){
        Boolean bol=false;
        WebElement Elements_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]"));
        Elements_Frames.click();
        WebElement Links_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Links\")]"));
        Links_span.click();


        List<WebElement> Links = driver.findElements(By.xpath("//*[@id=\"linkWrapper\"]/p/a"));
        System.out.println(Links.size());
        for (WebElement link : Links) {
            String url = link.getAttribute("href");

            try {
                URL links = new URL(url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) links.openConnection();
                httpURLConnection.setConnectTimeout(3000);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200)
                {
                    System.out.println(url + "-" + httpURLConnection.getResponseMessage());
                }
                else if(httpURLConnection.getResponseCode()==201||httpURLConnection.getResponseCode()==204
                        ||httpURLConnection.getResponseCode()==301||httpURLConnection.getResponseCode()==400
                        ||httpURLConnection.getResponseCode()==401||httpURLConnection.getResponseCode()==403
                        ||httpURLConnection.getResponseCode()==404)
                {
                    System.out.println(url + "-" + httpURLConnection.getResponseMessage() + "-" + "is a broken link");
                }
            } catch (Exception ex) {
                System.out.println(url + "-" + "is a broken link");
            }
        }
        bol=true;
        return bol;
    }
}
