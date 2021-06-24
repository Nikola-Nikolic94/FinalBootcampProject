package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MealItemTest extends BasicTest{

	@Test
	public void addMeal() throws InterruptedException {
		driver.get("http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo");
		js.executeScript("arguments[0].click()", popUpPage.getCloseButton());
		mealPage.getAddToCart().click();
		Thread.sleep(1000);
		Assert.assertTrue(notificationPage.getAlertMsgText().contains("The Following Errors Occurred:")); 
		Assert.assertTrue(notificationPage.getAlertMsgText().contains("Please Select Location"));
		notificationPage.waitUntilMsgDisappears();
		popUpPage.settingUpLocation("City Center - Albany");
		Thread.sleep(1000);
		mealPage.getAddToCart().click();
		Thread.sleep(3000);
		assertEquals(notificationPage.getAlertMsgText(), "Meal Added To Cart");
	}
	@Test
	public void addMealToFavourite() throws InterruptedException {
		driver.get("http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo");
		js.executeScript("arguments[0].click()", popUpPage.getCloseButton());
		mealPage.addTogetFavourite();
		Thread.sleep(1000);
		assertEquals(notificationPage.getAlertMsgText(), "Please login first!");
		driver.get(baseURL + "guest-user/login-form");
		loginPage.SignIn(email, password);
		driver.get("http://demo.yo-meals.com/meal/lobster-shrimp-chicken-quesadilla-combo");
		mealPage.addTogetFavourite();
		Thread.sleep(1000);
		assertEquals(notificationPage.getAlertMsgText(), "Product has been added to your favorites.");
		notificationPage.waitUntilMsgDisappears();
		mealPage.addTogetFavourite();
		Thread.sleep(1000);
		assertEquals(notificationPage.getAlertMsgText(), "Product has been removed from your favorites.");	
	}
	@Test
	public void clearCart() throws InterruptedException {
		driver.get("http://demo.yo-meals.com/meals");
		js.executeScript("arguments[0].click()", popUpPage.getCloseButton());
		Thread.sleep(1000);
		popUpPage.settingUpLocation("City Center - Albany");
		sheet = workbook.getSheet("Meals");	
		for(int i = 1; i <= sheet.getLastRowNum(); i++) {
			Thread.sleep(1000);
			driver.get(sheet.getRow(i).getCell(0).getStringCellValue());
			mealPage.addToCart(sheet.getRow(i).getCell(1).getNumericCellValue());
			Thread.sleep(1000);
			softAssert.assertEquals(notificationPage.getAlertMsgText(), "Meal Added To Cart");
		}
		cartSummaryPage.getClearAllBtn().click();
		Thread.sleep(1000);
		assertEquals(notificationPage.getAlertMsgText(), "All meals removed from Cart successfully");
	}
}
