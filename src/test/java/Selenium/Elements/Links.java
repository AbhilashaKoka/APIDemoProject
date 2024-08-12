package Selenium.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class Links {
    public static void main(String args[]) throws IOException {
        System.setProperty("Webdriver.driver.chrome", "D:\\Users\\akoka\\IdeaProjects\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://demoqa.com/links");
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
    }
}
