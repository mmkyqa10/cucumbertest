package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class NewContact {
	WebDriver driver;
	
	@Given("^that the user is on the login page$")
	public void that_the_user_is_on_the_login_page() {
			System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("https://freecrm.com/"); 
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@And("^click on Login button$")
	public void click_on_login_button() {
		WebElement element=driver.findElement(By.xpath("//span[text()='Log In']"));
	    JavascriptExecutor js= (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();",element);
	}

	
	@When("^enter the valid \"(.*)\" and \"(.*)\"$")
	public void enter_the_valid_and(String username, String password) {
	    driver.findElement(By.name("email")).sendKeys(username);
	    driver.findElement(By.name("password")).sendKeys(password);
	}
	
	@And("^click on login buttom$")
	public void click_on_login_buttom() {
		driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]")).click();
	}
	

	@And("^clicks on contacts-> New$")
	public void clicks_on_contacts_new() {
		int size=driver.findElements(By.tagName("iframe")).size();
		System.out.println("No.of iframes are " +size);
		//driver.switchTo().frame(0).navigate();
		driver.findElement(By.xpath("//*[@id=\"main-nav\"]/a[3]")).click();
		driver.findElement(By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button")).click();
		driver.navigate().refresh();
		
	}
	@And("^fill the \"(.*)\" and \"(.*)\"$")
	public void fill_the_and(String firstname, String lastname) {
		//driver.switchTo().frame(0);
		driver.findElement(By.name("first_name")).sendKeys(firstname);
		driver.findElement(By.name("last_name")).sendKeys(lastname);
	}
	@And("^click on Save button$")
	public void click_on_save_button() {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}
	@Then("^contact should be added with \"(.*)\"$")
	public void conct_should_e_added(String fullname) {
		String name=driver.findElement(By.xpath("//*[@id=\"dashboard-toolbar\"]/div[1]")).getText();
		System.out.println("Name is " + name);
		//Assert.assertEquals(fullname, name);
		driver.close();
	}



}
