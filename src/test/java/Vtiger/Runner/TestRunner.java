package Vtiger.Runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(

        features = "src/test/resources",
       // dryRun = true,
        glue = "Vtiger.StepDefinition",
        plugin= {"pretty","html:target/cucumber-html-report.html","json:target/cucumber.json"}
        , tags="@sanity"


    

)

public class TestRunner extends AbstractTestNGCucumberTests {
}
