package superadmin_ViewUser;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS4_FilterUser extends BaseClass {


	@Test
	public static void FilterUser() throws Throwable {
	

	
		Thread.sleep(4000);
		ExtentReportName("Filter User");


		GetWebElementandClick("UserFilterButton");

		LogInfo("Filter button is clicked");
		
		Thread.sleep(2000);
		TakeScreenshot("\\Filter.png");

		List("FilterGroup");
		LogInfo("Group name is searching");

		ViewAndClick("FilterGroup1", "FilterGroup2", SuperAdminExcel(1, 1, "Filter user"));
		LogInfo("Group name is searched"); 

		GetWebElementandClick("UserFilter");
		LogInfo("Group name is filtered");
		Thread.sleep(2000);
		TakeScreenshot("\\UserFiltered.png");

		List("FilteredUser");
		LogInfo("Search user from filtered list");

		ViewFromList("FilteredUser1", "FilteredUser2", SuperAdminExcel(1, 2, "Filter user"));
		LogInfo("User is found and viewed");


		GetWebElementandClick("UserFilterButton");

		LogInfo("Filter button is clicked");

		GetWebElementandClick("UserClearFilter");
		LogInfo("Filtered is cleared");

	}
	

	@AfterTest
	public static void ReportFlush() {
		flush();
	}
	}
