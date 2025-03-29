
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {

	WebDriver driver;
	String url = "https://www.saucedemo.com/";

	@Before
	public void setUp() {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
	}

	@Test
	public void standardUserLogin() {
			String userName = "standard_user";
			String password = "secret_sauce";

			driver.get(url);
			driver.findElement(By.className("login_logo")).isDisplayed();
			driver.findElement(By.id("user-name")).sendKeys(userName);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("login-button")).click();

			WebElement productPageTitleElement = driver.findElement(By.className("title"));
			String productPageTitle = productPageTitleElement.getText();
			
			String expectedTitle = "Products";
			Assert.assertEquals(expectedTitle, productPageTitle);	

	}  

	@Test
	public void lockedoutUserLogin() {
			String userName = "locked_out_user";
			String password = "secret_sauce";

			driver.get(url);
			driver.findElement(By.className("login_logo")).isDisplayed();
			driver.findElement(By.id("user-name")).sendKeys(userName);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("login-button")).click();

			WebElement errorMessageElement = driver.findElement(By.cssSelector("[data-test='error']"));
			String errorMessage = errorMessageElement.getText();
			System.out.println("Error message: " + errorMessage);

			Assert.assertTrue(errorMessageElement.isDisplayed());
			Assert.assertTrue(errorMessage.contains("Sorry, this user has been locked out"));

	}

	@Test
	public void invalidUserLogin() {
		String userName = "invalid_user";
		String password = "invalid_password";

		driver.get(url);
		driver.findElement(By.className("login_logo")).isDisplayed();
		driver.findElement(By.id("user-name")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();

		WebElement errorMessageElement = driver.findElement(By.cssSelector("[data-test='error']"));
		String errorMessage = errorMessageElement.getText();
		System.out.println("Error message: " + errorMessage);

		Assert.assertTrue(errorMessageElement.isDisplayed());
		Assert.assertTrue(errorMessage.contains("Username and password do not match any user in this service"));
		
	}

	@After
	public void tearDown() {
			if (driver != null) {
					driver.quit();
		}
	}
}
