package seleniumWebdriver;


public class Selectable extends BaseSetUp {


    public Selectable() {
    }

    public static void HandlingSelectable(){
        setup();
        driver.get("//https://demoqa.com/selectable");
        shutDown();
    }

}
