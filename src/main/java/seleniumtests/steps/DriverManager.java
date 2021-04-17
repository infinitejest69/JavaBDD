package seleniumtests.steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import seleniumtests.config.Configuration;

import java.util.concurrent.TimeUnit;

public class DriverManager {

  Configuration configuration;
  private WebDriver driver;

  public DriverManager() {
    this.configuration = new Configuration();
    this.driver = getDriver();
  }

  public WebDriver startChrome() {
    System.setProperty("webdriver.chrome.driver", configuration.getDriverPath());
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(configuration.getImplicitlyWait(), TimeUnit.SECONDS);
    return driver;
  }

  public WebDriver getDriver() {
    if (driver == null) driver = startChrome();
    return driver;
  }

  @AfterStep()
  public void takeScreenshot(Scenario scenario) {

    Configuration.screenShotLevel screenShotPolicy = configuration.getScreenShotPolicy();
    switch (screenShotPolicy) {
      case NONE:
        break;
      case FAIL:
        if (scenario.isFailed()) {
          screenshot(scenario);
        }
        break;
      case ALL:
        screenshot(scenario);
        break;
    }
  }

  private void screenshot(Scenario scenario) {
    TakesScreenshot ts = (TakesScreenshot) driver;
    byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
    scenario.attach(screenshot, "image/png", "");
  }

  @After()
  public void closeChrome() {
    driver.quit();
  }
}
