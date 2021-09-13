package jenkins;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class Jenkins extends BaseClass {	

	@Test()
	public static void Login() throws Throwable {

	
		LaunchURLinChromeDriver("URL");
		TimeWait();

		TypeDataInTheElement("Email", AdminExcel(1, 1, "Admin Login"));
		

		TypeDataInTheElement("Password", AdminExcel(1, 2 , "Admin Login"));
	

		GetWebElementandClick("LoginButton");
	

		WebElement Dashboard =	GetWebElement("Dashboard");
		if(Dashboard.isDisplayed()) {
			ConditionPass("Admin logged in successfully");

		}

		else {
			ConditionFail("Admin log in failed");
	
		}

	}


}
