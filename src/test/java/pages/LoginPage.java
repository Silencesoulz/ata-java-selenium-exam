package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

}
