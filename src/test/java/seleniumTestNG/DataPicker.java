package seleniumTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import java.util.List;

public class DataPicker  extends BaseSetUp {




    public static Boolean HandlingDataPicker(){
        Boolean bol=false;
        WebElement Widgets_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]"));
        Widgets_Frames.click();
        WebElement DatePicker_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Date Picker\")]"));
        DatePicker_span.click();

        WebElement dataPickerContainer = driver.findElement(By.xpath("//*[@id=\"datePickerContainer\"]"));
        WebElement dataPickerMonthYearInput = driver.findElement(By.xpath(" //*[@id=\"datePickerMonthYearInput\" and @type=\"text\"]"));
        List<WebElement> dataPickerWeeks = driver.findElements(By.xpath("//*[@class=\"react-datepicker__month\" and @role=\"listbox\"]"));
        for (WebElement week : dataPickerWeeks) {
            String day = week.findElement(By.xpath("//*[@class=\"react-datepicker__week\"]/div[@role=\"option\"]")).getAttribute("innerText");
        }

        bol=true;
       return bol;
    }

}
