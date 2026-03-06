package seleniumGeoLocationTest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import java.util.Optional;

public class GeoLocationTest {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // Set geolocation to New York City
        devTools.send(Emulation.setGeolocationOverride(
                Optional.of(40.7128),   // Latitude
                Optional.of(-74.0060),  // Longitude
                Optional.of(1)          // Accuracy in meters
        ));
        driver.get("https://www.google.com/maps");
    }
}