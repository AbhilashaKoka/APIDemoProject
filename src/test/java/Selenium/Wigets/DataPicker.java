package Selenium.Wigets;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class DataPicker {

    static WebDriver driver;
    static Actions action;

    public static void main(String args[]) {
        System.setProperty("Webdriver.driver.chrome", "D:\\Users\\akoka\\IdeaProjects\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        action = new Actions(driver);
        driver.get("https://demoqa.com/date-picker");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        WebElement dataPickerContainer = driver.findElement(By.xpath("//*[@id=\"datePickerContainer\"]"));
        WebElement dataPickerMonthYearInput = driver.findElement(By.xpath(" //*[@id=\"datePickerMonthYearInput\" and @type=\"text\"]"));
        List<WebElement> dataPickerWeeks = driver.findElements(By.xpath("//*[@class=\"react-datepicker__month\" and @role=\"listbox\"]"));
        for (WebElement week : dataPickerWeeks) {
            String day = week.findElement(By.xpath("//*[@class=\"react-datepicker__week\"]/div[@role=\"option\"]")).getAttribute("innerText");
        }
    }


}
