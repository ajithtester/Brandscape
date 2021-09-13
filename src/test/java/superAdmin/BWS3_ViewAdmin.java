package superAdmin;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS3_ViewAdmin extends BaseClass {

	@Test
	public static void ViewAdmin() throws Throwable {

		Thread.sleep(4000);
		ExtentReportName("View Admin");

		List("AdminMail");
		LogInfo("Searching admin email from the list");

		ViewFromList("ViewAdmin1", "ViewAdmin2", SuperAdminExcel(1, 1, "View Admin"));
		LogInfo("Added admin is found and viewed");

		Thread.sleep(2000);
		TakeScreenshot("\\ViewAdmin.png");


		ViewAll("ViewAllAdmin");
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
		TakeScreenshot("\\ViewAllAdmin.png");

	}
}