package seleniumTestNG;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(seleniumTestNG.TestStatusListener.class)
public class TestClass extends BaseSetUp{

   @Test
       public void TestButton() {
              Assert.assertEquals( Button.HandlingButton(), true);
        }
    @Test
    public void TestCheckBox() {
      Assert.assertEquals(CheckBox.HandlingCheckBox(),true);
    }
    @Test
    public void TestDatePicker() {
        Assert.assertEquals( DataPicker.HandlingDataPicker(),true);
   }
   @Test
     public void TestBrowserWindow() throws InterruptedException {
       Assert.assertEquals(BrowserWindow.HandlingBrowserWindow(),true);
   }
    @Test
    public void TestAutoComplete() {
        Assert.assertEquals( AutoComplete.HandlingAutomComplete(),true);
   }
    @Test
     public void TestAlert() {
        Assert.assertEquals( AlertsHandling.HandlingAlert(),true);
   }
     @Test
      public void TestAccordion() {
         Assert.assertEquals(AccordionHandling.HandlingAccordion(),true);
   }

    @Test
    public void TestPracticeForm() throws InterruptedException {
        Assert.assertEquals(Forms.HandlingForm(),true);
    }

    @Test
    public void TestFrame() {
        Assert.assertEquals( FramesHandling.HandlingFrame(),true);
    }
    @Test
    public void TestLink() {
        Assert.assertEquals(Links.HandlingLInk(),true);
    }

    @Test
    public void TestMenu() {
        Assert.assertEquals( Menu.HandlingMenu(),true);
    }
    @Test
    public void TestModalDialog() throws InterruptedException {
        Assert.assertEquals(ModalDialogHandling.HandlingModalDialog(),true);
    }

    @Test
    public void TestMultipleFrame(){
       Assert.assertEquals(MultipleFrameHandling.HandlingMultipleFrames(),true);

    }
    @Test
    public void TestProgressBar()
    {
        Assert.assertEquals( ProgressBar.HandlingProgressBar(),true);
    }

    @Test
    public void TestRadioButton() {
        Assert.assertEquals(RadioButton.HandlingRadioBUtton(),true);
    }

        @Test
        public void TestResizable()
        {
            Assert.assertEquals(Resizable.HandlingResizable(),true);
        }


    @Test
    public void TestSelectable()
    {
        Assert.assertEquals(Selectable.HandlingSelectable(),true);
    }
    @Test
    public void TestSelectMenu()
    {
        Assert.assertEquals(SelectMenu.HandlingSelectMenu(),true);
    }


    @Test
    public void TestSlider()
    {
        Assert.assertEquals( Slider.HandlingSlider(),true);
    }

    @Test
    public void TestSortable(){
        Assert.assertEquals(Sortable.HandlingSortable(),true);
    }

    @Test
    public void TestTabs(){
        Assert.assertEquals(Tabs.HandlingTabs(),true);
    }
    @Test
    public void TestTextBox() throws InterruptedException {
        Assert.assertEquals(TextBox.HandlingTextBox(),true);
    }

    @Test
    public void TestToolTip()
    {
        Assert.assertEquals(ToolTips.HandlingToolTip(),true);
    }

    @Test
    public void TestUpload() throws InterruptedException {
        Assert.assertEquals(UploadAndDownload.HandlingUploadAndDownload(),true);
    }

    @Test
    public void TestWebTable()
    {
        Assert.assertEquals(WebTableTest.HandlingWebTableTest(),true);
    }

    @Test
    public void TestDraggable()
    {
        Assert.assertEquals(Draggable.HandlingDraggable(),true);
    }

    @Test
    public void TestDroppable()
    {
        Assert.assertEquals(Droppable.HandlingDroppable(),true);
    }
    }



