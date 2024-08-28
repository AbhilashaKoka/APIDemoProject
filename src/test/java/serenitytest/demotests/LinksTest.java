package serenitytest.demotests;

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
public class LinksTest extends PageObject {


	@Managed(driver="edge")
	WebDriver driver;
	

	
	@Test
	public void webElementTest() {
		
		open();
		//find(By.id("searchLanguage")).sendKeys("Eesti");
		//find(By.id("searchLanguage")).selectByVisibleText("Eesti");
		
	//	find(By.id("searchLanguage")).selectByValue("hi");
		
		//find(By.id("searchLanguage")).getSelectOptions()
		
	WebElementFacade section = $("//*[@id=\"www-wikipedia-org\"]/div[6]/div[3]");
		
		//section.thenFindAll(By.tagName("a"));
	
		
		List<WebElementFacade> links =	section.thenFindAll(By.tagName("a"));
		
		//0 - 65
		//System.out.println(links.get(7).getText());
		
		
		
		for(WebElementFacade link:links) {
			
			System.out.println("Link text is :"+link.getText()+"---Printing URL----"+link.getAttribute("href"));
			
		}
		
		
		
		
		
		
		System.out.println("Total count of links are : "+links.size());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
