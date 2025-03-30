package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckoutPage {
  
  private WebDriver driver;

  public CheckoutPage(WebDriver driver) {
    this.driver = driver;
  }

  public void isCheckoutPageDisplayed() {
    WebElement checkoutTitle = driver.findElement(By.cssSelector("[data-test='title']"));
    Assert.assertTrue(checkoutTitle.isDisplayed());
  }

  public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
    driver.findElement(By.id("first-name")).sendKeys(firstName);
		driver.findElement(By.id("last-name")).sendKeys(lastName);
		driver.findElement(By.id("postal-code")).sendKeys(postalCode);
  }

  public void continueCheckout() {
    driver.findElement(By.id("continue")).click();
  }
}
