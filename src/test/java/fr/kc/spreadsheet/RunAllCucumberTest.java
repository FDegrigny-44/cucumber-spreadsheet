package fr.kc.spreadsheet;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
	plugin = { "pretty" },
	publish = false, 
	tags = "@text or @formulas or @numbers and not @ignore", 
	features = {"src/test/resources/fr/kc/spreadsheet" }
)
public class RunAllCucumberTest {

}
