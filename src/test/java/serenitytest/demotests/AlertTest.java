package serenitytest.demotests;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.temporal.ChronoUnit;


@RunWith(SerenityRunner.class)
public class AlertTest extends PageObject {

	@Managed(driver="chrome")
	WebDriver driver;
//code to implement in each test method

	@Test
	public void handlingAlert() {
		open();
		System.out.println(getTitle());
		evaluateJavascript("window.scrollBy(0,300)");
		setImplicitTimeout(10, ChronoUnit.SECONDS);

		WebElementFacade Frames_Frames = $("//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Alerts, Frame & Windows\")]");
		Frames_Frames.click();
		WebElementFacade Alerts_span = $("//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Alerts\")]");
		Alerts_span.click();


		WebElementFacade AlertWrapper = $("//*[@id=\"javascriptAlertsWrapper\"]");
		System.out.println(AlertWrapper.getAttribute("innerText"));

		WebElementFacade alertButton = $("//button[@id=\"alertButton\"]");
		alertButton.click();
		Alert alert=getAlert();
		System.out.println(getAlert().getText());
		getDriver().switchTo().alert().accept();


		WebElementFacade timeralertbutton = $("//button[@id=\"timerAlertButton\"]");
		timeralertbutton.click();
		waitForCondition().until(ExpectedConditions.alertIsPresent());
		System.out.println(getDriver().switchTo().alert().getText());
		getDriver().switchTo().alert().accept();


		WebElementFacade confirmButton = $("//button[@id=\"confirmButton\"]");
		confirmButton.click();
		System.out.println(getDriver().switchTo().alert().getText());
		getDriver().switchTo().alert().accept();


		WebElementFacade promptButton = $("//button[@id=\"promtButton\"]");
		promptButton.click();
		System.out.println(getDriver().switchTo().alert().getText());
		getDriver().switchTo().alert().accept();

	}

}
