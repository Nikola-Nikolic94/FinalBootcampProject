package tests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest{

	@Test
	public void editProfile() throws InterruptedException {
		driver.get(baseURL + "guest-user/login-form");
		js.executeScript("arguments[0].click()", popUpPage.getCloseButton());
		loginPage.SignIn(email, password);
		assertEquals(notificationPage.getAlertMsgText(), "Login Successfull");
		driver.navigate().to(baseURL + "member/profile");
		profilePage.settingChangingUserInfo("John", "Doe", "someAddress", "123-456", "456", "United States", "Nevada", "Las Vegas");
		Thread.sleep(500);
		assertEquals(notificationPage.getAlertMsgText(), "Setup Successful");
		authPage.Logout();
		Thread.sleep(3000);
		assertEquals(notificationPage.getAlertMsgText(), "Logout Successfull!");
	}
	
	@Test
	public void changeProfileImage() throws InterruptedException, IOException {
		driver.get(baseURL + "guest-user/login-form");
		js.executeScript("arguments[0].click()", popUpPage.getCloseButton());
		loginPage.SignIn(email, password);
		assertEquals(notificationPage.getAlertMsgText(), "Login Successfull");
		driver.get(baseURL + "member/profile");
		String imgPath = new File("./img/WR.jpg").getCanonicalPath();
		profilePage.uploadPicture(imgPath);
		Thread.sleep(3000);
		assertEquals(profilePage.getAlertMsgText(), "Profile Image Uploaded Successfully");
		notificationPage.waitUntilMsgDisappears();
		profilePage.removePicture();
		Thread.sleep(3000);
		assertEquals(profilePage.getAlertMsgText(), "Profile Image Deleted Successfully");
		notificationPage.waitUntilMsgDisappears();
		authPage.Logout();
		Thread.sleep(3000);
		assertEquals(notificationPage.getAlertMsgText(), "Logout Successfull!");
	}
}
