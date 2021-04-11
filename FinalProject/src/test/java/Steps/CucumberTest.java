package Steps;


import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/main/resources/",glue = {"Steps"}, monochrome = true)

public class CucumberTest {

}
