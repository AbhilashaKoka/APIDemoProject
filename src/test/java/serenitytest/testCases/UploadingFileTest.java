package serenitytest.testCases;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.annotations.Managed;

@RunWith(SerenityRunner.class)
public class UploadingFileTest extends PageObject {
	
	
	@Managed()
	WebDriver driver;
	
	
	
	@Test
	public void fileUpload() {
		
		open();
		$("//*[@id=\"email\"]").sendKeys("prafulgupta84@yahoo.in");
		$("//*[@id=\"pass\"]").typeAndEnter("Selenium@1234");
		
		$("//*[@id=\"navItem_100010051393565\"]/a/div").click();
		
		$("//div[starts-with(@class,'fbTimelineProfilePicSelector')]/div/a").click();
		

		upload("C:\\Users\\way2automation\\Desktop\\dd.png").to($("//a[@data-action-type='upload_photo']/div/input"));
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

}
