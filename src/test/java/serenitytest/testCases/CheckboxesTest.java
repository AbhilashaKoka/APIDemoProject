package serenitytest.testCases;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;

import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(SerenityRunner.class)
public class CheckboxesTest extends PageObject {



	@Managed(driver="edge")
	WebDriver driver;
	
	
	
	@Test
	public void checkboxTest() {
		open();
		System.out.println(getTitle());
		evaluateJavascript("window.scrollBy(0,300)");
		setImplicitTimeout(10, ChronoUnit.SECONDS);
		WebElementFacade Elements_Frames=$("//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]");
		Elements_Frames.click();
		WebElementFacade CheckBox_span=$( "//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Check Box\")]");
		CheckBox_span.click();
		//waitForCondition().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[title=\"Toggle\"]")));
		WebElementFacade sort= $("//button[title=\"Toggle\"]");
		evaluateJavascript("window.scrollBy(0,300)");
		sort.click();
		List<WebElementFacade> chkboxes=findAll("//input[type='checkbox']");
		int size=chkboxes.size();
		System.out.println(size);

		WebElementFacade sortDesktop=$("//span[@class=\"rct-title\"][ contains(text(),\"Desktop\")]//following::button[1][@title=\"Toggle\"]");
		sortDesktop.click();
		List<WebElementFacade> chkboxes2=findAll("input[type='checkbox']");
		int size2=chkboxes2.size();
		System.out.println(size2);
		WebElementFacade sortDesktop2=$("//span[@class=\"rct-title\"][ contains(text(),\"WorkSpace\")]//following::button[1][@title=\"Toggle\"]");
		WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(60));
		wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector(" button[title=\"Toggle\"]")));

		sortDesktop2.click();
		WebElementFacade sortDesktop3=$("//span[@class=\"rct-title\"][ contains(text(),\"React\")]//following::button[1][@title=\"Toggle\"]");
		sortDesktop3.click();
		/*
		 * Checkbox checkbox = new Checkbox($(
		 * "/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input[1]"));
		 * System.out.println(checkbox.isChecked()); checkbox.setChecked(true);
		 * System.out.println(checkbox.isChecked());
		 */
		
//		WebElementFacade block = find(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));
//
//		List<WebElementFacade> checkboxes = block.thenFindAll(By.name("sports"));
//
//		checkboxes.get(1).click();
//
//		for(WebElementFacade check: checkboxes) {
//
//			check.click();
//		}
//
//		System.out.println("Total checkboxes are : "+checkboxes.size());
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
	}
	

}
