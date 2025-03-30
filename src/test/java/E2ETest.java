
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutPage;
import pages.CheckoutSummaryPage;
import pages.LoginPage;
import pages.ProductsPage;

public class E2ETest {

	private WebDriver driver;
	private String url = "https://www.saucedemo.com/";
	private LoginPage loginPage;
	private ProductsPage productsPage;
	private CartPage cartPage;
	private CheckoutPage checkoutPage;
	private CheckoutSummaryPage checkoutSummaryPage;
	private CheckoutCompletePage checkoutCompletePage;

	@Before
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		loginPage = new LoginPage(driver);
		productsPage = new ProductsPage(driver);
		cartPage = new CartPage(driver);
		checkoutPage = new CheckoutPage(driver);
		checkoutSummaryPage = new CheckoutSummaryPage(driver);
		checkoutCompletePage = new CheckoutCompletePage(driver);
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
		checkoutPage.isCheckoutPageDisplayed();
		checkoutPage.fillCheckoutForm("Kevin", "Wu", "10260");
		checkoutPage.continueCheckout();

		// Checkout Summary
		checkoutSummaryPage.isCheckoutSummaryPageDisplayed();
		checkoutSummaryPage.getPaymentInfo();
		checkoutSummaryPage.getShippingInfo();
		checkoutSummaryPage.getPriceTotal();
		checkoutSummaryPage.finishCheckout();

		// Checkout complete
		checkoutCompletePage.isCheckoutCompletePageDisplayed();
		checkoutCompletePage.backToHomePage();

		// Redirect back to products page
		productsPage.isProductsPageDisplayed();

	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}