package stepdefinition;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class MainClass {
    WebDriver driver;
    public void getscreenshot(int value) throws Exception 
    {
	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrFile, new File("//home//mubashir//Desktop//img"+value+".PNG"));
	    driver.findElement(By.xpath(".//span[@class='page-numbers next']")).click();
    }
	
    @Given("^Navigate to stackover flow URL$")
    public void navigate_to_stackover_flow_URL() throws Throwable {
    	System.setProperty("webdriver.gecko.driver", "//home//mubashir//Desktop//geckodriver");
	    driver=new FirefoxDriver();
	    driver.manage().window().maximize();
	    driver.get("https://stackoverflow.com/users/login");
        
    }
    @Given("^Provide valid credentials$")
	public void provide_valid_credentials() throws Throwable
	{
		
		 driver.findElement(By.id("email")).sendKeys("test18engg@gmail.com");
		 driver.findElement(By.id("password")).sendKeys("v121518@");
		
	}

	@Given("^Click on sign in button$")
	public void click_on_sign_in_button() throws Throwable 
	{
		driver.findElement(By.id("submit-button")).click();
	  
	}
	
	@Then("^Login page should displayed$")
	public void login_page_should_displayed() throws Throwable 
	{
	
		Thread.sleep(2000);
		String currentURL = driver.getCurrentUrl();
	}
	
	@Then("^Getting the exact URL for tag$")
	public void getting_the_exact_URL() throws Throwable {
		Thread.sleep(2000);
		String url=driver.getCurrentUrl();
		System.out.println(url);
		driver.get(url+"questions/tagged/javascript");
	}
	
	@Then("^getting the text$")
	public void getting_the_text() throws Throwable {
		String text=driver.findElement(By.xpath(".//*[@class='summarycount al']")).getText();
		System.out.println("Total questions ="+text);
	}
	@Then("^Capturing the screenshot of next five pages$")
	public void capturing_the_screenshot_of_next_five_pages() throws Throwable {
		for(int i=0;i<5;i++)
		{
			getscreenshot(i);
		}
	}

}

	
	
	