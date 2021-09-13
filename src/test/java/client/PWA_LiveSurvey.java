package client;

import org.testng.annotations.Test;

import baseClass.BaseClass;

public class PWA_LiveSurvey extends BaseClass {
	@Test
	public static void LiveSurvey () throws Throwable {
		

		Thread.sleep(5000);

		ExtentReportName("Live Survey");
		
		GetWebElementandClick("LiveSurvey");
	
	AttenLiveSurvey("LiveSurvey1", "LiveSurvey2", "ViewSurvey1", "ViewSurvey2", "");
		
}
}