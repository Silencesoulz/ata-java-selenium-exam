package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage {
  
  private WebDriver driver;

  public CheckoutCompletePage(WebDriver driver) {
    this.driver = driver;
  }

  public void isCheckoutCompletePageDisplayed() {
    WebElement checkoutCompleteHeader = driver.findElement(By.cssSelector("[data-test='complete-header']"));
		WebElement checkoutCompleteBody = driver.findElement(By.cssSelector("[data-test='complete-text']"));
    Assert.assertTrue(checkoutCompleteHeader.isDisplayed());
    Assert.assertTrue(checkoutCompleteBody.isDisplayed());
  }
  
  public void backToHomePage() {
    driver.findElement(By.id("back-to-products")).click();
  }

}
