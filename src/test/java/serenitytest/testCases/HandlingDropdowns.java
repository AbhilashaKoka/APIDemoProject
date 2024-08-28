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
public class HandlingDropdowns extends PageObject {
	
	
	@Managed()
	WebDriver driver;
	
	/*
	 * 
	 * English - US
	 * English - UK
	 * 
	 */
	
	@Test
	public void webElementTest() {
		
		open();
		//find(By.id("searchLanguage")).sendKeys("Eesti");
		//find(By.id("searchLanguage")).selectByVisibleText("Eesti");
		
	//	find(By.id("searchLanguage")).selectByValue("hi");
		
		//find(By.id("searchLanguage")).getSelectOptions()
		
		WebElementFacade dropdown = find(By.id("searchLanguage"));
		
		List<WebElementFacade> values =	dropdown.thenFindAll(By.tagName("option"));
		
		/*
		 * WebElementFacade section2 = find(By.id("section2"));
		 * section2.thenFindAll(By.id("abc")).get(2).sendKeys("sdfsd");
		 */
		
		
		
		//0 - 65
		System.out.println(values.get(7).getText());
		
		for(WebElementFacade value:values) {
			
			System.out.println(value.getAttribute("lang"));
			
		}
		
		
		
		
		
		
		System.out.println("Total values in dropdown are : "+values.size());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
