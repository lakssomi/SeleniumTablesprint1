package stepdef;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	static WebDriver driver;

	@Before
	public void beforeScenario() throws ClassNotFoundException, SQLException {
		System.out.println("beforeSecnario()");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void url() {

		driver.get("http://seleniumtableassignment.s3-website-us-west-2.amazonaws.com");
	}

	@After
	public void afterScenario() {
		driver.quit();
	}

}
