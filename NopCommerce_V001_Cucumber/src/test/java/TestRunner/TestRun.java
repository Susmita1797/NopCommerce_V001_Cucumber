package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions

(
		features={".//Features/"}, //location of feature files
		glue="StepDefinitions",    //locate where steps are implemented
		dryRun=false,               // means without any real execution checks if every feature file contains corresponding step definition file or not
		monochrome = true, //it will remove unnecessary characters from the console window
		plugin={"pretty","html:test-output.html"} //pretty provides the reports in console in detailed and understandable format, html provides html reports
		//tags= "@Sanity,@Regression"
		)
public class TestRun {
	
}
