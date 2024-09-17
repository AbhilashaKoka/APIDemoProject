package seleniumTestNG;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(seleniumTestNG.TestStatusListener.class)
public class TestClass extends BaseSetUp{

   @Test(description = "Verify textBox",enabled = false,priority = 1)
       public void TestButton() {
              Assert.assertEquals( SeleElemHandling.HandlingButton(), true);
        }
    @Test(description = "Verify CheckBox",enabled = false)
    public void TestCheckBox() {
      Assert.assertEquals(SeleElemHandling.HandlingCheckBox(),true);
    }
    @Test(description = "verify datapicker",enabled = false)
    public void TestDatePicker() {
        Assert.assertEquals( SeleElemHandling.HandlingDataPicker(),true);
   }

    @Test(description = "verify BrowserWindow",enabled = true)
     public void TestBrowserWindow() throws InterruptedException {
       Assert.assertEquals(SeleElemHandling.HandlingBrowserWindow(),true);
   }

    @Test(description = "verify AutoComplete",enabled = true)
    public void TestAutoComplete() {
        Assert.assertEquals( SeleElemHandling.HandlingAutomComplete(),true);
   }

    @Test(description = "verify Alert",enabled = false)
     public void TestAlert() {
        Assert.assertEquals( SeleElemHandling.HandlingAlert(),true);
   }

    @Test(description = "verify Accordion",enabled = false)
      public void TestAccordion() {
         Assert.assertEquals(SeleElemHandling.HandlingAccordion(),true);
   }

    @Test(description = "verify PracticeForm",enabled = false)
    public void TestPracticeForm() throws InterruptedException {
        Assert.assertEquals(SeleElemHandling.HandlingForm(),true);
    }

    @Test(description = "verify Frames",enabled = false)
    public void TestFrame() {
        Assert.assertEquals( SeleElemHandling.HandlingFrame(),true);
    }
    @Test(description = "verify Links",enabled = false)
    public void TestLink() {
        Assert.assertEquals(SeleElemHandling.HandlingLInk(),true);
    }

    @Test(description = "verify Menu",enabled = false)
    public void TestMenu() {
        Assert.assertEquals( SeleElemHandling.HandlingMenu(),true);
    }
    @Test(description = "verify ModalDialog",enabled = false)
    public void TestModalDialog() throws InterruptedException {
        Assert.assertEquals(SeleElemHandling.HandlingModalDialog(),true);
    }

    @Test(description = "verify MultipleFrames",enabled = false)
    public void TestMultipleFrame(){
       Assert.assertEquals(SeleElemHandling.HandlingMultipleFrames(),true);

    }
    @Test(description = "verify ProgressBar",enabled = false)
    public void TestProgressBar()
    {
        Assert.assertEquals( SeleElemHandling.HandlingProgressBar(),true);
    }

    @Test(description = "verify RadioButton",enabled = false)
    public void TestRadioButton() {
        Assert.assertEquals(SeleElemHandling.HandlingRadioBUtton(),true);
    }
    @Test(description = "verify Resizable",enabled = false)
        public void TestResizable()
        {
            Assert.assertEquals(SeleElemHandling.HandlingResizable(),true);
        }


    @Test(description = "verify Selectable",enabled = false)
    public void TestSelectable()
    {
        Assert.assertEquals(SeleElemHandling.HandlingSelectable(),true);
    }
    @Test(description = "verify SelectMenu",enabled = false)
    public void TestSelectMenu()
    {
        Assert.assertEquals(SeleElemHandling.HandlingSelectMenu(),true);
    }


    @Test(description = "verify Slider",enabled = false)
    public void TestSlider()
    {
        Assert.assertEquals( SeleElemHandling.HandlingSlider(),true);
    }

    @Test(description = "verify Sortable",enabled = false)
    public void TestSortable(){
        Assert.assertEquals(SeleElemHandling.HandlingSortable(),true);
    }

    @Test(description = "verify Tabs",enabled = false)
    public void TestTabs(){
        Assert.assertEquals(SeleElemHandling.HandlingTabs(),true);
    }
    @Test(description = "verify TextBox",enabled = false)
    public void TestTextBox() throws InterruptedException {
        Assert.assertEquals(SeleElemHandling.HandlingTextBox(),true);
    }

    @Test(description = "verify ToolTips",enabled = false)
    public void TestToolTip()
    {
        Assert.assertEquals(SeleElemHandling.HandlingToolTip(),true);
    }

    @Test(description = "verify Upload",enabled = false)
    public void TestUpload() throws InterruptedException {
        Assert.assertEquals(SeleElemHandling.HandlingUploadAndDownload(),true);
    }

    @Test(description = "verify WebTable",enabled = false)
    public void TestWebTable()
    {
        Assert.assertEquals(SeleElemHandling.HandlingWebTableTest(),true);
    }

    @Test(description = "verify Draggable",enabled = false)
    public void TestDraggable()
    {
        Assert.assertEquals(SeleElemHandling.HandlingDraggable(),true);
    }

    @Test(description = "verify Droppable",enabled = false)
    public void TestDroppable()
    {
        Assert.assertEquals(SeleElemHandling.HandlingDroppable(),true);
    }
    }



