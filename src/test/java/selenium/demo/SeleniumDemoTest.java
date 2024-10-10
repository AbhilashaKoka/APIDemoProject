package selenium.demo;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SeleniumDemoTest extends BaseSetUp {



    public static Boolean HandlingAccordion(){
        Boolean bol=false;
        WebElement Widgets_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]"));
        Widgets_Frames.click();

        WebElement Accordian_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Accordian\")]"));
        Accordian_span.click();

        WebElement accordianContainer=driver.findElement(By.xpath(" //*[@id=\"accordianContainer\"]"));
        System.out.println(accordianContainer.getAttribute("innerText"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");

        List<WebElement> accordiansLIst=driver.findElements(By.xpath(" //div[@id=\"accordianContainer\"]//following::div[@class=\"accordion\"]"));
        int size=accordiansLIst.size();

        for(WebElement ele:accordiansLIst){
            action.moveToElement(ele).perform();
            action.moveToElement(ele.findElement(By.xpath("//*[@class=\"card-header\"]"))).clickAndHold().perform();
            WebElement accordianBody=driver.findElement(By.xpath("//*[@id=\"section1Heading\"]/following::div[starts-with(@class,'collapse')]"));
            action.moveToElement(accordianBody.findElement(By.xpath("//*[@class=\"card-body\" and @id=\"section1Content\"]/p"))).perform();
            action.build();
           System.out.println(driver.findElement(By.xpath("//*[@class=\"card-body\" and @id=\"section1Content\"]/p")).getAttribute("class"));
//            System.out.println(driver.findElement(By.xpath("//*[@class=\"card-body\" and @id=\"section1Content\"]/p")).getAttribute("autocomplete"));
//            System.out.println(driver.findElement(By.xpath("//*[@class=\"card-body\" and @id=\"section1Content\"]/p")).getAttribute("nonExistingAttribute"));

          }
        bol=true;
       return bol;
    }



    public static Boolean HandlingAlert(){
        Boolean bol=false;
        WebElement Window_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Alerts, Frame & Windows\")]"));
        Window_Frames.click();

        WebElement Alerts_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Alerts\")]"));
        Alerts_span.click();

        WebElement AlertWrapper=driver.findElement(By.xpath("//*[@id=\"javascriptAlertsWrapper\"]"));
        System.out.println(AlertWrapper.getAttribute("innerText"));

        WebElement alertButton=driver.findElement(By.xpath("//button[@id=\"alertButton\"]"));
        alertButton.click();

        driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        WebElement timeralertbutton=driver.findElement(By.xpath("//button[@id=\"timerAlertButton\"]"));
        timeralertbutton.click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5000));
        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();
        WebElement confirmButton=driver.findElement(By.xpath("//button[@id=\"confirmButton\"]"));
        confirmButton.click();
        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();
        WebElement promptButton=driver.findElement(By.xpath("//button[@id=\"promtButton\"]"));
        promptButton.click();
        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();
        bol=true;
        return  bol;
    }
    public static Boolean HandlingAutomComplete(){
        Boolean bol=false;
        WebElement Widgets_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]"));
        Widgets_Frames.click();
        WebElement Accordian_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Auto Complete\")]"));
        Accordian_span.click();

        WebElement firstPlaceholder=driver.findElement(By.xpath("//div[@class=\"auto-complete__input\"]//input[@id=\"autoCompleteMultipleInput\" and @type=\"text\"]"));
        firstPlaceholder.sendKeys("Green");

        firstPlaceholder.sendKeys(Keys.TAB);
        firstPlaceholder.sendKeys(Keys.TAB);

        WebElement secondPlaceHolder=driver.findElement(By.xpath("//*[@class=\"css-1g6gooi\"]/div[@class=\"auto-complete__input\"]/input[@id=\"autoCompleteMultipleInput\" and @type =\"text\"]"));
        secondPlaceHolder.sendKeys("Green");
        // secondPlaceHolder.sendKeys(Keys.TAB);
        bol=true;
        return bol;

    }

    public static Boolean HandlingBrowserWindow() throws InterruptedException {
        Boolean bol=false;
        WebElement Window_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Alerts, Frame & Windows\")]"));
        Window_Frames.click();

        WebElement BrowserWindows_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Browser Windows\")]"));
        BrowserWindows_span.click();

        WebElement BrowserWindow=driver.findElement(By.xpath("//*[@id=\"browserWindows\"]"));
        System.out.println(BrowserWindow.getAttribute("innerText"));

        WebElement tabButton=driver.findElement(By.xpath("//*[@id=\"tabButton\"]"));
        String parentWindow= driver.getWindowHandle();

        System.out.println("Parent Tab");
        tabButton.click();
        ArrayList<String> handles=new ArrayList<>(driver.getWindowHandles());
        // driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().window(handles.get(1));
        System.out.println("New Tab");
        driver.get("https://www.google.com");
        driver.switchTo().window(parentWindow);
        System.out.println("Parent Tab");
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");

        WebElement tabButton2=driver.findElement(By.xpath("//*[@id=\"tabButton\"]"));
        tabButton2.click();
        Object[] windowsHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowsHandles[1]);
        driver.switchTo().window((String) windowsHandles[0]);



        WebElement windowButton=driver.findElement(By.xpath("//*[@id=\"windowButton\"]"));
        String parentWindow3= driver.getWindowHandle();
        windowButton.click();
        driver.switchTo().newWindow(WindowType.WINDOW);
        System.out.println("Child Window");
        driver.get("http://www.google.com");
        driver.switchTo().window(parentWindow3);
        System.out.println("Parent Window");
        Thread.sleep(1000);


        WebElement messageWindowButton=driver.findElement(By.xpath("//*[@id=\"messageWindowButton\"]"));
        String parentWindow1= driver.getWindowHandle();
        messageWindowButton.click();
        Set<String> handles1=driver.getWindowHandles();
        Iterator<String> it1=handles1.iterator();
        if(it1.next()!=parentWindow1)
        {
            String childwindow1= it1.next();
            //name, handle, ID
            driver.switchTo().window(childwindow1);
            Dimension size=driver.manage().window().getSize();
            int widthOfWindow=size.getWidth();
            int HeightOfWindow=size.getHeight();

            System.out.println("Child Window width"+widthOfWindow);
            System.out.println("Child Window Height"+HeightOfWindow);

            Point position=driver.manage().window().getPosition();
            int x1=position.getX();
            int y1=position.getY();

            System.out.println("Child Window position of x coordinate "+widthOfWindow);
            System.out.println("Child Window position of y coordinate"+HeightOfWindow);

//            driver.manage().window().setPosition(new Point(20,30));
//            driver.manage().window().maximize();
//            driver.manage().window().minimize();
//            driver.manage().window().fullscreen();

        }
        bol=true;
        return bol;
    }


    public static Boolean HandlingButton(){
        Boolean bol=false;
        WebElement Elements_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]"));
        Elements_Frames.click();
        WebElement Button_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Buttons\")]"));
        Button_span.click();

        WebElement title = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/h1[contains(text(), \"Buttons\")]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", title);
        String titleOfPage = title.getText();
        Assertions.assertEquals("Buttons", titleOfPage);
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[@id=\"doubleClickBtn\"]"));
        if (doubleClickButton.isEnabled()) {
            action.moveToElement(doubleClickButton);
            action.doubleClick().build().perform();

        }
        WebElement outputForDoubleClick = driver.findElement(By.xpath("//*[@id=\"doubleClickMessage\"]"));
        String text = outputForDoubleClick.getAttribute("innerText");
        Assertions.assertEquals("You have done a double click", text);
        WebElement RightClickButton = driver.findElement(By.xpath("//button[@id=\"rightClickBtn\"]"));
        if (doubleClickButton.isEnabled()) {
            action.moveToElement(RightClickButton);
            action.contextClick().build().perform();

        }
        WebElement outputForRightClick = driver.findElement(By.xpath(" //*[@id=\"rightClickMessage\"]"));
        String text2 = outputForRightClick.getAttribute("innerText");
        Assertions.assertEquals("You have done a right click", text2);

        WebElement ClickMeButton = driver.findElement(By.xpath("//button[@id=\"rightClickBtn\"]//following::button"));
        if (ClickMeButton.isDisplayed()) {
            ClickMeButton.click();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id=\"rightClickBtn\"]//following::button")));
        if (ClickMeButton.isEnabled()) {
            action.moveToElement(ClickMeButton);
            action.click().build().perform();

        }
        WebElement outputForClick = driver.findElement(By.xpath(" //*[@id=\"dynamicClickMessage\"]"));
        String text3 = outputForClick.getAttribute("innerText");
        Assertions.assertEquals("You have done a dynamic click", text3);
        bol=true;
        return bol;
    }


    public static Boolean HandlingCheckBox(){
        Boolean bol=false;
        WebElement Elements_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]"));
        Elements_Frames.click();
        WebElement CheckBox_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Check Box\")]"));
        CheckBox_span.click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("  button[title=\"Toggle\"]")));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("location.reload()");
        WebElement sort= driver.findElement(By.cssSelector("  button[title=\"Toggle\"]"));
        // js.executeScript("arguments[0].scrollIntoView;",sort);
        js.executeScript("window.scrollBy(0,250)",sort);
        sort.click();
        List<WebElement> chkboxes=driver.findElements(By.cssSelector("input[type='checkbox']"));
        int size=chkboxes.size();
        System.out.println(size);

        WebElement sortDesktop=driver.findElement(By.xpath("//span[@class=\"rct-title\"][ contains(text(),\"Desktop\")]//following::button[1][@title=\"Toggle\"]"));
        sortDesktop.click();
        List<WebElement> chkboxes2=driver.findElements(By.cssSelector("input[type='checkbox']"));
        int size2=chkboxes2.size();
        System.out.println(size2);
        WebElement sortDesktop2=driver.findElement(By.xpath("//span[@class=\"rct-title\"][ contains(text(),\"WorkSpace\")]//following::button[1][@title=\"Toggle\"]"));
        WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(60));
        wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector(" button[title=\"Toggle\"]")));

        sortDesktop2.click();
        WebElement sortDesktop3=driver.findElement(By.xpath("//span[@class=\"rct-title\"][ contains(text(),\"React\")]//following::button[1][@title=\"Toggle\"]"));
        sortDesktop3.click();
        bol=true;
        return bol;

    }
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

    public static Boolean HandlingDraggable(){
        Boolean bol=false;
        WebElement Interactions_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Interactions\")]"));
        Interactions_Frames.click();
        WebElement Dragabble_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Dragabble\")]"));
        Dragabble_span.click();
        bol=true;
        return bol;


    }

    public static Boolean HandlingDroppable(){
        Boolean bol=false;
        WebElement Interactions_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Interactions\")]"));
        Interactions_Frames.click();
        WebElement Droppable_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Droppable\")]"));
        Droppable_span.click();
        bol=true;
        return bol;
    }

    public static Boolean HandlingForm() throws InterruptedException {
        Boolean bol=false;
        WebElement Forms_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Forms\")]"));
        Forms_Frames.click();
        WebElement PracticeForm_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Practice Form\")]"));
        PracticeForm_span.click();

        WebElement PracticeForm = driver.findElement(By.xpath("//*[@class=\"practice-form-wrapper\"]"));
        js.executeScript("window.scrollBy(0,350)", PracticeForm);
        WebElement InputBox_FirstName = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        InputBox_FirstName.sendKeys("XYZ", Keys.TAB);
        WebElement InputBox_LastName = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        InputBox_LastName.sendKeys("ABC", Keys.TAB);
        WebElement Email = driver.findElement(By.xpath("//*[@id=\"userEmail\"]"));
        Email.sendKeys("XYZ@gmail.com", Keys.TAB);
        WebElement RadioButton_Male = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]//following::label[contains(text(),\"Male\")]//preceding-sibling::input[@name=\"gender\"]"));
        if (!RadioButton_Male.isSelected())
        {
            action.moveToElement(RadioButton_Male).click().perform();
            RadioButton_Male.sendKeys(Keys.TAB);
        }
        WebElement Mobile = driver.findElement(By.xpath("//*[@id=\"userNumber\"]"));
        Mobile.sendKeys("90249234234", Keys.TAB);
        WebElement DateOfBirth = driver.findElement(By.xpath("//*[@id=\"dateOfBirthInput\"]"));
        DateOfBirth.sendKeys("25 JAN 2024",Keys.TAB,Keys.ENTER,Keys.TAB);
        Thread.sleep(5000);
        WebElement Subject = driver.findElement(By.xpath("//div[@class=\"subjects-auto-complete__input\"]/input[@type=\"text\"]"));
        Subject.sendKeys("Computer Science");
        Subject.sendKeys(Keys.TAB,Keys.TAB);
        js.executeScript("window.scrollBy(0,350)");
        Thread.sleep(8000);
        WebElement  CheckBox_Hobbies=driver.findElement(By.xpath("//div[@id=\"hobbiesWrapper\"]//label[contains(text(),\"Reading\")]//preceding-sibling::input"));
        if (!CheckBox_Hobbies.isSelected()) {
            action.moveToElement(CheckBox_Hobbies).click().perform();
            CheckBox_Hobbies.sendKeys(Keys.TAB,Keys.TAB);
        }
        js.executeScript("window.scrollBy(0,350)");
        WebElement  Upload_Picture=driver.findElement(By.xpath("//*[@id=\"uploadPicture\" and @type=\"file\"]"));
        Upload_Picture.sendKeys("D:\\Users\\akoka\\Downloads\\sampleFile.jpeg");
        js.executeScript("window.scrollBy(0,350)");
        WebElement  TextArea_CurrentAdress=driver.findElement(By.xpath("//textArea[@id=\"currentAddress\"]"));
        TextArea_CurrentAdress.sendKeys("adafafdhdlhdgl");
        TextArea_CurrentAdress.sendKeys(Keys.TAB);
        js.executeScript("window.scrollBy(0,350)");
        Thread.sleep(5000);
        WebElement  DropDown_States= driver.findElement(By.xpath("//input[@id=\"react-select-3-input\"]"));
        DropDown_States.sendKeys("Uttar Pradesh");
        DropDown_States.sendKeys(Keys.TAB);
        WebElement  DropDown_City= driver.findElement(By.xpath("//*[@id=\"react-select-4-input\"]"));
        DropDown_City.sendKeys("Lucknow");
        DropDown_City.sendKeys(Keys.TAB);
        WebElement submitButton=driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        submitButton.click();
        WebElement modalBox=driver.findElement(By.xpath("//*[@class=\"modal-dialog modal-lg\"]"));
        WebElement modalCloseButton=driver.findElement(By.xpath(" //*[@class=\"modal-dialog modal-lg\"]/div/div[3]/button[@type=\"button\"]"));
        action.moveToElement(modalBox).perform();
        List<WebElement> coloumn=driver.findElements(By.xpath("//table[@class=\"table table-dark table-striped table-bordered table-hover\"]/tbody/tr"));
        for(WebElement rows:coloumn) {
            String str1 = rows.findElement(By.xpath("td[1]")).getAttribute("innerText");
            String str2 = rows.findElement(By.xpath("td[2]")).getAttribute("innerText");
            System.out.println(str1 + ":" + str2);
        }
        action.moveToElement(modalCloseButton).click().perform();
        modalCloseButton.sendKeys(Keys.ESCAPE);
        js.executeScript("window.scrollBy(0,-350)");

        bol=true;
        return bol;

    }
    public static Boolean HandlingFrame(){
        Boolean bol=false;
        WebElement Window_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Alerts, Frame & Windows\")]"));
        Window_Frames.click();
        WebElement Frames_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Frames\")]"));
        Frames_span.click();

        WebElement iframes=driver.findElement(By.xpath("//*[@id=\"framesWrapper\"]"));
        System.out.println(iframes.getAttribute("innerText"));
        WebElement iframes1=driver.findElement(By.xpath("//*[@id=\"frame1Wrapper\"]//iframe"));
        driver.switchTo().frame("frame1");
        WebElement framesHeading=driver.findElement(By.xpath("//*[@id=\"sampleHeading\"]"));
        System.out.println(framesHeading.getText());
        driver.switchTo().defaultContent();
        WebElement iframes2=driver.findElement(By.xpath("//*[@id=\"frame2Wrapper\"]//iframe"));
        driver.switchTo().frame("frame2");
        System.out.println(iframes2.getAttribute("innerText"));
        driver.switchTo().defaultContent();
        bol=true;
        return bol;

    }

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

    public static Boolean HandlingMenu(){
        Boolean bol=false;
        WebElement Widgets_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]"));
        Widgets_Frames.click();
        WebElement menu_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Menu\")]"));
        menu_span.click();
        bol=true;
        return bol;


    }
    public static Boolean HandlingModalDialog() throws InterruptedException {
        Boolean bol=false;
        WebElement Window_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Alerts, Frame & Windows\")]"));
        Window_Frames.click();
        WebElement ModalDialogs_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Modal Dialogs\")]"));
        ModalDialogs_span.click();
        driver.get("https://demoqa.com/modal-dialogs");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");

        WebElement modalWrapper=driver.findElement(By.xpath("//*[@id=\"modalWrapper\"]"));
        System.out.println(modalWrapper.getAttribute("innerText"));

        WebElement smallButton=driver.findElement(By.xpath("//button[@id=\"showSmallModal\"] "));
        smallButton.click();
        WebElement modalBox=driver.findElement(By.xpath("//*[@class=\"modal-dialog modal-sm\"]"));
        WebElement closeButton=driver.findElement(By.xpath("//*[@id=\"closeSmallModal\"]"));
        action.moveToElement(modalBox).perform();
        action.moveToElement(closeButton).click().perform();

        Thread.sleep(3000);
        WebElement largeButton=driver.findElement(By.xpath("//*[@id=\"showLargeModal\"]"));
        largeButton.click();
        js.executeScript("window.scrollBy(0,400)");
        WebElement modalBox1=driver.findElement(By.xpath("//*[@class=\"modal-dialog modal-lg\"]"));
        WebElement closeButton1=driver.findElement(By.xpath("//*[@id=\"closeLargeModal\"]"));
        action.moveToElement(modalBox1).perform();
        action.moveToElement(closeButton1).click().perform();
        bol=true;
        return bol;

    }

    public static Boolean HandlingMultipleFrames(){
        Boolean bol=false;
        WebElement Window_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Alerts, Frame & Windows\")]"));
        Window_Frames.click();
        WebElement NestedFrames_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Nested Frames\")]"));
        NestedFrames_span.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
        WebElement frame1=driver.findElement(By.xpath("//*[@id=\"framesWrapper\"]//following-sibling::div[@id=\"frame1Wrapper\"]/iframe[@id=\"frame1\"]"));
        driver.switchTo().frame(frame1);
        WebElement frame1Element=driver.findElement(By.tagName("body"));
        String frame1Text=frame1Element.getText();
        System.out.println("Frame1 is :"+frame1Text);


        int countFrameInFrame1=driver.findElements(By.tagName("iframe")).size();
        driver.switchTo().frame(0);

        WebElement frame2=driver.findElement(By.xpath("//p"));
        System.out.println(frame2.getAttribute("innerText"));
        System.out.println("Number of frame:"+countFrameInFrame1);

        int countIframeINframe2=driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of frame:"+countIframeINframe2);
        bol=true;
        return bol;

    }

    public static Boolean HandlingProgressBar() {
        Boolean bol=false;
        WebElement Widgets_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]"));
        Widgets_Frames.click();
        WebElement ProgressBar_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Progress Bar\")]"));
        ProgressBar_span.click();
        bol=true;
        return  bol;

    }


    public static Boolean HandlingRadioBUtton(){
        Boolean bol=false;
        WebElement Elements_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]"));
        Elements_Frames.click();
        WebElement RadioButton_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Radio Button\")]"));
        RadioButton_span.click();
        driver.get("https://demoqa.com/radio-button");
        WebElement elem=driver.findElement(By.xpath("//label[@for=\"yesRadio\"]//preceding::input[@type=\"radio\"]"));
        if(!elem.isSelected()){

            elem.click();
        }
        bol=true;
        return  bol;
    }
    public static Boolean HandlingResizable(){
        Boolean bol=false;
        WebElement Interactions_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Interactions\")]"));
        Interactions_Frames.click();
        WebElement Resizable_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Resizable\")]"));
        Resizable_span.click();
        bol=true;
        return  bol;
    }
    public static Boolean HandlingSelectable(){
        Boolean bol=false;
        WebElement Interactions_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Interactions\")]"));
        Interactions_Frames.click();
        WebElement Selectable_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Selectable\")]"));
        Selectable_span.click();
        bol=true;
        return bol;

    }

    public static Boolean HandlingSelectMenu() {
        Boolean bol=false;
        WebElement Widgets_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]"));
        Widgets_Frames.click();
        WebElement SelectMenu_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Select Menu\")]"));
        SelectMenu_span.click();
        bol=true;
        return bol;

    }

    public static Boolean HandlingSlider() {
        Boolean bol=false;
        WebElement Widgets_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]"));
        Widgets_Frames.click();
        WebElement Slider_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Slider\")]"));
        Slider_span.click();

        bol=true;
        return  bol;

    }

    public static Boolean  HandlingSortable() {
        Boolean bol=false;
        WebElement Interactions_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Interactions\")]"));
        Interactions_Frames.click();
        WebElement Sortable_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Sortable\")]"));
        Sortable_span.click();
        bol=true;
        return bol;

    }


    public static Boolean  HandlingTabs() {
        Boolean bol=false;
        WebElement Widgets_Frames=driver.findElement(By.xpath( "//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]"));
        Widgets_Frames.click();
        WebElement Tab_span=driver.findElement(By.xpath( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Tabs\")]"));
        bol=true;
        return bol;
    }


    public static Boolean HandlingTextBox() throws InterruptedException {
        Boolean bol=false;
        WebElement Element_Frames= driver.findElement(By.xpath("//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]"));
        Element_Frames.click();
        WebElement TextBox_Span=driver.findElement(By.xpath("//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Text Box\")]"));
        TextBox_Span.click();
        String sText=js.executeScript("return document.title;").toString();
        WebElement element= driver.findElement(By.xpath("//*[contains(text(),\"Text Box\")]"));
        String sText1=js.executeScript("return document.title;").toString();
        System.out.println(sText1);
        String sText2=js.executeScript("return document.domain;").toString();
        System.out.println(sText2);
        String sText3=js.executeScript("return document.URL;").toString();
        System.out.println(sText3);
        js.executeScript("arguments[0].scrollIntoView;",element);
        js.executeScript("location.reload()");
        js.executeScript("document.getElementById('userName').value='sita';");
        js.executeScript("document.getElementById('userEmail').value='sita@gmail.com';");
        js.executeScript("document.getElementById('currentAddress').value='sita@gmail.com';");
        js.executeScript("document.getElementById('permanentAddress').value='sita@gmail.com';");
        js.executeScript("document.getElementById('submit').click();");
        List<WebElement> ele3=driver.findElements(By.xpath("//*[@id=\"output\"]//p"));
        if(ele3.size()!=0){
            System.out.println(ele3.size()+"Element found as tag name as input \n");
            for(WebElement inputele:ele3)
            {
                System.out.println(inputele.getText());
            }
        }
        //  System.out.println(name.toString());
        Thread.sleep(1000);
        bol=true;
        return bol;
    }

    public static Boolean HandlingToolTip() {
        Boolean bol=false;
        WebElement Widgets_Frames = driver.findElement(By.xpath("//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Widgets\")]"));
        Widgets_Frames.click();
        WebElement ToolTips_Span = driver.findElement(By.xpath("//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Tool Tips\")]"));
        ToolTips_Span.click();
        bol=true;
        return bol;
    }


    public static Boolean HandlingUploadAndDownload() throws InterruptedException {
        Boolean bol=false;
        WebElement Element_Frames= driver.findElement(By.xpath("//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]"));
        Element_Frames.click();
        WebElement UploadAndDownload_Span=driver.findElement(By.xpath("//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Upload and Download\")]"));
        UploadAndDownload_Span.click();


        Path pathOfDownloadFolder= Paths.get("D:\\Users\\akoka\\Downloads");
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
        bol=true;
        return bol;
    }

    public static Boolean HandlingWebTableTest(){
        Boolean bol=false;
        WebElement Element_Frames= driver.findElement(By.xpath("//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]"));
        Element_Frames.click();
        WebElement WebTables_Span=driver.findElement(By.xpath("//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Web Tables\")]"));
        WebTables_Span.click();

        WebElement searchButton=driver.findElement(By.xpath("//input[@id=\"searchBox\"]"));
        searchButton.sendKeys("Kierra", Keys.ENTER);
//        WebElement AddButton=driver.findElement(By.xpath("//Button[@id=\"addNewRecordButton\"]"));
//        WebElement EditButton=driver.findElement(By.xpath("//span[@id=\"edit-record-1\"]"));
//        WebElement DeleteButton=driver.findElement(By.xpath("//span[@id=\"delete-record-1\"]"));
//        WebElement table=driver.findElement(By.xpath(" //div[@class='rt-table']"));
//        WebElement tableHeader=driver.findElement(By.xpath(" //div[@class='rt-thead -header']"));
//        WebElement tableBody=driver.findElement(By.xpath(" //div[@class='rt-tbody']"));

        List<WebElement> RowGroup=driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        int sizeofRows=RowGroup.size();
        List<WebElement> tablerow=driver.findElements(By.xpath(" //div[@class='rt-td']"));
        int sizeofRows1=tablerow.size();
        for(WebElement row:tablerow)
        {
            row.findElement(By.xpath("//div[@class=\"action-buttons\"]//span[@title=\"Edit\"]")).click();
            //  WebElement  RegistrationWindow=driver.findElement(By.xpath("\"//div[@class=\"modal-content\"]\""));
            // WebElement RegistrationTitle= driver.findElement(By.xpath("registration-form-modal"));
            driver.switchTo().activeElement();
//          Actions action=new Actions(driver);
//          action.moveToElement(RegistrationWindow).release().build();
            //    System.out.println(RegistrationTitle.getAttribute("innerText"));

        }
        bol=true;
        return bol;
    }
}
