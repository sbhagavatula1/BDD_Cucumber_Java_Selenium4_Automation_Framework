package util;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase
{	
	public	WebDriver	driver;		// Accessed from all page classes
	public Properties prop;
	
	public WebDriver WebDriverManager() throws IOException
	{
		/***************************************************************************/
		/*                                                                         */
		/*  To ensure that the step-definition files contain only the information  */
		/*  that describe the required functional steps for that step-definition,  */ 
		/*  the following code which originally existed under the landingPage step */
		/*  definition, is moved in its entirety to here.                          */
		/*                                                                         */		
		/***************************************************************************/
		
		prop = new Properties();
		String filePath  = System.getProperty("user.dir") + "/src/test/resources/global.properties";
		FileInputStream fis	=	new FileInputStream(filePath);
		prop.load(fis);

		String	browser	=	prop.getProperty("browser_valueFromPropertiesFile");
		String	url		=	prop.getProperty("url_valueFromPropertiesFile");
		
		/********************************************************************************************************/
		/*                                                                                                      */
		/*   To trigger framework scenarios:                                                                    */
		/*                                                                                                      */
		/*       1) from Eclipse, We make changes in TestRunner and click "Run as TestNG"                       */
		/*       2) by using Maven-Eclipse plugin:                                                              */
		/*          - Right click on project                                                                    */
		/*          - Scroll down to "Run"                                                                      */
		/*          - scroll down to "Run Configurations                                                        */
		/*          - Select "maven build"                                                                      */
		/*          - click the "+" icon and select "new configuration"                                         */
		/*          - Select "browse" or "Workspace" and select the <base directory> where pom.xml is located.  */
        /*          - in our case, it is:                                                                       */
        /*                "C:\Users\satya\eclipse-workspace\FINAL_RSA_Junit_TestNG_Cucumber_E2E_SAVE"           */ 
		/*          - enter text "test" in the goal box                                                         */
		/*          - Note: This will trigger all TestRunner files. If we dont want certain test Runner files   */
		/*                  to be run, move them to another location                                            */
		/*          - click "Run"                                                                               */
		/*       2) from command line, by passing the Cucumber options                                          */
		/*             - Steps common to all options:                                                           */        
		/*                - Open commandline window                                                             */
		/*                - "cd" to the <base directory>                                                        */
		/*             - Option-1:                                                                              */
		/*                - type "mvn test" (Note above is applicable here also)                                */
		/*          Option-2:                                                                                   */
		/*  1) mvn test                                                                                         */
		/*  2) -Dbrowser_From_mvn_CommandLine                                                                   */
		/*                                                                                                      */
		/*                                                                                                      */
		/********************************************************************************************************/
		
		if (driver == null)
		{
			/*
				System.out.println("");
				System.out.println("Browser Name = " + 
						((browserName.substring(0, 1).toUpperCase()) +
						(browserName.substring(1).toLowerCase())));
				System.out.println("URL          = " + url);
				System.out.println("");
			*/

			if (browser.toUpperCase().equals("FIREFOX"))
			{
				//WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browser.toUpperCase().equals("EDGE"))
			{
				//WebDriverManager.edgedriver().setup();
				// Configure to prevent the "Prsonalize your web experience" pop up in Edge
				EdgeOptions opt = new EdgeOptions();
				opt.addArguments("--guest");
				//driver = new EdgeDriver();    //This DOES NOT PREVENT the "Prsonalize your web experience" pop up
				driver = new EdgeDriver(opt);   //This PREVENTS the "Prsonalize your web experience" pop up
			} else if (browser.toUpperCase().equals("CHROME"))
			{
				//WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			
			// Implicit wait applicable for Selenium 4 versions
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			driver.manage().window().maximize();
			//driver.manage().window().fullscreen();
			
			//driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
			//driver.get(prop.getProperty("url_valueFromPropertiesFile"));
			getURL();
		}	
		return driver;
	}
	public void getURL()
	{
		driver.get(prop.getProperty("url_valueFromPropertiesFile"));
	}
	
}