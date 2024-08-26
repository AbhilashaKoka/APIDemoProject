package seleniumTestNG;

public class Droppable extends BaseSetUp {
    public Droppable() {
    }


    public static void HandlingDroppable(){
        setup();
        driver.get("//https://demoqa.com/droppable");
        shutDown();
    }

}
