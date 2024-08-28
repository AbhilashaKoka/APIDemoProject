package serenitytest.testCases;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.annotations.Managed;

@RunWith(SerenityRunner.class)
public class TryItTest extends PageObject {


	@Managed(driver="edge")
	WebDriver driver;
	
	
	
	@Test
	public void handlingAlert() {
		//https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get
		open();
		
		getDriver().switchTo().frame("iframeResult");
		
		//$("/html/body/button").click();
		
		evaluateJavascript("arguments[0].style.border='3px solid red'",$("//*[@id=\"mySubmit\"]"));
		
		getDriver().switchTo().defaultContent();
		List<WebElementFacade> frames = findAll(By.tagName("iframe"));
		
		for(WebElementFacade frame: frames) {
			
			System.out.println(frame.getAttribute("id"));
		}
		
		System.out.println(frames.size());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
