package superAdmin;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS7_ViewProject extends BaseClass {

	
	
	@Test()
	public static void ViewProject() throws Throwable {

	
		Thread.sleep(3000);
		ExtentReportName("View Project");
	
		List("ViewProject");
		LogInfo("Searching project name from the list");
	
		
		ViewFromList("ViewProject1", "ViewProject2", SuperAdminExcel(1, 1, "View Project"));
		LogInfo("Added Project is found and viewed");
		
		Thread.sleep(2000);
		TakeScreenshot("\\ViewProject.png");

		ViewAll("ViewAllProject");
		WebElement NextButton =		GetWebElement("NextButton");
		if(NextButton.isEnabled()) {
			NextButton.click();
			Thread.sleep(2000);
			ViewAll("ViewAllAdmin");
		}
		
		Thread.sleep(2000);
		WebElement PreviousButton =		GetWebElement("Prev");
		if(PreviousButton.isEnabled()) {
			PreviousButton.click();

	}
		 Refresh();
	}
	
}