package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\mahes\\webservices\\cucumbertest\\Features\\deals.feature",
		glue= {"stepDefinations"},
		//format = {"pretty", "html:target/Destination"},
		plugin = {"pretty","html:test-outout","junit:junit_xml/cucumber.xml"},
		monochrome=true,
		dryRun=false
			)
public class CrmRunner {

}
