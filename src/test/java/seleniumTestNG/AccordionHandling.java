package seleniumTestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import java.util.List;

public class AccordionHandling extends BaseSetUp {


    public AccordionHandling() {
    }

    public static void HandlingAccordion(){
        setup();
        driver.get("https://demoqa.com/accordian");
        WebElement accordianContainer=driver.findElement(By.xpath(" //*[@id=\"accordianContainer\"]"));
        System.out.println(accordianContainer.getAttribute("innerText"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        List<WebElement> accordiansLIst=driver.findElements(By.xpath(" //div[@id=\"accordianContainer\"]//following::div[@class=\"accordion\"]"));
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
        shutDown();
    }
}
