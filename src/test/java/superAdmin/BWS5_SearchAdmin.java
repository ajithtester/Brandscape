package superAdmin;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS5_SearchAdmin extends BaseClass {



	@Test()
	public static void Login() throws Throwable {


		ExtentReportName("Search Admin");
		Thread.sleep(4000);

		TypeDataInTheElement("SearchAdmin", SuperAdminExcel(1, 1, "Search Admin"));
		Thread.sleep(2000);
		TakeScreenshot("\\SearchAdmin.png");

		List("SearchAdminMailID");
		LogInfo("Searching admin email from the list");
		Thread.sleep(3000);
		ViewFromList("SearchAdmin1", "SearchAdmin2", SuperAdminExcel(1, 1, "Search Admin"));
		LogInfo("Search admin is found and viewed");

		Thread.sleep(3000);
		WebElement CancelSearch =  GetWebElementandClick("CancelSearch");
		if(CancelSearch.isDisplayed()) {
			CancelSearch.click();
			LogInfo("X button is clicked");
		}else {
			ConditionFail("Not displayed");
			LogInfo("X button not displayed");
		}
		
		Thread.sleep(2000);
		TakeScreenshot("\\SearchAdmin.png");
	}}
