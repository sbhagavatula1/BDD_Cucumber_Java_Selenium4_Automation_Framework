package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage{
	//	Concept of Encapsulation implemented here
	//
	//	The variables are declared private in this class.
	//	This means that they can be accessed directly only by methods in this class,
	//	but cannot be accessed directly by methods from methods in other classes.
	
	private		WebDriver	driver;
	
	private		By	search		=	By.xpath("//input[@type='search']");
	private		By	productName	=	By.cssSelector("h4.product-name");
	//private	By	productName	=	By.xpath("//h4[@class='product-name']");
	
	private		By	topDeals	=	By.linkText("Top Deals");
	private 	By	increment	=	By.cssSelector("a.increment");
	//private	By	addtoCart	=	By.cssSelector(".product-action button"); // .product-action is parent & button is child
	private		By	addtoCart	=	By.xpath("//button[text()='ADD TO CART']//parent::div[@class='product-action']");
	
	//	Action Methods
	public LandingPage (WebDriver driver){
		this.driver = driver;
	}
	public void searchItem(String name){
		driver.findElement(search).clear();
		driver.findElement(search).sendKeys(name);
	}
	public void getSearchText(){
		driver.findElement(search).getText();
	}
	public String getLandingPageProductName(){
		return driver.findElement(productName).getText().split("-")[0].trim();
	}	
	public String getLandingPageTitle(){
		return driver.getTitle();
	}
	public void selectTopDealsPage(){
		driver.findElement(topDeals).click();
	}
	public void incrementQuantity(int quantity){
		int i = quantity - 1;
		
		while(i>0) {
			driver.findElement(increment).click();
			i--;
		}
	}
	public void addtoCart(){
		driver.findElement(addtoCart).click();
	}
}