package tests;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class SearchTest extends BasicTest{

	@Test
	public void searchResult() throws InterruptedException {
		driver.get("http://demo.yo-meals.com/meals");
		js.executeScript("arguments[0].click()", popUpPage.getCloseButton());
		Thread.sleep(1000);
		popUpPage.settingUpLocation("City Center - Albany");
		sheet = workbook.getSheet("Meal Search Results");
		for(int i = 1; i < 7; i++) {
			Thread.sleep(1000);
			driver.get(sheet.getRow(i).getCell(1).getStringCellValue());
			popUpPage.settingUpLocation(sheet.getRow(i).getCell(0).getStringCellValue());
			Thread.sleep(1000);
			int numberOfResults = (int) sheet.getRow(i).getCell(2).getNumericCellValue();		
			assertEquals(searchResultPage.allProductCount(), numberOfResults);
			List<String> sheetProducts = new ArrayList<>();
			for(int j = 3; j < 3 + numberOfResults; j++) {				
				sheetProducts.add(sheet.getRow(i).getCell(j).getStringCellValue());
			}
			List<String> names = searchResultPage.getProductNames();
			for(int j = 0; j < sheetProducts.size(); j++) {
				softAssert.assertEquals(names.get(j), sheetProducts.get(j));
			}		
		}
	}
}
