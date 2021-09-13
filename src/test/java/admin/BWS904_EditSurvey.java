package admin;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS904_EditSurvey extends BaseClass{

	@Test()
	public static void EditSurvey() throws Throwable {
		Thread.sleep(4000);
		ExtentReportName("Edit Survey");

		List("SurveyEdit");
		LogInfo("Searching survey from the list");

		EditFromList("SurveyEdit1", "SurveyEdit2", "SurveyEdit3", "SurveyEdit4", AdminExcel(1, 1, "Edit Survey"));
		LogInfo("Edit button is clicked");

		Thread.sleep(2000);
		TakeScreenshot("\\EditSurveyPage.png");

		GetWebElement("SurveyNameEdit").clear();
		LogInfo("Survey name is clicked and values are cleared");

		TypeDataInTheElement("SurveyNameEdit", AdminExcel(1, 2, "Edit Survey"));
		LogInfo("Survey name is edited");

		TryandClick("SurveyEditSave");
		LogInfo("Save button is clicked");


		WebElement SurveyUpdatedSuccessfully =	GetWebElement("SurveyUpdatedSuccessfully");

		Thread.sleep(3000);

		if(SurveyUpdatedSuccessfully.isDisplayed()) {
			ConditionPass("Survey edited successfully");
			LogInfo("Survey edited successfully");
		}else {
			ConditionFail("Survey not edited");
			LogInfo("Survey not edited");
		}
		Thread.sleep(2000);
		TakeScreenshot("\\SurveyEdited.png");
	}
}
