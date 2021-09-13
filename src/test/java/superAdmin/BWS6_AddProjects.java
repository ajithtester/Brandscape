package superAdmin;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS6_AddProjects extends BaseClass {

	@Test()
	public static void AddProject() throws Throwable {


		Thread.sleep(5000);
		ExtentReportName("Add Project");
		GetWebElementandClick("ManageProject");
		GetWebElementandClick("AddProject");



		TypeDataInTheElement("ProjectName", SuperAdminExcel(1, 2, "Add Project"));
		LogInfo("Project Name is clicked and value entered as :" + SuperAdminExcel(1, 2, "Add Project"));

		Thread.sleep(2000);

		TypeDataInTheElement("CompanyName", SuperAdminExcel(1, 3, "Add Project"));
		LogInfo("Company Name is clicked and value entered as :" + SuperAdminExcel(1, 3, "Add Project"));
		Thread.sleep(2000);


		TypeDataInTheElement("Admin", SuperAdminExcel(1, 4, "Add Project"));
		LogInfo("Admin is clicked and value entered as :" + SuperAdminExcel(1, 4, "Add Project"));
		Thread.sleep(3000);
		FindElementsandClick("SelectAdmin", SuperAdminExcel(1, 2, "Add Admin"));
		Thread.sleep(2000);


		TypeDataInTheElement("Category", SuperAdminExcel(1, 5, "Add Project"));
		LogInfo("Category is clicked and value entered as :" + SuperAdminExcel(1, 5, "Add Project"));
		Thread.sleep(2000);


		TypeDataInTheElement("Participants", SuperAdminExcel(1, 6, "Add Project"));
		LogInfo("Participants is clicked and value entered as :" + SuperAdminExcel(1, 6, "Add Project"));
		Thread.sleep(2000);


		Thread.sleep(2000);
		GetWebElementandClick("StartCalendar");
		Thread.sleep(2000);
		GetWebElementandClick("Yearpickerbtn");
		Thread.sleep(2000);
		Calendar("StartYearlist", SuperAdminExcel(1, 9, "Add Project"));
		Calendar("StartMonthlist", SuperAdminExcel(2, 9, "Add Project"));
		Calendar("StartDateList", SuperAdminExcel(3, 9, "Add Project"));

		Thread.sleep(2000);
		GetWebElementandClick("EndCalendar");
		Thread.sleep(2000);
		GetWebElementandClick("Yearpickerbtn");
		Thread.sleep(2000);
		Calendar("EndYearlist", SuperAdminExcel(4, 9, "Add Project"));
		Calendar("EndMonthlist", SuperAdminExcel(5, 9, "Add Project"));
		Calendar("EndDateList", SuperAdminExcel(6, 9, "Add Project"));

		Thread.sleep(2000);
		GetWebElementandClick("DemoCalendar");
		Thread.sleep(2000);
		GetWebElementandClick("Yearpickerbtn");
		Thread.sleep(2000);
		Calendar("DemoYearlist", SuperAdminExcel(7, 9, "Add Project"));
		Calendar("DemoMonthlist", SuperAdminExcel(8, 9, "Add Project"));
		Calendar("DemoDateList", SuperAdminExcel(9, 9, "Add Project"));


		Thread.sleep(2000);
		GetWebElementandClick("ReportCalendar");
		Thread.sleep(2000);
		GetWebElementandClick("Yearpickerbtn");
		Thread.sleep(2000);
		Calendar("ReportYearlist", SuperAdminExcel(10, 9, "Add Project"));
		Calendar("ReportMonthlist", SuperAdminExcel(11, 9, "Add Project"));
		Calendar("ReportDateList", SuperAdminExcel(12, 9, "Add Project"));
		LogInfo("Dates are selected");

		DropdownList("Projectcon", SuperAdminExcel(1, 8, "Add Project"));
		LogInfo("Project status is selected as :"+ SuperAdminExcel(1, 8, "Add Project"));

		DropdownList("TypeOfSelect", SuperAdminExcel(1, 7, "Add Project"));
		Thread.sleep(2000);
		LogInfo("Type of study is selected as :"+ SuperAdminExcel(1, 7, "Add Project"));

		Thread.sleep(5000);
		TypeDataInTheElement("UploadBanner", SuperAdminExcel(1, 1, "Add Project"));
		Thread.sleep(2000);
		GetWebElementandClick("ProjectSubmit");
		LogInfo("Submit button clicked");
		
		Thread.sleep(2000);
		WebElement ProjectAddedSuccessfully =	GetWebElement("ProjectAddedSuccessfully");

		//WebElement ProjectAddedSuccessfully =  ExplicitTimeWait("ProjectAddedSuccessfully");

		if(ProjectAddedSuccessfully.isDisplayed()) {
			ConditionPass("Project added successfully");
			LogInfo("Project added successfully");
		}else {
			ConditionFail("Project not added");
			LogInfo("Project not added");
		}
		
		Thread.sleep(2000);
	
		TakeScreenshot("\\AddProject.png");
		
		 Refresh();
	}
}
