package seleniumTestNG;



public class Menu extends BaseSetUp {

    public Menu() {

    }

    public static void HandlingMenu(){
        setup();
        driver.get("https://demoqa.com/menu");
        shutDown();
    }
}
