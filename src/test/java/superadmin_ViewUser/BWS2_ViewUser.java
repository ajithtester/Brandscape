package superadmin_ViewUser;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS2_ViewUser extends BaseClass {

	public static class BWS1_Login extends BaseClass {






			@Test
			public static void ViewUser() throws Throwable {
		


			Thread.sleep(4000);
			ExtentReportName("View user");
			

			GetWebElementandClick("Viewuser");
			LogInfo("View user is clicked");

			ViewAll("ViewAllUser");
			WebElement NextButton =		GetWebElement("NextButton");
			if(NextButton.isEnabled()) {
				NextButton.click();
				Thread.sleep(2000);
				//ViewAll("ViewAllUser");
			}Thread.sleep(2000);
			WebElement PreviousButton =		GetWebElement("PreviousButton");
			if(PreviousButton.isEnabled()) {
				PreviousButton.click();
				LogInfo("Previous button is clicked");
			} 
			
			Thread.sleep(2000);
			TakeScreenshot("\\ViewAllUser.png");
		}
	}}
