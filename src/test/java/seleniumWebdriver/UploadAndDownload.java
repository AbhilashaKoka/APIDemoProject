package seleniumWebdriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class UploadAndDownload extends BaseSetUp {
    public UploadAndDownload(){

    }

    public static void HandlingUploadAndDownload() throws InterruptedException {
        setup();
        Actions action = new Actions(driver);
        driver.get("https://demoqa.com/upload-download");

        Path pathOfDownloadFolder=Paths.get("D:\\Users\\akoka\\Downloads");
        if(Files.exists(pathOfDownloadFolder)&& Files.isDirectory(pathOfDownloadFolder)){
            System.out.println("Directory Exist!!");
        }
        else {
            System.out.println("Directory does not exist!!!");
        }
        WebElement title=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,350)",title);

        WebElement DownloadButton=driver.findElement(By.xpath("//*[@id=\"downloadButton\"]"));
        DownloadButton.click();
        Thread.sleep(5000);
        File currentFile=new File("D:\\Users\\akoka\\Downloads\\sampleFile.jpeg");
        if(currentFile.exists()){
            System.out.println("File Exist!!");
           }
        else{
            System.out.println("File does not exist!!!");
            }

        WebElement uploadButton=driver.findElement(By.xpath("//*[@id=\"uploadFile\"]"));
        uploadButton.sendKeys("D:\\Users\\akoka\\Downloads\\sampleFile.jpeg");
        WebElement FilePath=driver.findElement(By.xpath(" //*[@id=\"uploadedFilePath\"]"));
        Assertions.assertEquals("C:\\fakepath\\sampleFile.jpeg",FilePath.getAttribute("innerText"));
     shutDown();
    }
}