package seleniumWebdriver;


public class ProgressBar extends BaseSetUp {

    public ProgressBar() {
    }

    public static void HandlingProgressBar() {
         setup();
         driver.get("https://demoqa.com/progress-bar");
         shutDown();
    }
}
