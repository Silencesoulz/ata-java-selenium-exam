package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {

  private WebDriver driver;
  
  public ProductsPage(WebDriver driver) {
    this.driver = driver;
  }

  public void isProductsPageDisplayed() {
    WebElement productsTitle = driver.findElement(By.cssSelector("[data-test='title']"));
    Assert.assertTrue(productsTitle.isDisplayed());
  }

  public void sortProductsHighToLow() {
		driver.findElement(By.cssSelector("[data-test='product-sort-container']")).click();
    driver.findElement(By.cssSelector("option[value='hilo']")).click();
  }

  public void addToCart(String item) {
    String itemLocator = "add-to-cart" + "-" + item.toLowerCase().replace(" ", "-");
    System.out.println(itemLocator);
    driver.findElement(By.id(itemLocator)).click();
		driver.findElement(By.cssSelector("[data-test='shopping-cart-badge']")).isDisplayed();
		driver.findElement(By.id("shopping_cart_container")).click();
  }

}
