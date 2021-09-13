package admin;

import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS2_SelectProject extends BaseClass {


	@Test
	public static void ProjectSurvey() throws Throwable {

		ExtentReportName("Select Project");
		Thread.sleep(2000);

		GetWebElementandClick("SelectProject");
		LinkText(AdminExcel(1, 1, "Select Project"));
		LogInfo("Project is selected as : "+ AdminExcel(1, 1, "Select Project") );
		Thread.sleep(2000);
		TakeScreenshot("\\ProjectSelected");


	}
}
