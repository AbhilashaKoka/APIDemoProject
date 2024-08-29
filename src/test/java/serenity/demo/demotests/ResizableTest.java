package serenity.demo.demotests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.annotations.Managed;

@RunWith(SerenityRunner.class)
public class ResizableTest extends PageObject {


	@Managed(driver="edge")
	WebDriver driver;
	
	
	
	@Test
	public void slider() {
		//https://jqueryui.com/resources/demos/resizable/default.html
		open();
		
		withAction().dragAndDropBy($("//*[@id=\"resizable\"]/div[3]"), 400, 400).perform();
		
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
