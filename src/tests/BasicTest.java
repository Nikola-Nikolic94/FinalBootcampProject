package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopUpPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;
import pages.SearchResultPage;


public abstract class BasicTest {

	protected WebDriver driver;
	protected String baseURL = "http://demo.yo-meals.com/";
	protected String email = "customer@dummyid.com";
	protected String password = "12345678a";
	protected LocationPopUpPage popUpPage;
	protected LoginPage loginPage;
	protected NotificationSystemPage notificationPage;
	protected ProfilePage profilePage;
	protected AuthPage authPage;
	protected MealPage mealPage;
	protected CartSummaryPage cartSummaryPage;
	protected SearchResultPage searchResultPage;
	
	@BeforeMethod
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver= new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		popUpPage = new LocationPopUpPage(driver);
		loginPage = new LoginPage(driver);
		notificationPage = new NotificationSystemPage(driver);
		profilePage = new ProfilePage(driver);
		authPage = new AuthPage(driver);
		mealPage = new MealPage(driver);
		cartSummaryPage = new CartSummaryPage(driver);
		searchResultPage = new SearchResultPage(driver);
	}
	
	@AfterMethod
	public void cleanup() {
		//driver.close();
	}
}
