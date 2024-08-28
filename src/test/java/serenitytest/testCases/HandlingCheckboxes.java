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
public class HandlingCheckboxes extends PageObject {
	
	
	@Managed()
	WebDriver driver;
	
	
	
	@Test
	public void checkboxTest() {
		
		open();
		/*
		 * Checkbox checkbox = new Checkbox($(
		 * "/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input[1]"));
		 * System.out.println(checkbox.isChecked()); checkbox.setChecked(true);
		 * System.out.println(checkbox.isChecked());
		 */
		
		WebElementFacade block = find(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));
		
		List<WebElementFacade> checkboxes = block.thenFindAll(By.name("sports"));
		
		checkboxes.get(1).click();
		
		for(WebElementFacade check: checkboxes) {
			
			check.click();
		}
		
		System.out.println("Total checkboxes are : "+checkboxes.size());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
