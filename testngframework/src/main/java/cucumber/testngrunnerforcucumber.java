package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/java/cucumber", 
glue="stepdefinition", 
monochrome=true, 
plugin={"html:target/cucumber.html"})
public class testngrunnerforcucumber extends AbstractTestNGCucumberTests 
{

}
