package serenitytest.testCases;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@RunWith(SerenityRunner.class)
public class UploadTest extends PageObject{

    @Managed(driver="chrome")
    WebDriver driver;


    @Title("Executing upload Test")
    @Test
    public void HandlingUploadAndDownload() throws InterruptedException {
        open();
        evaluateJavascript("window.scrollBy(0,300)");
        WebElementFacade Button_Element=find(By.xpath("//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]"));
        Button_Element.click();
        WebElementFacade Span_UploadAndDownload=find(By.xpath("//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Upload and Download\")]"));
        Span_UploadAndDownload.click();

        Path pathOfDownloadFolder = Paths.get(System.getProperty("user.home")+"\\Downloads");
        if (Files.exists(pathOfDownloadFolder) && Files.isDirectory(pathOfDownloadFolder)) {
            System.out.println("Directory Exist!!");
        } else {
            System.out.println("Directory does not exist!!!");
        }
        find(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]"));
        evaluateJavascript("window.scrollBy(0,350)");

        find(By.xpath("//*[@id=\"downloadButton\"]")).click();


        Thread.sleep(3000);
        // waitFor(String.valueOf(Duration.millis(1000)));
        File currentFile = new File(System.getProperty("user.home")+"\\Downloads\\sampleFile.jpeg");
        if (currentFile.exists()) {
            System.out.println("File Exist!!");
        } else {
            System.out.println("File does not exist!!!");
        }
        find(By.xpath("//*[@id=\"uploadFile\"]")).sendKeys(System.getProperty("user.home")+"\\Downloads\\sampleFile.jpeg");
        String filePath= find(By.xpath("//*[@id=\"uploadedFilePath\"]")).getAttribute("innerText");
        Assertions.assertEquals("C:\\fakepath\\sampleFile.jpeg", filePath);
    }
}

