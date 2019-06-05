package mmp.assignment.one;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mmp.assigment.one.homepage.HomePage;

public class Assignment1_DynamicRows extends BaseClass {
	
	@Test	
	public void TC001_ColCountValidation() throws InterruptedException  {
		
		launchBrowser();
		HomePage hp=new HomePage(driver);		
		LoginPage lp=new LoginPage(driver);
		lp.credentialValidation();
		//hp.colCountCheck();
		int expected =5;
		int act=hp.colCountCheck();
		Assert.assertEquals(expected, act);
	
	}
	
	@Test
	public void TC002_ColDataValidation() throws InterruptedException {
		launchBrowser();
		HomePage hp=new HomePage(driver);		
		LoginPage lp=new LoginPage(driver);
		lp.credentialValidation();
		hp.colDataCheck();
		boolean result=hp.colDataCheck();
		Assert.assertTrue(result);
		
		
		
	}
	
	
	@Parameters({"username","password" })
	@Test
	public void TC002_ColCountValidationParam(String username,String password) throws InterruptedException  {
		
		launchBrowser();
		HomePage hp=new HomePage(driver);
		LoginPage lp=new LoginPage(driver);
		lp.credentialValidationParam(username, password);
		hp.colCountCheck();
		String expected="home";
		String act=lp.credentialValidationParam(username, password);
		Assert.assertEquals(expected, act);
		
	}
	
	
	
	
	
	

}
