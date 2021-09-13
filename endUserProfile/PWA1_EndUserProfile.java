
package endUserProfile;

import org.testng.annotations.Test;

import baseClass.BaseClass;

public class PWA1_EndUserProfile extends BaseClass{


	@Test
	public static void Profile() throws Throwable {

		Thread.sleep(6000);
		ExtentReportName("Profile");

		GetWebElementandClick("PWAMenu");
		LogInfo("User Menu is cicked");

		GetWebElementandClick("PWAProfile");
		LogInfo("PWA profile is cicked");

		Thread.sleep(3000);
		TakeScreenshot("\\ProfileView.png");

		
		Thread.sleep(3000);
		TakeScreenshot("\\ClientProfile.png");
		
		String  PWAUserEmail = 	GetText("PWAUserEmail");
		//String  PWAUserEmail =		PWAUserEmaill.getText();
		PrintOutput(PWAUserEmail);
		if (PWAUserEmail.equalsIgnoreCase(ClientExcel(1, 1, "Profile"))) {
			PrintOutput(ClientExcel(1, 1, "Profile"));
			ConditionPass("Profile Matched");
			LogInfo("Profile Matched");
		}else {
			ConditionFail("Profile not Matched");
			LogInfo("Profile not Matched");
			PrintOutput(ClientExcel(1, 1, "Profile"));
		}
	}
	
}
