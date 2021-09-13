package endUserProfile;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class PWA2_EndUserEditProfile extends BaseClass {

	@Test
	public static void EditProfile() throws Throwable {
	
		Thread.sleep(5000);

		ExtentReportName("Edit Profile");


		GetWebElementandClick("PwaEditProfile");
		LogInfo("Pwa Edit Profile is clicked");
		
		WebElement PwaEditProfileName =  GetWebElement("PwaEditProfileName");
		PwaEditProfileName.clear();
		LogInfo("Profile name is cleared");
		
		TypeInput(PwaEditProfileName, EndUserExcel(1, 1, "Edit Profile"));
		LogInfo("Profile name is entered as : "+ EndUserExcel(1, 1, "Edit Profile"));
		
		GetWebElementandClick("PwaSaveUser");
		LogInfo("Save button is clicked");
		Thread.sleep(3000);

		WebElement PwaEditSuccessfull=		GetWebElement("PwaEditSuccessfull");
		if(PwaEditSuccessfull.isDisplayed()) {
			PwaEditSuccessfull.click();
			ConditionPass("Profile edited successfully");
			LogInfo("Profile edited successfully");
		}else{
			ConditionFail("Profile not edited");
			LogInfo("Profile not edited");
		}
		Thread.sleep(3000);
		TakeScreenshot("\\ClientProfileEdited.png");
		
		GetWebElementandClick("PWABackProfile");
		LogInfo("Back button is clicked");



	}
}
