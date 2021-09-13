package baseClass;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static WebDriver driver;
	static java.util.List<WebElement> row;
	static String XpathFileLocation = "./xPath/try.properties";
	static String SuperAdminExcelLocation = "./BrandscapeExcel/SuperAdmin.xlsx";
	static String AdminExcelLocation = "C:\\Users\\ajithkumar.j\\Desktop\\Optisol_Work\\BWS_Automation\\Brandscape_Automation\\BrandscapeExcel\\Admin.xlsx";
	static String ClientExcelLocation =  "F:\\Brandscape\\BrandscapeAutomation\\BrandscapeExcel\\Client.xlsx";
	static String EnUserExcelLocation	= "F:\\Brandscape\\BrandscapeAutomation\\BrandscapeExcel\\EndUser.xlsx";
	static int a;
	static ExtentHtmlReporter htmlreporter;
	static ExtentReports extent;
	static ExtentTest extenttest;
	static int rowcount;
	static ChromeOptions options ;
	static String Var;
	static WebElement Webelement;
	static List<WebElement> Webelements;
	static String Xpath1 ;
	static String Xpath2 ;
	static String Xpath3 ; 
	static String Xpath4 ;





	public static void Extentreport(String Docname, String Result, String Testedby, String ReportPath ) {
		String reportpath = ReportPath;
		String path = System.getProperty("user.dir") + reportpath ;
		htmlreporter = new ExtentHtmlReporter(path);
		htmlreporter.config().setEncoding("utf-8");
		htmlreporter.config().setDocumentTitle(Docname);
		htmlreporter.config().setReportName(Result);
		htmlreporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.setSystemInfo("Tester", Testedby);
		extent.setSystemInfo("browser", "chrome");
		extent.attachReporter(htmlreporter);
	}

	public static void ExtentReportName(String ReportName) {
		extenttest = extent.createTest(ReportName);

	}
	public static void LogInfo(String Explanation) {

		extenttest.log(Status.INFO, Explanation);
	}

	public static void flush() {
		extent.flush();
	}

	public static String PropertyFile(String URL ) throws Throwable {

		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		return Var = Prop.getProperty(URL);
	}

	public static void LaunchURLinChromeDriver(String URL ) throws Throwable {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		PropertyFile(URL);
		driver.get(Var);
	}

	public static void LaunchURLinFirefoxDriver(String URL ) throws Throwable {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		PropertyFile(URL);
		driver.get(Var);
	}

	public static void Refresh() {

		driver.navigate().refresh();
	}

	public static void TimeWait() {

		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	}

	public static WebElement ExplicitTimeWait(String LoadXpath) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement Element= 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoadXpath)));
		Element.click();
		return Element;
	}

	public static WebElement GetWebElement(String LoadXpath) throws Throwable {

		String Xpath = PropertyFile(LoadXpath);
		Webelement = 	driver.findElement(By.xpath(Xpath));
		return Webelement;
	}	

	public static WebElement GetWebElementandClick(String LoadXpath) throws Throwable {

		GetWebElement(LoadXpath);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", Webelement);
		return Webelement;
	}


	public static String GetText(String LoadXpath) throws Throwable {

		GetWebElement(LoadXpath);
		String Text =  Webelement.getText();
		return Text;
	}

	public static void Clear (String LoadXpath ) throws Throwable {

		GetWebElement(LoadXpath);
		Webelement.clear();
	} 

	public static void TypeDataInTheElement ( String LoadXpath ,  String Data) throws Throwable {

		GetWebElement(LoadXpath);
		Webelement.sendKeys(Data);
	} 

	public static  void LinkText(String LoadXpath) throws Throwable {

		WebElement element = 	driver.findElement(By.linkText(LoadXpath));
		element.click();
	}

	public static String SuperAdminExcel(int row, int col, String sheetname) throws Throwable {

		File file = new File(SuperAdminExcelLocation);
		FileInputStream fis = new FileInputStream(file);
		Workbook W = WorkbookFactory.create(fis);
		Sheet S = W.getSheet(sheetname);
		Row r = S.getRow(row);
		Cell s = r.getCell(col);
		String data = s.toString();
		return data;
	}

	public static String AdminExcel(int row, int col, String sheetname) throws Throwable {

		File file = new File(AdminExcelLocation);
		FileInputStream fis = new FileInputStream(file);
		Workbook W = WorkbookFactory.create(fis);
		Sheet S = W.getSheet(sheetname);
		Row r = S.getRow(row);
		Cell s = r.getCell(col);
		String data = s.toString();
		return data;
	}

	public static String ClientExcel(int row, int col, String sheetname) throws Throwable {

		File file = new File(ClientExcelLocation);
		FileInputStream fis = new FileInputStream(file);
		Workbook W = WorkbookFactory.create(fis);
		Sheet S = W.getSheet(sheetname);
		Row r = S.getRow(row);
		Cell s = r.getCell(col);
		String data = s.toString();
		return data;
	}

	public static String EndUserExcel(int row, int col, String sheetname) throws Throwable {

		File file = new File(EnUserExcelLocation);
		FileInputStream fis = new FileInputStream(file);
		Workbook W = WorkbookFactory.create(fis);
		Sheet S = W.getSheet(sheetname);
		Row r = S.getRow(row);
		Cell s = r.getCell(col);
		String data = s.toString();
		return data;
	}

	public static void List(String LoadXpath ) throws Throwable {

		PropertyFile(LoadXpath);
		List<WebElement> allrow= 	driver.findElements(By.xpath(Var)); 
		rowcount = allrow.size(); 
	}

	public static void TwoXpaths(String LoadXpath1 , String LoadXpath2 ) throws Throwable {

		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		Xpath1 = Prop.getProperty(LoadXpath1);
		Xpath2 = Prop.getProperty(LoadXpath2);
	}

	public static void FourXpaths(String LoadXpath1 , String LoadXpath2 , String LoadXpath3 , String LoadXpath4) throws Throwable {

		Properties Prop = new Properties();
		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		Xpath1 = Prop.getProperty(LoadXpath1);
		Xpath2 = Prop.getProperty(LoadXpath2);
		Xpath3 = Prop.getProperty(LoadXpath3);
		Xpath4 = Prop.getProperty(LoadXpath4);
	}

	public static void ViewFromList(String LoadXpath1 , String LoadXpath2 , String Emails ) throws Throwable {

		TwoXpaths(LoadXpath1, LoadXpath2);

		for (int i = 1; i<=rowcount; i++ )		{	
			WebElement row = driver.findElement(By.xpath(Xpath1 + i + Xpath2));
			String AdminEmail = row.getText();
			if(AdminEmail.equalsIgnoreCase(Emails)) {
				System.err.println(AdminEmail); 
				break; 
			}	
		}
	}

	public static void ViewAndGetText(String LoadXpath1 , String LoadXpath2) throws Throwable {

		TwoXpaths(LoadXpath1 , LoadXpath2 ) ;

		for (int i = 1; i<=rowcount; i++ )		{	
			WebElement row = driver.findElement(By.xpath(Xpath1 + i + Xpath2));
			String AdminEmail = row.getText();
			System.err.println(AdminEmail);
		}		
	}

	public static void ViewAndClick(String LoadXpath1 , String LoadXpath2 , String Emails ) throws Throwable {

		TwoXpaths(LoadXpath1, LoadXpath2);

		for (int i = 1; i<=rowcount; i++ )		{	
			WebElement row = driver.findElement(By.xpath(Xpath1 + i + Xpath2));
			String AdminEmail = row.getText();
			System.out.println(AdminEmail);
			if(AdminEmail.equalsIgnoreCase(Emails)) {
				row.click();
				break; 
			}		
		}
	}

	public static void ClickFromList(String LoadXpath1 , String LoadXpath2 , String Emails ) throws Throwable {

		TwoXpaths(LoadXpath1, LoadXpath2);

		for (int i = 1; i<=rowcount; i++ )		{	
			WebElement row = driver.findElement(By.xpath(Xpath1 + i + Xpath2));
			String AdminEmail = row.getText();
			if(AdminEmail.equalsIgnoreCase(Emails)) {
				row.click();
				break; 
			}	
			System.out.println(AdminEmail); 	
		}
	}

	public static void EditFromList(String LoadXpath1 , String LoadXpath2 ,String LoadXpath3 , String LoadXpath4 , String Emails  ) throws Throwable {

		FourXpaths(LoadXpath1, LoadXpath2, LoadXpath3, LoadXpath4);

		for (int i = 1; i<=rowcount; i++ )		{	
			WebElement row = driver.findElement(By.xpath(Xpath1 + i + Xpath2));
			String AdminEmail = row.getText();
			if(AdminEmail.equalsIgnoreCase(Emails)) {
				WebElement edit = driver.findElement(By.xpath(Xpath3 + i + Xpath4));
				edit.click();
				break; 
			}
		}
	}

	public static void DeleteFromList(String LoadXpath1 , String LoadXpath2 ,String LoadXpath3 , String LoadXpath4 , String Emails  ) throws Throwable {

		FourXpaths(LoadXpath1, LoadXpath2, LoadXpath3, LoadXpath4);

		for (int i = 1; i<=rowcount; i++ )		{	
			WebElement row = driver.findElement(By.xpath(Xpath1 + i + Xpath2));
			String AdminEmail = row.getText();
			if(AdminEmail.equalsIgnoreCase(Emails)) {
				WebElement edit = driver.findElement(By.xpath(Xpath3 + i + Xpath4));
				edit.click();
				break; 
			}
		}
	}

	public static void AttenLiveSurvey(String LoadXpath1 , String LoadXpath2 ,String LoadXpath3 , String LoadXpath4 , String Emails  ) throws Throwable {

		FourXpaths(LoadXpath1, LoadXpath2, LoadXpath3, LoadXpath4);

		for (int i = 1; i<=rowcount; i++ )		{	
			WebElement row = driver.findElement(By.xpath(Xpath1 + i + Xpath2));
			String AdminEmail = row.getText();
			if(AdminEmail.equalsIgnoreCase(Emails)) {
				WebElement edit = driver.findElement(By.xpath(Xpath3 + i + Xpath4));
				edit.click();
				break; 
			}
		}
	}

	public static void FilteredProject (String LoadXpath1 , String LoadXpath2 ,String LoadXpath3 , String LoadXpath4 , String ProjectStatus  ) throws Throwable {

		FourXpaths(LoadXpath1, LoadXpath2, LoadXpath3, LoadXpath4);

		for (int i = 1; i<=rowcount; i++ )		{	
			WebElement row = driver.findElement(By.xpath(Xpath1 + i + Xpath2));
			String ProjectStatus1 = row.getText();

			if(ProjectStatus1.equalsIgnoreCase(ProjectStatus)) {
				WebElement ProjectName = driver.findElement(By.xpath(Xpath3 + i + Xpath4));
				System.out.println(ProjectName); 
			}
		}
	}

	public static  List<WebElement> FindElements (String LoadXpath) throws Throwable {
		Properties Prop = new Properties();

		File Location = new File(XpathFileLocation);
		System.out.println(XpathFileLocation);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		String Xpath = Prop.getProperty(LoadXpath);
		Webelements= 	driver.findElements(By.xpath(Xpath));
		return Webelements;
	}

	public static  List<WebElement> Calendar(String LoadXpath , String Value ) throws Throwable {

		FindElements(LoadXpath);		
		rowcount = Webelements.size();

		for (WebElement Key : Webelements) {
			if (Key.getText().equals(Value)) {
				Key.click();
				break;
			}
		}
		return Webelements;
	}	

	public static  List<WebElement> Select(String LoadXpath ,  String Value ) throws Throwable {

		FindElements(LoadXpath);		
		rowcount = Webelements.size();

		for (WebElement Key : Webelements) {
			if (Key.getText().equals(Value)) {
				Key.click();
				break;
			}
		}
		return Webelements;
	}	

	public static  List<WebElement> FindElementsandClick(String LoadXpath , String Value ) throws Throwable {

		FindElements(LoadXpath); 
		rowcount = Webelements.size();

		for (WebElement Key : Webelements) {

			if (Key.getText().equals(Value)) {
				Key.click();
				break;
			}
		}
		return Webelements;
	}

	public static  void ViewAll(String LoadXpath ) throws Throwable {

		FindElements(LoadXpath); 
		rowcount = Webelements.size();

		for (WebElement Key : Webelements) {

			String UserEmail	=	Key.getText();
			System.err.println(UserEmail);

		}
	}

	public static void TakeScreenshot(String Location) throws Throwable {

		File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SrcFile, new File("F:\\Brandscape\\BrandscapeAutomation\\SS"+Location));
		String SS = "F:\\Brandscape\\BrandscapeAutomation\\SS"+Location;
		extenttest.addScreenCaptureFromPath(SS);
	}

	public static void ConditionPass(String Text) throws Throwable {

		System.out.println(Text);

	}

	public static void ConditionFail(String Text) throws Throwable {

		System.out.println(Text);

	}

	public static void PrintOutput(String OutputText ) {
		System.out.println(OutputText);
	}

	public static  void RobotClass() throws Throwable {
		Robot upf = new Robot();
		upf.keyPress(KeyEvent.VK_TAB);
		upf.keyRelease(KeyEvent.VK_TAB);
		upf.keyPress(KeyEvent.VK_ENTER);
		upf.keyRelease(KeyEvent.VK_ENTER);

	}



	public static void TryandClick(String LoadXpath ) throws Throwable {

		try {
			GetWebElementandClick(LoadXpath);
		} catch (StaleElementReferenceException e) {
			GetWebElementandClick(LoadXpath);
		}
	}



	public static void DropdownList(String LoadXpath , String TypeOfStudy ) throws Throwable {
		GetWebElement(LoadXpath);
		Select w1 = new Select(Webelement);
		w1.selectByValue(TypeOfStudy);

	}



	public static  void Mouse(String LoadXpath) throws InterruptedException, Throwable {

		GetWebElement(LoadXpath);
		Actions actionProvider = new Actions(driver);
		actionProvider.doubleClick(Webelement).perform();
	}

	public static  void Random(String LoadXpath) throws InterruptedException, Throwable {
		Random rand = new Random();


		GetWebElement(LoadXpath);

Webelement.sendKeys(rand.nextInt(1000)+"a");



	}

	


}



