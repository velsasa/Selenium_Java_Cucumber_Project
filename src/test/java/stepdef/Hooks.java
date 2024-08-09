package stepdef;

import base.Base;
import com.tutorialsninja.liveproject.util.PathHelper;
import config.PropertyFileReader;
import framework.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static base.Base.driver;

public class Hooks {
	private static Logger log = Logger.getLogger(Hooks.class);
	
	@Before
	public void setUp(Scenario scenario){
	PropertyConfigurator.configure(PathHelper.getResourcePath("/src/main/resources/ConfigurationFile/log4j.properties"));
	log.info("Scenario Started: "+scenario.getName());
	Base.reader=new PropertyFileReader();
	Browser.startBrowser();
	Browser.maximize();
	}
	@After
	public void closeBrowser(Scenario scenario){
	if(scenario.isFailed()){
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "name");
	}
	log.info("Scenario Completed: "+scenario.getName());
	log.info("Scenario Status is: "+scenario.getStatus());
	driver.quit();
	}

}
