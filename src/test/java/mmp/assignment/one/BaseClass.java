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
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.*;

import junit.framework.Assert;

public class BaseClass {

	//private static final String[] String username = null;
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
	
	
	/*Validating login credentials using parameterization*/
	@Parameters({"username","password"})
	public void credentialValidationParam(String username,String password) throws InterruptedException
	{		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
	}
	

	
	public void tearDrop() {
		//driver.close();
	}
}
