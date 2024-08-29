package serenity.demo.pagesObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadPage extends PageObject {


    @FindBy(xpath="//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]")
    WebElementFacade Button_Element;


   @FindBy(xpath="//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Upload and Download\")]")
    WebElementFacade Span_UploadAndDownload;


    @FindBy(xpath="//*[@id=\"app\"]/div/div/div/div[2]/div[2]")
    WebElementFacade Span;

    @FindBy(xpath="//*[@id=\"downloadButton\"]")
    WebElementFacade Button_Download;

    @FindBy(xpath="//*[@id=\"uploadFile\"]")
    WebElementFacade Button_Upload;




    public void UploadLandingPage()
    {
        evaluateJavascript("window.scrollBy(0,300)");
        Button_Element.click();
        Span_UploadAndDownload.click();
    }

    public void FileUploadAndDownload() throws InterruptedException {
    Path pathOfDownloadFolder = Paths.get(System.getProperty("user.home")+"\\Downloads");
        if (Files.exists(pathOfDownloadFolder) && Files.isDirectory(pathOfDownloadFolder)) {
        System.out.println("Directory Exist!!");
    } else {
        System.out.println("Directory does not exist!!!");
    }
    Span.getAttribute("innerText");
    evaluateJavascript("window.scrollBy(0,350)");
    Button_Download.click();
        Thread.sleep(3000);
       File currentFile = new File(System.getProperty("user.home")+"\\Downloads\\sampleFile.jpeg");
        if (currentFile.exists()) {
        System.out.println("File Exist!!");
    } else {
        System.out.println("File does not exist!!!");
    }
    Button_Upload.sendKeys(System.getProperty("user.home")+"\\Downloads\\sampleFile.jpeg");
    String filePath= find(By.xpath("//*[@id=\"uploadedFilePath\"]")).getAttribute("innerText");
        Assertions.assertEquals("C:\\fakepath\\sampleFile.jpeg", filePath);
}
}
