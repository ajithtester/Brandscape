package superAdmin;

import org.testng.annotations.Test;

import baseClass.BaseClass;

public class BWS902_Message extends BaseClass {
	
	


	

	@Test()
	public static void Login() throws Throwable {
		Thread.sleep(3000);
		ExtentReportName("Message");
		
		GetWebElementandClick("Message");
		LogInfo("Message is clicked from menu");
		
		Thread.sleep(6000);
		TypeDataInTheElement("SearchMessage", SuperAdminExcel(1, 1, "Message"));
		LogInfo("Admin name is entered in search as : "+ SuperAdminExcel(1, 1, "Message"));
		Thread.sleep(4000);
		

		Calendar("AdminDrop", SuperAdminExcel(1, 1, "Message"));
		LogInfo("Admin selected from the list : "+ SuperAdminExcel(1, 1, "Message"));
		Thread.sleep(6000);
		
		TypeDataInTheElement("TypeMessage", SuperAdminExcel(1, 2, "Message"));
		LogInfo("Message is typed as : "+ SuperAdminExcel(1, 2, "Message") );
		Thread.sleep(2000);
		GetWebElementandClick("SendMessage");
		LogInfo("Send button is clicked");
		Thread.sleep(2000);
		TakeScreenshot("\\Message.png");
		
	}	
}
