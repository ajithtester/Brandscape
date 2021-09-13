package admin;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS903_AddSurvey extends BaseClass {
	
	@Test
	public static void AddSurvey() throws Throwable {
	
		ExtentReportName("AddSurvey");
		Thread.sleep(5000);

		GetWebElementandClick("ManageSurvey");
		GetWebElementandClick("AddSurvey");
		Thread.sleep(5000);
		Thread.sleep(2000);
		TakeScreenshot("\\AddSurveyPage.png");
		
		TypeDataInTheElement("JSON", AdminExcel(1, 2, "Add Survey"));
		LogInfo("Json is entered");
		
		TypeDataInTheElement("SurveyTitle", AdminExcel(1, 1, "Add Survey"));
		LogInfo("Survey Title is entered as : "+ AdminExcel(1, 1, "Add Survey"));
		Thread.sleep(5000);
		
		GetWebElementandClick("Savesurvey");
		LogInfo("Save survey button is clicked");
		WebElement Surveycreatedsuccessfully =	GetWebElement("Surveycreatedsuccessfully");

		Thread.sleep(3000);

		if(Surveycreatedsuccessfully.isDisplayed()) {
			ConditionPass("Survey added successfully");
			LogInfo("Survey added successfully");
		}else {
			ConditionFail("Survey not added");
			LogInfo("Survey not added");
		}
		
		Thread.sleep(2000);
		TakeScreenshot("\\SurveyAdded.png");



	}
}

