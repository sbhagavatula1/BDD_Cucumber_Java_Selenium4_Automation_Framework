package TestRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
	features="@target/failed_scenarios.txt",
	
	//	However, "glue" appears to be case sensitive !!!
	//	NOTE: The "stepDefinitions" is the name of the package that that contains the step definitions
	//	Specifying "glue" attribute with values like "StepDefinitions" or any other name that has
	//	even single case deviation from the original name  ===> NOT ALLOWED!!!
	//	The only "glue" value ALLOWED is: "stepDefinitions" (with no case deviation from original value)
	glue="stepDefinitions",
	
	// "dryRun=true" ===> Script is not executed but only checked for correctness
	dryRun=false,
	
	// "monochrome=true" ===> Makes the reports readable,
	monochrome	=	true,
	
	//////////////////////////////////////////////////////////////
	//                                                          //
	//                    Generating Reports                    //
	//                                                          //
	//////////////////////////////////////////////////////////////
	
	plugin	=	{	"pretty",
			
			//////////////////////////////////
			//                              //
			//	In built cucumber options	//
			//                              //
			//////////////////////////////////
			"html:target/cucumber.html",    // It shows the location where the html report should be stored
			"json:target/cucumber.json",	// It shows the location where the json report should be stored
			//	"xml:target/cucumber.xml",	//xml is not a valid option?
			
			
			//////////////////////////////////
			//                              //
			//	    Third party plugins     //
			//                              //
			//////////////////////////////////
			//	Refer to Lesson #46 at 6:43
			// 	Refer to Usage section at: https://www.extentreports.com/docs/versions/4/java/cucumber4.html
			//
			//	Usage
			//
			//	To begin using the adapter, add the com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter
			//	plugin to the runner.
			//
			//		@RunWith(Cucumber.class)
			//		@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
			//		public class RunCukesTest {
			//			// ..
			//		}
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		}
)
public class FailedTestRunner extends AbstractTestNGCucumberTests {
	@Override
	
	// "parallel=true"  ===> the tests are run in parallel
	// "parallel=false" ===> the tests are run in sequence
	@DataProvider(parallel=false)
	
	public Object[][] scenarios (){
		// invoking scenarios that are in the super class "scenarios"
		return super.scenarios();
	}
}