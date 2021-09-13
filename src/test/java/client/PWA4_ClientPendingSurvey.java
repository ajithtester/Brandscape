package client;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class PWA4_ClientPendingSurvey extends BaseClass {


		@Test
		public static void ClientPendingSurvey() throws Throwable {

			Thread.sleep(5000);

			ExtentReportName("Pending Survey");
			
			GetWebElementandClick("PendingSurvey");
			GetWebElementandClick("ViewSurvey");
			GetWebElementandClick("Complete");
			
			TypeDataInTheElement("Notes", "Proceed");
			
			Thread.sleep(5000);
			WebElement NotificationIcon =	GetWebElement("NotificationIcon");
			if(NotificationIcon.isDisplayed()) {
				
				ConditionPass("Survey completed and submitted");
				LogInfo("Survey completed and submitted");
			}else {
				ConditionFail("Survey not submitted");
				LogInfo("Survey not submitted");
			}		
}
}