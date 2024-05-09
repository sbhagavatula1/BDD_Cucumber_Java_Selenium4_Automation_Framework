package TestRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
	//	The path where the feature files are stored appears to be case INSENSITIVE
	//	The actual feature files path is: "src/test/java/features"
	//	However, the "features" attribute in the runner script appears to allow
	//	its value to be specified:
	//		either as:
	//			"src/test/java/features"
	//			(with no case deviation)
	//		or as:
	//			something like "sRc/TeSt/jAvA/FeAtUrEs"
	//			(with 1 or more case deviations)
	features="sRc/TeSt/jAvA/FeAtUrEs",
	
	//	However, the path where the step"glue" attribute appears to be case SENSITIVE !!!
	//	The "stepDefinitions" is the name of the package that that contains
	//	the step definitions.
	//	Specifying the "glue" attribute with values like:
	//		either: "StepDefinitions"
	//		or: any other name that has even single case deviation 
	//			from the original name 
	//			===> NOT ALLOWED!!!
	//
	//		The only "glue" value ALLOWED is: "stepDefinitions"
	//		(with no case deviation from original value)
	glue="stepDefinitions",
	
	// "dryRun=true" ===> Script is not executed but only checked for correctness
	dryRun=false,
	
	// "monochrome=true" ===> Makes the reports readable,
	monochrome	=	true,	
	
	//tags	=	"@A_Checkout",

	//tags 	=	"@A_SearchProduct",
	//-Dcucumber.filter.tags = "@C_Checkout"
	//-Dcucumber.features = "C_Checkout.feature"
	
	//tags	=	"@C_Checkout",
	//-Dcucumber.filter.tags = "@A_SearchProduct"
	//-Dcucumber.features = "A_SearchProduct.feature"

	tags	=	"@A_Checkout",
	
	//tags	=	"@A_Checkout or ",
	//			+ "@A_SearchProduct",

	//tags	=	"@B_OffersPageBackground or @B_PlaceOrderBackground",
	//tags	=	"@B_OffersPageBackground or 
	//			+ "@B_PlaceOrderBackground or", 
	//			+ "@B_OffersPage or", 
	//			+ "@B_PlaceOrder",
	
	//tags	=	"@B_PlaceOrder1",
	//tags	=	"@B_PlaceOrder2",
	//tags	=	"@B_PlaceOrder2A",
	//tags	=	"@B_PlaceOrder3",
	//tags	=	"@B_PlaceOrder5",
	//tags	=	"@B_OffersPage",
	
	//tags	=	"@B_PlaceOrder1 or "
	//			+ "@B_PlaceOrder2 or "
	//			+ "@B_PlaceOrder2A or "
	//			+ "@B_PlaceOrder3 or "
	//			+ "@B_PlaceOrder5 or "
	//			+ "@B_OffersPage or "
	//			+ "@B_OffersPage3 or "
	//			+ "@C_Checkout",
	
	//tags	=	"@B_OffersPageBackground or"
	//			+ "@B_PlaceOrderBackground or"
	//			+ "@B_OffersPage or"
	//			+ "@B_PlaceOrder2 or" 
	//			+ "@B_PlaceOrder3",
	
	//////////////////////////////////////////////////////////////
	//                                                          //
	//                    Generating Reports                    //
	//                                                          //
	//////////////////////////////////////////////////////////////	
	plugin	=	
		{	"pretty",	
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
			// 	Refer to Usage section at:
			//	https://www.extentreports.com/docs/versions/4/java/cucumber4.html
			//
			//	Usage
			//
			//	To begin using the adapter, add the:
			//	"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter"
			//	plugin to the runner - as shown below:
			//
			//		@RunWith(Cucumber.class)
			//		@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
			//		public class RunCukesTest {
			//			// ..
			//		}
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			
			//	As the name suggests, it reruns only the failed scenarion to verify
			//	if the failures were genuine or caused due ti network delays.
			"rerun:target/failed_scenarios.txt",
		}
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	@Override
	// "parallel=true"  ===> the tests are run in parallel
	// "parallel=false" ===> the tests are run in sequence
	@DataProvider(parallel=false)	
	public Object[][] scenarios (){
		// invoking scenarios that are in the super class "scenarios"
		return super.scenarios();
	}
}