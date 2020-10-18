package stepDefinations;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Deals {
	WebDriver driver;
	
	@Given("^that the user is on the login page for deals$")
	public void that_the_user_is_on_the_login_page() {
			System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get("https://freecrm.com/"); 
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@And("click on the Login button")
	public void click_on_the_login_button() {
		WebElement element=driver.findElement(By.xpath("//span[text()='Log In']"));
	    JavascriptExecutor js= (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();",element);
	}

	@When("^provided the valid username and password$")
	public void provided_the_valid_username_and_password(DataTable credentials) {
		List<List<String>> data=credentials.asLists();
	    driver.findElement(By.name("email")).sendKeys(data.get(0).get(0));
	    driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
	}
	@And("^click on the login buttom$")
	public void click_on_login_buttom() {
		driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]")).click();
	}
	
	@And("^clicks on the deals->New option$")
	public void clicks_on_the_deals_new_option() {
		driver.findElement(By.xpath("//span[text()='Deals']")).click();
		driver.findElement(By.xpath("//button[text()='New']")).click();
	}
	@And("^fill the title,description and probability$")
	public void fill_the_title_description_and_probability(DataTable dealinfo) {
	List<List<String>> data=dealinfo.asLists();
	driver.findElement(By.name("title")).sendKeys(data.get(0).get(0));
	driver.findElement(By.name("description")).sendKeys(data.get(0).get(1));
	driver.findElement(By.name("probability")).sendKeys(data.get(0).get(2));
	}
	@And("^click on Save button for deals$")
	public void click_on_save_button_for_deals() {
		driver.findElement(By.xpath("//button[text()='Save']")).click();
	}
	@Then("^deal should be added$")
	public void deal_should_be_added() {
		driver.close();
	}



	
}
