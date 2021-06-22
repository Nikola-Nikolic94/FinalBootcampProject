package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasicPage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	public WebElement getUsername() {
		return driver.findElement(By.name("username"));
	}
	public WebElement getPassword() {
		return driver.findElement(By.name("password"));
	}
	public WebElement getSubmit() {
		return driver.findElement(By.name("btn_submit"));
	}
	public void SignIn(String email, String password) throws InterruptedException {
		getUsername().clear();
		getPassword().clear();
		getUsername().sendKeys(email);
		getPassword().sendKeys(password);
		Thread.sleep(2000);
		getSubmit().click();
	}
}
