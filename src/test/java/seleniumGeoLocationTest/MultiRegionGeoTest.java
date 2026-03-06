package seleniumGeoLocationTest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

import java.util.List;
import java.util.Optional;

public class MultiRegionGeoTest {
    public static void main(String[] args) {
        // Define multiple regions
        List<Region> regions = List.of(
                new Region("NewYork", 40.7128, -74.0060),
                new Region("Paris", 48.8566, 2.3522),
                new Region("Tokyo", 35.6895, 139.6917)
        );

        for (Region region : regions) {
            ChromeDriver driver = new ChromeDriver();
            DevTools devTools = driver.getDevTools();
            devTools.createSession();

            // Override geolocation
            devTools.send(Emulation.setGeolocationOverride(
                    Optional.of(region.latitude),
                    Optional.of(region.longitude),
                    Optional.of(10) // accuracy in meters
            ));

            driver.get("https://www.google.com/maps");
            System.out.println("Testing region: " + region.name);

            driver.quit();
        }
    }

    static class Region {
        String name;
        double latitude;
        double longitude;
        Region(String name, double lat, double lon) {
            this.name = name;
            this.latitude = lat;
            this.longitude = lon;
        }
    }
}
