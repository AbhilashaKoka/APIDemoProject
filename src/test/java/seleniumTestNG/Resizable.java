package seleniumTestNG;

public class Resizable extends BaseSetUp {


    public Resizable() {
    }

    public static void HandlingResizable(){
      setup();
      driver.get("//https://demoqa.com/resizable");
      shutDown();
    }

}
