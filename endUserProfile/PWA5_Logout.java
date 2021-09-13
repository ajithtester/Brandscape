package endUserProfile;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class PWA5_Logout extends BaseClass {


			@Test
			public static void Logout() throws Throwable {

				Thread.sleep(5000);

				ExtentReportName("Logout");
				
				GetWebElementandClick("PWAMenu");
				LogInfo("User Menu is cicked");
				
				GetWebElementandClick("PwaLogout");
				LogInfo("Logout successfull");
				Thread.sleep(5000);
				WebElement PWAEmail =	GetWebElement("PWAEmail");
				if(PWAEmail.isDisplayed()) {
					
					ConditionPass("Logout successfull");
					LogInfo("Logout successfull");
				}else {
					ConditionFail("Logout Failed");
					LogInfo("Logout Failed");
				}
				
				Thread.sleep(3000);
				TakeScreenshot("\\UserLogout.png");
}
			@AfterTest
			public static void ReportFlush() {
				flush();
			}
}