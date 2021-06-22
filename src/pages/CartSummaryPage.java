package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartSummaryPage extends BasicPage{

	public CartSummaryPage(WebDriver driver) {
		super(driver);
	}
	public WebElement getClearAllBtn() {
		return driver.findElement(By.xpath("//a[normalize-space()='Clear All']"));
	}
	public void clearAllFromCart() {
		getClearAllBtn().click();
	}
}
