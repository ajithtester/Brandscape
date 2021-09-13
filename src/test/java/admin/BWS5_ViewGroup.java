package admin;

import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS5_ViewGroup extends BaseClass {

	@Test
	public static void ViewGroup() throws Throwable {


	
		Thread.sleep(4000);
		ExtentReportName("View Group");
		
		List("ViewGroup");
		LogInfo("Searching Group from the list");

		ViewFromList("ViewGroup1", "ViewGroup2", AdminExcel(1, 1, "View Group"));
		LogInfo("Added Group is found and viewed");
		
		ViewAll("ViewAllGroup");
	
		
		TakeScreenshot("\\ViewAllGroups.png");
		
		
	}

	}
	
	
	
	
	
	
	
