package client;

import org.testng.annotations.Test;

import baseClass.BaseClass;

public class PWA3_ClientHome extends BaseClass {

	
	@Test
	public static void ClientHome() throws Throwable {

		Thread.sleep(5000);
		
		ExtentReportName("Home Survey");

		GetWebElementandClick("StartSurvey");
		TypeDataInTheElement("Comment", "Good");
		GetWebElementandClick("SaveSurvey");
		
		
		Thread.sleep(5000);
		GetWebElementandClick("PWABackProfile");
		
		
		
}
}