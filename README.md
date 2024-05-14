**Summary**:
 - This is a Cucumber BDD Selenium Automation Framework
 - Built using Maven TestNG with Selenium 4 and Java 21
 - Using the Java OOP Principles and Page Object Model design patterns
 - Based on the Requirements written in the Gherkin format
 - For the Web Application: [Fruits & Vegetable Web Application by RahulShetty](https://rahulshettyacademy.com/seleniumPractise/#/)
 - Automation test script developed by **Satyasai Bhagavatula** and tested on the following popular browsers:
	 - Chrome
	 - Firefox
	 - Edge

**Details**:
 - The project name is stored at the root of the framework created by the Maven build, and the rest of the framework's folder structure is populated with the contents of the project, as explained below:
	 - < Project Name >
		 - <src/main/java>
			 - No files saved here.
		 - <src/main/resources>
			 - No files saved here.
		 -  <src/test/java>
			 - <*features*>
				- This folder contains multiple feature files, each ending with the suffix "**.feature**" containing the requirements written in the Gherkin format.
				- These files also optionally contain one or more unique tag names, identified by the preceding "**@**", to enable their selective running from the runner command (see the sample feature file shown below):
		
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
			 - This folder contains the below mentioned "**.java**" class files, that specifically implement the Gherkin requirements for the corresponding step definition files, thus complying with the **Single Responsibility Principle (SRP)** of the Object Oriented Programming (OOP):
				 - **LandingPageStepDefinition**
				 - **OffersPageStepDefinition**
				 - **CheckoutPageStepDefinition**
			- 	This folder also contains the following "**.java**" class file, which handles the common *before* and *after* annotations logic
				 - **Hooks** - 
			- Translation of a sample step into java selenium code:
				- The step to be translated:
					-  *Given User is on Greenkart LandingPage*
				- Translating the step into Java-Selenium code 
					- @Given("User is on Greenkart LandingPage")
					- public void "**Any meaningful function name**" () {
						- Add necessary Java Selenium code here.
					- } 
		- <*pageObjects*>
			- This folder contains the "**.java**" class file  **PageObjectManager** which enables enforcement of the **SRP** principle described above, by automatically creating the "**new**"page objects when needed through its constructor: 
				- **LandingPage**
				- **OffersPage** 
				- **CheckoutPage**
	         - Each page class file contains the Selenium locators of the web elements such as text boxes and buttons on the page.
	         - These web elements are accessed from outside the class only through the action methods defined within the respective class.
	         - This implements the **OOP** principle of **encapsulation**.
		- <*TestRunner*>
			- This folder has 2 "**.java**" class files, used as the starting point to run the application as **TestNG Test**
			- both extend the **AbstractTestNGCucumberTests** class
			- This implements the **OOP** principle of **Inheritance**.
				- **TestNGTestRunner**
					- This file contains ***@CucumberOptions***, that include the following parameters:
						- ***features***
							- This species the location of the features files
						- ***glue***
							- This specifies the location of the Step Definition files
						- ***dryRun***
							- This needs to be set to false to run the application
						- ***tags***
							- These specify which feature segments need to be executed
						- ***monochrome***
							- Set to "true" to make the reports readable
						- ***plugin***
							- **pretty** option to print in an easily readable format,
							- The in-built plugins to generate **XML**, **JSON** reports,
							- The 3rd party plugin to print the **extent reports**
						- It also can specify if the tests are run in sequence or parallel.
				- **FailedTestRunner**
					- Since some of the failed automation tests pass when executed again, this file re-executes only the failed tests.
					- Any tests that continue to fail after this run, are treated as truly failed tests.
		- <*util*>
			- This folder contains the following "**.java**" class files:
				- **GenericUtils**
					- This contains the generic routine to switch between windows
				- **TestBase**
					- This contains the **WebDriverManager** which enables enforcement of the **SRP** principle, by automatically creating "**new** driver objects when needed through its constructor: 
						 - **FirefoxDriver**
						 - **EdgeDriver** 
						 - **ChromeDriver**
	 - <src/test/resources>
		 - **extent. properties** setting for printing the extent reports
		 - **global.properties** as the name suggests, contains fields referenced throughout the application
	 - *pom.xml*
		 - Includes all the needed Maven dependencies, including the **picocontainer** dependency, which facilitates the transport of the common context information across multiple Java files.
	 -  *.gitignore*
		 - Includes all files that should not be pushed to the **GitHub**
- 	This framework has grown into its current form through a step-by-step approach (see below)::
	- Version_01: Testing with Single Browser
	- Version_02: Testing with Multiple Browsers
	- Version_03: Splitting the single file containing all the step definitions into multiple Step Definition files for better readability and maintainability.
		- However, since the inter-step definition connectivity has not yet been established, the script failed with the **NullPointerException**
	 - Version_04: PicoContainer Dependency Injected into **pom.xml** to prevent the  **NullPointerException**
	 - Version_05: The code to switch to Offers Page is captured in a separate function, within the "OffersPageStepDefinition" class.
	 - Version_06: Defined the Landing and Offers pages.
	 - Version_07: Defined PageObjectsManager and invoked pages from step definition.
	 - Version_08: Defined BaseClass and Generic Utilities
	 - Version_09: Reading data from Property & testng.xml files
	 - Version_10: Adding Hooks file to Implement Pre and Post-Browser Conditions
	 - Version_11: Parametrize Using Scenario Outline - Run in sequence.
	 - Version_12: Parametrize Using Scenario Outline - Run in parallel.
	 - Version_13: Add new Feature, page, and step definition files to place Product Order
	 - Version_14: Generating various types of reports in the Cucumber framework
	 - Version_15: Generate and attach automatic screenshots of failed tests
	 - Version_16: Enable Rerun only failed tests
	 - Version_17: ErrorChecking For EmptyStringValues
	 - Version_18: Using Selenium 4 native enhancement - Removed dependency on importing **BonnieGarcia** version of WebDriverManager

- Execute the script from either from Eclipse or from the command line:
	- From Eclipse
		- Execute - **Run as TestNG Test** 
			- either on **TestNGTestRunner.java**
			- or on **FailedTestRunner.java**
	- From the command line:
		- Change to the directory that contains the **pom.xml** fie
		- Execute the command "**mvn test**"
