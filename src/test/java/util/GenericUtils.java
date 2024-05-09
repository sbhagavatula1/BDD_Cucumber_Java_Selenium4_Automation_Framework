package util;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils
{	
	WebDriver driver;	
	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	public void SwitchWindowToChild()
	{
		// Since the Landing and Offer pages are in different
		// windows/tabs, we need to get the total count of
		// windows opened and their respective window hdndle
		// IDs, and capture them in the set variable "s1" 
		
		//	Here we cannot use "testContextSetup.driver" since
		//	it is coming from WebDriverManager, 
		//Set<String> s1 = testContextSetup.driver.getWindowHandles();
		Set<String> s1 = driver.getWindowHandles();
		
		// Window IDs are retrieved by iterating using the iterator "i1"
		// through the set collection "s1"
		// Note: "i1" initially points to "Null"
		//
		Iterator<String> i1 = s1.iterator();
		
		// The 1st "next" operation on "i1" points to index 0 in "s1",
		// which is the parent window handle
		String parentWindow = i1.next();
		
		// The 2nd "next" operation on "i1" points to index 1 in "s1",
		// which is child window handle
		String childWindow = i1.next();

		// Currently Selenium is in Parent window and has no knowledge of child window,
		// To work on the offers page, We need to be able to switch to child window.
		// Once switched to child window, Selenium will not have knowledge of parent window
		//testContextSetup.driver.switchTo().window(childWindow);
		driver.switchTo().window(childWindow);
	}
}