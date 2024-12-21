package stepdefinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageobjects.base;
import pageobjects.pages;

public class stepdef extends base{
	
	
	@Given("Launch the given URL {string}")
	public void launch_the_given_url(String AppURL) {
		driversetup("Chrome");
	    driver.get(AppURL);
	}

	@Then("Verify the title of the page {string}")
	public void verify_the_title_of_the_page(String Expectedtitle) {
	    String actualtitle = driver.getTitle();
	    Assert.assertEquals(actualtitle,Expectedtitle);
	}

	@When("clicking on the {string} link")
	public void clicking_on_the_link(String link) {
		page = new pages(driver);
		page.Click(link);
	}

	@Then("verify the text on the page as {string}")
	public void verify_the_text_on_the_page_as(String ExpectedABText) {
	    String actualtext = page.getAbtext();
	    boolean text = actualtext.contains(ExpectedABText);
	    Assert.assertTrue(text);
	    
	}

	@When("Navigate back to Home page")
	public void navigate_back_to_home_page() {
	    driver.navigate().back();
	}

	@Then("Select {string} value form drop down")
	public void select_value_form_drop_down(String Option) {
	
		page.selectdropdownvalue(Option);
	  
	}

	@Then("verify {string} is selected")
	public void verify_is_selected(String ExpectedOption) {
	   String actualoption = page.getselectedvalue(); 
	   Assert.assertEquals(actualoption,ExpectedOption);
		
	}

	@Then("Verify the below hyperlinks are presented on the Frames Page")
	public void verify_the_below_hyperlinks_are_presented_on_the_frames_page(DataTable datatable) {
	    
		List<String> expectedlinks = datatable.asList();
		List<WebElement> elements = page.getallframes();
		for(String expectedlink:expectedlinks) {
			boolean linkpresent = elements.stream().map(WebElement::getText).anyMatch(actualLinktext->actualLinktext.equals(expectedlink));
			Assert.assertTrue(linkpresent);
		
		}
		driver.quit();		
	}

}
