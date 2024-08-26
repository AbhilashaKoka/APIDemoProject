package seleniumTestNG;

public class Sortable extends BaseSetUp {


    public Sortable() {
    }

    public static void HandlingSortable() {
        setup();
        driver.get("https://demoqa.com/sortable");
        shutDown();
    }}

