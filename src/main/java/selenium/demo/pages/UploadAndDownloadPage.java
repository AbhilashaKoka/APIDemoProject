package selenium.demo.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class UploadAndDownloadPage  {
WebDriver driver;


    @FindBy(how= How.XPATH,using="//*[@id=\"app\"]/div/div/div/div[2]/div[2]")
    private  WebElement title;
    @FindBy(how= How.XPATH,using="//*[@id=\"downloadButton\"]")
    private  WebElement DownloadButton;
    @FindBy(how= How.XPATH,using="//*[@id=\"uploadFile\"]")
    private  WebElement uploadButton;
    @FindBy(how= How.XPATH,using=" //*[@id=\"uploadedFilePath\"]")
    private WebElement FilePath;
    @FindBy(how = How.XPATH, using = "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]")
    private WebElement Element_frame;
    @FindBy(how = How.XPATH, using = "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Upload and Download\")]")
    private WebElement UploadDownload_Span;

    public UploadAndDownloadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean UploadAndDownloadlandingPage(){
        boolean bol=false;
        Element_frame.click();
        UploadDownload_Span.click();
        bol=true;
        return bol;
    }

    public  boolean HandlingUploadAndDownload() throws InterruptedException {
    boolean bol=false;

        Path pathOfDownloadFolder= Paths.get("D:\\Users\\akoka\\Downloads");

        if(Files.exists(pathOfDownloadFolder)&& Files.isDirectory(pathOfDownloadFolder)){
            System.out.println("Directory Exist!!");
        }
        else {
            System.out.println("Directory does not exist!!!");
        }

        DownloadButton.click();
        Thread.sleep(5000);
        File currentFile=new File("D:\\Users\\akoka\\Downloads\\sampleFile.jpeg");
        if(currentFile.exists()){
            System.out.println("File Exist!!");
        }
        else{
            System.out.println("File does not exist!!!");
            }

        uploadButton.sendKeys("D:\\Users\\akoka\\Downloads\\sampleFile.jpeg");
bol=true;
return bol;
      //  Assertions.assertEquals("C:\\fakepath\\sampleFile.jpeg",FilePath.getAttribute("innerText"));

   }
}
