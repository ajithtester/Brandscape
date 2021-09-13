package admin;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS8_ViewUser extends BaseClass {

	@Test
	public static void ViewUser () throws Throwable {
	
		Thread.sleep(4000);
		ExtentReportName("View User");
		GetWebElementandClick("ManageUser");
		Thread.sleep(2000);
		TakeScreenshot("\\ViewManageUsers.png");
		
		List("AdminViewUserMail");
		LogInfo("Searching user email from the list");

		ViewFromList("AdminViewUserMail1", "AdminViewUserMail2", AdminExcel(1, 1, "View User"));
		LogInfo("Added user is found and viewed");
		
		ViewAll("AdminViewAllUsers");
		WebElement NextButton =		GetWebElement("NextButton");

		if(NextButton.isEnabled()) {
			NextButton.click();
			LogInfo("Next button is clicked");
			Thread.sleep(2000);
			ViewAll("ViewAllAdmin");
		} 
		LogInfo("All Added admin is viewed");

		WebElement PreviousButton =		GetWebElement("PreviousButton");
		if(PreviousButton.isEnabled()) {
			PreviousButton.click();
			LogInfo("Previous button is clicked");
		} 
		Thread.sleep(2000);
		TakeScreenshot("\\ViewAllManageUsers.png");

}
}