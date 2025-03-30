
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest {

	private WebDriver driver;
	private String url = "https://www.saucedemo.com/";
	private LoginPage loginPage;
	private ProductsPage productsPage;

	@Before
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		loginPage = new LoginPage(driver);
		productsPage = new ProductsPage(driver);
		driver.get(url);
	}

	@Test
	public void standardUserLogin() {
			loginPage.isLoginPageDisplayed();
			loginPage.login("standard_user", "secret_sauce");
			Assert.assertTrue(productsPage.isProductsPageDisplayed());
	}  

	@Test
	public void lockedoutUserLogin() {
			loginPage.isLoginPageDisplayed();
			loginPage.login("locked_out_user", "secret_sauce");
			loginPage.verifyErrorMessage("Sorry, this user has been locked out.");
	}

	@Test
	public void invalidUserLogin() {
		loginPage.isLoginPageDisplayed();
		loginPage.login("invalid_user", "invalid_password");
		loginPage.verifyErrorMessage("Username and password do not match any user in this service");
	}

	@After
	public void tearDown() {
			if (driver != null) {
					driver.quit();
		}
	}
}
