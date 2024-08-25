package seleniumWebdriver;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;

public class Slider extends BaseSetUp {
    static WebDriver driver;
    static Actions action;

    public static void HandlingSlider() {
        setup();
        driver.get("https://demoqa.com/slider");
        shutDown();
    }
}
