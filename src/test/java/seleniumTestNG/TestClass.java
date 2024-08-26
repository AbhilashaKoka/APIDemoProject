package seleniumTestNG;

import org.testng.annotations.Test;

import static seleniumTestNG.Button.HandlingButton;
import static seleniumTestNG.CheckBox.HandlingCheckBox;

import static seleniumTestNG.DataPicker.HandlingDataPicker;
import static seleniumTestNG.BrowserWindow.HandlingBrowserWindow;
import static seleniumTestNG.AutoComplete.HandlingAutomComplete;
import static seleniumTestNG.AlertsHandling.HandlingAlert;
import static seleniumTestNG.AccordionHandling.HandlingAccordion;
import static seleniumTestNG.Draggable.HandlingDraggable;
import static seleniumTestNG.Droppable.HandlingDroppable;
import static seleniumTestNG.Forms.HandlingForm;
import static seleniumTestNG.FramesHandling.HandlingFrame;
import static seleniumTestNG.Links.HandlingLInk;
import static seleniumTestNG.Menu.HandlingMenu;
import static seleniumTestNG.ModalDialogHandling.HandlingModalDialog;
import static seleniumTestNG.MultipleFrameHandling.HandlingMultipleFrames;
import static seleniumTestNG.ProgressBar.HandlingProgressBar;
import static seleniumTestNG.RadioButton.HandlingRadioBUtton;
import static seleniumTestNG.Resizable.HandlingResizable;
import static seleniumTestNG.Selectable.HandlingSelectable;
import static seleniumTestNG.SelectMenu.HandlingSelectMenu;
import static seleniumTestNG.Slider.HandlingSlider;
import static seleniumTestNG.Sortable.HandlingSortable;
import static seleniumTestNG.Tabs.HandlingTabs;
import static seleniumTestNG.TextBox.HandlingTextBox;
import static seleniumTestNG.ToolTips.HandlingToolTip;
import static seleniumTestNG.UploadAndDownload.HandlingUploadAndDownload;
import static seleniumTestNG.WebTableTest.HandlingWebTableTest;


public class TestClass extends BaseSetUp{

   @Test
       public void TestButton() {

       HandlingButton();
        }
    @Test
    public void TestCheckBox() {

       HandlingCheckBox();
    }
    @Test
    public void TestDatePicker() {
        HandlingDataPicker();
   }
   @Test
     public void TestBrowserWindow() throws InterruptedException {
        HandlingBrowserWindow();
   }
    @Test
    public void TestAutoComplete() {
        HandlingAutomComplete();
   }
    @Test
     public void TestAlert() {
        HandlingAlert();
   }
     @Test
      public void TestAccordion() {
        HandlingAccordion();
   }

    @Test
    public void TestPracticeForm() throws InterruptedException {
        HandlingForm();
    }

    @Test
    public void TestFrame() {
        HandlingFrame();
    }
    @Test
    public void TestLink() {
        HandlingLInk();
    }

    @Test
    public void TestMenu() {
        HandlingMenu();
    }
    @Test
    public void TestModalDialog() throws InterruptedException {
        HandlingModalDialog();
    }

    @Test
    public void TestMultipleFrame(){
       HandlingMultipleFrames();

    }
    @Test
    public void TestProgressBar()
    {
        HandlingProgressBar();
    }

    @Test
    public void TestRadioButton() {
        HandlingRadioBUtton();
    }

        @Test
        public void TestResizable()
        {
            HandlingResizable();
        }


    @Test
    public void TestSelectable()
    {
        HandlingSelectable();
    }
    @Test
    public void TestSelectMenu()
    {
        HandlingSelectMenu();
    }


    @Test
    public void TestSlider()
    {
        HandlingSlider();
    }

    @Test
    public void TestSortable(){
       HandlingSortable();
    }

    @Test
    public void TestTabs(){
       HandlingTabs();
    }
    @Test
    public void TestTextBox() throws InterruptedException {
        HandlingTextBox();
    }

    @Test
    public void TestToolTip()
    {
        HandlingToolTip();
    }

    @Test
    public void TestUpload() throws InterruptedException {
        HandlingUploadAndDownload();
    }

    @Test
    public void TestWebTable()
    {
        HandlingWebTableTest();
    }

    @Test
    public void TestDraggable()
    {
        HandlingDraggable();
    }

    @Test
    public void TestDroppable()
    {
        HandlingDroppable();
    }
    }



