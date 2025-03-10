package seleniumUITest.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import seleniumUITest.manager.DriverManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class BrowserWindowPage {
    WebDriver driver;

    static Actions action;
    static JavascriptExecutor js;


   @FindBy(how = How.XPATH, using = "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Alerts, Frame & Windows\")]")
   private WebElement   Window_Frames;

    @FindBy(how = How.XPATH, using = "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Browser Windows\")]")
    private WebElement  BrowserWindows_span;

   @FindBy(how = How.XPATH, using = "//*[@id=\"browserWindows\"]")
   private WebElement BrowserWindow;


    @FindBy(how = How.XPATH, using ="//*[@id=\"tabButton\"]")
    private WebElement  tabButton;

    @FindBy(how = How.XPATH, using ="//*[@id=\"tabButton\"]")
    private WebElement  tabButton2;


    @FindBy(how = How.XPATH, using ="//*[@id=\"windowButton\"]")
    private WebElement parentWindow3;

    @FindBy(how = How.XPATH, using ="//*[@id=\"messageWindowButton\"]")
    private WebElement parentWindow1;


    public void BrowserWindowPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean BrowserWindowLandingPage()
    {
        boolean bol=false;
        DriverManager.scrollWindowUp(Window_Frames);
        Window_Frames.click();
        BrowserWindows_span.click();
        bol=true;
        return bol;
    }


    public  Boolean HandlingBrowserWindow() throws InterruptedException {
        Boolean bol=false;

        Window_Frames.click();
        BrowserWindows_span.click();
        System.out.println(BrowserWindow.getAttribute("innerText"));
        String parentWindow= driver.getWindowHandle();

        System.out.println("Parent Tab");
        tabButton.click();
        ArrayList<String> handles=new ArrayList<>(driver.getWindowHandles());
        // driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().window(handles.get(1));
        System.out.println("New Tab");
        driver.get("https://www.google.com");
        driver.switchTo().window(parentWindow);
        System.out.println("Parent Tab");
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");


        tabButton2.click();
        Object[] windowsHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowsHandles[1]);
        driver.switchTo().window((String) windowsHandles[0]);



        WebElement windowButton=driver.findElement(By.xpath("//*[@id=\"windowButton\"]"));
        String parentWindow3= driver.getWindowHandle();
        windowButton.click();
        driver.switchTo().newWindow(WindowType.WINDOW);
        System.out.println("Child Window");
        driver.get("http://www.google.com");
        driver.switchTo().window(parentWindow3);
        System.out.println("Parent Window");
        Thread.sleep(1000);


        WebElement messageWindowButton=driver.findElement(By.xpath("//*[@id=\"messageWindowButton\"]"));
        String parentWindow1= driver.getWindowHandle();
        messageWindowButton.click();
        Set<String> handles1=driver.getWindowHandles();
        Iterator<String> it1=handles1.iterator();
        if(it1.next()!=parentWindow1)
        {
            String childwindow1= it1.next();
            //name, handle, ID
            driver.switchTo().window(childwindow1);
            Dimension size=driver.manage().window().getSize();
            int widthOfWindow=size.getWidth();
            int HeightOfWindow=size.getHeight();

            System.out.println("Child Window width"+widthOfWindow);
            System.out.println("Child Window Height"+HeightOfWindow);

            Point position=driver.manage().window().getPosition();
            int x1=position.getX();
            int y1=position.getY();

            System.out.println("Child Window position of x coordinate "+widthOfWindow);
            System.out.println("Child Window position of y coordinate"+HeightOfWindow);

//            driver.manage().window().setPosition(new Point(20,30));
//            driver.manage().window().maximize();
//            driver.manage().window().minimize();
//            driver.manage().window().fullscreen();

        }
        bol=true;
        return bol;
    }

}
