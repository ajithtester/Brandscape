package admin;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS903_ViewSurvey extends BaseClass {


	@Test()
	public static void ViewSurvey() throws Throwable {

	
		Thread.sleep(3000);
		
		ExtentReportName("View Survey");

		List("ViewadminSurvey");
		LogInfo("Searching project name from the list");
	
		
		ViewFromList("ViewadminSurvey1", "ViewadminSurvey2", AdminExcel(1, 1, "View Survey"));
		LogInfo("Added survey is found and viewed");

		
		ViewAll("ViewAllSurvey");
		WebElement NextButton =		GetWebElement("NextButton");
		if(NextButton.isEnabled()) {
			NextButton.click();
			Thread.sleep(2000);
			ViewAll("ViewAllSurvey");
			
			WebElement PreviousButton =		GetWebElement("PreviousButton");
			if(PreviousButton.isEnabled()) {
				PreviousButton.click();
				ViewAll("ViewAllSurvey");
				LogInfo("Previous button is clicked");
			} 
		Thread.sleep(2000);
		TakeScreenshot("\\ViewSurvey.png");
	}


	}
}