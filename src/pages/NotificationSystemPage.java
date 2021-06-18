package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage extends BasicPage{

	public NotificationSystemPage(WebDriver driver) {
		super(driver);
	}
	public WebElement getAlertMsg() {
		return driver.findElement(By.xpath("//*[contains(@class,'system_message')]"));
	}
	public String getAlertMsgText() {
		return getAlertMsg().getText();
	}
	public void waitUntilMsgDisappears() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.attributeContains(getAlertMsg(), "style", "display:none"));
	}
}
