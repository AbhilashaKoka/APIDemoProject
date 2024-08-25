package seleniumWebdriver;
import org.junit.jupiter.api.Test;
import static seleniumWebdriver.Button.HandlingButton;
import static seleniumWebdriver.CheckBox.HandlingCheckBox;

import static seleniumWebdriver.DataPicker.HandlingDataPicker;
import static seleniumWebdriver.BrowserWindow.HandlingBrowserWindow;
import static seleniumWebdriver.AutoComplete.HandlingAutomComplete;
import static seleniumWebdriver.AlertsHandling.HandlingAlert;
import static seleniumWebdriver.AccordionHandling.HandlingAccordion;
import static seleniumWebdriver.Draggable.HandlingDraggable;
import static seleniumWebdriver.Droppable.HandlingDroppable;
import static seleniumWebdriver.Forms.HandlingForm;
import static seleniumWebdriver.FramesHandling.HandlingFrame;
import static seleniumWebdriver.Links.HandlingLInk;
import static seleniumWebdriver.Menu.HandlingMenu;
import static seleniumWebdriver.ModalDialogHandling.HandlingModalDialog;
import static seleniumWebdriver.MultipleFrameHandling.HandlingMultipleFrames;
import static seleniumWebdriver.ProgressBar.HandlingProgressBar;
import static seleniumWebdriver.RadioButton.HandlingRadioBUtton;
import static seleniumWebdriver.Resizable.HandlingResizable;
import static seleniumWebdriver.Selectable.HandlingSelectable;
import static seleniumWebdriver.SelectMenu.HandlingSelectMenu;
import static seleniumWebdriver.Slider.HandlingSlider;
import static seleniumWebdriver.Sortable.HandlingSortable;
import static seleniumWebdriver.Tabs.HandlingTabs;
import static seleniumWebdriver.TextBox.HandlingTextBox;
import static seleniumWebdriver.ToolTips.HandlingToolTip;
import static seleniumWebdriver.UploadAndDownload.HandlingUploadAndDownload;
import static seleniumWebdriver.WebTableTest.HandlingWebTableTest;


public class JunitTestRunner {
   @Test()
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



