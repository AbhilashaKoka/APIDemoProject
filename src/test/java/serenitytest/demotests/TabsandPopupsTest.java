package serenitytest.demotests;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.annotations.Managed;

@RunWith(SerenityRunner.class)
public class TabsandPopupsTest extends PageObject {


	@Managed(driver="edge")
	WebDriver driver;
	
	
	
	@Test
	public void handlingPopups() {
		//https://mail.rediff.com/cgi-bin/login.cgi
		open();
		
		
		$("//*[@id=\"wrapper\"]/header/div[2]/div/div[2]/div/a[1]").click();
	
		ArrayList<String> newTab = new ArrayList<String> (getDriver().getWindowHandles());
		
		getDriver().switchTo().window(newTab.get(1));
		
		$("//*[@id=\"user_email\"]").sendKeys("trainer@way2automation.com");
		
		System.out.println("Second window Title : "+getTitle());
		getDriver().close();
		getDriver().switchTo().window(newTab.get(0));
		System.out.println("First window Title : "+getTitle());
		getDriver().close();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
