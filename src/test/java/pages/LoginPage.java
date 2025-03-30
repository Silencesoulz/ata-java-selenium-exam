package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
  
  private WebDriver driver;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  public void isLoginPageDisplayed() {
    driver.findElement(By.className("login_logo")).isDisplayed();
  }

  public void login(String userName, String password) {
		driver.findElement(By.id("user-name")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
  }

  public void verifyErrorMessage(String errorMessage) {
    WebElement errorMessageElement = driver.findElement(By.cssSelector("[data-test='error']"));
		String getErrorMessage = errorMessageElement.getText();
		System.out.println("Error message: " + getErrorMessage);

    Assert.assertTrue(errorMessageElement.isDisplayed());
		Assert.assertTrue(getErrorMessage.contains(errorMessage));
  }

}
