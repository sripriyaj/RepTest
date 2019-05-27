package mmp.assignment.one;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mmp.assigment.one.homepage.HomePage;

public class Assignment1_DynamicRows extends BaseClass {
	
	@Test	
	public void TC001_ColCountValidation() throws InterruptedException  {
		
		launchBrowser();
		HomePage hp=new HomePage(driver);
		credentialValidation();
		hp.colCountCheck();
		
	}
	
	@Parameters({"username","password" })
	@Test
	public void TC002_ColCountValidationParam(String username,String password) throws InterruptedException  {
		
		launchBrowser();
		HomePage hp=new HomePage(driver);
		credentialValidationParam( username, password);
		hp.colCountCheck();
		
	}
	
	
	
	
	
	

}
