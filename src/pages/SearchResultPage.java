package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends BasicPage{

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	public List<WebElement> getAllProducts() {
		return driver.findElements(By.xpath("//*[@class='product-name']/a"));
	}
	public List<String> getProductNames() {
		List<String> productNames = new ArrayList<>();
		List<WebElement> products = getAllProducts();
		for(int i = 0; i < products.size(); i++) {
			productNames.add(products.get(i).getText());
		}
		return productNames;
	}
	public int allProductCount() {
		return getAllProducts().size();
	}
}
