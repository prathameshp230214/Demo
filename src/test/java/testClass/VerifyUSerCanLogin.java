package testClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import baseClass.BaseClass;
import pomClass.LoginPage;
import utilClass.Util;

public class VerifyUSerCanLogin {
	
	WebDriver driver;
	LoginPage lp;
	ExtentTest extent;
	
	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String br) {
		
		driver = BaseClass.getWebDriver(br);
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		
		lp=new LoginPage(driver);
		
	}
	
	@Test
	public void VerifyUserCanLogin() {
		
		lp.enterUsername();
		lp.enterPassword();
		lp.clickSubmit();
		
	}
	
	//-----Use Of DATA PROVIDER ------------
	@DataProvider(name="testData")
	//public String[] getData() - for single type of data
	public Object[][] getData() {
		Object[][] pName = {{"realme", "10000"}, {"Samsung", "20000"}};
		return pName;
	}
	
	@Test(dataProvider="testData")
	public void myTest(String pName, String pPrice) {
		System.out.println(pName);
		System.out.println(pPrice);
	}
	

	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.SUCCESS) {
			extent.log(Status.PASS, "Test : "+result.getName());
		}else if(result.getStatus()==ITestResult.FAILURE) {
			String path = Util.getScreenshot(driver, result.getName());
			extent.log(Status.FAIL, "Test : "+result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
		}else if(result.getStatus()==ITestResult.SKIP) {
			extent.log(Status.SKIP, "Test : "+result.getName());
		}
		
		
		
		
	}
	
	@AfterClass
	public void afterClass() {
		
	}


	

}
