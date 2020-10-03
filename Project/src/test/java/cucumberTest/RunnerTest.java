package cucumberTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith (Cucumber.class)
@CucumberOptions(
		features= {"classpath:features"},
		glue="stepDefination",
		plugin= {"pretty",
				"html:test-output/cucumberreport"
		}
		)
public class RunnerTest {

	
}
