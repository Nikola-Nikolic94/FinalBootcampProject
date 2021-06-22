package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MealPage extends BasicPage{

	public MealPage(WebDriver driver) {
		super(driver);
	}
	public WebElement getAddToCart() {
		return driver.findElement(By.xpath("//a[normalize-space()='Add To Cart']"));
	}
	public WebElement getQuantity() {
		return driver.findElement(By.name("product_qty"));
	}
	public WebElement getFavourite() {
		return driver.findElement(By.className("favourite"));
	}
	public void addToCart(double quantity) {
		js.executeScript("arguments[0].value=arguments[1]", getQuantity(), quantity);
		getAddToCart().click();
	}
	public void addTogetFavourite() {
		getFavourite().click();
	}
}
