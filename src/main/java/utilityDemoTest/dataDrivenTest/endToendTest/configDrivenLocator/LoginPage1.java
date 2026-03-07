package utilityDemoTest.dataDrivenTest.endToendTest.configDrivenLocator;
import org.openqa.selenium.WebDriver;


    public class LoginPage1 {
        WebDriver driver;

        public LoginPage1(WebDriver driver) {
            this.driver = driver;
        }

        public void login(String user, String pass) {
            driver.findElement(LocatorFactory.get("LoginPage", "usernameField")).sendKeys(user);
            driver.findElement(LocatorFactory.get("LoginPage", "passwordField")).sendKeys(pass);
            driver.findElement(LocatorFactory.get("LoginPage", "loginButton")).click();
        }
    }



//- Config-driven: Update locators in JSON, no code changes needed.
//- Team-friendly: Non-developers can edit locators without touching Java.
//- Scalable: Extend to multiple environments (locators.qa.json, locators.prod.json).
//- Maintainable: Centralized locator management reduces duplication.
//mvn test -Denv=qa
//mvn test -Denv=prod

