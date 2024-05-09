package util;

import java.io.IOException;

import pageObjects.PageObjectsManager;

public class TestContextSetup {
	
	//
	// This class will have info on which variables will be shared between step definition files
	//
	
	//public	WebDriver			driver; 
	
	public		String				landingPageProductName;
	public		String				checkoutPageProductName;
	
	public		PageObjectsManager	pageObjectsManager;
	public		TestBase			testBase;
	public		GenericUtils		genericUtils;
	
	public TestContextSetup() throws IOException {
		
		//	Our architecture has 2 managers:
		//		1.	WebDriverManager, which gets initialized in the "TestContextSetup",
		//			which returns the "driver", coming from "TestBase.java"
		testBase = new TestBase();
		
		//		2.	PageObjectsManager, which gets initialized in the "TestContextSetup",
		//			receives "driver" from WebDriverManager and delegates that driver to
		//			all PageObject files.
		//	pageObjectsManager	=	new PageObjectsManager(driver);
		pageObjectsManager	=	new PageObjectsManager(testBase.WebDriverManager());
		//	This will replace the need to create the POM object in the step definitions.
		//
		//	It may be noted that when creating the POM object in the step definitions,
		//	it was done by passing "testContextSetup.driver" as argument. Howeve, since the
		//	POM object is being created in the "TestContextSetup" class itself, there is no
		//	need to prefix the "driver" with "testContextSetup".
		//	Instead, pass just "driver" as the argument.
		
		genericUtils			=	new GenericUtils(testBase.WebDriverManager());
		
		//	Since an instance of the "TestContextSetup" is passed as parameter to the constructors
		//	of both the "LandingPageStepDefinition" and the "OffersPageStepDefinition" classes,  
		//	whenever any method in either step definition is called. the "TestContextSetup" class is
		//	instantiated and the "testContextSetup" object gets created, in that respective stepdefinition.
		//
		//	Since "PageObjectsManager" is now part of the "TestContextSetup" constructor, it may be
		//	noted that whenever the "TestContextSetup" class is instantiated (triggered by whenever
		//	any method of these step definitions is called), automatically the "PageObjectsManager" class
		//	also is instantiated and readily available for use in that respectvie step definition.
		//
		//	This means that:
		//		the following statements in the "LandingPageSrepDefinition"
		//			pageObjectsManager = new PageObjectsManager(testContextSetup.driver);
		//			LandingPage landingPage = pageObjectsManager.getLandingPage();
		//		will be replaced by:
		//			LandingPage landingPage = testContextSetup.pageObjectsManager.getLandingPage();
		//
		//	This also means that:
		//		the following statements in the "OffersPageSrepDefinition"
		//			pageObjectsManager    = new PageObjectsManager(testContextSetup.driver);
		//			OffersPage offersPage = pageObjectsManager.getLandingPage();
		//		will be replaced by:
		//			OffersPage offersPage = testContextSetup.pageObjectsManager.getOffersPage();
	}
}