package superAdmin;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS2_AddAdmin extends BaseClass {

	@Test()
	public static void AddAdmin() throws Throwable {

Thread.sleep(3000);
		ExtentReportName("Add Admin");

		GetWebElementandClick("ManageAdmin");
		LogInfo("Manage admin is clicked");

		GetWebElementandClick("AddAdmin");
		LogInfo("Add admin is clicked");


		TypeDataInTheElement("AdminName", SuperAdminExcel(1, 1, "Add Admin"));
		LogInfo("Admin name is entered as : " + SuperAdminExcel(1, 1, "Add Admin"));

		TypeDataInTheElement("AdminEmail", SuperAdminExcel(1, 2, "Add Admin"));
		LogInfo("Admin email is entered as : " + SuperAdminExcel(1, 2, "Add Admin"));

		GetWebElementandClick("Save");
		LogInfo("Save is clicked");

		WebElement AdminAddedSuccessfully =	GetWebElement("AdminAddedSuccessfully");

		Thread.sleep(3000);

		if(AdminAddedSuccessfully.isDisplayed()) {
			ConditionPass("Admin added successfully");
			LogInfo("Admin added successfully");
		}else {
			ConditionFail("Admin not added");
			LogInfo("Admin not added");
		}
		
		Thread.sleep(2000);
		TakeScreenshot("\\AddAdmin1.png");

	}
}
