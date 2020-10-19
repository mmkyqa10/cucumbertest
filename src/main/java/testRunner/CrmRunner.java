package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\mahes\\webservices\\cucumbertest\\Features\\dealsmap.feature",
		glue= {"stepDefinations"},
		plugin = {"pretty","html:test-outout","junit:junit_xml/cucumber.xml"},
		monochrome=true,
		dryRun=false
			)
public class CrmRunner {

}
