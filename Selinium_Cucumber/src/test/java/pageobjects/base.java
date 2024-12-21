package pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {

	protected static WebDriver driver;
	public pages page;
	
	public static void driversetup(String browser) {
		switch(browser) {
		case "Chrome" : driver= new ChromeDriver();break;
		
		case "Edge" : driver= new EdgeDriver();break;
		
		case "IE" : driver= new InternetExplorerDriver();break;
		
		default : driver= new FirefoxDriver();break;
		
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}
}
