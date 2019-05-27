package mmp.assignment.one;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.*;

import junit.framework.Assert;

public class BaseClass {

	public WebDriver driver;
	WebElement element;
	
	/* initiating  the browser */
	public void initBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

	}
	/* Launching the browser*/
	public void launchBrowser() throws InterruptedException {
		initBrowser();
		driver.navigate().to("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(),'Patient Login')]")).click();
		Thread.sleep(3000);
		element = driver.findElement(By.xpath("//a[@class='button button-alt'][contains(text(),'Login')]"));
		driver.findElement(By.xpath("//a[@class='button button-alt'][contains(text(),'Login')]")).click();
	}
	/*Explicit wait call*/
	public void waitCallExplicit() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/*Validating login credentials*/
	public void credentialValidation() throws InterruptedException
	{		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ria1");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Ria12345");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
	}
	
	/*Validating login credentials using parameterization*/
	public void credentialValidationParam(String username,String password) throws InterruptedException
	{		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
	}
	

	/*
	//Validating column count 
	public void colCountCheck() {
		List<WebElement> list = driver.findElements(By.tagName("th"));
		System.out.println("Col size is   " + list.size());
		//String[] expected= {"Doctor","Date","Appointment","Time"};
		String expected="Time";
		String actual = "";
		for (WebElement webElement : list) {			
			actual=webElement.getText();		
		}
		//Assert.assertTrue(actual.contains("Time"));
		
		boolean result = actual.contains(expected) ;

		Assert.assertTrue(result);

	}
	
	*/
}
