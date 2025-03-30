package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
  
  private WebDriver driver;

  public CartPage(WebDriver driver) {
    this.driver = driver;
  }

  public void isCartPageDisplayed() {
    WebElement cartTitle = driver.findElement(By.cssSelector("[data-test='title']"));
    Assert.assertTrue(cartTitle.isDisplayed());
  }

  public void checkout() {
		driver.findElement(By.cssSelector("[data-test='cart-list']")).isDisplayed();
		driver.findElement(By.id("checkout")).click();
  } 

}
