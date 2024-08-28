package serenitytest.testCases;
import net.serenitybdd.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


import net.serenitybdd.core.pages.PageObject;

import net.serenitybdd.junit.runners.SerenityRunner;


@RunWith(SerenityRunner.class)
public class HandlingDragandDrop extends PageObject {
	
	
	@Managed()
	WebDriver driver;
	
	
	
	@Test
	public void draganddrop() {
		//https://jqueryui.com/resources/demos/droppable/default.html
		open();
		
		withAction().dragAndDrop($("//*[@id=\"draggable\"]"), $("//*[@id=\"droppable\"]")).perform();
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
