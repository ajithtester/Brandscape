package admin;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS3_AddUser extends BaseClass {
	@Test
	public static void AddUser() throws Throwable {
	
		ExtentReportName("Add User");

		GetWebElementandClick("ManageUser");
		LogInfo("Manage user is clicked");

		GetWebElementandClick("AddUser");
		LogInfo("Add user is clicked");

		Thread.sleep(2000);
		TakeScreenshot("\\AddUserPage");
		
		Random("Userid");
		
//		TypeDataInTheElement("Userid", AdminExcel(1, 1, "Add User"));
//		LogInfo("Userid is entered as : " + AdminExcel(1, 1, "Add User"));
		System.err.println(AdminExcel(1, 1, "Add User"));

		TypeDataInTheElement("UserName", AdminExcel(1, 2, "Add User"));
		LogInfo("UserName is entered as : " + AdminExcel(1, 2, "Add User"));
		
		Thread.sleep(3000);
		GetWebElementandClick("Code");
		LogInfo("Phone number code is selected");

		TypeDataInTheElement("SearchCountry", AdminExcel(1, 3, "Add User"));
		LogInfo("In is typed in search country");

		GetWebElementandClick("Country");
		LogInfo("India is selected");

		TypeDataInTheElement("PhoneNumber", AdminExcel(1, 4, "Add User"));
		System.err.println(AdminExcel(1, 4, "Add User"));
		LogInfo("Phone number is typed as : " + AdminExcel(1, 4, "Add User") );

		Thread.sleep(3000);
		RobotClass();
		Calendar("selectuserrole", "user");

		TypeDataInTheElement("UserEmail", AdminExcel(1, 5, "Add User"));
		LogInfo("Phone number is typed as : " +  AdminExcel(1, 5, "Add User"));

		Thread.sleep(5000);

		GetWebElementandClick("SaveUser");
		
		WebElement UserAddedSuccessfully =	GetWebElement("UserAddedSuccessfully");

		Thread.sleep(3000);

		if(UserAddedSuccessfully.isDisplayed()) {
			ConditionPass("User added successfully");
			LogInfo("User added successfully");
		}else {
			ConditionFail("User not added");
			LogInfo("AdUsermin not added");
		}
		
		Thread.sleep(2000);
		TakeScreenshot("\\AddUser.png");

	}


	

	
}
