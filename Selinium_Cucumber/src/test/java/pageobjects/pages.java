package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class pages extends base {

	public pages(WebDriver driver) {
		base.driver=driver;
		
	}
	
	//Locators
	
	String link = "//a[text()='%s']";
	
	By Abtext = By.xpath("//h3[contains(text(),'A/B Test')]");

	By dropdown = By.id("dropdown");
	
	By Frames = By.xpath("//ul//a");
	
	// Actions
	
	public void Click(String Link) {
		driver.findElement(By.xpath(String.format(link,Link))).click();
		
	}
	
	public String getAbtext() {
		return driver.findElement(Abtext).getText();
	}
	
	public void selectdropdownvalue(String Option) {
		
		Select select = new Select(driver.findElement(dropdown));
		select.selectByVisibleText(Option);
	}
	
	public String getselectedvalue() {
	
		Select select = new Select(driver.findElement(dropdown));
		return select.getFirstSelectedOption().getText();
	}
	
	public List<WebElement> getallframes() {
		
		return driver.findElements(Frames);
	}
}
