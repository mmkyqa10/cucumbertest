package stepDefinations;

import java.util.HashMap;
import java.util.Map;
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

public class DealsMap {
		WebDriver driver;
		
	@Given("that the user is on the login page for dealsmap")
	public void that_the_user_is_on_the_login_page_for_dealsmap() {
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://freecrm.com/"); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	@And("click on the Login button for dealsmap")
	public void click_on_the_login_button_for_dealsmap() {
		WebElement element=driver.findElement(By.xpath("//span[text()='Log In']"));
	    JavascriptExecutor js= (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();",element);
	}
	@When("provided the valid username and password for dealsmap")
	public void provided_the_valid_username_and_password_for_dealsmap(DataTable credits) {
		for(Map<String, String> udata : credits.asMaps()) {
			//System.out.println("Username is "+udata.get("username"));
		    driver.findElement(By.name("email")).sendKeys(udata.get("username"));
		    driver.findElement(By.name("password")).sendKeys(udata.get("password"));
		}
	}
	@And("click on the login buttom for dealsmap")
	public void click_on_the_login_buttom_for_dealsmap() {
		driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]")).click();
	}
	@And("clicks on the deals->New option for dealsmap")
	public void clicks_on_the_deals_new_option_for_dealsmap() {
		//driver.findElement(By.xpath("//span[text()='Deals']")).click();	
		//driver.findElement(By.xpath("//button[text()='New']")).click();
	}
	@And("fill the title,description and probability for dealsmap")
	public void fill_the_title_description_and_probability_for_dealsmap(DataTable values) {
		System.out.println("Values prior to loop" + values);
		
		for(Map<String, String> info : values.asMaps()) {
			driver.findElement(By.xpath("//*[@id=\"main-nav\"]/a[1]/span")).click();
			driver.findElement(By.xpath("//span[text()='Deals']")).click();	
			driver.findElement(By.xpath("//button[text()='New']")).click();
			driver.findElement(By.name("title")).sendKeys(info.get("title"));
			driver.findElement(By.name("description")).sendKeys(info.get("description"));
			driver.findElement(By.name("probability")).sendKeys(info.get("probability"));
			driver.findElement(By.xpath("//button[text()='Save']")).click();
						
			//WebDriverWait wait=new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"dashboard-toolbar\"]/div[1]")));


			//driver.navigate().refresh();
			//System.out.println("data details are "+ info.get("Title")+info.get("Description")+info.get("Probability"));

	   }
	}
	@And("click on Save button for dealsmap")
	public void click_on_save_button_for_dealsmap() {
		//driver.findElement(By.xpath("//button[text()='Save']")).click();

	}
	@Then("deal should be added for dealsmap")
	public void deal_should_be_added_for_dealsmap() {
		driver.close();
	}



	
}
