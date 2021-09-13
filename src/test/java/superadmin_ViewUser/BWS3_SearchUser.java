package superadmin_ViewUser;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS3_SearchUser extends BaseClass {
 @Test
	public static void SearchUser () throws Throwable {


	Thread.sleep(4000);
	ExtentReportName("Search User");


	Thread.sleep(4000);
	TypeDataInTheElement("SearchViewUser", SuperAdminExcel(1, 1, "Search User"));
	Thread.sleep(2000);
	TakeScreenshot("\\SearchViewUser.png");

	List("SearchUserMail");
	LogInfo("Searching admin email from the list");
	
	Thread.sleep(3000);
	
	ViewFromList("SearchUserMail1", "SearchUserMail2", SuperAdminExcel(1, 1, "Search User"));
	LogInfo("Search admin is found and viewed");
	Thread.sleep(2000);
	TakeScreenshot("\\SearchViewUsers.png");
	Thread.sleep(2000);

	WebElement CancelUserSearch =  GetWebElementandClick("CancelUserSearch");
	if(CancelUserSearch.isDisplayed()) {
		CancelUserSearch.click();
	}else {
		ConditionFail("Not displayed");
	}
}}
