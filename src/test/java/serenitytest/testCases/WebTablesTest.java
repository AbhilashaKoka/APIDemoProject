package serenitytest.testCases;

import java.util.List;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.annotations.Managed;

@RunWith(SerenityRunner.class)
public class WebTablesTest extends PageObject {


	@Managed(driver="edge")
	WebDriver driver;
	
	
	@Test
	public void webtable() {

		open();
		evaluateJavascript("window.scrollBy(0,300)");
		WebElementFacade Element_Frames= $("//*[@class=\"category-cards\"]//following::div[@class=\"card-body\"]//h5[contains(text(),\"Elements\")]");
		Element_Frames.click();
		WebElementFacade WebTables_Span=$("//*[@class=\"accordion\"]//div[@class=\"element-group\"]//following::span[@class=\"text\" and contains(text(),\"Web Tables\")]");
		WebTables_Span.click();
		WebElementFacade searchButton=$("//input[@id=\"searchBox\"]");
		searchButton.sendKeys("Kierra", Keys.ENTER);
		List<WebElementFacade> RowGroup=findAll("//div[@class='rt-tr-group']");
		int sizeofRows=RowGroup.size();
		List<WebElementFacade> tablerow=findAll(" //div[@class='rt-td']");
		int sizeofRows1=tablerow.size();
		for(WebElement row:tablerow)
		{
			row.findElement(By.xpath("//div[@class=\"action-buttons\"]//span[@title=\"Edit\"]")).click();
			//  WebElement  RegistrationWindow=driver.findElement(By.xpath("\"//div[@class=\"modal-content\"]\""));
			// WebElement RegistrationTitle= driver.findElement(By.xpath("registration-form-modal"));
			getDriver().switchTo().activeElement();
//          Actions action=new Actions(driver);
//          action.moveToElement(RegistrationWindow).release().build();
			//    System.out.println(RegistrationTitle.getAttribute("innerText"));

		}
		/*
		 * WebElementFacade table = $("//*[@id=\"leftcontainer\"]/table/tbody");
		 * List<WebElementFacade> rows = table.thenFindAll(By.tagName("tr"));
		 * 
		 * System.out.println(rows.size());
		 * 
		 * for(WebElementFacade row:rows) {
		 * 
		 * System.out.println(row.getText()); }
		 * 
		 * WebElementFacade row1 = $("//*[@id=\"leftcontainer\"]/table/tbody/tr[1]");
		 * List<WebElementFacade> cols= row1.thenFindAll(By.tagName("td"));
		 * 
		 * System.out.println("Total cols are: "+cols.size());
		 */
		
//		HtmlTable table = new HtmlTable($("//*[@id=\"leftcontainer\"]/table"));
//
//		List<String> headers = table.getHeadings();
//
//		for(String header: headers) {
//
//			System.out.println(header);
//		}
//
//		List<WebElement> rows = table.getRowElements();
//
//		for(WebElement row:rows) {
//
//			System.out.println(row.getText());
//
//		}
//
//
//		System.out.println("Total rows are : "+rows.size());
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
	}
	

}
