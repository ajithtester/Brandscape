package admin;

import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS906_AdminMessage  extends BaseClass {



	@Test()
	public static void AdminMessage() throws Throwable {

		Thread.sleep(3000);
		ExtentReportName("Admin Message");
		GetWebElementandClick("AdminTextMessage");
		LogInfo("Message is clicked");
		
		GetWebElementandClick("Dropdown");
		Thread.sleep(2000);
		
		LinkText(AdminExcel(1, 1, "Admin Inbox"));
		LogInfo(AdminExcel(1, 1, "Admin Inbox")+ "Is selected");
		Thread.sleep(3000);
		
		TypeDataInTheElement("SearchUserToMessage", AdminExcel(1, 3, "Admin Inbox"));	
		Calendar("SelectUserFromList", AdminExcel(1, 3, "Admin Inbox"));
		LogInfo(AdminExcel(1, 3, "Admin Inbox") + "Is selected");
		Thread.sleep(3000);
		
		TypeDataInTheElement("TypeMessage", AdminExcel(1, 4, "Admin Inbox"));
		LogInfo("Message is sent as : "+ AdminExcel(1, 4, "Admin Inbox"));
	
		GetWebElementandClick("SendMessage");
		LogInfo("Send Button is clicked");
		Thread.sleep(5000);
		TakeScreenshot("\\Message.png");
		

	}
}