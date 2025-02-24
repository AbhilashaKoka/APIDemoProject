package seleniumUITest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import seleniumUITest.manager.DriverManager;
import seleniumUITest.testDataClass.PracticeFormsDetails;

import java.awt.*;
import java.util.List;

import static org.openqa.selenium.Keys.*;


public class PracticeFormPage {

WebDriver driver;


    @FindBy(how = How.XPATH, using = "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Forms\")]")
    private WebElement Frame_forms;

    @FindBy(how = How.XPATH, using = "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Practice Form\")]")
    private WebElement Options_PracticeForms;

    @FindBy(how = How.XPATH, using = "//*[@class=\"practice-form-wrapper\"]")
    private WebElement Wrapper_PracticeForm;

    @FindBy(how = How.XPATH, using = "//*[@id=\"firstName\"]")
    private WebElement InputBox_FirstName;

    @FindBy(how = How.XPATH, using = "//*[@id=\"lastName\"]")
    private WebElement InputBox_LastName;

    @FindBy(how = How.XPATH, using = "//*[@id=\"userEmail\"]")
    private WebElement InputBox_Email;

    @FindBy(how = How.XPATH, using = "//*[@id=\"genterWrapper\"]/div[2]/div")
    private List<WebElement> Radio_div;

    @FindBy(how = How.XPATH, using = "//*[@id=\"genterWrapper\"]/div[2]/div/label")
    private List<WebElement> Radio_label;

    @FindBy(how = How.XPATH, using = "//*[@id=\"genterWrapper\"]/div[2]/div/input")
    private List<WebElement> Radio_input;

    @FindBy(how = How.XPATH, using = "//*[@id=\"genterWrapper\"]//following::label[contains(text(),\"Male\")]//preceding-sibling::input[@name=\"gender\"]")
    private WebElement RadioButton_Male;

    @FindBy(how = How.XPATH, using = "//*[@id=\"userNumber\"]")
    private WebElement Inputbox_Mobile;

    @FindBy(how = How.XPATH, using = "//*[@id=\"dateOfBirthInput\"]")
    private WebElement Inputbox_DateOfBirth;

    @FindBy(how = How.XPATH, using = "//div[@class=\"subjects-auto-complete__input\"]/input[@type=\"text\"]")
    private WebElement Inputbox_Subject;

    @FindBy(how = How.XPATH, using ="//*[@id=\"hobbiesWrapper\"]/div[2]/div")
    private List<WebElement> CheckBox_div;


    @FindBy(how = How.XPATH, using ="//div[@id=\"hobbiesWrapper\"]//label[contains(text(),\"Reading\")]//preceding-sibling::input")
    private WebElement CheckBox_Hobbies;

    @FindBy(how = How.XPATH, using ="//*[@id=\"uploadPicture\" and @type=\"file\"]")
    private WebElement Upload_Picture;

    @FindBy(how = How.XPATH, using ="//textArea[@id=\"currentAddress\"]")
    private WebElement TextArea_CurrentAdress;

    @FindBy(how = How.XPATH, using ="//input[@id=\"react-select-3-input\"]")
    private WebElement DropDown_States;

    @FindBy(how = How.XPATH, using ="//*[@id=\"react-select-4-input\"]")
    private WebElement DropDown_City;

    @FindBy(how = How.XPATH, using ="//*[@id=\"submit\"]")
    private WebElement submitButton;

    @FindBy(how = How.XPATH, using ="//*[@class=\"modal-dialog modal-lg\"]")
    private WebElement ModalBox;

    @FindBy(how = How.XPATH, using =" //*[@class=\"modal-dialog modal-lg\"]/div/div[3]/button[@type=\"button\"]")
    private WebElement Button_ModalBoxClose;

    @FindBy(how = How.XPATH, using ="//table[@class=\"table table-dark table-striped table-bordered table-hover\"]/tbody/tr")
    private List<WebElement> Table_Coloumn;

    @FindBy(how = How.XPATH, using ="//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Forms\")]")
    private WebElement Frame_formFrames;

    @FindBy(how = How.XPATH, using ="//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Practice Form\")]")
    private WebElement PracticeForms;

    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean PracticeFormLandingPage()
    {
        boolean bol=false;
        DriverManager.scrollWindowUp(Frame_formFrames);
        Frame_formFrames.click();
        PracticeForms.click();
        bol=true;
        return bol;
    }


    public boolean SubmitPracticeForm(PracticeFormsDetails practiceFormsDetails) throws AWTException {
        boolean bol=false;
        DriverManager.scrollWindowUp(InputBox_FirstName);
        InputBox_FirstName.sendKeys(practiceFormsDetails.getFirstName(), TAB);
        InputBox_LastName.sendKeys(practiceFormsDetails.getLastName(), TAB);
        InputBox_Email.sendKeys(practiceFormsDetails.getEmail(), TAB);

        for(WebElement ele:Radio_div){
          String gender= practiceFormsDetails.getGender();
            if( ele.findElement(By.xpath("child::label")).getText().equalsIgnoreCase(gender))
           {
               if(ele.findElement(By.xpath("child::input[@value='"+practiceFormsDetails.getGender()+"']")).isSelected())
               {
                   System.out.println("not able to click the label Radio Button");
               }
               else
               {
                   ele.findElement(By.xpath("//child::label[contains(text(), '"+practiceFormsDetails.getGender()+"')]")).click();
                   break;
               }
           }
        }

        DriverManager.scrollWindowUp(Inputbox_Mobile);
        Inputbox_Mobile.sendKeys(practiceFormsDetails.getMobile(), TAB);

        DriverManager.scrollWindowUp(Inputbox_DateOfBirth);
        Inputbox_DateOfBirth.sendKeys(practiceFormsDetails.getDOB(), TAB, ENTER, TAB);

        DriverManager.scrollWindowUp(Inputbox_Subject);
        Actions actions = new Actions(driver);
        actions.sendKeys(SHIFT).perform();
        actions.sendKeys(practiceFormsDetails.getSubject()).perform();
        actions.sendKeys(ENTER, TAB).perform();
        actions.build();



        for(WebElement ele: CheckBox_div) {
            String hobbies = practiceFormsDetails.getHobbies();
            if( ele.findElement(By.xpath("child::label")).getText().equalsIgnoreCase(hobbies))
            {
                   ele.findElement(By.xpath("//child::label[contains(text(), '"+practiceFormsDetails.getHobbies()+"')]")).click();
                    break;
            }
        }



        Upload_Picture.sendKeys(practiceFormsDetails.getFilePath());
        DriverManager.scrollWindowUp(TextArea_CurrentAdress);

        TextArea_CurrentAdress.sendKeys(practiceFormsDetails.getCurrentAddr(), TAB);
        DropDown_States.sendKeys(practiceFormsDetails.getState(), TAB, TAB);
        DropDown_City.sendKeys(practiceFormsDetails.getCity(), TAB, TAB);
        submitButton.submit();
        bol=true;
        return bol;
    }


    public boolean HandlingModalBox()
    {
        boolean bol=false;
        DriverManager.MoveToElement(ModalBox);
        for(WebElement rows:Table_Coloumn) {
            String str1 = rows.findElement(By.xpath("td[1]")).getAttribute("innerText");
            String str2 = rows.findElement(By.xpath("td[2]")).getAttribute("innerText");
            System.out.println(str1 + ":" + str2);
        }
        Button_ModalBoxClose.sendKeys(ESCAPE);
        bol=true;
        return bol;
    }
}
