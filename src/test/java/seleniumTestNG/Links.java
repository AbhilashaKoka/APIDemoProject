package seleniumTestNG;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;

import java.net.URL;
import java.util.List;


public class Links  extends BaseSetUp {


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
