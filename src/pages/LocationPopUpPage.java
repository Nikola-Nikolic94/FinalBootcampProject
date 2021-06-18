package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopUpPage extends BasicPage{

	public LocationPopUpPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getSelectLocation() {
		return driver.findElement(By.className("location-selector"));
	}
	public WebElement getCloseButton() {
		return driver.findElement(By.className("close-btn"));
	}
	public WebElement getKeyword() {
		return driver.findElement(By.id("locality_keyword"));
	}
	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}
	public WebElement getLocationInput() {
		return driver.findElement(By.id("location_id"));
	}
	public WebElement getSubmit() {
		return driver.findElement(By.name("btn_submit"));
	}
	public void openPopUp() {
		getSelectLocation().click();
	}
	public void settingUpLocation(String locationName) {
		getKeyword().click();
		String valueData = getLocationInput().getAttribute("data-value");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1]", getLocationInput(), valueData);
		js.executeScript("arguments[0].click()", getSubmit());
	}
	public void closePopUp() {
		getCloseButton().click();
	}
}
