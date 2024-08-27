package seleniumTestNG;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(seleniumTestNG.TestStatusListener.class)
public class TestClass extends BaseSetUp{

   @Test(description = "Verify textBox",enabled = false,priority = 1)
       public void TestButton() {
              Assert.assertEquals( Button.HandlingButton(), true);
        }
    @Test(description = "Verify CheckBox",enabled = false)
    public void TestCheckBox() {
      Assert.assertEquals(CheckBox.HandlingCheckBox(),true);
    }
    @Test(description = "verify datapicker",enabled = false)
    public void TestDatePicker() {
        Assert.assertEquals( DataPicker.HandlingDataPicker(),true);
   }
    @Test(description = "verify BrowserWindow",enabled = true)
     public void TestBrowserWindow() throws InterruptedException {
       Assert.assertEquals(BrowserWindow.HandlingBrowserWindow(),true);
   }
    @Test(description = "verify AutoComplete",enabled = false)
    public void TestAutoComplete() {
        Assert.assertEquals( AutoComplete.HandlingAutomComplete(),true);
   }
    @Test(description = "verify Alert",enabled = false)
     public void TestAlert() {
        Assert.assertEquals( AlertsHandling.HandlingAlert(),true);
   }
    @Test(description = "verify Accordion",enabled = false)
      public void TestAccordion() {
         Assert.assertEquals(AccordionHandling.HandlingAccordion(),true);
   }

    @Test(description = "verify PracticeForm",enabled = false)
    public void TestPracticeForm() throws InterruptedException {
        Assert.assertEquals(Forms.HandlingForm(),true);
    }

    @Test(description = "verify Frames",enabled = false)
    public void TestFrame() {
        Assert.assertEquals( FramesHandling.HandlingFrame(),true);
    }
    @Test(description = "verify Links",enabled = false)
    public void TestLink() {
        Assert.assertEquals(Links.HandlingLInk(),true);
    }

    @Test(description = "verify Menu",enabled = false)
    public void TestMenu() {
        Assert.assertEquals( Menu.HandlingMenu(),true);
    }
    @Test(description = "verify ModalDialog",enabled = false)
    public void TestModalDialog() throws InterruptedException {
        Assert.assertEquals(ModalDialogHandling.HandlingModalDialog(),true);
    }

    @Test(description = "verify MultipleFrames",enabled = false)
    public void TestMultipleFrame(){
       Assert.assertEquals(MultipleFrameHandling.HandlingMultipleFrames(),true);

    }
    @Test(description = "verify ProgressBar",enabled = false)
    public void TestProgressBar()
    {
        Assert.assertEquals( ProgressBar.HandlingProgressBar(),true);
    }

    @Test(description = "verify RadioButton",enabled = false)
    public void TestRadioButton() {
        Assert.assertEquals(RadioButton.HandlingRadioBUtton(),true);
    }
    @Test(description = "verify Resizable",enabled = false)
        public void TestResizable()
        {
            Assert.assertEquals(Resizable.HandlingResizable(),true);
        }


    @Test(description = "verify Selectable",enabled = false)
    public void TestSelectable()
    {
        Assert.assertEquals(Selectable.HandlingSelectable(),true);
    }
    @Test(description = "verify SelectMenu",enabled = false)
    public void TestSelectMenu()
    {
        Assert.assertEquals(SelectMenu.HandlingSelectMenu(),true);
    }


    @Test(description = "verify Slider",enabled = false)
    public void TestSlider()
    {
        Assert.assertEquals( Slider.HandlingSlider(),true);
    }

    @Test(description = "verify Sortable",enabled = false)
    public void TestSortable(){
        Assert.assertEquals(Sortable.HandlingSortable(),true);
    }

    @Test(description = "verify Tabs",enabled = false)
    public void TestTabs(){
        Assert.assertEquals(Tabs.HandlingTabs(),true);
    }
    @Test(description = "verify TextBox",enabled = false)
    public void TestTextBox() throws InterruptedException {
        Assert.assertEquals(TextBox.HandlingTextBox(),true);
    }

    @Test(description = "verify ToolTips",enabled = false)
    public void TestToolTip()
    {
        Assert.assertEquals(ToolTips.HandlingToolTip(),true);
    }

    @Test(description = "verify Upload",enabled = false)
    public void TestUpload() throws InterruptedException {
        Assert.assertEquals(UploadAndDownload.HandlingUploadAndDownload(),true);
    }

    @Test(description = "verify WebTable",enabled = false)
    public void TestWebTable()
    {
        Assert.assertEquals(WebTableTest.HandlingWebTableTest(),true);
    }

    @Test(description = "verify Draggable",enabled = false)
    public void TestDraggable()
    {
        Assert.assertEquals(Draggable.HandlingDraggable(),true);
    }

    @Test(description = "verify Droppable",enabled = false)
    public void TestDroppable()
    {
        Assert.assertEquals(Droppable.HandlingDroppable(),true);
    }
    }



