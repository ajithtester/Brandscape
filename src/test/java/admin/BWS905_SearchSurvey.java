package admin;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS905_SearchSurvey extends BaseClass {



	@Test()
	public static void SearchSurvey() throws Throwable {


		ExtentReportName("Search Survey");
		
	
		Thread.sleep(4000);  
		TypeDataInTheElement("SearchSurvey", AdminExcel(1, 1, "Search Survey"));

		Thread.sleep(2000);
		TakeScreenshot("\\SearchSurvey.png");


		List("SurveyName");
		LogInfo("Searching survey name from the list");
		Thread.sleep(3000);
		ViewFromList("SurveyName1", "SurveyName2",  AdminExcel(1, 1, "Search Survey"));
		LogInfo("Search survey is found and viewed");




		Thread.sleep(3000);
		WebElement CancelSearch =  GetWebElementandClick("CancelSurveySearch");
		if(CancelSearch.isDisplayed()) {
			CancelSearch.click();
		}else {
			ConditionFail("Not displayed");
		}

		Thread.sleep(2000);
		TakeScreenshot("\\SurveySearched.png");

	}
}
