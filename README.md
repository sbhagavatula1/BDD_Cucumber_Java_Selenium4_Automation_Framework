**Highlights**:
 - This is a Cucumber BDD Selenium Automation Framework
 - Built using Maven TestNG with Selenium 4 and Java 21
 - Based on Requirements written in the Gherkin format
 - Utilizing TestNG, Java OOP principles, and Page Object Model design patterns
 - Developed by: **Satyasai Bhagavatula**
 - Web Application: [Fruits & Vegetable Web Application by RahulShetty](https://rahulshettyacademy.com/seleniumPractise/#/)
 - Automation Test Script location: https://github.com/sbhagavatula1/BDD_Cucumber_Java_Selenium4_Automation_Framework.git
 - Automation Test Script tested on the following popular browsers:
	- Chrome
	- Firefox
	- Edge

**Details**:
 - The framework's project name stored at the root, along with the underlying files and folders in the default folder structure created by the Maven build tool:
	 - <src/main/java>
		 - No files saved here.
	 - <src/main/resources>
		 - No files saved here.
	 -  <src/test/java>
		 - <*features*>
			- This folder consists of multiple feature files, each ending with the suffix **.feature** containing the requirements written in the Gherkin format, associated with one or more unique tag names, identified by the preceding “**@**”, to enable their selective running from the runner command (see the sample feature file shown below):
						
						Feature: A_Place the order for the Products
						@A_Checkout
						Scenario Outline: A_Users should have the same search experience in both Home & Checkout pages
							Given User is on Greenkart LandingPage
							When User searched with shortname <Name> in LandingPage and extracted actual name of the product
							And Added "3" items of the selected product to cart
							Then user proceeds to checkout and validate the <Name> items in CheckoutPage
							And verify user has ability to enter promo code and place the order

						Examples:
						|Name|
						|Bro|
		 - <*stepDefinitions*> - 
			 - This folder consists of the following “.java” class files: 
				 - **LandingPageStpDefinition** - Contans only the logic implementing the *Landing Page* specific Gherkin requirements
				 - **OffersPageStepDefinition** - Contans only the logic implementing the *Offers Page* specific Gherkin requirements
				 - **CheckoutPageStepDefinition** - Contans only the logic implementing the *Checkout Page* specific Gherkin requirements
				 - **Hooks** - Contans the common *before* and *after* annotations logic
			- The above implementation complies with the **Single Responsibility Principle (SRP)** of the Object Oriented Programming (OOP).
		- <*pageObjects*>
			- This folder contains the page manager “.java” file  **PageObjectManager** which enforces the the **OOP** principle of **SRP**, described above, by automatically creating the new page “.java” files: **LandingPage**, **OffersPage** and **CheckoutPage**, through its constructor when the application starts.
	         - Each page “.java” class file contains the Selenium locators of the web elements such as text boxes and buttons on the page, enabling their access from outside the class only through the action methods defined within the respective class, thus complying with the **OOP** principle of **encapsulation**.
		- <*TestRunner*>
			- This folder has 2 “.java” class files, used as the starting point to run the application as **TestNG Test**, both extending the **AbstractTestNGCucumberTests**, implementing the **OOP** principle of **Inheritance**.
				- **TestNGTestRunner**
					- This file consists of ***@CucumberOptions***, that include the following parameters:
						- ***features***
							- This species the location of the features files
						- ***glue***
							- This specifies the location of the Step Definition files
						- ***dryRun***
							- This needs to be set to “false” to run the application
						- ***tags***
							- These specify which feature segments need to be executed
						- ***monochrome***
							- Set to "true" to make the reports readable
						- ***plugin***
							- **pretty** option to print in an easily readable format,
							- The in-built plugins to generate **XML**, **JSON** reports,
							- The 3rd party plugin to print the “**extent reports**”
						- It also can specify if the tests are run in sequence or parallel.
				- **FailedTestRunner**
					- Since some of the failed automation tests pass when they are executed again, this file will re-execute only the failed tests.
					- Any tests that continue to fail after this run, are considered truly failed tests.
		- <*util*>
		This folder contains the following “.java” class files:
			- **GenericUtils**
				- This contains the generic routine to switch between windows
			- **TestBase**
				- This contains the ".java" file **WebDriverManager** which enforces the the **OOP** principle of **SRP**, described above, by automatically creating the new WebDriver objects: **FirefoxDriver**, **EdgeDriver** and **ChromeDriver**, through its constructor when the application starts.
			- **TestContextSetup**
				- This ".java" file containing the page and web driver objects, is invoked when application is started, starting creation of the objects through its contructor.
	 - <src/test/resources>
		 - **extent.properties** – setting for printing the extent reports
		 - **global.properties** – as the name suggests, contains fields referenced throughout the application
	 - *pom.xml*
		 - Includes all the needed Maven dependencies, including the **picocontainer** dependency, which facilitates the transport of the common context information across multiple Java files.
	 -  *.gitignore*
		 - Includes all files that should not be uploaded to **GitHub**
- 	This framework has evolved into its current form through a step-by-step approach, as described below:
	- Version_01: Testing with Single Browser
	- Version_02: Testing with Multiple Browsers
	- Version_03: Splitting the single file containing all the step definitions, into multiple Step Definition files for better readability and maintainability.
		- However, since the inter-step definition connectivity has not yet been established, the script failed with the **NullPointerException**
	 - Version_04: PicoContainer Dependency Injected into **pom.xml** to prevent the  **NullPointerException**
	 - Version_05: The code included in the offers step definition to switch to Offers Page, is captured in a separate function, within the "OffersPageStepDefinition" class.
	 - Version_06: Defined the Landing and Offers pages.
	 - Version_07: Defined PageObjectsManager and invoked pages from step definition.
	 - Version_08: Defined BaseClass and Generic Utilities
	 - Version_09: Reading data from Property & testng.xml files
	 - Version_10: Adding_Hooks file to Implement Pre and Post-Browser Conditions
	 - Version_11: Parametrize Using Scenario Outline - Run in sequence.
	 - Version_12: Parametrize Using Scenario Outline - Run in parallel.
	 - Version_13: Add new Feature, page, and step definition files to place Product Order
	 - Version_14: Generating different types of reports in the Cucumber framework
	 - Version_15: Generate and attach automatic screenshots of failed tests
	 - Version_16: Enable Rerun only failed tests
	 - Version_17: ErrorChecking_For_EmptyStringValues
	 - Version_18: Selenium 4 native enhancement - Removed dependency on importing **BonnieGarcia**

- The script can be executed:
	- Either from Eclipse by executing “Run as TestNG Test”:
		- either on “TestNGTestRunner.java”
		- or on “FailedTestRunner.java”
	- or by executing the following commands from the command line:
		- cd C:\Users\satya\OneDrive\Desktop\SampleGitFolder\BDD_Cucumber_OOPS_POM_TestNG
		- C:\Users\satya\OneDrive\Desktop\SampleGitFolder\BDD_Cucumber_OOPS_POM_TestNG>mvn test