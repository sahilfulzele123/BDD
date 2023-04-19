package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	WebDriver driver = null;
	
	@Given("I want to launch the browser")
	public void i_want_to_launch_the_browser() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Given("I want to load the URL")
	public void i_want_to_load_the_url() {
	    
		driver.get("http://localhost:8888");
	}
	
	@When("Login page is displayed enter valid credentials")
	public void login_page_is_displayed_enter_valid_credentials() {
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
	   
	}
	
	@When("Click on login")
	public void click_on_login() {
		driver.findElement(By.id("submitButton")).click();
	}
	
	@Then("Validate if Home page is displayed")
	public void validate_if_home_page_is_displayed() {
	
		String expTitle = "Vtiger";
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		if(actTitle.contains(expTitle)) {
			System.out.println("PASS");
		}
		else {
			System.out.println("Fail");
		}
	}


}
