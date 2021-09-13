package endUserProfile;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class PWA_EndUserLogin extends BaseClass{


	@BeforeTest

	public static void ExtentReport() throws Throwable {

		Extentreport("Brandscape", "Brandscape Automation", "Ajith Kumar", "\\User\\ExtentReport.html");
	}

	@Test()
	public static void Login() throws Throwable {

		ExtentReportName("Login");

		LaunchPWAURLinChromeDriver("PWAURL");
		//LaunchURLinFirefoxDriver("URL");
		LogInfo("Brandscape URL loaded successfully");

		TimeWait();

		TypeDataInTheElement("PWAEmail", EndUserExcel(1, 1, "Log In"));
		LogInfo("Email ID is entered as : " + EndUserExcel(1, 1, "Log In"));

		TypeDataInTheElement("StudyID", EndUserExcel(1, 2, "Log In"));
		LogInfo("Study ID is entered as : " + EndUserExcel(1, 2, "Log In"));

		GetWebElementandClick("PWASendButton");
		LogInfo("Login button is clicked");
		
		Thread.sleep(3000);
		TakeScreenshot("\\OTPpage.png");
		
		Thread.sleep(15000);
		GetWebElementandClick("VerifyCode");
		LogInfo("Login button is clicked");
		System.out.println("clicked");

		Thread.sleep(6000);
		WebElement LetsStart = 	GetWebElement("LetsStart");
		if(LetsStart.isDisplayed()) {
			LetsStart.click();
		} else{
			PrintOutput("LetsStart is missing");
		}
		Thread.sleep(3000);
		WebElement NotificationIcon =	GetWebElement("NotificationIcon");
		if(NotificationIcon.isDisplayed()) {
			ConditionPass("Login successfull");
			LogInfo("Login successfull");
		}else {
			ConditionFail("Login Failed");
			LogInfo("Login Failed");
		}
		Thread.sleep(3000);
		TakeScreenshot("\\LoggedIn.png");

	}
}


