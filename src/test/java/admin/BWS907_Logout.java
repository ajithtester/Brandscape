package admin;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS907_Logout extends BaseClass {


	@Test()
	public static void Logout() throws Throwable {

		Thread.sleep(3000);
		ExtentReportName("Logout");

		GetWebElementandClick("AdminProfileButton");
		LogInfo("Profile button is clicked");



		GetWebElementandClick("Logout");
		LogInfo("Logout is clicked");

		WebElement Email =	GetWebElement("Email");

		Thread.sleep(3000);

		if(Email.isDisplayed()) {
			ConditionPass("Logout successfully");
			LogInfo("Logout successfully");
		}else {
			ConditionFail("Logout not edited");
			LogInfo("Logout not edited");
		}
		Thread.sleep(2000);
		TakeScreenshot("\\Logout.png");
	}

	@AfterTest
	public static void ReportFlush() {
		flush();
	}
}
