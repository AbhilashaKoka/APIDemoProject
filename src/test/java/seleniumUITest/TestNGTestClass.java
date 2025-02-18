package seleniumUITest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TestStatusListener.class)
public class TestNGTestClass extends BaseSetUp{

   @Test(description = "Verify textBox",enabled = true,priority = 1)
       public void TestButton() {
              Assert.assertEquals( SeleniumDemoTest.HandlingButton(), true);
        }

    @Test(description = "Verify CheckBox",enabled = false)
    public void TestCheckBox() {
      Assert.assertEquals(SeleniumDemoTest.HandlingCheckBox(),true);
    }

    @Test(description = "verify datapicker",enabled = false)
    public void TestDatePicker() {
        Assert.assertEquals( SeleniumDemoTest.HandlingDataPicker(),true);
   }

    @Test(description = "verify BrowserWindow",enabled = false)
     public void TestBrowserWindow() throws InterruptedException {
       Assert.assertEquals(SeleniumDemoTest.HandlingBrowserWindow(),true);
   }

    @Test(description = "verify AutoComplete",enabled = false)
    public void TestAutoComplete() {
        Assert.assertEquals( SeleniumDemoTest.HandlingAutoComplete(),true);
   }

    @Test(description = "verify Alert",enabled = false)
     public void TestAlert() {
        Assert.assertEquals( SeleniumDemoTest.HandlingAlert(),true);
   }

    @Test(description = "verify Accordion",enabled = false)
      public void TestAccordion() {
         Assert.assertEquals(SeleniumDemoTest.HandlingAccordion(),true);
   }

    @Test(description = "verify PracticeForm",enabled = true)
    public void TestPracticeForm() throws InterruptedException {
        Assert.assertEquals(SeleniumDemoTest.HandlingForm(),true);
    }
    @Test(description = "verify Frames",enabled = false)
    public void TestFrame() {
        Assert.assertEquals( SeleniumDemoTest.HandlingFrame(),true);
    }

    @Test(description = "verify Links",enabled = false)
    public void TestLink() {
        Assert.assertEquals(SeleniumDemoTest.HandlingLink(),true);
    }

    @Test(description = "verify Menu",enabled = false)
    public void TestMenu() {
        Assert.assertEquals( SeleniumDemoTest.HandlingMenu(),true);
    }


    @Test(description = "verify ModalDialog",enabled = false)
    public void TestModalDialog() throws InterruptedException {
        Assert.assertEquals(SeleniumDemoTest.HandlingModalDialog(),true);
    }

    @Test(description = "verify MultipleFrames",enabled = false)
    public void TestMultipleFrame(){
       Assert.assertEquals(SeleniumDemoTest.HandlingMultipleFrames(),true);

    }
    @Test(description = "verify ProgressBar",enabled = false)
    public void TestProgressBar()
    {
        Assert.assertEquals( SeleniumDemoTest.HandlingProgressBar(),true);
    }

    @Test(description = "verify RadioButton",enabled = false)
    public void TestRadioButton() {
        Assert.assertEquals(SeleniumDemoTest.HandlingRadioButton(),true);
    }

    @Test(description = "verify Resizable",enabled = false)
        public void TestResizable()
        {
            Assert.assertEquals(SeleniumDemoTest.HandlingResizable(),true);
        }


    @Test(description = "verify Selectable",enabled = false)
    public void TestSelectable()
    {
        Assert.assertEquals(SeleniumDemoTest.HandlingSelectable(),true);
    }

    @Test(description = "verify SelectMenu",enabled = false)
    public void TestSelectMenu()
    {
        Assert.assertEquals(SeleniumDemoTest.HandlingSelectMenu(),true);
    }


    @Test(description = "verify Slider",enabled = false)
    public void TestSlider()
    {
        Assert.assertEquals( SeleniumDemoTest.HandlingSlider(),true);
    }

    @Test(description = "verify Sortable",enabled = false)
    public void TestSortable(){
        Assert.assertEquals(SeleniumDemoTest.HandlingSortable(),true);
    }

    @Test(description = "verify Tabs",enabled = false)
    public void TestTabs(){
        Assert.assertEquals(SeleniumDemoTest.HandlingTabs(),true);
    }
    @Test(description = "verify TextBox",enabled = false)
    public void TestTextBox() throws InterruptedException {
        Assert.assertEquals(SeleniumDemoTest.HandlingTextBox(),true);
    }

    @Test(description = "verify ToolTips",enabled = false)
    public void TestToolTip()
    {
        Assert.assertEquals(SeleniumDemoTest.HandlingToolTip(),true);
    }

    @Test(description = "verify Upload",enabled = false)
    public void TestUpload() throws InterruptedException {
        Assert.assertEquals(SeleniumDemoTest.HandlingUploadAndDownload(),true);
    }

    @Test(description = "verify WebTable",enabled = false)
    public void TestWebTable()
    {
        Assert.assertEquals(SeleniumDemoTest.HandlingWebTableTest(),true);
    }

    @Test(description = "verify Draggable",enabled = false)
    public void TestDraggable()
    {
        Assert.assertEquals(SeleniumDemoTest.HandlingDraggable(),true);
    }

    @Test(description = "verify Droppable",enabled = false)
    public void TestDroppable()
    {
        Assert.assertEquals(SeleniumDemoTest.HandlingDroppable(),true);
    }
    }



