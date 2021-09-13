package admin;

import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS902_FilterUser extends BaseClass {



	@Test
	public static void FilterUser() throws Throwable {


		Thread.sleep(4000);
		ExtentReportName("Filter User");
	
		GetWebElementandClick("AdminFilterUserButton");

		LogInfo("Filter button is clicked");

		List("AdminFilterSearch");
		LogInfo("Group name is searching");

		ViewAndClick("AdminFilterSearch1", "AdminFilterSearch2", AdminExcel(1, 1, "Filter User"));
		LogInfo("Group name is searched"); 
		Thread.sleep(2000);
		TakeScreenshot("\\FilterUserByGroup.png");
		GetWebElementandClick("AdminUserFilter");
		LogInfo("Group name is filtered");

		Thread.sleep(2000);

		List("AdminFilteredUser");
		LogInfo("Search user from filtered list");

		ViewFromList("AdminFilteredUser1", "AdminFilteredUser2", AdminExcel(1, 1, "Filter User"));
		LogInfo("user is found and viewed");
		Thread.sleep(2000);
		TakeScreenshot("\\UserFilteredByuser.png");

		GetWebElementandClick("AdminFilterUserButton");

		LogInfo("Filter button is clicked");

		GetWebElementandClick("AdminClearFilter");
		LogInfo("Filtered is cleared");




	}
}