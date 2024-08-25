package seleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckBox  extends BaseSetUp {

    public CheckBox() {
    }

    public static void HandlingCheckBox(){
        setup();
        driver.get("https://demoqa.com/checkbox");
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("  button[title=\"Toggle\"]")));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("location.reload()");
        WebElement sort= driver.findElement(By.cssSelector("  button[title=\"Toggle\"]"));
      // js.executeScript("arguments[0].scrollIntoView;",sort);
        js.executeScript("window.scrollBy(0,250)",sort);
       sort.click();
        List<WebElement> chkboxes=driver.findElements(By.cssSelector("input[type='checkbox']"));
        int size=chkboxes.size();
        System.out.println(size);

        WebElement sortDesktop=driver.findElement(By.xpath("//span[@class=\"rct-title\"][ contains(text(),\"Desktop\")]//following::button[1][@title=\"Toggle\"]"));
        sortDesktop.click();
        List<WebElement> chkboxes2=driver.findElements(By.cssSelector("input[type='checkbox']"));
        int size2=chkboxes2.size();
        System.out.println(size2);
        WebElement sortDesktop2=driver.findElement(By.xpath("//span[@class=\"rct-title\"][ contains(text(),\"WorkSpace\")]//following::button[1][@title=\"Toggle\"]"));
        WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(60));
        wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector(" button[title=\"Toggle\"]")));

        sortDesktop2.click();
        WebElement sortDesktop3=driver.findElement(By.xpath("//span[@class=\"rct-title\"][ contains(text(),\"React\")]//following::button[1][@title=\"Toggle\"]"));
        sortDesktop3.click();


        shutDown();
    }
}
