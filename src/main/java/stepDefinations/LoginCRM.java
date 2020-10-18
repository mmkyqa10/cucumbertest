package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginCRM {
		
	WebDriver driver;
	
	@Given("^that user is on the login page$")
	public void that_user_is_on_the_login_page() {
	System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("https://freecrm.com/"); 
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	@When("^the user provided valid \"(.*)\" and \"(.*)\"$")
	public void the_user_provided_valid_username_and_password(String username,String password) {
		//driver.switchTo().frame("st_gdpr_iframe");
	    WebElement element=driver.findElement(By.xpath("//span[text()='Log In']"));
	    JavascriptExecutor js= (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();",element);
	    driver.findElement(By.name("email")).sendKeys(username);
	    driver.findElement(By.name("password")).sendKeys(password);
	    driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]")).click();
	   
	}
	@Then("^user should see the home page$")
	public void user_should_see_the_home_page() {
	    String text=driver.getTitle();
	    Assert.assertEquals("Cogmento CRM", text);
	    driver.close();
	}

	
	

}
