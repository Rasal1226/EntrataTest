package selenium;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature/",
        glue= "stepDefinitions",
//        tags = "@test1",
        plugin = {"pretty"},
        monochrome = true


)
public class runner {

}
