package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthPage extends BasicPage{

	public AuthPage(WebDriver driver) {
		super(driver);
	}
	public WebElement getLogoutDropDown() {
		return driver.findElement(By.className("accounts-link"));
	}
	public WebElement getLogoutBtn() {
		return driver.findElement(By.xpath("//div[@class='my-account-dropdown']/ul/li[2]"));
	}
	public void Logout() {
		getLogoutDropDown().click();
		getLogoutBtn().click();
	}
}
