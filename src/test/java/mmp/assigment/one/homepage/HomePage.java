package mmp.assigment.one.homepage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class HomePage {
	
	
	WebDriver driver;  
	public HomePage(WebDriver driver) {
		this.driver=driver;
		
	}

	/*Validating column count */
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

	
}
