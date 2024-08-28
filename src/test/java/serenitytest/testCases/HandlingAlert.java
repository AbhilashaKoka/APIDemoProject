package serenitytest.testCases;



import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;



import net.serenitybdd.junit.runners.SerenityRunner;


@RunWith(SerenityRunner.class)
public class HandlingAlert extends PageObject {
	
	
	@Managed()
	WebDriver driver;
	
	
	
	@Test
	public void handlingAlert() {
		//https://mail.rediff.com/cgi-bin/login.cgi
		open();
		
		
		$("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/input[2]").click();
		
		Alert alert = getAlert();
		System.out.println(alert.getText());
		alert.accept();
		
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
