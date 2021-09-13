package superAdmin;

import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS9_FilterProject extends BaseClass {





	@Test()
	public static void FilterProject() throws Throwable {



		Thread.sleep(4000);
		ExtentReportName("Filter Project");
		
		GetWebElementandClick("ProjectFilterButton");

		LogInfo("Filter button is clicked");

		List("ProjectStatus");
		LogInfo("Project status is searching");

		ViewAndClick("ProjectStatus1", "ProjectStatus2", SuperAdminExcel(1, 1, "Filter Project"));
		LogInfo("Project status is filtered"); 

		Thread.sleep(2000);
		TakeScreenshot("\\ProjectFilter.png");
		
		GetWebElementandClick("Filter");
		LogInfo("Project is filtered");

		
		Thread.sleep(3000);

		List("FilteredProject");
		LogInfo("Search project from filtered list");

		FilteredProject("FilteredProject1", "FilteredProject2", "ProjectName1", "ProjectName2", SuperAdminExcel(1, 1, "Filter Project"));
		LogInfo("Project is filters based on status : "+ SuperAdminExcel(1, 1, "Filter Project") );

		Thread.sleep(2000);
		TakeScreenshot("\\FilterProject.png");
	

		GetWebElementandClick("ClearFilter");
		LogInfo("Filtered is cleared");


	}
}