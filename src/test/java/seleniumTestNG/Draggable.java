package seleniumTestNG;

public class Draggable extends BaseSetUp {

    public Draggable()
    {

    }

    public static void HandlingDraggable(){

        setup();
        driver.get("//https://demoqa.com/dragabble");
        shutDown();
    }

}
