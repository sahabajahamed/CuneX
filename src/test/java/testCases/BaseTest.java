package testCases;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public  class BaseTest {
	
	public WebDriver driver;
	
	
	// Driver is open
	@BeforeMethod
	public void setup() {
	try {
		  ChromeOptions options = new ChromeOptions();
	        Map<String, Object> prefs = new HashMap<>();

	        // Disable notifications permission pop-up
	        prefs.put("profile.default_content_setting_values.notifications", 2);
	      

	        // Set these preferences into ChromeOptions
	        options.setExperimentalOption("prefs", prefs);

	      
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver(options);

	        // Maximize window and set implicit wait
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	        // Navigate to the login page
	        driver.get("https://staging.groundmetrx.com/");
		}
		catch (Exception e) {
	e.printStackTrace();
	}
	}
	
	// driver is close 
	@AfterMethod
	public void teardown()
	{
		if (driver!= null)
		{
			driver.quit();
		}
	}
	
	
	// Random value put here 
	public String randomString()
	{
		String generateString=RandomStringUtils.randomAlphabetic(5);
		return generateString;
		//
		
	}
	
	public String randomNumber()
	{
		String generateNumber= RandomStringUtils.randomNumeric(10);
		return generateNumber;
	}
	public String randomAlphaNumeric()
	{
		String generateNumber=RandomStringUtils.randomNumeric(5);
		String generateString=RandomStringUtils.randomAlphabetic(4);
		return (generateNumber+"@"+generateString );
	}
	

}
