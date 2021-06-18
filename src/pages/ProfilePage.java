package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BasicPage{
	
	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement getFirstName() {
		return driver.findElement(By.name("user_first_name"));
	}
	public WebElement getLastName() {
		return driver.findElement(By.name("user_last_name"));
	}
	public WebElement getAddress() {
		return driver.findElement(By.name("user_address"));
	}
	public WebElement getPhoneNumber() {
		return driver.findElement(By.name("user_phone"));
	}
	public WebElement getZipCode() {
		return driver.findElement(By.name("user_zip"));
	}
	public WebElement getCountry() {
		return driver.findElement(By.name("user_country_id"));
	}
	public WebElement getState() {
		return driver.findElement(By.name("user_state_id"));
	}
	public WebElement getCity() {
		return driver.findElement(By.name("user_city"));
	}
	public WebElement getSaveBtn() {
		return driver.findElement(By.xpath("//div[@class='row']//input[@name='btn_submit']"));
	}
	public WebElement getUploadBtn() {
		return driver.findElement(By.xpath("//*[@title='Upload']"));
	}
	public WebElement getUpload() {
		js.executeScript("arguments[0].click()", getUploadBtn());
		return driver.findElement(By.xpath("//input[@type='file']"));
	}
	public void uploadPicture(String path) {
		getUpload().sendKeys(path);	
	}
	public void removePicture() {
		WebElement remove = driver.findElement(By.xpath("//*[@title='Remove']"));
		js.executeScript("arguments[0].click()", remove);
	}
	public void settingChangingUserInfo(String firstName,
										String lastName,
										String address,
										String phoneNumber,
										String zipCode,
										String country,
										String state,
										String city) {
		
		getFirstName().sendKeys(firstName);
		getLastName().sendKeys(lastName);
		getAddress().sendKeys(address);
		getPhoneNumber().sendKeys(phoneNumber);
		getZipCode().sendKeys(zipCode);
		getCountry().sendKeys(country);
		getState().sendKeys(state);
		getCity().sendKeys(city);
		getSaveBtn().click();
	}
}
