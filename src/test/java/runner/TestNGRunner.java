package runner;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import listeners.AnnotationTransformer;

@CucumberOptions(
			features="src/test/resources/features",glue= {"stepDefinitions"},
			plugin= {
					"pretty",
					"html:target/cucumber-reports.html",
					"json:target/cucumber-reports.json",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"rerun:target/failed_scenarios.txt",
					 "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
					   "html:target/cucumber-reports/cucumber.html",
					   "junit:target/cucumber-reports/cucumber.xml",
					   "tech.grasshopper.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
					
			},
			monochrome = true
			)



//@Listeners(AnnotationTransformer.class)		
@Listeners(listeners.TestNGListeners.class)
public class TestNGRunner extends AbstractTestNGCucumberTests{}


