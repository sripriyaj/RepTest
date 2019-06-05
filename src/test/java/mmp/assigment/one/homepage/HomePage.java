package mmp.assigment.one.homepage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	/* Validating column count */
	public int colCountCheck() {
		List<WebElement> list = driver.findElements(By.tagName("th"));
		System.out.println("Col size is   " + list.size());
		// String[] expected= {"Doctor","Date","Appointment","Time"};
		int actual=list.size();
		return actual;
	}
	
	/* Col data check*/
	public boolean colDataCheck() {
		
		List<WebElement> list = driver.findElements(By.tagName("th"));
		// String[] expected= {"Doctor","Date","Appointment","Time"};
		
		String expected = "Time";
		boolean result = false;

		for (WebElement webElement : list) {
			String actual = webElement.getText();
			if (actual.contains(expected)) {
				result = true;
				break;

			}

		}
		return result;
	}

}
