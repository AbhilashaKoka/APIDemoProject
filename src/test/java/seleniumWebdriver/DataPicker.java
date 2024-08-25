package seleniumWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import java.util.List;

public class DataPicker  extends BaseSetUp {


    public DataPicker() {

    }

    public static void HandlingDataPicker(){
        setup();
        driver.get("https://demoqa.com/date-picker");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        WebElement dataPickerContainer = driver.findElement(By.xpath("//*[@id=\"datePickerContainer\"]"));
        WebElement dataPickerMonthYearInput = driver.findElement(By.xpath(" //*[@id=\"datePickerMonthYearInput\" and @type=\"text\"]"));
        List<WebElement> dataPickerWeeks = driver.findElements(By.xpath("//*[@class=\"react-datepicker__month\" and @role=\"listbox\"]"));
        for (WebElement week : dataPickerWeeks) {
            String day = week.findElement(By.xpath("//*[@class=\"react-datepicker__week\"]/div[@role=\"option\"]")).getAttribute("innerText");
        }
        shutDown();
    }

}
