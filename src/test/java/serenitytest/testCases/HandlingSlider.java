package serenitytest.testCases;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.annotations.Managed;

@RunWith(SerenityRunner.class)
public class HandlingSlider extends PageObject {
	
	
	@Managed()
	WebDriver driver;
	
	
	
	@Test
	public void slider() {
		//https://jqueryui.com/resources/demos/slider/default.html
		open();
		int size = $("//*[@id=\"slider\"]").getSize().width/2;
		
		withAction().dragAndDropBy($("//*[@id=\"slider\"]/span"), size, 0).perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		withAction().dragAndDropBy($("//*[@id=\"slider\"]/span"), -size, 0).perform();
		
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
