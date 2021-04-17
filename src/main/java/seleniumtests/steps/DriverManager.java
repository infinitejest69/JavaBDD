package seleniumtests.steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import seleniumtests.config.Configuration;
import seleniumtests.enums.ScreenShotLevel;

import java.util.concurrent.TimeUnit;

public class DriverManager {

  Configuration configuration;
  private WebDriver driver;

  public DriverManager() {
    this.configuration = new Configuration();
    this.driver = getDriver();
  }
  //
  //  public WebDriver startChrome() {
  //    System.setProperty("webdriver.chrome.driver", configuration.getDriverPath());
  //    driver = new ChromeDriver();
  //    driver.manage().window().maximize();
  //    driver.manage().timeouts().implicitlyWait(configuration.getImplicitlyWait(),
  // TimeUnit.SECONDS);
  //    return driver;
  //  }

  public WebDriver getDriver() {
    if (driver == null) driver = createDriver();
    return driver;
  }

  private WebDriver createDriver() {
    switch (configuration.getEnvironment()) {
      case LOCAL:
        driver = createLocalDriver();
        break;
      case REMOTE:
        driver = createRemoteDriver();
        break;
    }
    return driver;
  }

  private WebDriver createLocalDriver() {
    switch (configuration.getBrowser()) {
      case FIREFOX:
        driver = new FirefoxDriver();
        break;
      case CHROME:
        System.setProperty("webdriver.chrome.driver", configuration.getDriverPath());
        driver = new ChromeDriver();
        break;
      case INTERNETEXPLORER:
        driver = new InternetExplorerDriver();
        break;
    }
    if (configuration.getBrowserWindowSize()) driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(configuration.getImplicitlyWait(), TimeUnit.SECONDS);
    return driver;
  }

  private WebDriver createRemoteDriver() {
    throw new RuntimeException("RemoteWebDriver is not yet implemented");
  }

  @AfterStep()
  public void takeScreenshot(Scenario scenario) {

    ScreenShotLevel screenShotPolicy = configuration.getScreenShotPolicy();
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

  @After()
  public void closeChrome() {
    driver.close();
    driver.quit();
  }

  public void screenshot(Scenario scenario) {
    TakesScreenshot ts = (TakesScreenshot) driver;
    byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
    scenario.attach(screenshot, "image/png", "");
  }
}
