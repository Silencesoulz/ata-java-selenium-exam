
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class E2ETest {

	private WebDriver driver;
	private String url = "https://www.saucedemo.com/";
	private LoginPage loginPage;
	private ProductsPage productsPage;
	private CartPage cartPage;

	@Before
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		loginPage = new LoginPage(driver);
		productsPage = new ProductsPage(driver);
		cartPage = new CartPage(driver);
		driver.get(url);
	}

	@Test
	public void testE2E() {
		// Login Page
		loginPage.isLoginPageDisplayed();
		loginPage.login("standard_user", "secret_sauce");

		// Product Page
		productsPage.isProductsPageDisplayed();
		productsPage.sortProductsHighToLow();
		productsPage.addToCart("Sauce Labs Backpack");

		// Cart Page
		cartPage.isCartPageDisplayed();
		cartPage.checkout();

		// Checkout Page
		String firstName = "Kevin";
		String lastName = "Wu";
		String postalCode = "10250";

		driver.findElement(By.cssSelector("[data-test='title']")).isDisplayed();
		driver.findElement(By.id("first-name")).sendKeys(firstName);
		driver.findElement(By.id("last-name")).sendKeys(lastName);
		driver.findElement(By.id("postal-code")).sendKeys(postalCode);
		driver.findElement(By.id("continue")).click();

		// Checkout Summary
		driver.findElement(By.cssSelector("[data-test='title']")).isDisplayed();
		driver.findElement(By.id("checkout_summary_container")).isDisplayed();

		// Payment Information
		WebElement paymentInfoLabelElement = driver.findElement(By.cssSelector("[data-test='payment-info-label']"));
		WebElement paymentInfoValueElement = driver.findElement(By.cssSelector("[data-test='payment-info-value']"));
		String paymentInfoLabel = paymentInfoLabelElement.getText();
		String paymentInfoValue = paymentInfoValueElement.getText();
		System.out.println(paymentInfoLabel + paymentInfoValue);

		// Shipping Information
		WebElement shippingInfoLabelElement = driver.findElement(By.cssSelector("[data-test='shipping-info-label']"));
		WebElement shippingInfoValueElement = driver.findElement(By.cssSelector("[data-test='shipping-info-value']"));
		String shippingLabel = shippingInfoLabelElement.getText();
		String shippingValue = shippingInfoValueElement.getText();
		System.out.println(shippingLabel + shippingValue);

		// Price Total
		WebElement totalInfoLabelElement = driver.findElement(By.cssSelector("[data-test='total-info-label']"));
		WebElement subTotalLabelElement = driver.findElement(By.cssSelector("[data-test='subtotal-label']"));
		WebElement taxLabelElement = driver.findElement(By.cssSelector("[data-test='tax-label']"));
		WebElement totalLabelElement = driver.findElement(By.cssSelector("[data-test='total-label']"));
		String totalLabel = totalInfoLabelElement.getText();
		String subTotal = subTotalLabelElement.getText();
		String tax = taxLabelElement.getText();
		String total = totalLabelElement.getText();
		System.out.println(totalLabel + subTotal + tax + total);

		driver.findElement(By.id("finish")).click();

		// Checkout complete
		driver.findElement(By.cssSelector("[data-test='complete-header']")).isDisplayed();
		driver.findElement(By.cssSelector("[data-test='complete-text']")).isDisplayed();
		driver.findElement(By.id("back-to-products")).click();

		// Back to Products Page
		WebElement inventoryContainerElement = driver.findElement(By.cssSelector("[data-test='inventory-container']"));
		Assert.assertTrue(inventoryContainerElement.isDisplayed());

	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}