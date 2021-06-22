package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	protected WebDriverWait wait;
	protected JavascriptExecutor js;
	protected File file;
	protected FileInputStream fis;
	protected XSSFWorkbook workbook;
	protected XSSFSheet sheet;
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
	public void setup() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver= new ChromeDriver();
		this.js = (JavascriptExecutor)driver;
		this.wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		this.file = new File("./data/FirstDataForm.xlsx");
		this.fis = new FileInputStream(file);
		this.workbook = new XSSFWorkbook(fis);
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
