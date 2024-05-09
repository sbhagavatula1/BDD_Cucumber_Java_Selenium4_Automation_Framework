package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.TestContextSetup;

public class Hooks{
	public TestContextSetup	testContextSetup;
	
	public Hooks (TestContextSetup testContextSetup){
		this.testContextSetup = testContextSetup;
	}
	@Before
	public void ExecuteBeforeEachScenario() throws IOException{
		/*********************************************************************************/
		/*                                                                               */
		/*     There is no "Before" code to be executed here because it is done by       */
		/*     default when the construtcor TestContextSetup is executed which in turn   */
		/*     calls TestBase class, which includes the before steps to be executed.     */
		/*                                                                               */
		/*********************************************************************************/
	}
	@After
	public void ExecuteAfterEachScenario() throws IOException{
		/*********************************************************************************/
		/*                                                                               */
		/*     The lines of code in this method gets executed, as method name suggests,  */
		/*     at the end of each scenario, because of the "After" annotation, and not   */
		/*     because of the method name, which can be any name.                        */
		/*                                                                               */
		/*********************************************************************************/
		testContextSetup.testBase.WebDriverManager().quit();
	}
	@AfterStep
	// Executes on each step of scenario
	public void AddScreenshot(Scenario scenario) throws IOException {
		WebDriver driver = testContextSetup.testBase.WebDriverManager();
		if (scenario.isFailed()) {
			File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// Attaching the screenshot requires to convert the data from File to byte format
			// Extent reports read the attached screenshot and includes in their report.
			byte[] fileUtils = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileUtils, "image/png", "image");
		}
	}
}