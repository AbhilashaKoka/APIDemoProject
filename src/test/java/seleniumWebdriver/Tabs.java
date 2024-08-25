package seleniumWebdriver;



public class Tabs extends BaseSetUp {

    public Tabs() {
    }

    public static void HandlingTabs() {
       setup();
        driver.get("https://demoqa.com/tabs");
        shutDown();
    }
}
