package seleniumTestNG;



public class ToolTips extends BaseSetUp {
    public ToolTips(){

    }
    public static void HandlingToolTip(){
        setup();
        driver.get("https://demoqa.com/tool-tips");
         shutDown();}
}
