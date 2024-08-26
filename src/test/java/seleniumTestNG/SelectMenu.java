package seleniumTestNG;



public class SelectMenu extends BaseSetUp {

    public SelectMenu() {
    }

    public static void HandlingSelectMenu() {
        setup();
        driver.get("https://demoqa.com/select-menu");
        shutDown();
    }
}
