package admin;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS901_SearchUser extends BaseClass {

	@Test
	public static void SearchUser () throws Throwable {
		Thread.sleep(4000);
		ExtentReportName("Search User");

		TypeDataInTheElement("AdminSearchaUser", AdminExcel(1, 1, "Search User"));
		Thread.sleep(2000);
		TakeScreenshot("\\AdminSearchUser.png");

		List("SearchUserMailID");
		LogInfo("Searching user email from the list");
		Thread.sleep(3000);
		ViewFromList("SearchUserMailID1", "SearchUserMailID2", AdminExcel(1, 1, "Search User"));
		LogInfo("Search user is found and viewed");
		Thread.sleep(2000);
		TakeScreenshot("\\AdminSearchUserFound.png");
		Thread.sleep(3000);
		WebElement AdminCancelSearchUser =  GetWebElementandClick("AdminCancelSearchUser");
		if(AdminCancelSearchUser.isDisplayed()) {
			AdminCancelSearchUser.click();
		}else {
			ConditionFail("Not displayed");
		}
	}}
