
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {

	WebDriver driver;

	@Before
	public void setUp() {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
	}

	@Test
	public void login() {
			driver.get("https://www.saucedemo.com/");
			System.out.println("Page Title: " + driver.getTitle());
	}  

	@After
	public void tearDown() {
			if (driver != null) {
					driver.quit();
		}
	}
}
