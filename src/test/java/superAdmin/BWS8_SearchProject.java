package superAdmin;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS8_SearchProject extends BaseClass {



	@Test()
	public static void SearchProject() throws Throwable {

		Thread.sleep(4000);  
	
		ExtentReportName("Search Project");
		
		TypeDataInTheElement("SearchProject", SuperAdminExcel(1, 1, "Search Project"));
		Thread.sleep(2000);
		TakeScreenshot("\\SearchProject.png");

		List("SearchProjectName");
		LogInfo("Searching admin email from the list");
		Thread.sleep(3000);
		ViewFromList("SearchProjectName1", "SearchProjectName2", SuperAdminExcel(1, 1, "Search Project"));
		LogInfo("Search admin is found and viewed");
		
		
		Thread.sleep(2000);
		TakeScreenshot("\\SearchProject.png");

		Thread.sleep(10000);
		WebElement CancelSearch =  GetWebElementandClick("CancelProjectSearch");
		if(CancelSearch.isDisplayed()) {
			CancelSearch.click();
			LogInfo("X button is clicked");
		}else {
			ConditionFail("Not displayed");
			LogInfo("X button not displaye");
		}
	}}
