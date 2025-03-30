package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutSummaryPage {
  
  private WebDriver driver;

  public CheckoutSummaryPage(WebDriver driver)  {
    this.driver = driver;
  }

  public void isCheckoutSummaryPageDisplayed() {
    WebElement checkoutSummaryTitle = driver.findElement(By.cssSelector("[data-test='title']"));
		WebElement checkoutSummaryInfo = driver.findElement(By.id("checkout_summary_container"));
    Assert.assertTrue(checkoutSummaryTitle.isDisplayed());
    Assert.assertTrue(checkoutSummaryInfo.isDisplayed());
  }

  public void getPaymentInfo() {
    WebElement paymentInfoLabelElement = driver.findElement(By.cssSelector("[data-test='payment-info-label']"));
		WebElement paymentInfoValueElement = driver.findElement(By.cssSelector("[data-test='payment-info-value']"));
		String paymentInfoLabel = paymentInfoLabelElement.getText();
		String paymentInfoValue = paymentInfoValueElement.getText();
		System.out.println(paymentInfoLabel + paymentInfoValue);
  }

  public void getShippingInfo() {
    WebElement shippingInfoLabelElement = driver.findElement(By.cssSelector("[data-test='shipping-info-label']"));
		WebElement shippingInfoValueElement = driver.findElement(By.cssSelector("[data-test='shipping-info-value']"));
		String shippingLabel = shippingInfoLabelElement.getText();
		String shippingValue = shippingInfoValueElement.getText();
		System.out.println(shippingLabel + shippingValue);
  }

  public void getPriceTotal() {
    WebElement totalInfoLabelElement = driver.findElement(By.cssSelector("[data-test='total-info-label']"));
		WebElement subTotalLabelElement = driver.findElement(By.cssSelector("[data-test='subtotal-label']"));
		WebElement taxLabelElement = driver.findElement(By.cssSelector("[data-test='tax-label']"));
		WebElement totalLabelElement = driver.findElement(By.cssSelector("[data-test='total-label']"));
		String totalLabel = totalInfoLabelElement.getText();
		String subTotal = subTotalLabelElement.getText();
		String tax = taxLabelElement.getText();
		String total = totalLabelElement.getText();
		System.out.println(totalLabel + subTotal + tax + total);  
  }

  public void finishCheckout() {
    driver.findElement(By.id("finish")).click();
  }

}
