package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OffersPage
{	
	//	Concept of Encapsulation implemented here
	//
	//	The variables are declared private in this class.
	//	This means that they can be accessed directly only by methods in this class,
	//	but cannot be accessed directly by methods from methods in other classes.
	
	private		WebDriver	driver;
	private		By			search		=	By.xpath("//input[@type='search']");
	private		By			productName	=	By.cssSelector("tr td:nth-child(1)");
	
	//	Action Methods
	public OffersPage (WebDriver driver){
		this.driver = driver;
	}
	public void searchItem(String name){
		driver.findElement(search).clear();
		driver.findElement(search).sendKeys(name);
	}
	public void getSearchText(){
		driver.findElement(search).getText();
	}
	public String getOffersPageProductName(){
		return driver.findElement(productName).getText();
	}
	public String getOffersPageTitle(){
		return driver.getTitle();
	}
}