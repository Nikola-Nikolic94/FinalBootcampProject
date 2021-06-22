package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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
	public Select getCountry() {
		return new Select (driver.findElement(By.name("user_country_id")));
	}
	public Select getState() {
		return new Select (driver.findElement(By.name("user_state_id")));
	}
	public Select getCity() {
		return new Select (driver.findElement(By.name("user_city")));
	}
	public WebElement getSaveBtn() {
		return driver.findElement(By.xpath("//div[@class='row']//input[@name='btn_submit']"));
	}
	public void uploadPicture(String path) throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.className("avatar"));
		action.moveToElement(we).build().perform();
		Thread.sleep(1000);
		WebElement btn = driver.findElement(By.xpath("//a[@title='Uplaod']"));
		js.executeScript("arguments[0].click()", btn);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(path);
		
	}
	public void removePicture() {
		WebElement remove = driver.findElement(By.xpath("//*[@title='Remove']"));
		js.executeScript("arguments[0].click()", remove);
	}
	public String getAlertMsgText() {
		return driver.findElement(By.className("content")).getText();
	}
	public void settingChangingUserInfo(String firstName,
										String lastName,
										String address,
										String phoneNumber,
										String zipCode,
										String country,
										String state,
										String city) throws InterruptedException {
		getFirstName().clear();
		getFirstName().sendKeys(firstName);
		getLastName().clear();
		getLastName().sendKeys(lastName);
		getAddress().clear();
		getAddress().sendKeys(address);
		getPhoneNumber().clear();
		getPhoneNumber().sendKeys(phoneNumber);
		getZipCode().clear();
		getZipCode().sendKeys(zipCode);
		getCountry().selectByVisibleText(country);
		Thread.sleep(1000);
		getState().selectByVisibleText(state);
		Thread.sleep(1000);
		getCity().selectByVisibleText(city);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click()", getSaveBtn());
	}
}
