package seleniumGrid.demo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;


public class LocalGridDemoTests extends BaseTest {

    @Test
    public void test1() {
          getDriver().get("https://demoqa.com");
          JavascriptExecutor   js = (JavascriptExecutor) getDriver();
           js.executeScript("window.scrollBy(0,300)");
            WebElement Widgets_Frames=getDriver().findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]"));
            Widgets_Frames.click();
            WebElement DatePicker_span=getDriver().findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Date Picker\")]"));
            DatePicker_span.click();
            WebElement dataPickerContainer = getDriver().findElement(By.xpath("//*[@id=\"datePickerContainer\"]"));
            WebElement dataPickerMonthYearInput = getDriver().findElement(By.xpath(" //*[@id=\"datePickerMonthYearInput\" and @type=\"text\"]"));
            List<WebElement> dataPickerWeeks = getDriver().findElements(By.xpath("//*[@class=\"react-datepicker__month\" and @role=\"listbox\"]"));
            for (WebElement week : dataPickerWeeks) {
                String day = week.findElement(By.xpath("//*[@class=\"react-datepicker__week\"]/div[@role=\"option\"]")).getAttribute("innerText");
            }


        }

    }