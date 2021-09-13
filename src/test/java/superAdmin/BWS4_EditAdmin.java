package superAdmin;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS4_EditAdmin extends BaseClass{

	@Test


	public static void EditAdmin() throws Throwable {
		Thread.sleep(4000);
		ExtentReportName("Edit Admin");

		List("AdminEdit");
		LogInfo("Searching admin email from the list");

		EditFromList("AdminEdit1", "AdminEdit2", "AdminEdit3", "AdminEdit4", SuperAdminExcel(1, 1, "Edit Admin"));
		LogInfo("Edit button is clicked");

		Thread.sleep(2000);
		TakeScreenshot("\\ClearAdmin.png");
		
		Thread.sleep(4000);
		GetWebElement("AdminNameEdit").clear();
		LogInfo("Admin name is clicked and values are cleared");
		
	

		TypeDataInTheElement("AdminNameEdit", SuperAdminExcel(1, 2, "Edit Admin"));
		LogInfo("Admin name is edited");
		Thread.sleep(2000);
		TakeScreenshot("\\AdminName.png");

		TryandClick("AdminSave");
		LogInfo("Save button is clicked");


		WebElement AdminEditSave =	GetWebElement("AdminEditSave");

		Thread.sleep(3000);

		if(AdminEditSave.isDisplayed()) {
			ConditionPass("Admin edited successfully");
			LogInfo("Admin edited successfully");
		}else {
			ConditionFail("Admin not edited");
			LogInfo("Admin not edited");
		}

		Thread.sleep(2000);
		TakeScreenshot("\\EditAdmin.png");
	}
}
